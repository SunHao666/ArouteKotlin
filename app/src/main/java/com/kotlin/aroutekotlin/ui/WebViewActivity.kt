package com.kotlin.aroutekotlin.ui

import com.alibaba.android.arouter.facade.annotation.Route
import com.kotlin.aroutekotlin.databinding.AcyWebviewBinding
import com.kotlin.base.RoutePath
import com.kotlin.base.base.BaseActivity
import com.kotlin.base.common.ArouteKey

@Route(path = RoutePath.Main.PAGE_WEBVIEW_ACTIVITY)
class WebViewActivity : BaseActivity<AcyWebviewBinding>() {
    override fun initView() {
        intent?.apply {
            getStringExtra(ArouteKey.MAIN.KEY_URL)?.apply {
                mBinding.webview.loadUrl(this)
            }
        }
    }

    override fun getSubBinging() = AcyWebviewBinding.inflate(layoutInflater)
}