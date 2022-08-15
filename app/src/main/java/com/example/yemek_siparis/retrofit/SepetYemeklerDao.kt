package com.example.yemek_siparis.retrofit

import com.example.yemek_siparis.data.entity.CRUDCevap
import com.example.yemek_siparis.data.entity.SepetYemeklerCevap
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface SepetYemeklerDao {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    fun tumSepetYemekler(@Field("kullanici_adi") kullanici_adi:String) : Call<SepetYemeklerCevap>

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    fun yemekEkle(@Field("yemek_adi") yemek_ad:String,
                  @Field("yemek_resim_adi") yemek_resim_adi:String,
                  @Field("yemek_fiyat") yemek_fiyat:Int,
                  @Field("yemek_siparis_adet") yemek_siparis_adet:Int,
                  @Field("kullanici_adi") kullanici_adi:String) : Call<CRUDCevap>

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    fun yemekSil(@Field("sepet_yemek_id") yemek_id:Int,@Field("kullanici_adi") kullanici_adi: String) : Call<CRUDCevap>
}