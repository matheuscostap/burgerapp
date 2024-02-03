package costa.matheus.domain.repository

import costa.matheus.domain.entities.DayOfferEntity
import costa.matheus.domain.entities.Section
import kotlinx.coroutines.Deferred

interface AllProductsRepository {

    suspend fun getProducts(): Deferred<List<Section>>
    suspend fun getDayOffer(): Deferred<DayOfferEntity>

}