package com.example.app_with_error

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // RecyclerView initialization
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.setLinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(getItem())

        // Setting up inputs
        val editText = findViewById<EditText>(R.id.edit_text_input)
        editText.addTextChangedListener { text ->
            // Update RecyclerView on text input change
            val updatedList = getItem().filter { it.contains(text.toString()) }
            recyclerView.adapter.updateList(updatedList)
        }
    }

    private fun getItem(): List<String> {
        return listOf("Item 1", "Item 2", "Item 3", "Item 4")
    }
}
