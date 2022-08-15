package com.example.yemek_siparis.ui.adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.yemek_siparis.R
import com.example.yemek_siparis.data.entity.SepetYemekler
import com.example.yemek_siparis.data.entity.Yemekler
import com.example.yemek_siparis.databinding.CardTasarimBinding
import com.example.yemek_siparis.databinding.SepetCardTasarimBinding
import com.example.yemek_siparis.ui.fragment.AnasayfaFragmentDirections
import com.example.yemek_siparis.ui.viewModel.AnasayfFragmentViewModel
import com.example.yemek_siparis.ui.viewModel.SepetFragmentViewModel
import com.example.yemek_siparis.utils.gecisYap
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class SepetYemeklerAdapter (var mContext:Context, var sepetYemeklerListesi:List<SepetYemekler>,var viewModel:SepetFragmentViewModel) : RecyclerView.Adapter<SepetYemeklerAdapter.SepetCardTasarimTutucu>(){
    inner class SepetCardTasarimTutucu(tasarim:SepetCardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim:SepetCardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SepetCardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = SepetCardTasarimBinding.inflate(layoutInflater, parent, false)
        return SepetCardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: SepetCardTasarimTutucu, position: Int) {
        val yemek = sepetYemeklerListesi.get(position)
        val s = holder.tasarim
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim}"
        s.textViewBaslik.text = "${yemek.yemek_ad}"
        s.textViewYemekFiyat.text = "₺ ${yemek.yemek_fiyat}"
        s.textViewSepetAdet.text = "${yemek.yemek_siparis_adet} Adet"
        Picasso.get().load(url).into(s.imageViewYemekS)


        s.imageViewSil.setOnClickListener {
            /*viewModel.sil(yemek.yemek_id, "mert_kafali")
            Snackbar.make(it,"Silindi!",Snackbar.LENGTH_SHORT).show()*/
            Snackbar.make(it, "Silmek istediğinize emin misiniz?", Snackbar.LENGTH_LONG)
                .setAction("EVET") {
                    viewModel.sil(yemek.yemek_id, viewModel.kullanici_adi)
                }.show()
        }


    }

    override fun getItemCount(): Int {
        return sepetYemeklerListesi.size
    }
}