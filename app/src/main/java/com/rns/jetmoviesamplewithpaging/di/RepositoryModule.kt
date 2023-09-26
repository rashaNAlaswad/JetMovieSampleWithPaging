package com.rns.jetmoviesamplewithpaging.di

import com.rns.jetmoviesamplewithpaging.data.MovieRepository
import com.rns.jetmoviesamplewithpaging.data.MovieRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRepositoryImp: MovieRepositoryImp,
    ): MovieRepository = movieRepositoryImp
}