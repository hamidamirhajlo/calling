package com.hamid.calling

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.MovableFAB
import com.example.MovableFABActionListener

const val IS_ACCEPTED = "isAccepted"

class MainActivity : AppCompatActivity() {
    private lateinit var actionIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionIntent = Intent(this@MainActivity, CallActionActivity::class.java)

        val answer = findViewById<MovableFAB>(R.id.fab_answer)

        answer.movableFABActionListener = object : MovableFABActionListener {
            override fun onAction() {
                Toast.makeText(this@MainActivity, "accepted.", Toast.LENGTH_SHORT).show()
                actionIntent.putExtra(IS_ACCEPTED, true)
                startActivity(actionIntent)
                finish()
            }
        }

        val reject = findViewById<MovableFAB>(R.id.fab_reject)

        reject.movableFABActionListener = object : MovableFABActionListener {
            override fun onAction() {
                Toast.makeText(this@MainActivity, "rejected.", Toast.LENGTH_SHORT).show()
                actionIntent.putExtra(IS_ACCEPTED, false)
                this@MainActivity.startActivity(actionIntent)
                finish()
            }
        }

    }
}
