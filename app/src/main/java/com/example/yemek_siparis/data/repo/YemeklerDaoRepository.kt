package com.example.yemek_siparis.data.repo

import androidx.lifecycle.MutableLiveData
import com.example.yemek_siparis.data.entity.Yemekler
import com.example.yemek_siparis.data.entity.YemeklerCevap
import com.example.yemek_siparis.retrofit.YemeklerDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YemeklerDaoRepository(var ydao:YemeklerDao) {
    var yemeklerListesi:MutableLiveData<List<Yemekler>>
    //http://kasimadalan.pe.hu/kisiler/tum_kisiler.php

    init {
    yemeklerListesi = MutableLiveData()
    }

    fun yemekleriGetir() : MutableLiveData<List<Yemekler>>{
        return yemeklerListesi
    }

    fun tumYemekleriAl(){
       /* val liste = ArrayList<Yemekler>()
        val y1 = Yemekler(1,"Kebap",15,"sfj6u6ur")
        val y2 = Yemekler(2,"Lahmacun",20,"lahmacun")

        liste.add(y1)
        liste.add(y2)
        yemeklerListesi.value = liste*/

        ydao.tumYemekler().enqueue(object:Callback<YemeklerCevap>{
            override fun onResponse(call: Call<YemeklerCevap>?, response: Response<YemeklerCevap>) {
                val liste = response.body().yemekler
                yemeklerListesi.value = liste
            }

            override fun onFailure(call: Call<YemeklerCevap>?, t: Throwable?) {}
        })
    }

    fun yemekEkle(yemek_ad:String,yemek_fiyat:Int){

    }

    fun yemekSil(yemek_id:Int){

    }
}