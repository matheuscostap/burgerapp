package costa.matheus.domain.entities

enum class SectionType {
    NORMAL, HIGHLIGHT
}

data class Section(
    val title: String,
    val products: List<Product>,
    val sectionType: SectionType
)