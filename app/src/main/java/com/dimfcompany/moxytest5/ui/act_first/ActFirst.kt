package com.dimfcompany.moxytest5.ui.act_first

import android.os.Bundle
import android.util.Log
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.dimfcompany.moxytest5.R
import com.dimfcompany.moxytest5.base.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class ActFirst : BaseActivity(), ActFirstMvp
{
    @InjectPresenter
    lateinit var presenter: ActFirstPresenter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners()
    {
        btn_login.setOnClickListener(
            {
                presenter.clicked_register()
            })
    }

    override fun make_injection()
    {
        presenter.getPresenterComponent(this).inject(presenter)
    }

    override fun bind_dummy_data(text1: String, text2: String)
    {
        Log.e(TAG, "Called here: ")
        tv_register.setText(text1 + " ||| " + text2)
    }
}
