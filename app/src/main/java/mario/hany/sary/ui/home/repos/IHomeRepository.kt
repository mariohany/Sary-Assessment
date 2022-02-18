package mario.hany.sary.ui.home.repos

import io.reactivex.rxjava3.core.Single
import mario.hany.sary.models.Banner
import mario.hany.sary.data.models.BaseResponse
import mario.hany.sary.models.Other
import mario.hany.sary.models.Section

interface IHomeRepository {
    fun getBanners(): Single<BaseResponse<List<Banner>, Any>>
    fun getCatalog(): Single<BaseResponse<List<Section>, Other>>
}