package fr.epsi.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductAdapter (val products: ArrayList<Product>):RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(view:View) :RecyclerView.ViewHolder(view){
        val textViewProductName = view.findViewById<TextView>(R.id.textViewProductName)
        val textViewProductDescription = view.findViewById<TextView>(R.id.textViewProductDescription)
        val imageViewProduct = view.findViewById<ImageView>(R.id.imageViewProduct)
        val layoutContent= view.findViewById<LinearLayout>(R.id.layoutContentCategoryItem)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recycler_view_item_product_list, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products.get(position)
        holder.textViewProductName.text=product.name
        holder.textViewProductDescription.text=product.description
        Picasso.get().load(product.picture_url).into(holder.imageViewProduct)
        holder.layoutContent.setOnClickListener(View.OnClickListener {
            Toast.makeText(holder.layoutContent.context,product.name,Toast.LENGTH_SHORT).show()
        })
    }

    override fun getItemCount(): Int {
        return products.size
    }
}