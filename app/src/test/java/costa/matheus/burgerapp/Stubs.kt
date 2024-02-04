package costa.matheus.burgerapp

import costa.matheus.domain.entities.Allergen
import costa.matheus.domain.entities.Product
import costa.matheus.domain.entities.Section
import costa.matheus.domain.entities.SectionType

object Stubs {

    fun getNormalSectionStub(): List<Section> {
        return listOf(
            Section(
                title = "title",
                products = listOf(
                    Product(
                    name = "name",
                    description = "description",
                    image = "image",
                    price = "price",
                    promotionalPrice = "promotional_price",
                    calories = "calories",
                    totalFat = "total_fat",
                    carbohydrates = "carbohydrates",
                    proteins = "proteins",
                    allergen = Allergen(
                        egg = true,
                        milk = true,
                        gluten = true,
                        soy = true
                    )
                )
                ),
                sectionType = SectionType.NORMAL
            )
        )
    }

    fun getHighlightSectionStub(): List<Section> {
        return listOf(
            Section(
                title = "title",
                products = listOf(
                    Product(
                        name = "name",
                        description = "description",
                        image = "image",
                        price = "price",
                        promotionalPrice = "promotional_price",
                        calories = "calories",
                        totalFat = "total_fat",
                        carbohydrates = "carbohydrates",
                        proteins = "proteins",
                        allergen = Allergen(
                            egg = true,
                            milk = true,
                            gluten = true,
                            soy = true
                        )
                    )
                ),
                sectionType = SectionType.HIGHLIGHT
            )
        )
    }
}