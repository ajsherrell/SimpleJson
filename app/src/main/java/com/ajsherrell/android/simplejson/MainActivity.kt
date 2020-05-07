package com.ajsherrell.android.simplejson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val job = Job()

    private val service: QuizApiService = QuizApiService

    private val coroutineScope = CoroutineScope(Dispatchers.Main + job)

    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.textView)

        val liveData = MutableLiveData<Quiz>()
        suspend fun getData() {
            liveData.value = service.quizReportService.getQuiz()
        }

        liveData.observe(this, Observer<Quiz> { result ->
            tv.text = result.toString()
        })

        coroutineScope.launch {
            try {
                getData()
            } catch (e: IOException) {
                Log.d("Error!!! ${e.message}", e.toString())
            }
        }
    }

    override fun onStop() {
        super.onStop()
        job.cancel()
    }
}



