package com.dimfcompany.moxytest5.base.activity

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity

abstract class BaseActivity : MvpAppCompatActivity()
{
    protected val TAG = this::class.java.name

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        make_injection()
    }

    abstract fun make_injection()
}