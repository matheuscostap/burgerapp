package costa.matheus.domain.entities

import java.io.Serializable

data class Allergen(
    val egg: Boolean,
    val milk: Boolean,
    val gluten: Boolean,
    val soy: Boolean
): Serializable