package project.if26.com.soundboard

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.widget.DrawerLayout
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LockScreen : AppCompatActivity() {

    private lateinit var mDrawerLayout: DrawerLayout
    private lateinit var password:String
    private lateinit var editText: EditText
    private lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lock_screen)


            // load the password
            var settings = getSharedPreferences("PREF", 0)
            password = settings.getString("password","")
            Log.v("intentmain","password value : " + password.toString())

            // init button and field
            editText = findViewById(R.id.text_input_lockscreen)
            button = findViewById(R.id.button_lock_screen)

        if (password.equals(""))
        {
            Log.v("intentmain","Create a new password intent")
            //if no password
            val intent = Intent(getApplicationContext(), CreatePassword::class.java)
            startActivity(intent)
            finish()

        }

        button.setOnClickListener { v ->


                //if there is a password
                if (password.equals(editText.text.toString())) {
                    val toast = Toast.makeText(applicationContext, "Password match", Toast.LENGTH_SHORT)
                    toast.show()
                    val intent = Intent(getApplicationContext(), DrumPad::class.java)
                    startActivity(intent)
                    finish()

                } else {
                    val toast = Toast.makeText(applicationContext, "Password is wrong", Toast.LENGTH_SHORT)
                    toast.show()

                }


        }



/*
        Handler handler = new Handler();

        handler.postDelayed(object:Runnable {
          @Overridepublic internal override fun run() {
                if (password.equals(""))
                {
                    //if no password
                    val intent = Intent(getApplicationContext(), CreatePassword::class.java)
                    startActivity(intent)
                    finish()
                }
                else
                {
                    //if there is a password
                }
            }
        })

        handler.postDelayed(new Runnable(){
            @Overridepublic void run (){
                if(password.equals("")){
                    //if no password
                    Intent intent = new Intent(getApplicationContext(), CreatePassword.class);
                    startActivity(intent);
                    finish()


                }
                else {
                    //if there is a password
                }

            }

        })
*/
        /*
        SharedPreferences  settings = getSharedPreferences("PREF", 0);
        password = settings.getString("password", "")

         */

    }
}
