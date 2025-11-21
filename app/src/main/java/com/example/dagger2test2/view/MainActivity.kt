package com.example.dagger2test2.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dagger2test2.R
import com.example.dagger2test2.di.DaggerAppComponent
import com.example.dagger2test2.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerAppComponent.create().inject(this)

        val text_view = findViewById<TextView>(R.id.text_view)
        val button_get = findViewById<Button>(R.id.button_get)
        val button_put = findViewById<Button>(R.id.button_put)
        val edit_text = findViewById<EditText>(R.id.edit_text)

        //Подписываемся на изменения
        mainViewModel.lifeData.observe(this) { list ->
            var string = ""
            list.forEach {
                string += it
            }
            text_view.text = string
        }
        //Этой кнойпкой будем забирать из базы списко
        button_get.setOnClickListener {
            mainViewModel.getDB()
        }
        //Этой кнопкой будем класть в базу строку
        button_put.setOnClickListener {
            val text = edit_text.text.toString()
            mainViewModel.putToDB(text)
        }
    }
}