package com.dicoding.mysimpleinjection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    lateinit var engine: Engine

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        engine = Engine()
        val car = Car(engine)
        car.start()
    }
}

class Car (private val engine: Engine) {
    fun start() {
        engine.start()
    }
}

class Engine() {
    fun start() {
        println("Engine started....")
    }
}