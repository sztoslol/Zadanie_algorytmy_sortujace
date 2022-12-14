package com.example.zadaniealgorytmysortujce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Przypisanie elementów layoutu do zmiennych
        var wynik_wstawianie = findViewById<TextView>(R.id.textView_wynik_wstawianie)
        var wynik_babelkowe = findViewById<TextView>(R.id.textView_wynik_babelkowe)
        var wynik_szybkie = findViewById<TextView>(R.id.textView_wynik_szybkie)
        var wynik_heap = findViewById<TextView>(R.id.textView_wynik_heap)
        var wynik_scalanie = findViewById<TextView>(R.id.textView_wynik_scalanie)

    }
}