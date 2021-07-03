package com.kotlin.base.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.alibaba.android.arouter.facade.annotation.Autowired

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {


    lateinit var mBinding: VB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = getSubBinging()
        setContentView(mBinding.root)
        initView()
    }

    abstract fun initView()

    abstract fun getSubBinging(): VB
}