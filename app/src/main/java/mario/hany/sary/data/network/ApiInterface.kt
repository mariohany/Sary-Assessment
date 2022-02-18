package mario.hany.sary.data.network

import io.reactivex.rxjava3.core.Single
import mario.hany.sary.data.models.BaseResponse
import mario.hany.sary.models.Banner
import mario.hany.sary.models.Other
import mario.hany.sary.models.Section
import retrofit2.http.GET

interface ApiInterface {
    @GET("baskets/313817/banners/")
    fun getBanners(): Single<BaseResponse<List<Banner>, Any>>

    @GET("baskets/313817/catalog/")
    fun getCatalog(): Single<BaseResponse<List<Section>, Other>>
}