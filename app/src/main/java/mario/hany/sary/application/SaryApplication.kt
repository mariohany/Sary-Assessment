package mario.hany.sary.application

import android.app.Application
import mario.hany.sary.di.networkModule
import mario.hany.sary.di.repositoriesModule
import mario.hany.sary.di.useCasesModule
import mario.hany.sary.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SaryApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SaryApplication)
            modules(
                listOf(
                    networkModule, repositoriesModule, viewModelsModule, useCasesModule
                )
            )
        }
    }
}