package mario.hany.sary.ui.home.usecases

import io.reactivex.rxjava3.core.Single
import mario.hany.sary.models.Banner
import mario.hany.sary.data.models.BaseResponse
import mario.hany.sary.models.Other
import mario.hany.sary.models.Section
import mario.hany.sary.ui.home.repos.IHomeRepository

class HomeUseCase(private val repo: IHomeRepository): IHomeUseCase {
    override fun getBanners(): Single<BaseResponse<List<Banner>, Any>> {
        return repo.getBanners()
    }

    override fun getCatalog(): Single<BaseResponse<List<Section>, Other>> {
        return repo.getCatalog()
    }
}