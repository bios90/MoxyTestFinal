package com.dimfcompany.moxytest5.ui.act_first

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface ActFirstMvp : MvpView
{
    @StateStrategyType(value = AddToEndSingleStrategy::class)
    fun bind_dummy_data(text1: String, text2: String)
}