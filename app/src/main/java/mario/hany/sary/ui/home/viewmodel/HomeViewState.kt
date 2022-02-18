package mario.hany.sary.ui.home.viewmodel

import mario.hany.sary.models.Banner
import mario.hany.sary.models.Section

sealed class HomeViewState{
    class Loading(val state:Boolean): HomeViewState()
    class Banners(val list: List<Banner>): HomeViewState()
    class Catalog(val list: List<Section>): HomeViewState()
    object SpecialOrder: HomeViewState()
    class Error(val msg:String): HomeViewState()
}
