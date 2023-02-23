package fr.epsi.myapplication

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity(){

    fun setHeaderTitle(title: String?) {
        val textView = findViewById<TextView>(R.id.main_header)
        textView.setText(title)
    }

}