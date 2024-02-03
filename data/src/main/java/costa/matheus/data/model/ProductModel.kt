package costa.matheus.data.model


data class ProductModel (
    val name: String,
    val description: String,
    val image: String,
    val price: String,
    val promotional_price: String?,
    val calories: String,
    val total_fat: String,
    val carbohydrates: String,
    val proteins: String,
    val allergen: AllergenModel
)