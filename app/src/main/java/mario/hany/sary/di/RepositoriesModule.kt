package mario.hany.sary.di

import mario.hany.sary.ui.home.repos.HomeRepository
import mario.hany.sary.ui.home.repos.IHomeRepository
import org.koin.dsl.module

val repositoriesModule = module {
    single<IHomeRepository> { HomeRepository(get()) }
}