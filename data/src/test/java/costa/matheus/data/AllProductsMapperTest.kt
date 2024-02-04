package costa.matheus.data

import costa.matheus.data.mapper.AllProductsMapper
import costa.matheus.domain.entities.SectionType
import org.junit.Assert
import org.junit.Test

class AllProductsMapperTest {

    @Test
    fun `should map section type HIGHLIGHT for special products`() {
        // Arrange
        val productsPageResponse = Stubs.getProductsPageResponse()

        // Act
        val result = AllProductsMapper().map(productsPageResponse)

        // Assert
        val section = result.first()
        val product = section.products.first()

        Assert.assertTrue(section.sectionType == SectionType.HIGHLIGHT)
        Assert.assertTrue(product.name == "special")
    }

    @Test
    fun `should map section type NORMAL for normal products`() {
        // Arrange
        val productsPageResponse = Stubs.getProductsPageResponse()

        // Act
        val result = AllProductsMapper().map(productsPageResponse)

        // Assert
        val section = result[1]
        val product = section.products.first()

        Assert.assertTrue(section.sectionType == SectionType.NORMAL)
        Assert.assertTrue(product.name == "normal")
    }

    @Test
    fun `should map products properties correctly`() {
        // Arrange
        val productsPageResponse = Stubs.getProductsPageResponse()

        // Act
        val result = AllProductsMapper().map(productsPageResponse)

        // Assert
        val specialProduct = result.first().products.first()

        Assert.assertTrue(specialProduct.name == "special")
        Assert.assertTrue(specialProduct.description == "description")
        Assert.assertTrue(specialProduct.image == "image")
        Assert.assertTrue(specialProduct.price == "price")
        Assert.assertTrue(specialProduct.promotionalPrice == null)
        Assert.assertTrue(specialProduct.calories == "calories")
        Assert.assertTrue(specialProduct.totalFat == "totalfat")
        Assert.assertTrue(specialProduct.carbohydrates == "carbohydrates")
        Assert.assertTrue(specialProduct.proteins == "proteins")
        Assert.assertTrue(specialProduct.allergen.egg)
        Assert.assertTrue(specialProduct.allergen.milk)
        Assert.assertTrue(specialProduct.allergen.gluten)
        Assert.assertTrue(specialProduct.allergen.soy)
    }


}