package mario.hany.sary.di

import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import mario.hany.sary.BuildConfig
import mario.hany.sary.data.network.ApiInterface
import mario.hany.sary.data.network.AuthenticationInterceptor

import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL = BuildConfig.BASE_URL

val networkModule = module {

    single { AuthenticationInterceptor() }
    single { ChuckerInterceptor.Builder(androidContext()).collector(get()).build() }
    single {
        ChuckerCollector(
            context = androidContext(),
            // Toggles visibility of the push notification
            showNotification = BuildConfig.DEBUG,
            // Allows to customize the retention period of collected data
        )
    }
    factory { provideOkHttpClient(get(), get()) }
    factory { provideRetrofit(get()) }
    factory { provideDealerRemoteService(get()) }

}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
}

fun provideOkHttpClient(authInterceptor: AuthenticationInterceptor, chuckInterceptor: ChuckerInterceptor): OkHttpClient {

    return OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .addInterceptor(chuckInterceptor)
        .readTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .build()
}

fun provideDealerRemoteService(retrofit: Retrofit): ApiInterface =
    retrofit.create(ApiInterface::class.java)
