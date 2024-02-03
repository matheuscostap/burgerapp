package costa.matheus.domain.entities

import java.io.Serializable

data class Product (
    val name: String,
    val description: String,
    val image: String,
    val price: String,
    val promotionalPrice: String?,
    val calories: String,
    val totalFat: String,
    val carbohydrates: String,
    val proteins: String,
    val allergen: Allergen
): Serializable