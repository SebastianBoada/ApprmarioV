package com.example.apprmario


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun alert(v: View){
        buildAlertDialog().show()
    }

    fun buildAlertDialog() : AlertDialog.Builder {
        val inflater = this.layoutInflater
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)

        builder.apply {
            setView(inflater.inflate(R.layout.alertdialog_delete, null))
        }

        builder.create()

        return builder
    }

    private fun buildAlertDC() : AlertDialog.Builder{
        val builder : AlertDialog.Builder = AlertDialog.Builder(this)

        val inflater : LayoutInflater = this.layoutInflater

        builder.apply {
            setTitle("Soy un titulo")
            setView(inflater.inflate(R.layout.activity_main, null))
        }

        return builder
    }


}

