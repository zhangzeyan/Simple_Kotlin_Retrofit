package com.simple.retrofit

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface StudentApiService {

    @GET("student/{propertyId}")
    fun student(@Path("propertyId") propertyId :Int): Observable<Student>

    @GET("student/age/{age}")
    fun studentAge(@Path("age") age :Int): Observable<List<Student>>


    companion object Factory {
        fun create(): StudentApiService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://172.18.3.11:8080/")
                    .build()

            return retrofit.create(StudentApiService::class.java);
        }
    }
}