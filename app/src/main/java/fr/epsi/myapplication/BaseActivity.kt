package fr.epsi.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("EPSI B3 PROJECT ANDROID","################ onCreate :"+javaClass.simpleName)
    }

    override fun onStart() {
        super.onStart()
        Log.i("EPSI B3 PROJECT ANDROID","################ onStart :"+javaClass.simpleName)
    }

    override fun onResume() {
        super.onResume()
        Log.i("EPSI B3 PROJECT ANDROID","################ onResume :"+javaClass.simpleName)
    }

    override fun onPause() {
        super.onPause()
        Log.i("EPSI B3 PROJECT ANDROID","################ onPause :"+javaClass.simpleName)
    }

    override fun onStop() {
        super.onStop()
        Log.i("EPSI B3 PROJECT ANDROID","################ onStop :"+javaClass.simpleName)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("EPSI B3 PROJECT ANDROID","################ onDestroy :"+javaClass.simpleName)
    }

    override fun finish() {
        super.finish()
        Log.i("EPSI B3 PROJECT ANDROID","################ finish :"+javaClass.simpleName)
    }

    fun setHeaderTitle(title: String?) {
        val textView = findViewById<TextView>(R.id.textViewTitle)
        textView.text = title
    }

    fun showBack() {
        val imageViewBack = findViewById<ImageView>(R.id.imageViewBack)
        imageViewBack.visibility = View.VISIBLE
        imageViewBack.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

}