package costa.matheus.data.datasource

import costa.matheus.data.model.DayOfferModel
import costa.matheus.data.model.ProductsPageResponse
import retrofit2.http.GET

interface BurgerDataSource {

    @GET("/matheuscostap/burgerapp/main/api.json")
    suspend fun getAllProducts(): ProductsPageResponse

    @GET("/matheuscostap/burgerapp/main/dayoffer.json")
    suspend fun getDayOffer(): DayOfferModel
}