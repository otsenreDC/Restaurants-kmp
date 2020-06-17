package com.instacarro.restaurants

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jetbrains.handson.mpp.mobile.createApplicationScreenMessage
import com.jetbrains.handson.mpp.mobile.user_cases.GetCitiesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.main_text).text = createApplicationScreenMessage()

        GetCitiesUseCase().execute {
            GlobalScope.apply {
                launch(Dispatchers.Main) {
                    findViewById<TextView>(R.id.main_text).text = "${it.count} cities found"
                }
            }
        }
    }
}
