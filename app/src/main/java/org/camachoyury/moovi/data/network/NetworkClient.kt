package org.camachoyury.moovi.data.network


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.camachoyury.moovi.BuildConfig
import org.camachoyury.moovi.data.MooviRepository
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val SERVER_URL = "https://api.themoviedb.org/3/"

object NetworkClient {

    val mooviRepository : MooviRepository by lazy{

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
        if (BuildConfig.DEBUG) {
            client.addInterceptor(loggingInterceptor)
        }

        val okHttpClient = client.build()


        val mooviApi = Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(MooviApi::class.java)

        return@lazy MooviRepository(mooviApi)

    }


}