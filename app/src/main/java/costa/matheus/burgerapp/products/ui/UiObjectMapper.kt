package costa.matheus.burgerapp.products.ui

import androidx.compose.ui.graphics.Color
import costa.matheus.domain.entities.DayOfferEntity
import costa.matheus.domain.entities.Product
import costa.matheus.domain.entities.Section
import costa.matheus.domain.entities.SectionType

class UiObjectMapper {

    fun mapSections(sections: List<Section>): List<UiObject> {
        val finalPage = mutableListOf<UiObject>()

        sections.forEach { section ->
            finalPage.add(
                UiObject.Title(
                    title = section.title
                )
            )

            when(section.sectionType) {
                SectionType.NORMAL -> {
                    section.products.forEach { product ->
                        finalPage.add(
                            UiObject.Offer(
                                product = product
                            )
                        )
                    }
                }

                SectionType.HIGHLIGHT -> {
                    finalPage.add(
                        UiObject.Highlighted(
                            products = section.products,
                            colors = mapColors(section.products)
                        )
                    )
                }
            }
        }

        return finalPage
    }

    fun mapDayOffer(dayOfferEntity: DayOfferEntity): UiObject.DayOffer {
        return UiObject.DayOffer(
            entity = dayOfferEntity
        )
    }

    private fun mapColors(products: List<Product>): List<Color> {
        val colors = mutableListOf<Color>()

        products.forEach {
            colors.add(cardsColors.random())
        }

        return colors
    }

    private val cardsColors = arrayOf(
        Color(0xffFFC53F),
        Color(0XFFFF814B),
        Color(0xffE95555),
        Color(0xFFCC2D2D),
        Color(0xffB14943)
    )

}