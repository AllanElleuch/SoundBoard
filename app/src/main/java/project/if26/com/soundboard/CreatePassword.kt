package project.if26.com.soundboard

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_lock_screen.*

class CreatePassword : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_password)

        editText = findViewById(R.id.text_input_createpassword)
        button = findViewById(R.id.button_create_password)



        button.setOnClickListener { v ->

            val editTextValue = this.editText.text.toString()

            if(editTextValue.equals("")){
                val toast = Toast.makeText(applicationContext, "No password entered", Toast.LENGTH_SHORT)
                toast.show()

            }
            else{

              val settings = getSharedPreferences("PREF",0)
                val editor = settings.edit()
                editor.putString("password",editTextValue)
                editor.apply()
                Log.v("intentmain","password saved : " + editTextValue)
                val intent = Intent(getApplicationContext(), LockScreen::class.java)
                startActivity(intent)
                finish()
                val toast = Toast.makeText(applicationContext, "Save password", Toast.LENGTH_SHORT)
                toast.show()

            }




         }






    }
}
