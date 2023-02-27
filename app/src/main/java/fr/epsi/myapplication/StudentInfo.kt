package fr.epsi.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class StudentInfo : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_info)
        showBack()
    }
}