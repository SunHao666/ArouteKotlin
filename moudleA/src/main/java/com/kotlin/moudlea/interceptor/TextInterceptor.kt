package com.kotlin.moudlea.interceptor

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.alibaba.android.arouter.launcher.ARouter
import com.kotlin.base.RoutePath
import com.kotlin.base.common.ArouteKey
import com.kotlin.base.common.e

/**
 * create by SunHao in 2021/7/3
 *
 * @Description : 拦截器
 **/
@Interceptor(priority = 7,name = "测试拦截器")
class TextInterceptor : IInterceptor {
    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        val mDialog by lazy { AlertDialog.Builder(postcard?.context) }
        if (RoutePath.Main.PAGE_INTERCEPTOR_ACTIVITY == postcard?.path) {

            mDialog.apply {
                setTitle("拦截器")
                setNegativeButton("继续"
                ) { _, _ ->
                    callback?.onContinue(postcard)
                }

                setNeutralButton("算了"){
                    _,_ ->
                    callback?.onInterrupt(Throwable("我觉得有问题"))
                }
                setPositiveButton("加点料", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        postcard.withString(ArouteKey.MAIN.KEY_DATA, "我是来自拦截器的参数")
                        callback?.onContinue(postcard)
                    }
                })

            }
            Handler(Looper.getMainLooper()).post {
                mDialog.create().show()
            }

        }else{
            callback?.onContinue(postcard)
        }
    }

    override fun init(context: Context?) {
        "${TextInterceptor::class.java.simpleName} has init".e()
    }
}