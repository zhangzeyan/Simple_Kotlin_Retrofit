package com.simple.retrofit

import io.reactivex.Observable

class SearchRepository(private val apiService: StudentApiService) {

    fun student(propertyId: Int): Observable<Student> {
        return apiService.student(propertyId)
    }

    fun studentAge(age: Int): Observable<List<Student>> {
        return apiService.studentAge(age)
    }
}