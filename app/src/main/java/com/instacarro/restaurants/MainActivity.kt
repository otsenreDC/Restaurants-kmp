package com.instacarro.restaurants

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jetbrains.handson.mpp.mobile.presentation.Main
import com.jetbrains.handson.mpp.mobile.presentation.MainPresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), MainPresenter {

    private val main = Main(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main.loadMain()
    }

    override fun numberOfCities(value: String) {
        GlobalScope.apply {
            launch(Dispatchers.Main) {
                findViewById<TextView>(R.id.citiesLabels).text = value
            }
        }
    }

    override fun numberOfCountries(value: String) {
        GlobalScope.apply {
            launch(Dispatchers.Main) {
                findViewById<TextView>(R.id.countriesLabel).text = value
            }
        }
    }

    override fun numberOfRestaurants(value: String) {
        GlobalScope.apply {
            launch(Dispatchers.Main) {
                findViewById<TextView>(R.id.restaurantsLabels).text = value
            }
        }
    }

    override fun loading(loading: Boolean) {
        GlobalScope.apply {
            launch(Dispatchers.Main) {
                findViewById<ProgressBar>(R.id.progressBar).visibility =
                    if (loading) View.VISIBLE else View.INVISIBLE
            }
        }
    }
}
