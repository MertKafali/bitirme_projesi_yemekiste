package com.example.yemek_siparis.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SepetYemeklerCevap(@SerializedName("sepet_yemekler") var sepet_yemekler: List<SepetYemekler>,
                              @SerializedName("success")  var success:Int) {
}