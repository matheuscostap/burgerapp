package costa.matheus.domain.di

import costa.matheus.domain.repository.AllProductsRepository
import costa.matheus.domain.usecases.GetAllProductsUseCase
import costa.matheus.domain.usecases.GetDayOfferUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun provideGetAllProductsUseCase(repository: AllProductsRepository): GetAllProductsUseCase {
        return GetAllProductsUseCase(repository)
    }

    @Provides
    fun provideGetDayOfferUseCase(repository: AllProductsRepository): GetDayOfferUseCase {
        return GetDayOfferUseCase(repository)
    }

}