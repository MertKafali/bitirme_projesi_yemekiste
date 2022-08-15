package com.example.yemek_siparis.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Yemekler(@SerializedName("yemek_id")var yemek_id:Int,
                    @SerializedName("yemek_adi")var yemek_ad:String,
                    @SerializedName("yemek_fiyat")var yemek_fiyat:Int,
                    @SerializedName("yemek_resim_adi")var yemek_resim:String) : Serializable {
}