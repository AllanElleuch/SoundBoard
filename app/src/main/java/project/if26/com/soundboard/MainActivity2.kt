package project.if26.com.soundboard

import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.support.v4.view.GravityCompat;
import android.support.design.widget.NavigationView;
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.View


class MainActivity2 : AppCompatActivity() {


    private lateinit var mDrawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mario)
        mDrawerLayout = findViewById(R.id.drawer_layout)


        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight
            menuItem.isChecked = true
            // close drawer when item is tapped
            mDrawerLayout.closeDrawers()

            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here

            true
        }

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionbar: ActionBar? = supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24px)
        }


        mDrawerLayout.addDrawerListener(
                object : DrawerLayout.DrawerListener {
                    override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                        // Respond when the drawer's position changes
                    }

                    override fun onDrawerOpened(drawerView: View) {
                        // Respond when the drawer is opened
                    }

                    override fun onDrawerClosed(drawerView: View) {
                        // Respond when the drawer is closed
                    }

                    override fun onDrawerStateChanged(newState: Int) {
                        // Respond when the drawer motion state changes
                    }
                }

        )



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
                mDrawerLayout.openDrawer(GravityCompat.START)
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
                Log.v("MainActivity1","IN mario menu2")
                mDrawerLayout.openDrawer(GravityCompat.START)
                val myIntent = Intent(this, MainActivity::class.java)
                startActivity(myIntent)

                true
            }

            else -> {
                Log.v("MainActivity1","in else : " + item.toString())
                super.onOptionsItemSelected(item)}
        }
    }

}