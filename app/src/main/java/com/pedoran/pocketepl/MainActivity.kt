package com.pedoran.pocketepl

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.pedoran.pocketepl.ui.matchResult.MatchResultFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_result, R.id.navigation_upcoming, R.id.navigation_team
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
//        nav_view.setOnNavigationItemSelectedListener {
//            when(it.itemId){
//                R.id.navigation_result ->{
//                    loadMatch(savedInstanceState)
//                }
//            }
//            true
//        }
//        nav_view.selectedItemId = R.id.navigation_result
//    }
//
//    private fun loadMatch(savedInstanceState: Bundle?) {
//        if (savedInstanceState == null) {
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.nav_host_fragment, MatchResultFragment(), MatchResultFragment::class.java.simpleName)
//                .commit()
//        }
//    }
}
