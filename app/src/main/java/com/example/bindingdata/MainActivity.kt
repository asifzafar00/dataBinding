package com.example.bindingdata

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.bindingdata.ContactDatabase.Companion.getDatabaseObject
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            database = getDatabaseObject(applicationContext)
            database.contactDAO()
                .insertContact(contact = Contact(0, "John", "99999", Date()))
        }
    }

    fun showData(v: View) {
        database.contactDAO().getContact().observe(this) {
            Log.e(TAG, "ShowData: " + it.toString())
        }
    }
}