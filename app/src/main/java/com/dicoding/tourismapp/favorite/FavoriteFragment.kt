package com.dicoding.tourismapp.favorite

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.tourismapp.R
import com.dicoding.tourismapp.core.ui.TourismAdapter
import com.dicoding.tourismapp.core.ui.ViewModelFactory
import com.dicoding.tourismapp.databinding.FragmentFavoriteBinding
import com.dicoding.tourismapp.detail.DetailTourismActivity
import kotlinx.android.synthetic.main.fragment_favorite.*
import kotlinx.android.synthetic.main.fragment_home.rv_tourism

class FavoriteFragment : Fragment() {

    private lateinit var favoriteViewModel: FavoriteViewModel
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

//            hapus kode berikut
//            val factory = ViewModelFactory.getInstance(requireActivity())
//            val viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

            val tourismAdapter = TourismAdapter()
            tourismAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailTourismActivity::class.java)
                intent.putExtra(DetailTourismActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            val factory = ViewModelFactory.getInstance(requireActivity())
            favoriteViewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

            favoriteViewModel.favoriteTourism.observe(viewLifecycleOwner) { dataTourism ->
                tourismAdapter.submitList(dataTourism)
                binding.viewEmpty.root.visibility =
                    if (dataTourism.isNotEmpty()) View.GONE else View.VISIBLE
            }

            with(binding.rvTourism) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tourismAdapter
            }
        }
    }
}
