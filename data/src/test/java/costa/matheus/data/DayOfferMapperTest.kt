package costa.matheus.data


import costa.matheus.data.mapper.DayOfferMapper
import org.junit.Assert
import org.junit.Test

class DayOfferMapperTest {

    @Test
    fun `should map DayOfferModel to DayOfferEntity correctly`() {
        // Arrange
        val model = Stubs.getDayOfferModel()

        // Act
        val result = DayOfferMapper().map(model)

        // Assert
        Assert.assertTrue(result.image == model.image)
    }

}