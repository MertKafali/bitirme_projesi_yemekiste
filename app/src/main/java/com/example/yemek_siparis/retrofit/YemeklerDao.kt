package com.example.yemek_siparis.retrofit

import com.example.yemek_siparis.data.entity.YemeklerCevap
import retrofit2.Call
import retrofit2.http.GET

interface YemeklerDao {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php

    @GET("yemekler/tumYemekleriGetir.php")
    fun tumYemekler() : Call<YemeklerCevap>


}