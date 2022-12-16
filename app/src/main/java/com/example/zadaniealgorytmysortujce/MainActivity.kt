package com.example.zadaniealgorytmysortujce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random
import kotlin.random.nextInt
import android.system.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Przypisanie elementów layoutu do zmiennych(TextView)
        var wynik_wstawianie_textview = findViewById<TextView>(R.id.textView_wynik_wstawianie)
        var wynik_babelkowe_textview = findViewById<TextView>(R.id.textView_wynik_babelkowe)
        var wynik_szybkie_textview = findViewById<TextView>(R.id.textView_wynik_szybkie)
        var wynik_heap_textview = findViewById<TextView>(R.id.textView_wynik_heap)
        var wynik_scalanie_textview = findViewById<TextView>(R.id.textView_wynik_scalanie)

        //Przypisanie interaktywnych elementow layoutu do zmiennych
        var input_ile_razy = findViewById<EditText>(R.id.input_ile_razy)
        var input_ile_elementow = findViewById<EditText>(R.id.input_ile_elem)
        var button_main = findViewById<Button>(R.id.button_wykonaj)
        if (input_ile_razy.text != null && input_ile_elementow.text != null)
        {
            //stworzenie losowej listy
            var losowa_lista = losuj(input_ile_elementow.toString().toInt())
            //zainicjowanie tablicy zawierającej wyniki
            var wyniki_arr = listOf<Long>(0,0,0,0,0)

            //zmienne pomocnicze do obliczania czasu trwania sortoawias
            var temp1 : Long; var temp2 : Long
            temp1 = System.currentTimeMillis()
            sortowanie_przez_wstawianie(losowa_lista)
            temp2 = System.currentTimeMillis()
        }
        else
            Toast.makeText(this, "Wypełnij wszystkie pola", Toast.LENGTH_SHORT)

    }
}

//Funkcja losująca
fun losuj(n : Int) : MutableList<Int> {
    val kolejnosc = generateSequence {
        Random.nextInt(1..9)
    }.distinct().take(n).toList()
    return kolejnosc.toMutableList()
}

//===========================Sortowanie przez wstawianie===========================
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

//===============================Sortowanie bąbelkowe===============================
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

//===============================Sortowanie szybkie===============================
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

//==========================Funkcja sortowania przez kopcoawnie==========================
fun sortowanie_przez_kopcowanie(array: IntArray) {
    // Budowanie kopca
    for (i in array.size / 2 - 1 downTo 0) {
        heapify(array, array.size, i)
    }

    for (i in array.size - 1 downTo 0) {
        val temp = array[0]
        array[0] = array[i]
        array[i] = temp

        heapify(array, i, 0)
    }
}

//Funkcja pomocnicza do sortowania przez kopcowanie
fun heapify(array: IntArray, n: Int, i: Int) {
    var largest = i
    val l = 2 * i + 1
    val r = 2 * i + 2

    if (l < n && array[l] > array[largest]) {
        largest = l
    }

    if (r < n && array[r] > array[largest]) {
        largest = r
    }

    if (largest != i) {
        val temp = array[i]
        array[i] = array[largest]
        array[largest] = temp

        heapify(array, n, largest)
    }
}

//===========================Funkcja sortowania przez scalanie===========================
fun sortowanie_przez_scalanie(array: IntArray): IntArray {
    if (array.size <= 1) return array

    val mid = array.size / 2
    val left = sortowanie_przez_scalanie(array.copyOfRange(0, mid))
    val right = sortowanie_przez_scalanie(array.copyOfRange(mid, array.size))

    return merge(left, right)
}

//Funkcja pomocnicza do sortowania przez scalanie
fun merge(left: IntArray, right: IntArray): IntArray {
    var leftIndex = 0
    var rightIndex = 0
    val result = IntArray(left.size + right.size)

    for (i in result.indices) {
        if (leftIndex >= left.size) {
            result[i] = right[rightIndex++]
        } else if (rightIndex >= right.size) {
            result[i] = left[leftIndex++]
        } else if (left[leftIndex] < right[rightIndex]) {
            result[i] = left[leftIndex++]
        } else {
            result[i] = right[rightIndex++]
        }
    }

    return result
}
