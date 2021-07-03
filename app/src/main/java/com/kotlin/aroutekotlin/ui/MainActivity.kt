package com.kotlin.aroutekotlin.ui

import android.content.Intent
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.kotlin.aroutekotlin.bean.User
import com.kotlin.aroutekotlin.databinding.ActivityMainBinding
import com.kotlin.base.RoutePath
import com.kotlin.base.base.BaseActivity
import com.kotlin.base.common.ArouteKey
import com.kotlin.base.common.e
import com.kotlin.moudlea.fragment.BlankFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun initView() {
        mBinding.mNormalBtn.setOnClickListener {
            skipNomal()
        }
        mBinding.mWithDataBtn.setOnClickListener {
            skipWithData()
        }
        mBinding.mResultBtn.setOnClickListener {
            skipForResult()
        }
        mBinding.mFragmentBtn.setOnClickListener {
            getFragmentInstance()
        }
        mBinding.mSchemeBtn.setOnClickListener {
            skipScheme()
        }
        mBinding.mInterceptor.setOnClickListener {
            interceptorTest()
        }
    }

    private fun interceptorTest() {
        ARouter.getInstance().build(RoutePath.Main.PAGE_INTERCEPTOR_ACTIVITY).navigation(this,object :NavigationCallback{
            override fun onLost(postcard: Postcard?) {
                "onLost".e()
            }

            override fun onFound(postcard: Postcard?) {
                "onFound".e()
            }

            override fun onInterrupt(postcard: Postcard?) {
                "被拦截了".e()
            }

            override fun onArrival(postcard: Postcard?) {
                "arrive".e()

            }

        })
    }

    private fun skipScheme() {
        ARouter.getInstance().build(RoutePath.Main.PAGE_WEBVIEW_ACTIVITY)
            .withString(ArouteKey.MAIN.KEY_URL,"file:///android_asset/scheme-test.html").navigation()
    }

    private fun getFragmentInstance() {
        val fragment = ARouter.getInstance().build(RoutePath.ModuleA.PAGE_MODULEA_BLANKFRAGMENT)
            .navigation() as Fragment
    }

    private fun skipForResult() {
        ARouter.getInstance()
            .build(RoutePath.Main.PAGE_SECOND_ACTIVITY)
            .navigation(this, 1000)
    }

    private fun skipWithData() {
        ARouter.getInstance().build(RoutePath.Main.PAGE_SECOND_ACTIVITY)
            .withString(ArouteKey.MAIN.KEY_STRING, "hello aroute")
            .withParcelable(ArouteKey.MAIN.KEY_PARCELABLE, User("张三"))
            .navigation()
    }

    private fun skipNomal() {
        ARouter.getInstance().build(RoutePath.Main.PAGE_SECOND_ACTIVITY).navigation()
    }

    override fun getSubBinging() = ActivityMainBinding.inflate(layoutInflater)

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1000) {
            data.apply {
                val stringExtra = data?.getStringExtra(ArouteKey.MAIN.KEY_STRING)
                println(stringExtra)
            }
        }
    }
}