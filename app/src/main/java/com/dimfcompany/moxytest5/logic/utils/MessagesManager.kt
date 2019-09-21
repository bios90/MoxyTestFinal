package com.dimfcompany.moxytest5.logic.utils

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.annotation.ColorRes
import com.arellomobile.mvp.MvpAppCompatActivity
import com.dimfcompany.moxytest5.R
import com.dimfcompany.moxytest5.base.makeTransparentBg
import com.tapadoo.alerter.Alerter

class MessagesManager(val activity: MvpAppCompatActivity) {
    var progressDialog: AlertDialog? = null
    //region Alerter
    fun showNoInternetAlerter() {
        showRedAlerter("Ошибка", "Нет соединения с сетью")
    }

    fun showRedAlerter(text: String) {
        showAlerter("Ошибка", text, R.color.redLight)
    }

    fun showRedAlerter(title: String, text: String) {
        showAlerter(title, text, R.color.redLight)
    }

    fun showGreenAlerter(text: String) {
        showAlerter("", text, R.color.green)
    }

    fun showGreenAlerter(title: String, text: String) {
        showAlerter(title, text, R.color.green)
    }

    fun showAlerter(title: String, text: String, @ColorRes color: Int) {
        Alerter.create(activity)
            .setTitle(title)
            .setText(text)
            .setDuration(4000)
            .setBackgroundColorRes(color)
            .setOnClickListener(View.OnClickListener { Alerter.hide() })
            .show()
    }
    //endregion

    fun showProgressDialog() {
        showProgressDialog(null)
    }

    fun showProgressDialog(message: String?) {
        if (progressDialog != null && progressDialog!!.isShowing) {
            dismissProgressDialog()
        }

        val dialogView = LayoutInflater.from(activity).inflate(R.layout.progress_spinner_dialog, null)
        val textView: TextView = dialogView.findViewById(R.id.tv_header_title)

        if (message != null) {
            textView.text = message
        }

        progressDialog = AlertDialog.Builder(activity).create()
        progressDialog!!.setCancelable(false)
        progressDialog!!.setCanceledOnTouchOutside(false)
        progressDialog!!.setView(dialogView)
        progressDialog!!.makeTransparentBg()
        progressDialog!!.show()
    }

    fun dismissProgressDialog() {
        if (progressDialog != null) {
            if (progressDialog!!.isShowing) {
                progressDialog!!.dismiss()
            }

            progressDialog = null
        }
    }
}