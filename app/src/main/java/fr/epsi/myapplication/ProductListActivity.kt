package fr.epsi.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ProductListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        showBack()
    }
}