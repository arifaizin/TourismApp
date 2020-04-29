package com.dicoding.tourismapp.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.dicoding.tourismapp.R
import com.dicoding.tourismapp.core.data.source.local.entity.TourismEntity
import kotlinx.android.synthetic.main.activity_detail_home.*
import kotlinx.android.synthetic.main.content_detail_home.*

class DetailHomeActivity : AppCompatActivity() {

    private lateinit var detailMovieViewModel: DetailTourismViewModel

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_home)
        setSupportActionBar(toolbar)

        val factory = DetailTourismViewModelFactory.getInstance(this)
        detailMovieViewModel = ViewModelProvider(this, factory)[DetailTourismViewModel::class.java]

        val detailTourism = intent.getParcelableExtra<TourismEntity>(EXTRA_DATA)
        showDetailTourism(detailTourism)
    }

    private fun showDetailTourism(detailTourism: TourismEntity?) {
        detailTourism?.let {
            supportActionBar?.title = detailTourism.name
            detail_description.text = detailTourism.description
            Glide.with(this@DetailHomeActivity)
                .load(detailTourism.image)
                .into(detail_image)

            var statusFavorite = detailTourism.isFavorite
            setStatusFavorite(statusFavorite)
            fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailMovieViewModel.setFavoriteMovie(detailTourism, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) fab.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.ic_favorite_white
            )
        )
        else fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
    }
}
