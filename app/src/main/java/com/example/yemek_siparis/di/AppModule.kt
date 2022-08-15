package com.example.yemek_siparis.di

import com.example.yemek_siparis.data.repo.SepetYemeklerDaoRepository
import com.example.yemek_siparis.data.repo.YemeklerDaoRepository
import com.example.yemek_siparis.retrofit.ApiUtils
import com.example.yemek_siparis.retrofit.SepetYemeklerDao
import com.example.yemek_siparis.retrofit.YemeklerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideYemeklerDaoRepository(ydao:YemeklerDao) : YemeklerDaoRepository{
        return YemeklerDaoRepository(ydao)
    }

    @Provides
    @Singleton
    fun provideYemeklerDao() : YemeklerDao{
        return ApiUtils.getYemeklerDao()
    }

    @Provides
    @Singleton
    fun provideSepetYemeklerDaoRepository(sdao:SepetYemeklerDao) : SepetYemeklerDaoRepository{
        return SepetYemeklerDaoRepository(sdao)
    }

    @Provides
    @Singleton
    fun provideSepetYemeklerDao() : SepetYemeklerDao{
        return ApiUtils.getSepetYemeklerDao()
    }
}