package com.example.primeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val edtpeso: EditText = findViewById(R.id.edittext_peso)
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val edtaltura: EditText = findViewById(R.id.edittext_altura)


        btnCalcular.setOnClickListener {

            val alturaStr = edtaltura.text.toString()
            val pesoStr = edtpeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                val altura: Float = edtaltura.text.toString().toFloat()
                val peso: Float = edtpeso.text.toString().toFloat()

                val alturafinal: Float = altura * altura
                val Result: Float = peso / alturafinal


                val intent = Intent(this, ResultActivity::class.java)

                    .apply {
                        putExtra("EXTRA_RESULT", Result)
                    }
                startActivity(intent)

            } else{
                    Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_LONG).show()

                }

            }

        }
    }


