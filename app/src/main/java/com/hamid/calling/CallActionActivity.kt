package com.hamid.calling

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CallActionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_action)
        val tv = findViewById<TextView>(R.id.tv_action)
        val accepted = intent?.getBooleanExtra(IS_ACCEPTED, false)

        if (accepted == true){
            tv.text = "Accepted"
            tv.setTextColor(Color.GREEN)
        }else{
            tv.text = "Rejected"
            tv.setTextColor(Color.RED)

        }
    }
}