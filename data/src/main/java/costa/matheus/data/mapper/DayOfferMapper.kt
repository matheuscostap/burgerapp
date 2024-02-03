package costa.matheus.data.mapper

import costa.matheus.data.model.DayOfferModel
import costa.matheus.domain.entities.DayOfferEntity

class DayOfferMapper {

    fun map(model: DayOfferModel): DayOfferEntity {
        return DayOfferEntity(model.image)
    }
}