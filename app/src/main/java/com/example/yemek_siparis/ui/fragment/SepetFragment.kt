package com.example.yemek_siparis.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yemek_siparis.MainActivity
import com.example.yemek_siparis.R
import com.example.yemek_siparis.data.entity.SepetYemekler
import com.example.yemek_siparis.databinding.FragmentAnasayfaBinding
import com.example.yemek_siparis.databinding.FragmentSepetBinding
import com.example.yemek_siparis.ui.adapter.SepetYemeklerAdapter
import com.example.yemek_siparis.ui.adapter.YemeklerAdapter
import com.example.yemek_siparis.ui.viewModel.SepetFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SepetFragment : Fragment() {
private lateinit var tasarim:FragmentSepetBinding
private lateinit var viewModel: SepetFragmentViewModel
    private lateinit var tumSepet : List<SepetYemekler>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentSepetBinding.inflate(inflater, container, false)

        tasarim.rvv.layoutManager = LinearLayoutManager(requireContext())

        viewModel.sepetYemeklerListesi.observe(viewLifecycleOwner){
            val adapterr = SepetYemeklerAdapter(requireContext(), it,viewModel)
            tasarim.rvv.adapter = adapterr
tumSepet =viewModel.sepetYemeklerListesi.value!!
        }

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel:SepetFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.yemekleriYukle()
    }

}