package mario.hany.sary.data.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .addHeader(
                "Authorization",
                "token eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MjY5OTE1LCJ1c2VyX3Bob25lIjoiMjAxMDEyNjg2MDI2In0._zbjGr6-HBpc1uaRsu7nvxDiwakwVyRTvD-VRfCcb0Q"
            )
            .addHeader("Accept-Language", "en")
            .addHeader("App-Version", "5.5.0.0.0")
            .addHeader("Device-Type", "android")
            .addHeader("Platform", "FLAGSHIP")
            .addHeader("Device-Id","e979a401955ab2a5")
            .build()
        return chain.proceed(newRequest)
    }
}