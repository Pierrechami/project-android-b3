package fr.epsi.myapplication

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class CategoriesActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        setHeaderTitle("Rayons")
        showBack()

        val categories= arrayListOf<Category>()

        val recyclerviewCategories=findViewById<RecyclerView>(R.id.recyclerviewCategories)
        recyclerviewCategories.layoutManager= LinearLayoutManager(this)
        val categoryAdapter=CategoriesAdapter(categories)
        recyclerviewCategories.adapter=categoryAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL="https://www.ugarit.online/epsi/categories.json"
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
                    val jsCategories = JSONObject(data)
                    val jsArrayCategories = jsCategories.getJSONArray("items")
                    for (i in 0 until jsArrayCategories.length()) {
                        val js = jsArrayCategories.getJSONObject(i)
                        val category = Category(
                            js.optString("category_id", "not found"),
                            js.optString("title", "not found"),
                            js.optString("products_url", "not found")
                        )
                        categories.add(category)
                        runOnUiThread(Runnable {
                            categoryAdapter.notifyDataSetChanged()
                        })
                    }
                }
            }
        })
    }
}