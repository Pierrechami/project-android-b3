package fr.epsi.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class StudentInfoActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_info)
        showBack()
        val student = intent.getSerializableExtra("student") as? Student
        setHeaderTitle("${student?.firstName} ${student?.lastName}")

        val names = findViewById<TextView>(R.id.textViewNames)
        names.text = "${student?.lastName} ${student?.firstName}"
        val email = findViewById<TextView>(R.id.textViewEmail)
        email.text = "${student?.email}"
        val group = findViewById<TextView>(R.id.textViewGroup)
        group.text = "${student?.group}"
        val avatar = findViewById<ImageView>(R.id.studentImage)
        Picasso.get().load(student?.avatar).into(avatar)

        val button = findViewById<Button>(R.id.urlEpsi)
        button.setOnClickListener {
            val url = getString(R.string.epsi_link)
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }
}