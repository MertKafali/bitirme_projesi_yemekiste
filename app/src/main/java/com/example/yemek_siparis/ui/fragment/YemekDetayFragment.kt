package com.example.yemek_siparis.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.yemek_siparis.MainActivity
import com.example.yemek_siparis.R
import com.example.yemek_siparis.data.repo.YemeklerDaoRepository
import com.example.yemek_siparis.databinding.FragmentSepetBinding
import com.example.yemek_siparis.databinding.FragmentYemekDetayBinding
import com.example.yemek_siparis.ui.adapter.YemeklerAdapter
import com.example.yemek_siparis.ui.viewModel.SepetFragmentViewModel
import com.example.yemek_siparis.ui.viewModel.YemekDetayFragmentViewModel
import com.example.yemek_siparis.utils.gecisYap
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YemekDetayFragment : Fragment() {
private lateinit var tasarim:FragmentYemekDetayBinding
private lateinit var viewModel:SepetFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentYemekDetayBinding.inflate(inflater, container, false)

        val bundle:YemekDetayFragmentArgs by navArgs()
        val gelenYemek = bundle.yemek
        var yemek_siparis_adet = 1

        tasarim.textViewYemekAdi.text = gelenYemek.yemek_ad
        tasarim.textViewYEmekFiyati.text = "₺ " + gelenYemek.yemek_fiyat.toString()
        Picasso.get().load("http://kasimadalan.pe.hu/yemekler/resimler/${gelenYemek.yemek_resim}").into(tasarim.imageViewResim)

        tasarim.buttonSepeteEkle.setOnClickListener {
            var yemek_ad = gelenYemek.yemek_ad
            var yemek_fiyat = gelenYemek.yemek_fiyat
            var yemek_resim_adi = gelenYemek.yemek_resim

            viewModel.ekle(yemek_ad, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet,"mert_kafali")
            Log.e("Yemeği sepete ekle","$yemek_ad - $yemek_fiyat - $yemek_siparis_adet")
            Snackbar.make(it,"Sepete Eklendi!",Snackbar.LENGTH_SHORT).show()

        }

        tasarim.button.setOnClickListener {
            val gecis = YemekDetayFragmentDirections.gitAnasayfa()
            Navigation.gecisYap(it,gecis)
        }

        tasarim.buttonArtir.setOnClickListener {
            yemek_siparis_adet += 1
            tasarim.textViewAdet.text = yemek_siparis_adet.toString()
        }
        tasarim.buttonAzalt.setOnClickListener {
        if (yemek_siparis_adet > 1){
            yemek_siparis_adet -= 1
            tasarim.textViewAdet.text = yemek_siparis_adet.toString()
        }
        }

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel: SepetFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

}