package costa.matheus.domain

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import costa.matheus.domain.entities.Allergen
import costa.matheus.domain.entities.Product
import costa.matheus.domain.entities.Section
import costa.matheus.domain.entities.SectionType
import costa.matheus.domain.repository.AllProductsRepository
import costa.matheus.domain.usecases.GetAllProductsUseCase
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetAllProductsUseCaseTest {

    private lateinit var useCase: GetAllProductsUseCase
    private val repository: AllProductsRepository = mock()

    @Before
    fun setup() {
        useCase = GetAllProductsUseCase(repository)
    }

    @Test
    fun `call() should return list of sections`() = runTest {
        // Arrange
        val sections = listOf(
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

        whenever(repository.getProducts()) doReturn CompletableDeferred(sections)

        // Act
        val result = useCase.call().await()

        // Assert
        Assert.assertTrue(result.first() == sections.first())
        Assert.assertTrue(result.first().products.first() == sections.first().products.first())
    }

}