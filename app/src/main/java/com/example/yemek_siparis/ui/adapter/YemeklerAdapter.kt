package com.example.yemek_siparis.ui.adapter

import android.app.AlertDialog
import android.content.Context
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.yemek_siparis.R
import com.example.yemek_siparis.data.entity.Yemekler
import com.example.yemek_siparis.databinding.CardTasarimBinding
import com.example.yemek_siparis.ui.fragment.AnasayfaFragmentDirections
import com.example.yemek_siparis.ui.viewModel.AnasayfFragmentViewModel
import com.example.yemek_siparis.utils.gecisYap
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class YemeklerAdapter (var mContext:Context, var yemeklerListesi:List<Yemekler>,var viewModel:AnasayfFragmentViewModel) : RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu>(){
    inner class CardTasarimTutucu(tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim:CardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardTasarimBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemek = yemeklerListesi.get(position)
        val t = holder.tasarim
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim}"
        t.textViewAd.text = "${yemek.yemek_ad}"
        t.textViewFiyat.text = "₺ ${yemek.yemek_fiyat}"
        Picasso.get().load(url).into(t.imageViewYemek)

        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.gitYemekdetay(yemek = yemek)
            Navigation.gecisYap(it,gecis)

            /*val ad = AlertDialog.Builder(getActivity())
            val alerTasarim = layoutInflater.inflate(R.layout.fragment_yemek_detay,null)

            ad.setView(alerTasarim)

            val d = ad.create()

            d.show()*/
        }

        t.buttonEkle.setOnClickListener {
            Snackbar.make(it,"Sepete Eklendi!",Snackbar.LENGTH_SHORT).show()
        }


    }

    override fun getItemCount(): Int {
        return yemeklerListesi.size
    }
}