package com.kotlin.aroutekotlin.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.kotlin.base.RoutePath

@Route(path = RoutePath.Main.PAGE_INTERCEPTOR_ACTIVITY)
class TextInterceptorAcy:AppCompatActivity() {
    @JvmField
    @Autowired
    var data:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ARouter.getInstance().inject(this)
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
    }
}