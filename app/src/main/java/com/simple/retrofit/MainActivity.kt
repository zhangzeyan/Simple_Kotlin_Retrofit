package com.simple.retrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val repository = SearchRepositoryProvider.provideSearchRepository()

//        repository.student(1)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe({ result ->
//                    tv_name.text= "姓名："+result.name
//                    tv_age.text= "年龄："+result.age
//
//                    tv_sex.text= "性别："+ if (result.isSex) "男" else "女"
//                }, { error ->
//                    error.printStackTrace()
//                })

        repository.studentAge(22)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    tv_name.text= "姓名："+result[1].name
                    tv_age.text= "年龄："+result[1].age

                    tv_sex.text= "性别："+ if (result[1].isSex) "男" else "女"
                }, { error ->
                    error.printStackTrace()
                })
    }

}
