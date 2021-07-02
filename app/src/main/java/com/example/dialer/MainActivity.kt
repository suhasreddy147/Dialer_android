package com.example.dialer

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var num : TextView
    private lateinit var one: TextView
    private lateinit var two : TextView
    private lateinit var three : TextView
    private lateinit var four : TextView
    private lateinit var five : TextView
    private lateinit var six : TextView
    private lateinit var seven : TextView
    private lateinit var eight : TextView
    private lateinit var nine : TextView
    private lateinit var zero : TextView
    private lateinit var plus : TextView
    private lateinit var hash : TextView
    private lateinit var cancel : TextView
    private lateinit var call : Button
    private lateinit var save : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num = findViewById(R.id.num_tv)
        one = findViewById(R.id.one_tv)
        two = findViewById(R.id.two_tv)
        three = findViewById(R.id.three_tv)
        four = findViewById(R.id.four_tv)
        five = findViewById(R.id.five_tv)
        six = findViewById(R.id.six_tv)
        seven = findViewById(R.id.seven_tv)
        eight = findViewById(R.id.eight_tv)
        nine = findViewById(R.id.nine_tv)
        zero = findViewById(R.id.zero_tv)
        plus = findViewById(R.id.plus_tv)
        hash = findViewById(R.id.hash_tv)
        call = findViewById(R.id.call_btn)
        save = findViewById(R.id.save_btn)
        cancel = findViewById(R.id.X_tv)

        one.setOnClickListener {
            pressButton("1", true)
        }

        two.setOnClickListener {
            pressButton("2", true)
        }

        three.setOnClickListener {
            pressButton("3", true)
        }

        four.setOnClickListener {
            pressButton("4", true)
        }

        five.setOnClickListener {
            pressButton("5", true)
        }

        six.setOnClickListener {
            pressButton("6", true)
        }

        seven.setOnClickListener {
            pressButton("7", true)
        }

        eight.setOnClickListener {
            pressButton("8", true)
        }

        nine.setOnClickListener {
            pressButton("9", true)
        }

        zero.setOnClickListener {
            pressButton("0",true)
        }

        hash.setOnClickListener {
            pressButton("#", true)
        }

        plus.setOnClickListener {
            pressButton("+", true)
        }

        cancel.setOnClickListener {
            num.text = ""
        }

        call.setOnClickListener{
            //Toast.makeText(baseContext, "Call Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "${num.text}"))
            startActivity(intent)
        }

        save.setOnClickListener{
            val intent = Intent(
                ContactsContract.Intents.SHOW_OR_CREATE_CONTACT,
                Uri.parse("tel:"+ num.text)
            )
            intent.putExtra(ContactsContract.Intents.EXTRA_FORCE_CREATE, true)
            startActivity(intent)
        }
    }

    private fun pressButton(string: String, clear: Boolean){
        if(!clear){
            num.text=""
        }
        else{
            num.append(string)
        }
    }
}