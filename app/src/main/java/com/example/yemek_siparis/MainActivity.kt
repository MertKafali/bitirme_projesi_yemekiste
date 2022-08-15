package com.example.yemek_siparis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.yemek_siparis.databinding.DrawerSayfaBinding
import com.example.yemek_siparis.databinding.FragmentSepetBinding
import com.example.yemek_siparis.ui.fragment.AnasayfaFragment
import com.example.yemek_siparis.ui.fragment.SepetFragment
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var tasarim:DrawerSayfaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = DrawerSayfaBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

        NavigationUI.setupWithNavController(tasarim.bottomNavigationView,navHostFragment.navController)
        NavigationUI.setupWithNavController(tasarim.navigationView,navHostFragment.navController)

        setSupportActionBar(tasarim.toolbar)

        val toggle = ActionBarDrawerToggle(this,tasarim.drawer,tasarim.toolbar,
            0,0)
        tasarim.drawer.addDrawerListener(toggle)
        toggle.syncState()



    }

    override fun onBackPressed() {
        if(tasarim.drawer.isDrawerOpen(GravityCompat.START)){
            tasarim.drawer.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        tasarim.toolbar.title = ""
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        /*when(item.itemId){
            R.id.sepetFragment -> {

            }
        }*/
        return super.onOptionsItemSelected(item)
    }

}