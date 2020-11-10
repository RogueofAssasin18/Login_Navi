package com.example.myloginapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activities.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tasks.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       login_btn.setOnClickListener {

           if (username_in.text.toString().equals("ricallan")
                   && password_in.text.toString().equals("123")) {

               showActivities()
                   }
           else "Login Failed!"
       }
    }

    private fun showActivities(){
        activities_layout.visibility=View.VISIBLE
        tasks_layout.visibility=View.GONE
        home_in.visibility=View.GONE

        task_btn.setOnClickListener{
            showTasks()
        }
    }
    private fun showTasks(){
        activities_layout.visibility=View.GONE
        tasks_layout.visibility=View.VISIBLE
        home_in.visibility=View.GONE

        task_btn1.setOnClickListener {
            val intent1 = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent1)
        }
        task_btn2.setOnClickListener {
            val intent2 = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/RogueofAssasin18/Login_Navi.git"))
            startActivity(intent2)
        }
        task_btn3.setOnClickListener {
            val intent3 = Intent(Intent.ACTION_SEND)
            intent3.putExtra(Intent.EXTRA_TEXT, "android studio")
            intent3.type="text/plain"
            startActivity(intent3)
        }
        task_btn4.setOnClickListener {
            openApp()
        }
        task_btn5.setOnClickListener {
            Toast.makeText(applicationContext,"No context",Toast.LENGTH_SHORT).show()
        }
    }
    private fun openApp(){
        val intent4 = Intent(Intent.ACTION_VIEW)
        intent4.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent4.setPackage("com.android.microsoftword")
        if(intent4.resolveActivity(this.packageManager) != null)
        {
            startActivity(intent4)
        }
        else
            Toast.makeText(applicationContext,"Application cant be found!",Toast.LENGTH_SHORT).show()
    }

}