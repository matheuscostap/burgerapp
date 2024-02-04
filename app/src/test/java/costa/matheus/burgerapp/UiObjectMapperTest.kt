package costa.matheus.burgerapp

import costa.matheus.burgerapp.products.ui.UiObject
import costa.matheus.burgerapp.products.ui.UiObjectMapper
import costa.matheus.domain.entities.Section
import org.junit.Assert
import org.junit.Test

class UiObjectMapperTest {

    @Test
    fun `mapSections() test`() {
        // Arrange
        val sections = mutableListOf<Section>()
        sections.addAll(Stubs.getNormalSectionStub())
        sections.addAll(Stubs.getHighlightSectionStub())

        // Act
        val result = UiObjectMapper().mapSections(sections)

        // Assert
        Assert.assertTrue(result[0] is UiObject.Title)
        Assert.assertTrue(result[1] is UiObject.Offer)
        Assert.assertTrue(result[2] is UiObject.Title)
        Assert.assertTrue(result[3] is UiObject.Highlighted)
    }

}