package com.example.yemek_siparis.data.repo

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.yemek_siparis.MainActivity
import com.example.yemek_siparis.R
import com.example.yemek_siparis.data.entity.*
import com.example.yemek_siparis.retrofit.SepetYemeklerDao
import com.example.yemek_siparis.retrofit.YemeklerDao
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SepetYemeklerDaoRepository(var sdao:SepetYemeklerDao) {
    var sepetYemeklerListesi:MutableLiveData<List<SepetYemekler>>
    //http://kasimadalan.pe.hu/kisiler/tum_kisiler.php

    init {
        sepetYemeklerListesi = MutableLiveData()
    }

    fun sepettekiYemekleriGetir() : MutableLiveData<List<SepetYemekler>>{
        return sepetYemeklerListesi
    }

    fun tumYemekleriAl(kullanici_adi: String){
         /*val listem = ArrayList<SepetYemekler>()
         val yem1 = SepetYemekler(1,"Kebap",15,"sfj6u6ur",1, "mert_kafali")
         val yem2 = SepetYemekler(2,"Lahmacun",20,"lahmacun",2,"mert_kafali")

         listem.add(yem1)
         listem.add(yem2)
         sepetYemeklerListesi.value = listem*/

       sdao.tumSepetYemekler(kullanici_adi).enqueue(object:Callback<SepetYemeklerCevap>{
            override fun onResponse(call: Call<SepetYemeklerCevap>?, response: Response<SepetYemeklerCevap>) {
                val list = response.body().sepet_yemekler
                sepetYemeklerListesi.value = list
            }

            override fun onFailure(call: Call<SepetYemeklerCevap>?, t: Throwable?) {}
        })
    }

    fun yemekEkle(yemek_ad:String,yemek_resim_adi:String,yemek_fiyat:Int,yemek_siparis_adet:Int,kullanici_adi:String){
         sdao.yemekEkle(yemek_ad,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi).enqueue(object:Callback<CRUDCevap>{
             override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>) {
                 val basari = response.body().success
                 val mesaj = response.body().message
                    Log.e("Sepete Eklendi","$basari - $mesaj")
             }

             override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {}
         })
    }

    fun yemekSil(yemek_id:Int,kullanici_adi: String){
        sdao.yemekSil(yemek_id,kullanici_adi).enqueue(object:Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>) {
                tumYemekleriAl(kullanici_adi)
            }
            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {}
        })
    }
}