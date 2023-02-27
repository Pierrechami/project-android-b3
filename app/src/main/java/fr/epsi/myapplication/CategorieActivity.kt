package fr.epsi.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CategorieActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categorie)
        setHeaderTitle("Rayons")
        showBack()
    }
}