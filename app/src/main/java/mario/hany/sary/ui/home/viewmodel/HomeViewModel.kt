package mario.hany.sary.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.core.Single
import mario.hany.sary.models.Banner
import mario.hany.sary.models.Other
import mario.hany.sary.models.Section
import mario.hany.sary.ui.home.usecases.IHomeUseCase

class HomeViewModel(private val useCase: IHomeUseCase) : ViewModel() {
    private val _viewState: MutableLiveData<HomeViewState> by lazy { MutableLiveData() }
    val viewState: LiveData<HomeViewState> = _viewState

    fun loadHomeScreen() {
        _viewState.apply {
            value = HomeViewState.Loading(true)
            Single.merge(
                useCase.getBanners(),
                useCase.getCatalog()
            ).subscribe({ res ->
                if (res.status) {
                    when(res.result?.first()) {
                        is Banner -> {
                            value = (res.result as? List<Banner>)?.let { HomeViewState.Banners(it) }
                        }
                        is Section -> {
                            (res.other as? Other)?.showSpecialOrderView?.let {
                                value = HomeViewState.SpecialOrder
                            }
                            value = (res.result as? List<Section>)?.let { HomeViewState.Catalog(it.filter { !it.data.isNullOrEmpty() }) }
                        }
                    }
                } else
                    value = res.message?.let { HomeViewState.Error(it) }
            },{ err ->
                value = HomeViewState.Error(err.message!!)
            },{
                value = HomeViewState.Loading(false)
            })
        }
    }
}