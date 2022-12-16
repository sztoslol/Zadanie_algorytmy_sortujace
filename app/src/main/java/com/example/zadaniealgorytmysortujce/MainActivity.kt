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

//Sortowanie przez wstawianie
fun sortowanie_przez_wstawianie(arr : MutableList<Int>)
{
    for (i in 1 until arr.size) {
        val current = arr[i]
        var j = i - 1

        while (j >= 0 && arr[j] > current) {
            arr[j + 1] = arr[j]
            j--
        }

        arr[j + 1] = current
    }
}

//Sortowanie bąbelkowe
fun sortowanie_babelkowe(arr: MutableList<Int>){
    for (i in 0 until arr.size - 1) {
        for (j in 0 until arr.size - i - 1) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
}

//Sortowanie szybkie
fun sortowanie_szybkie(array: IntArray, low: Int, high: Int) {
    if (low < high) {
        val pivot = partition(array, low, high)
        sortowanie_szybkie(array, low, pivot - 1)
        sortowanie_szybkie(array, pivot + 1, high)
    }
}

//Funkcja pomocnicza do szybkiego sortowania zwraca indeks elementu pivot po przeniesieniu
// go na swoje ostateczne miejsce między lewą a prawą podtablicą po podziale tablicy na dwie części
fun partition(array: IntArray, low: Int, high: Int): Int {
    val pivot = array[high]
    var i = low - 1
    for (j in low until high) {
        if (array[j] <= pivot) {
            i++
            val temp = array[i]
            array[i] = array[j]
            array[j] = temp
        }
    }
    val temp = array[i + 1]
    array[i + 1] = array[high]
    array[high] = temp
    return i + 1
}