package com.example.yemek_siparis.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemek_siparis.data.entity.SepetYemekler
import com.example.yemek_siparis.data.repo.SepetYemeklerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SepetFragmentViewModel @Inject constructor (var srepo:SepetYemeklerDaoRepository) : ViewModel()  {

    var sepetYemeklerListesi = MutableLiveData<List<SepetYemekler>>()
    var kullanici_adi = "mert_kafali"

    init {
        yemekleriYukle()
        sepetYemeklerListesi = srepo.sepettekiYemekleriGetir()
    }

    fun yemekleriYukle(){
        srepo.tumYemekleriAl(kullanici_adi)
    }

    fun ekle(yemek_ad:String,yemek_resim_adi:String,yemek_fiyat:Int,yemek_siparis_adet:Int,kullanici_adi:String){
        srepo.yemekEkle(yemek_ad,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
    }

    fun sil(yemek_id:Int,kullanici_adi: String){
       srepo.yemekSil(yemek_id,kullanici_adi)
    }
}