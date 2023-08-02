package com.example.bindingdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import android.view.View
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java,
            "contactDB"
        ).build()

        GlobalScope.launch {

            database.contactDAO().insertContact(contact = Contact(0, "John", "99999"))
        }


    }

    fun showData(v: View) {
        database.contactDAO().getContact().observe(this) {
            Log.e(TAG, "showData: " + it.toString())

        }
    }
}