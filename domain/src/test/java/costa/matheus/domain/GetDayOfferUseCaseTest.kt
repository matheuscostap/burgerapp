package costa.matheus.domain

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import costa.matheus.domain.entities.DayOfferEntity
import costa.matheus.domain.repository.AllProductsRepository
import costa.matheus.domain.usecases.GetDayOfferUseCase
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetDayOfferUseCaseTest {

    lateinit var useCase: GetDayOfferUseCase
    private val repository: AllProductsRepository = mock()

    @Before
    fun setup() {
        useCase = GetDayOfferUseCase(repository)
    }

    @Test
    fun `call() should return DayOfferEntity`() = runTest {
        // Arrange
        val entity = DayOfferEntity("image")

        whenever(repository.getDayOffer()) doReturn CompletableDeferred(entity)

        // Act
        val result = useCase.call().await()

        // Assert
        Assert.assertTrue(entity.image == result.image)
    }


}