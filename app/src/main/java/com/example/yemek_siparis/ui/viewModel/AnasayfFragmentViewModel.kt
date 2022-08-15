package com.example.yemek_siparis.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemek_siparis.data.entity.Yemekler
import com.example.yemek_siparis.data.repo.YemeklerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnasayfFragmentViewModel @Inject constructor (var yrepo:YemeklerDaoRepository) : ViewModel() {

    var yemeklerListesi = MutableLiveData<List<Yemekler>>()

    init {
        yemekleriYukle()
        yemeklerListesi = yrepo.yemekleriGetir()
    }

    fun yemekleriYukle(){
        yrepo.tumYemekleriAl()
    }
}