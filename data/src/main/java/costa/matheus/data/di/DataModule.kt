package costa.matheus.data.di

import costa.matheus.data.datasource.BurgerDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    @Singleton
    fun provideBurgerDataSource(): BurgerDataSource {
        val okHttpClient = RetrofitUtils.createOkHttpClient()
        return RetrofitUtils.createWebService(okHttpClient, "https://raw.githubusercontent.com/")
    }

}