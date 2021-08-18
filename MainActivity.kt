package com.example.basic_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.home_screen_content.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)    //Of Toolbar widget in home_screen_content

        val toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close)
        toggle.isDrawerIndicatorEnabled=true     //to show hamburger sign
        drawerLayout.addDrawerListener(toggle)  //Listener for monitoring events about drawers
        toggle.syncState()


        nav_drawer.setNavigationItemSelectedListener(this)


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        /*parameter should be either Gravity.left or right or GravityCompat.start or end*/
        drawerLayout.closeDrawer(GravityCompat.START)

        when(item.itemId){
            R.id.home->{
                setActionBarTitle("Home")
                changeFragment(HomeFragment())
            }

            R.id.about->{
                setActionBarTitle("About Us")
                changeFragment(AboutFragment())
            }

            R.id.contact->{
                setActionBarTitle("Contact Details")
                changeFragment(ContactFragment())
            }
        }

        return true
    }

    fun setActionBarTitle(bartitle:String){
        supportActionBar?.title =bartitle
    }

    fun changeFragment(frag:Fragment){
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.fragment_container,frag).commit()
    }
}