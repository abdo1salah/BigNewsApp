package com.example.bignewsapp

//bff176c0fbdf435991f92999abf57929
//https://newsapi.org

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bignewsapp.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {
    lateinit var binding : ActivityCategoryBinding
    lateinit var category : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolBar = binding.toolbar
        setSupportActionBar(toolBar)
        supportActionBar!!.title = "Explore"

        binding.generalCv.setOnClickListener {
            category = "general"
            goToNews(category)
        }
        binding.sportsCv.setOnClickListener {
            category = "sports"
            goToNews(category)
        }
        binding.businessCv.setOnClickListener {
            category = "business"
            goToNews(category)
        }
        binding.technologyCv.setOnClickListener {
            category = "technology"
            goToNews(category)
        }
        binding.entertainmentCv.setOnClickListener {
            category = "entertainment"
            goToNews(category)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu_items,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val i :Intent
         when(item.itemId){
            R.id.settings -> {
                i = Intent(this, SettingsActivity::class.java)
                startActivity(i)
            }
            R.id.logout -> {}
            else -> {}
        }

        return super.onOptionsItemSelected(item)
    }
    fun goToNews(category : String){
        val i = Intent(this, NewsActivity::class.java)
        i.putExtra("category",category)
        startActivity(i)
    }

}