package com.dicoding.tourismapp.maps

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.dicoding.core.data.Resource
import com.dicoding.core.domain.Tourism
import com.dicoding.tourismapp.MyApplication
import com.dicoding.tourismapp.R
import com.dicoding.tourismapp.detail.DetailTourismActivity
import com.dicoding.tourismapp.di.ViewModelFactory
import com.dicoding.tourismapp.home.HomeViewModel
import com.google.gson.Gson
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.geometry.LatLngBounds
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.plugins.annotation.SymbolManager
import com.mapbox.mapboxsdk.plugins.annotation.SymbolOptions
import kotlinx.android.synthetic.main.activity_maps.*
import kotlinx.android.synthetic.main.view_error.*
import javax.inject.Inject


class MapsActivity : AppCompatActivity() {

    companion object {
        private const val ICON_ID = "ICON_ID"
    }

    private lateinit var mapboxMap: MapboxMap

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: HomeViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        supportActionBar?.title = "Tourism Map"

        mapView?.onCreate(savedInstanceState)
        mapView?.getMapAsync { mapboxMap ->
            this.mapboxMap = mapboxMap
            getTourismData()
        }
    }

    private fun getTourismData() {
        viewModel.getTourism().observe(this, Observer { tourism ->
            if (tourism != null) {
                when (tourism) {
                    is Resource.Loading -> progress_bar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        progress_bar.visibility = View.GONE
                        showMarker(tourism.data)
                    }
                    is Resource.Error -> {
                        progress_bar.visibility = View.GONE
                        view_error.visibility = View.VISIBLE
                        tv_error.text = tourism.message ?: getString(R.string.something_wrong)
                    }
                }
            }
        })
    }

    private fun showMarker(dataTourism: List<Tourism>?) {
        mapboxMap.setStyle(Style.MAPBOX_STREETS) { style ->
            style.addImage(ICON_ID, BitmapFactory.decodeResource(resources, R.drawable.mapbox_marker_icon_default))
            val latLngBoundsBuilder = LatLngBounds.Builder()

            val symbolManager = SymbolManager(mapView, mapboxMap, style)
            symbolManager.iconAllowOverlap = true

            dataTourism?.forEach { data ->
                latLngBoundsBuilder.include(LatLng(data.latitude, data.longitude))
                symbolManager.create(
                    SymbolOptions()
                        .withLatLng(LatLng(data.latitude, data.longitude))
                        .withIconImage(ICON_ID)
                        .withData(Gson().toJsonTree(data))
                )
            }

            val latLngBounds = latLngBoundsBuilder.build()
            mapboxMap.easeCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 50), 5000)

            symbolManager.addClickListener { symbol ->
                val data = Gson().fromJson(symbol.data, Tourism::class.java)
                val intent = Intent(this, DetailTourismActivity::class.java)
                intent.putExtra(DetailTourismActivity.EXTRA_DATA, data)
                startActivity(intent)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }
}

