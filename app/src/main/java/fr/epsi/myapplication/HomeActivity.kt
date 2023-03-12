package fr.epsi.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class HomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setHeaderTitle(getString(R.string.first_menu))

        val buttonLogin = findViewById<Button>(R.id.buttonInfo)
        buttonLogin.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, GroupInfosActivity::class.java)
            startActivity(newIntent)
        })
        val buttonSignup = findViewById<Button>(R.id.buttonProduits)
        buttonSignup.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, CategoriesActivity::class.java)
            startActivity(newIntent)
        })
    }
}


