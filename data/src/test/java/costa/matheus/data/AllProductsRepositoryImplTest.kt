package costa.matheus.data

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import costa.matheus.data.datasource.BurgerDataSource
import costa.matheus.data.repository.AllProductsRepositoryImpl
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AllProductsRepositoryImplTest {

    private lateinit var repository: AllProductsRepositoryImpl

    private val dataSource: BurgerDataSource = mock()

    @Before
    fun setup() {
        repository = AllProductsRepositoryImpl(dataSource)
    }

    @Test
    fun `getProducts() should return list of sections`() = runTest {
        // Arrange
        val dataSourceReturn = Stubs.getProductsPageResponse()

        whenever(dataSource.getAllProducts()) doReturn dataSourceReturn

        // Act
        val response = repository.getProducts().await()

        // Assert
        Assert.assertTrue("list should not be empty", response.isNotEmpty())
        Assert.assertTrue("list should have two sections", response.size == 2)
    }

    @Test
    fun `getDayOffer() should return DayOfferEntity`() = runTest {
        // Arrange
        val dataSourceReturn = Stubs.getDayOfferModel()

        whenever(dataSource.getDayOffer()) doReturn dataSourceReturn

        // Act
        val response = repository.getDayOffer().await()

        // Assert
        Assert.assertTrue(response.image == dataSourceReturn.image)
    }
}