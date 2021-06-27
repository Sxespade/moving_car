package com.myapp.movingcar

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnStart
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var objectAnimator: ObjectAnimator
    private lateinit var objectAnimator2: ObjectAnimator
    private lateinit var objectAnimator3: ObjectAnimator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.car)




        imageView.setOnClickListener {
            objectAnimator = ObjectAnimator.ofFloat(imageView,View.TRANSLATION_X,imageView.translationX,
                imageView.translationX + 200f)
            objectAnimator2 = ObjectAnimator.ofFloat(imageView,View.TRANSLATION_Y,imageView.translationY,
                imageView.translationY + 200f)
            objectAnimator.duration = 4000
            objectAnimator.start()
            objectAnimator.doOnEnd {
                    objectAnimator2.duration = 4000
                    objectAnimator2.start()
                }
        }
    }
}