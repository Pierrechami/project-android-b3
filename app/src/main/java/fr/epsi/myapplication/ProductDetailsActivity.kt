package fr.epsi.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ProductDetailsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        showBack()
        val product = intent.getSerializableExtra("product") as? Product
        setHeaderTitle("${product?.name}")

        val imageViewProduct = findViewById<ImageView>(R.id.productimage)
        Picasso.get().load(product?.picture_url).into(imageViewProduct)

        val textViewProductDescription = findViewById<TextView>(R.id.productDescription)
        textViewProductDescription.text = "Descrption : "+product?.description
    }
}