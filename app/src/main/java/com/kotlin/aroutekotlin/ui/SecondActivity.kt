package com.kotlin.aroutekotlin.ui

import android.content.Intent
import com.alibaba.android.arouter.facade.annotation.Route
import com.kotlin.aroutekotlin.bean.User
import com.kotlin.aroutekotlin.databinding.AcySecondBinding
import com.kotlin.base.RoutePath
import com.kotlin.base.base.BaseActivity
import com.kotlin.base.common.ArouteKey
import java.lang.StringBuilder

@Route(path = RoutePath.Main.PAGE_SECOND_ACTIVITY)
class SecondActivity:BaseActivity<AcySecondBinding>() {
    override fun initView() {
        withData()
        mBinding.mResultBtn.setOnClickListener {
            val intent = Intent().apply {
                putExtra(ArouteKey.MAIN.KEY_STRING,"Second Back")
            }
            setResult(1001,intent)
        }
    }

    private fun withData() {
        val sb = StringBuilder()
        val stringExtra = intent.getStringExtra(ArouteKey.MAIN.KEY_STRING)
        val user = intent.getParcelableExtra<User>(ArouteKey.MAIN.KEY_PARCELABLE)
        sb.append(stringExtra)
        sb.append(",")
        sb.append(user?.name)
        mBinding.textView.text = sb.toString()
    }

    override fun getSubBinging() = AcySecondBinding.inflate(layoutInflater)
}