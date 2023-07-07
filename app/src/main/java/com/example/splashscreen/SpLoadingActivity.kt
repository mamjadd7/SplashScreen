package com.example.splashscreen

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SpLoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sp_loading)


        heavyTask()

    }

    private fun heavyTask() {
        LongOperation().execute()
    }

    private open inner class LongOperation : AsyncTask<String?, Void? , String?>() {
        override fun doInBackground(vararg params: String?): String? {
            for (i in 0 .. 6)
            {
                try {
                    Thread.sleep(1000)
                }catch (e:Exception){
                    Thread.interrupted()
                }
            }
            return "result"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            startActivity(Intent(this@SpLoadingActivity, MainActivity::class.java))
        }

    }
}