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

class StudentAdapter (val students: ArrayList<Student>):RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    class ViewHolder(view:View) :RecyclerView.ViewHolder(view){
        val student_names = view.findViewById<TextView>(R.id.student_names)
        val student_email = view.findViewById<TextView>(R.id.student_email)
        val student_group = view.findViewById<TextView>(R.id.student_group)
        val student_avatar = view.findViewById<ImageView>(R.id.student_avatar)
        val layoutContent= view.findViewById<LinearLayout>(R.id.layoutContent)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recycler_item_student, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = students.get(position)
        holder.student_names.text=student.lastName + " " + student.firstName
        holder.student_email.text=student.email
        holder.student_group.text=student.group
        Picasso.get().load(student.avatar).into(holder.student_avatar)
        holder.layoutContent.setOnClickListener(View.OnClickListener {
            Toast.makeText(holder.layoutContent.context,student.firstName,Toast.LENGTH_SHORT).show()
        })
    }

    override fun getItemCount(): Int {
        return students.size
    }
}
