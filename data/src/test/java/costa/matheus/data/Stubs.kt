package costa.matheus.data

import costa.matheus.data.model.AllergenModel
import costa.matheus.data.model.DayOfferModel
import costa.matheus.data.model.ProductModel
import costa.matheus.data.model.ProductsPageResponse

object Stubs {

    fun getProductsPageResponse(): ProductsPageResponse {
        return ProductsPageResponse(
            specialProducts = listOf(
                ProductModel(
                    name = "special",
                    description = "description",
                    image = "image",
                    price = "price",
                    promotional_price = null,
                    calories = "calories",
                    total_fat = "totalfat",
                    carbohydrates = "carbohydrates",
                    proteins = "proteins",
                    allergen = AllergenModel(
                        egg = true,
                        milk = true,
                        gluten = true,
                        soy = true
                    )
                )
            ),
            allProducts = listOf(
                ProductModel(
                    name = "normal",
                    description = "description",
                    image = "image",
                    price = "price",
                    promotional_price = null,
                    calories = "calories",
                    total_fat = "totalfat",
                    carbohydrates = "carbohydrates",
                    proteins = "proteins",
                    allergen = AllergenModel(
                        egg = true,
                        milk = true,
                        gluten = true,
                        soy = true
                    )
                )
            )
        )
    }

    fun getDayOfferModel(): DayOfferModel {
        return DayOfferModel("image")
    }

}