package com.procreation.navigationarchitecturecomponent

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = toolbar
        setSupportActionBar(toolbar)

        val drawerLayout = drawer_layout
        val navView = nav_view
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.fragment1,
                R.id.fragment2,
                R.id.fragment3
            ), drawerLayout
        )

        /**
         * add action bar with burger
         */
        setupActionBarWithNavController(navController, appBarConfiguration)

        /**
         * set side menu's items onClickListener
         */
        navView.setupWithNavController(navController)


    }

    /**
     * set burger onClick action(open side menu)
     */
    override fun onSupportNavigateUp(): Boolean {
        Log.d("tag", "onSupportNavigateUp")
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.side_menu, menu)
        return true
    }*/

    fun onFragment1NextClick() {

        val action = Fragment1Directions.actionFragment1ToFragment2("some text")
        navController.navigate(action)
    }

    fun onFragment1BackClick() {

    }

    fun onFragment2NextClick() {
        //navController.navigate(R.id.fragment3)
        navController.navigate(R.id.action_fragment2_to_fragment3)
    }

    fun onFragment2BackClick() {
        navController.popBackStack()
    }

    fun onFragment3NextClick() {
        navController.navigate(R.id.secondActivity)
    }

    fun onFragment3BackClick() {
        navController.popBackStack()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        //if(item.itemId == R.id.id_logout)
            Log.d("tag", item.itemId.toString())

        return false
    }
}
