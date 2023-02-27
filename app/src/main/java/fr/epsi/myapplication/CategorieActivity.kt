package fr.epsi.myapplication

import android.os.Bundle

class CategorieActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        setHeaderTitle("Rayons")
        showBack()
    }
}