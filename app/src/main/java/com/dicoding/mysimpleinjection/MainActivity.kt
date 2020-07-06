package com.dicoding.mysimpleinjection

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideEngine(@ApplicationContext context: Context): Engine = Engine(context)
}

@HiltAndroidApp
open class MyApplication : Application() {
}

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        car.start()
    }
}

@Singleton
class Car @Inject constructor(private val engine: Engine) {
    fun start() {
        engine.start()
    }
}

class Engine(val context: Context) {
    fun start() {
        println(context.applicationContext.getString(R.string.engine_start))
    }
}
