package costa.matheus.data.mapper

import costa.matheus.data.model.AllergenModel
import costa.matheus.data.model.ProductModel
import costa.matheus.data.model.ProductsPageResponse
import costa.matheus.domain.entities.Allergen
import costa.matheus.domain.entities.Product
import costa.matheus.domain.entities.Section
import costa.matheus.domain.entities.SectionType

class AllProductsMapper {

    fun map(productPageResponse: ProductsPageResponse): List<Section> {
        return listOf(
            Section(
                title = "Combos",
                sectionType = SectionType.HIGHLIGHT,
                products = productPageResponse.specialProducts.map { mapProduct(it) }
            ),
            Section(
                title = "Ofertas",
                sectionType = SectionType.NORMAL,
                products = productPageResponse.allProducts.map { mapProduct(it) }
            )
        )
    }

    private fun mapProduct(productModel: ProductModel) = Product(
        name = productModel.name,
        description = productModel.description,
        image = productModel.image,
        price = productModel.price,
        promotionalPrice = productModel.promotional_price,
        calories = productModel.calories,
        totalFat = productModel.total_fat,
        carbohydrates = productModel.carbohydrates,
        proteins = productModel.proteins,
        allergen = Allergen(
            egg = productModel.allergen.egg,
            milk = productModel.allergen.milk,
            gluten = productModel.allergen.gluten,
            soy = productModel.allergen.soy
        )
    )

}