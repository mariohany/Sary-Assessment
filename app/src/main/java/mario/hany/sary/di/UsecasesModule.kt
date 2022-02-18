package mario.hany.sary.di

import mario.hany.sary.ui.home.usecases.HomeUseCase
import mario.hany.sary.ui.home.usecases.IHomeUseCase
import org.koin.dsl.module

val useCasesModule = module {
    single<IHomeUseCase> { HomeUseCase(get()) }

}