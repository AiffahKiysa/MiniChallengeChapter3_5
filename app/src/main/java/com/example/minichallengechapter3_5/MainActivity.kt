package com.example.minichallengechapter3_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvItems: RecyclerView
    private var list: ArrayList<Item> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvItems = findViewById(R.id.rv_item)
        rvItems.setHasFixedSize(true)

        list.addAll(ItemData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvItems.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListItemAdapter(list)
        rvItems.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListItemAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Item) {
                showSelectedHero(data)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when(selectedMode) {
            R.id.action_list -> {
                showRecyclerList()
            }

            R.id.action_grid -> {
                showRecyclerGrid()
            }

            R.id.action_cardView -> {
                showRecyclerCardView()
            }
        }
    }

    private fun showRecyclerGrid(){
        rvItems.layoutManager = GridLayoutManager(this, 2)
        val gridHeroAdapter = GridItemAdapter(list)
        rvItems.adapter = gridHeroAdapter

        gridHeroAdapter.setOnItemClickCallback(object : GridItemAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Item) {
                showSelectedHero(data)
            }
        })
    }

    private fun showRecyclerCardView() {
        rvItems.layoutManager = LinearLayoutManager(this)
        val cardViewItemAdapter = CardViewItemAdapter(list)
        rvItems.adapter = cardViewItemAdapter
    }

    private fun showSelectedHero(hero: Item) {
        Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()
    }
}