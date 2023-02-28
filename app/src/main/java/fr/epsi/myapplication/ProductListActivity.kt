package fr.epsi.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.CacheControl
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

class ProductListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        showBack()
        val category = intent.getSerializableExtra("category") as? Category
        setHeaderTitle("${category?.title}")

        val products= arrayListOf<Product>()

        val recyclerviewProducts=findViewById<RecyclerView>(R.id.recyclerviewProducts)
        recyclerviewProducts.layoutManager= LinearLayoutManager(this)
        val productAdapter=ProductAdapter(products)
        recyclerviewProducts.adapter=productAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL=category?.products_url
        val request = Request.Builder()
            .url(mRequestURL)
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body()?.string()

                if(data!=null) {
                    val jsProducts = JSONObject(data)
                    val jsArrayProducts = jsProducts.getJSONArray("items")
                    for (i in 0 until jsArrayProducts.length()) {
                        val js = jsArrayProducts.getJSONObject(i)
                        val product = Product(
                            js.optString("name", "not found"),
                            js.optString("description", "not found"),
                            js.optString("picture_url", "not found"),
                        )
                        products.add(product)
                        runOnUiThread(Runnable {
                            productAdapter.notifyDataSetChanged()
                        })
                    }
                }
            }
        })

        }
    }