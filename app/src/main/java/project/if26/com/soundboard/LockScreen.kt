package project.if26.com.soundboard

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.widget.DrawerLayout
import android.util.Log
class LockScreen : AppCompatActivity() {

    private lateinit var mDrawerLayout: DrawerLayout
    private lateinit var password:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lock_screen)

        // load the password
        var settings = getSharedPreferences("PREF", 0)
        password = settings.getString("password","")


        if (password.equals(""))
        {
            Log.v("intent","Create a new password intent")
            //if no password
            val intent = Intent(getApplicationContext(), CreatePassword::class.java)
            startActivity(intent)
        }
        else
        {
            //if there is a password
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
