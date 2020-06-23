package com.instacarro.restaurants

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jetbrains.handson.mpp.mobile.viewmodels.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = MainViewModel()

        viewModel.countries.addObserver {
            GlobalScope.launch(Dispatchers.Main) {
                findViewById<TextView>(R.id.countriesLabel).text = it
            }
        }
        viewModel.cities.addObserver {
            GlobalScope.launch(Dispatchers.Main) {
                findViewById<TextView>(R.id.citiesLabel).text = it
            }
        }
        viewModel.restaurants.addObserver {
            GlobalScope.launch(Dispatchers.Main) {
                findViewById<TextView>(R.id.restaurantsLabel).text = it
            }
        }
        viewModel.loading.addObserver {
            GlobalScope.launch(Dispatchers.Main) {
                findViewById<View>(R.id.progressBar).visibility = if (it)
                    View.VISIBLE
                else
                    View.INVISIBLE
            }
        }

        viewModel.loadData()
    }
}
