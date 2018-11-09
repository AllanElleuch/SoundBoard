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


open class Template_Activity : AppCompatActivity() ,  NavigationView.OnNavigationItemSelectedListener  {



    lateinit var mDrawerLayout: DrawerLayout



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)




    }


     fun setNavigationView() {


         mDrawerLayout = findViewById(R.id.drawer_layout)
         val navigationView: NavigationView = findViewById(R.id.nav_view)
         navigationView.setNavigationItemSelectedListener(this)



         val toolbar: Toolbar = findViewById(R.id.toolbar)
         setSupportActionBar(toolbar)
         val actionbar: ActionBar? = supportActionBar
         actionbar?.apply {
             setDisplayHomeAsUpEnabled(true)
             setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24px)
         }

    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        // set item as selected to persist highlight
        item.isChecked = true
        // close drawer when item is tapped
        mDrawerLayout.closeDrawers()

        val drumpadActivityIntent = Intent(this, DrumPad::class.java)
        val settingsActivityIntent = Intent(this, MainActivity::class.java)
        val myActivityPacManAttempt = Intent(this, MainActivity2::class.java)





        return when (item.itemId) {



            R.id.drumpad_menu -> {
                Log.v("MainActivity1","in drumpad menu")
                mDrawerLayout.openDrawer(GravityCompat.START)
                startActivity(drumpadActivityIntent)
             true
             }
            R.id.settings_menu -> {
                Log.v("MainActivity1","In settings menu")
                mDrawerLayout.openDrawer(GravityCompat.START)
                startActivity(settingsActivityIntent)
                true
             }

            else -> {
                Log.v("MainActivity1","in else : " + item.toString())
                super.onOptionsItemSelected(item)}

        }


    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.optionsmenu_view, menu)
        return true
    }

     override fun onOptionsItemSelected(item: MenuItem): Boolean {
         Log.v("MainActivity1","debut item selected")

         return when (item.itemId) {


            android.R.id.home -> {
                this.mDrawerLayout.openDrawer(GravityCompat.START)
                Log.v("MainActivity1","home")
                true

            }

             R.id.mario_menu -> {
                 Log.v("MainActivity1","IN mario menu")
                 mDrawerLayout.openDrawer(GravityCompat.START)
                 val myIntent = Intent(this, MainActivity2::class.java)
                 startActivity(myIntent)

                 true
             }

             R.id.pac_man -> {
                 Log.v("MainActivity1","IN pacman menu")
                 mDrawerLayout.openDrawer(GravityCompat.START)
                 val myIntent = Intent(this, Template_Activity::class.java)
                 startActivity(myIntent)

                 true
             }

            else -> {
                Log.v("MainActivity1","in else : " + item.toString())
                super.onOptionsItemSelected(item)}
        }
    }




}