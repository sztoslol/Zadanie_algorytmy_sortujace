package com.example.zadaniealgorytmysortujce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Przypisanie elementów layoutu do zmiennych(TextView)
        var wynik_wstawianie = findViewById<TextView>(R.id.textView_wynik_wstawianie)
        var wynik_babelkowe = findViewById<TextView>(R.id.textView_wynik_babelkowe)
        var wynik_szybkie = findViewById<TextView>(R.id.textView_wynik_szybkie)
        var wynik_heap = findViewById<TextView>(R.id.textView_wynik_heap)
        var wynik_scalanie = findViewById<TextView>(R.id.textView_wynik_scalanie)

        //Przypisanie interaktywnych elementow layoutu do zmiennych
        var input_ile_razy = findViewById<EditText>(R.id.input_ile_razy)
        var input_ile_elementow = findViewById<EditText>(R.id.input_ile_elem)
        var button_main = findViewById<Button>(R.id.button_wykonaj)
    }
}