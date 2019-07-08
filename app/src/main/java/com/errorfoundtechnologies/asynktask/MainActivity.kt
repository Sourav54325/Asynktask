package com.errorfoundtechnologies.asynktask

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt1.setOnClickListener {
            var task = MyTask(iiview)
            task.execute()
            Log.d("I shouldn't be here","fff")
        }

    }
    class MyTask(var iview: ImageView) : AsyncTask<Unit, Unit, Unit>()
    {
        var bmp: Bitmap? = null

        override fun onPreExecute() {
            super.onPreExecute()

        }

        override fun doInBackground(vararg p0: Unit?) {
            var u = URL("https://klgadgetguy.com/wp-content/uploads/2018/11/google-android-copy.jpg")
            var isr = u.openStream()
            bmp = BitmapFactory.decodeStream(isr)
        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)
            iview.setImageBitmap(bmp)
            Log.d("i","here")
        }
    }
  }





