package mario.hany.sary.ui.home.repos

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import mario.hany.sary.models.Banner
import mario.hany.sary.data.models.BaseResponse
import mario.hany.sary.models.Other
import mario.hany.sary.models.Section
import mario.hany.sary.data.network.ApiInterface

class HomeRepository(private val remote: ApiInterface) : IHomeRepository {
    override fun getBanners(): Single<BaseResponse<List<Banner>, Any>> =
        remote.getBanners().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
    override fun getCatalog(): Single<BaseResponse<List<Section>, Other>> =
        remote.getCatalog().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
}