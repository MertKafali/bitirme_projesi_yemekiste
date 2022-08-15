package com.example.yemek_siparis.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.yemek_siparis.data.repo.SepetYemeklerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class YemekDetayFragmentViewModel @Inject constructor (var yrepo:SepetYemeklerDaoRepository) : ViewModel()  {


    fun ekle(yemek_ad:String,yemek_resim_adi:String,yemek_fiyat:Int,yemek_siparis_adet:Int,kullanici_adi:String){
        yrepo.yemekEkle(yemek_ad,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
    }
}