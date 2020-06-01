package com.dicoding.mysimpleinjection

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module


val appModule = module {
    factory {
        Engine(get())
    }

    single {
        Car(get())
    }
}

open class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }
}

class MainActivity : AppCompatActivity() {

    val car: Car by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        car.start()
    }
}

class Car(private val engine: Engine) {
    fun start() {
        engine.start()
    }
}

class Engine(val context: Context) {
    fun start() {
        println(context.applicationContext.getString(R.string.engine_start))
    }
}