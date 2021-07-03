package com.kotlin.base

class RoutePath {
    object Main{
        const val MAIN = "/main"
        const val PAGE_MAIN_ACTIVITY = "$MAIN/MainActivity"
        const val PAGE_SECOND_ACTIVITY = "$MAIN/SecondActivity"
        const val PAGE_WEBVIEW_ACTIVITY = "$MAIN/WebViewActivity"
        const val PAGE_SEHEMEA_ACTIVITY = "$MAIN/SchemeToAActivity"
        const val PAGE_INTERCEPTOR_ACTIVITY = "$MAIN/TextInterceptorActivity"
    }

    object ModuleA{
        const val MAOULEA = "/moduleA"
        const val PAGE_MODULEA_FIRSTACTIVITY= "$MAOULEA/FirstActivity"
        const val PAGE_MODULEA_BLANKFRAGMENT= "{MAOULEA/BlankFragment"
    }

    object ModuleB{
        const val MAOULEB = "/moduleB"
        const val PAGE_MODULEB_FIRSTACTIVITY= "$MAOULEB/FirstActivity"

    }
}