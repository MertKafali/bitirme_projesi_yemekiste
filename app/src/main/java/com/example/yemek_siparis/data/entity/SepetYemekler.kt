package com.example.yemek_siparis.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SepetYemekler(@SerializedName("sepet_yemek_id") var yemek_id:Int,
                         @SerializedName("yemek_adi") var yemek_ad:String,
                         @SerializedName("yemek_resim_adi") var yemek_resim:String,
                         @SerializedName("yemek_fiyat") var yemek_fiyat:Int,
                         @SerializedName("yemek_siparis_adet") var yemek_siparis_adet:Int,
                         @SerializedName("kullanici_adi") var kullanici_adi:String) : Serializable {
}