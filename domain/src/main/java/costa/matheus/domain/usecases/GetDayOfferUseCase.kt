package costa.matheus.domain.usecases

import costa.matheus.domain.repository.AllProductsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetDayOfferUseCase @Inject constructor(
    private val repository: AllProductsRepository
) {

    suspend fun call() = repository.getDayOffer()

}