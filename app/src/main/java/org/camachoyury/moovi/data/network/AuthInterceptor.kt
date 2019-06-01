package org.camachoyury.moovi.data.network

import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

private const val API_KEY = "api_key"
private const val LANUAGE = "en"

class AuthInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request
                .url()
                .newBuilder()
                .addQueryParameter(API_KEY,"ea34d9b6d5b890cf49efe5cca27784bd")
                .addQueryParameter(LANUAGE, Locale.getDefault().language)
                .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }

}