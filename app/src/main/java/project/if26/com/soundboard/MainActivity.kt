package project.if26.com.soundboard

import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.support.v4.view.GravityCompat
import android.support.design.widget.NavigationView
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.Toast


class youMainActivity : Template_Activity() {


    private lateinit var button: Button
    var chrono: Long = 0
    val listEvenement = ArrayList< Pair<String,Int> >()


    fun Go_Chrono() {
        chrono = java.lang.System.currentTimeMillis()
    }

    fun addEvent_Chrono() {
        val chrono2 = java.lang.System.currentTimeMillis()
        val temps = chrono2 - chrono
        var tuple =   Pair<String,Int>("",400);
        listEvenement.add(tuple);

        Log.v("Chrono","Temps evenement = $temps ms")
        var printlist = "";
        for (item in listEvenement){
            printlist += Integer.toString(item.second) + " | ";


        }
    }

    fun Stop_Chrono() {
        val chrono2 = java.lang.System.currentTimeMillis()
        val temps = chrono2 - chrono
        println("Temps ecoule = $temps ms")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

         setNavigationView();
        button = findViewById(R.id.button_changepassword)
        button.setOnClickListener { v ->


                val intent = Intent(getApplicationContext(), CreatePassword::class.java)
                startActivity(intent)
                finish()


        }
        Log.v("MainActivity1","Create Main activity")

    }





}