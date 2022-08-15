package com.example.yemek_siparis.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.yemek_siparis.R
import com.example.yemek_siparis.data.entity.Yemekler
import com.example.yemek_siparis.databinding.FragmentAnasayfaBinding
import com.example.yemek_siparis.ui.adapter.YemeklerAdapter
import com.example.yemek_siparis.ui.viewModel.AnasayfFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var tasarim:FragmentAnasayfaBinding
    private lateinit var viewModel:AnasayfFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false)

        tasarim.rv.layoutManager = LinearLayoutManager(requireContext())

        viewModel.yemeklerListesi.observe(viewLifecycleOwner){
            val adapter = YemeklerAdapter(requireContext(), it,viewModel)
            tasarim.rv.adapter = adapter
        }



        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel:AnasayfFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }
}