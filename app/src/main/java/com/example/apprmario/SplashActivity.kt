package com.example.apprmario

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.transition.Explode
import android.view.View
import android.view.ViewAnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.hypot


class SplashActivity : AppCompatActivity() {

    private var handler : Handler = Handler()
    private lateinit var img : ImageView
    private lateinit var lyt : LinearLayout
    private lateinit var run : Runnable
    private val explode = Explode()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        img = findViewById(R.id.splImg)
        lyt = findViewById(R.id.lytImg)

        explode.duration = 1000 // Duración en milisegundos
        window.exitTransition = explode

        //initRevelacionCircularI()
        initFadeTransI()
        handler.postDelayed(run, 1000)

        initSplash()
        handler.postDelayed(run, 3000)
    }


    //Funcion para pasar a la siguiente actividad despues de que el splash se muestra
    private fun initSplash(){
        run = Runnable {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finishAfterTransition()
        }
    }

    private fun initFadeTransI(){
        run = Runnable {
            val transY : ObjectAnimator = ObjectAnimator.ofFloat(lyt,"y",250f)
            val fade : ObjectAnimator = ObjectAnimator.ofFloat(lyt, View.ALPHA, 0.0f, 1.0f)

            val anim = AnimatorSet()
            anim.playTogether(transY, fade)
            anim.duration = 1000
            anim.start()

            //var anim = AnimatorSet()
        }
    }

    //Animacion de revelacion circular del logo
    private fun initRevelacionCircularI(){
        run = Runnable {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val cx = img.width / 2
                val cy = img.height / 2

                // Obtener el radio final donde termina el circulo
                val finalRadius = hypot(cx.toDouble(), cy.toDouble()).toFloat()
                println(finalRadius)

                // Crear el animador para la vista
                val anim : Animator = ViewAnimationUtils.createCircularReveal(img, cx, cy, 0f, finalRadius)
                anim.duration = 1000

                // Hacer que la vista sea visible e iniciar la animación
                img.visibility = View.VISIBLE
                anim.start()
            } else {
                img.visibility = View.INVISIBLE
            }
        }
    }
}
