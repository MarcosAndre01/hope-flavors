package br.ufpb.care.extension

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast

fun String.showMessage(context: Context?) {
    val message = Toast.makeText(context, this, Toast.LENGTH_LONG)
    val view = message.view
//    view?.setBackgroundResource(R.drawable.backgroud_notification)
    val text = view?.findViewById<TextView>(android.R.id.message)
    text?.gravity = Gravity.CENTER
    text?.setTextColor(Color.parseColor("#FF0000"))

    message.setGravity(Gravity.TOP, 0, 0)
    message.show()
}