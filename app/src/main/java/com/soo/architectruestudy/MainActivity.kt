package com.soo.architectruestudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(BlogFragment())

        bottomNavigation.setOnNavigationItemSelectedListener(this)
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null

        when(item.itemId) {
            R.id.navigation_blog -> fragment = BlogFragment()
            R.id.navigation_kin -> fragment = KinFragment()
            R.id.navigation_movie -> fragment = MovieFragment()
            R.id.navigation_image -> fragment = ImageFragment()
        }

        return loadFragment(fragment)
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        fragment?.let {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, fragment!!)
                    .commit()
            return true
        }
        return false
    }
}