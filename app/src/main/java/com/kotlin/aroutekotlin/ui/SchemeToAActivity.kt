package com.kotlin.aroutekotlin.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.kotlin.aroutekotlin.R
import com.kotlin.aroutekotlin.databinding.AcySchemeABinding
import com.kotlin.base.RoutePath
import com.kotlin.base.base.BaseActivity
import java.lang.String

@Route(path = RoutePath.Main.PAGE_SEHEMEA_ACTIVITY)
class SchemeToAActivity:BaseActivity<AcySchemeABinding>() {
    @JvmField
    @Autowired(desc = "姓名")
    var name = "jack"
    @JvmField
    @Autowired
    var age = 10
    @JvmField
    @Autowired
    var height = 175
    @JvmField
    @Autowired(name = "boy", required = true)
    var girl = false


    override fun onCreate(savedInstanceState: Bundle?) {
        ARouter.getInstance().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun initView() {

        // No more getter ...
        // name = getIntent().getStringExtra("name");
        // age = getIntent().getIntExtra("age", 0);
        // girl = getIntent().getBooleanExtra("girl", false);
        // high = getIntent().getLongExtra("high", 0);
        // url = getIntent().getStringExtra("url");
        val params = String.format(
            "name=%s,\n age=%s, \n height=%s,\n girl=%s",
            name,
            age,
            height,
            girl
        )
        mBinding.test.text = params
    }

    override fun getSubBinging() = AcySchemeABinding.inflate(layoutInflater)
}