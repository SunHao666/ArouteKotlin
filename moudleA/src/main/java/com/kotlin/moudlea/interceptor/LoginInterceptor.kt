package com.kotlin.moudlea.interceptor

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.kotlin.base.RoutePath
import com.kotlin.base.common.UserManager
import com.kotlin.base.common.e

@Interceptor(priority = 1,name = "login拦截器")
class LoginInterceptor:IInterceptor {
    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        val path = postcard?.path
        if(RoutePath.Main.PAGE_INTERCEPTOR_ACTIVITY == path){
            if(UserManager.user == null){
                callback?.onInterrupt(Throwable("需要先登录"))
            }
        }else{
            callback?.onContinue(postcard)
        }
    }

    override fun init(context: Context?) {
        "LoginInterceptor has init".e()
    }
}