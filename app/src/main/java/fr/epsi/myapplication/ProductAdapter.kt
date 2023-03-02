package fr.epsi.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductAdapter (private val products: ArrayList<Product>):RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(view:View) :RecyclerView.ViewHolder(view){
        val textViewProductName: TextView = view.findViewById(R.id.textViewProductName)
        val textViewProductDescription: TextView = view.findViewById(R.id.textViewProductDescription)
        val imageViewProduct: ImageView = view.findViewById(R.id.imageViewProduct)
        val layoutContent: LinearLayout = view.findViewById(R.id.layoutContentCategoryItem)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recycler_view_item_product_list, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.textViewProductName.text=product.name
        holder.textViewProductDescription.text="Description: "+product.description
        Picasso.get().load(product.picture_url).into(holder.imageViewProduct)
        holder.layoutContent.setOnClickListener(View.OnClickListener {
            val intent = Intent(holder.layoutContent.context, ProductDetailsActivity::class.java)
            intent.putExtra("product", product)
            holder.layoutContent.context.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return products.size
    }
}