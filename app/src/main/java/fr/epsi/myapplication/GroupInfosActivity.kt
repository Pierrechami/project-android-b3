package fr.epsi.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import org.json.JSONObject
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GroupInfosActivity : BaseActivity() {
    private val studentsJsonString: String = "{\n" +
            "\"students\": [\n" +
            "{\n" +
            "\"firstName\": \"Julien\",\n" +
            "\"lastName\": \"Flusin\",\n" +
            "\"email\": \"julien.flusin@epsi.fr\",\n" +
            "\"avatar\": \"https://avatars.githubusercontent.com/u/50296610?v=4\",\n" +
            "\"group\": \"https://github.com/Pierrechami/Android-project.git\"\n" +
            "},\n" +
            "{\n" +
            "\"firstName\": \"Pierre\",\n" +
            "\"lastName\": \"Chaminade\",\n" +
            "\"email\": \"pierre.chaminade@epsi.fr\",\n" +
            "\"avatar\": \"https://avatars.githubusercontent.com/u/80400025?v=4\",\n" +
            "\"group\": \"https://github.com/Pierrechami/Android-project.git\"\n" +
            "},\n" +
            "{\n" +
            "\"firstName\": \"Quentin\",\n" +
            "\"lastName\": \"Launay\",\n" +
            "\"email\": \"quentin.launay@epsi.fr\",\n" +
            "\"avatar\": \"https://avatars.githubusercontent.com/u/50755766?v=4\",\n" +
            "\"group\": \"https://github.com/Pierrechami/Android-project.git\"\n" +
            "}\n" +
            "]\n}"
    val data: JSONObject = JSONObject(studentsJsonString)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_infos)
        setHeaderTitle("Infos")
        showBack()

        val students= arrayListOf<Student>()
        val JSONstudents = data.getJSONArray("students")
        for(i in 0 until JSONstudents.length()){
            val js = JSONstudents.getJSONObject(i)
            val student = Student(
                js.optString("firstName", "not found"),
                js.optString("lastName", "not found"),
                js.optString("email", "not found"),
                js.optString("avatar", "not found"),
                js.optString("group", "not found"),
            )
            val button = Button(ContextThemeWrapper(this,R.style.EpsiButton))
            button.text = "${student.firstName} ${student.lastName}"
            button.setOnClickListener {
                val newIntent = Intent(application, StudentInfo::class.java)
                newIntent.putExtra("student", student)
                startActivity(newIntent)
            }

            val layout = findViewById<LinearLayout>(R.id.layoutGroupInfos)
            layout.addView(button)
            students.add(student)
        }
    }
}