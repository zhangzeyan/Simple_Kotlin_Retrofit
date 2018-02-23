package com.simple.retrofit


object SearchRepositoryProvider {
    fun provideSearchRepository(): SearchRepository {
        return SearchRepository(StudentApiService.create())
    }
}