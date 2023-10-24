package com.example.project999

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).activityCreated(savedInstanceState == null)

        val textView = findViewById<TextView>(R.id.counterTextView)

        if (savedInstanceState == null) {
            textView.text = "0"
        }
        textView.setOnClickListener {
            var count = textView.text.toString().toInt()
            textView.text = (++count).toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        val list = ArrayList<String>()
        for (i in 0 .. 1000_000){
            list.add(System.currentTimeMillis().toString())
        }
        val size = list.toString().toByteArray().size
        Log.d("sab", "list: $size")
        outState.putStringArrayList("a",list)
    }

}