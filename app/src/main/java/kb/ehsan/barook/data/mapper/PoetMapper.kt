package kb.ehsan.barook.data.mapper

import kb.ehsan.barook.data.model.PoetResponse
import kb.ehsan.barook.di.BaseImageUrl
import kb.ehsan.barook.domain.model.LifeDomainModel
import kb.ehsan.barook.domain.model.PoetDomainModel
import java.net.URI
import javax.inject.Inject

class PoetMapper @Inject constructor(
    @BaseImageUrl private val baseUrl: String
) {
    fun map(data: PoetResponse) = with(data) {
        PoetDomainModel(
            id = id,
            name = name,
            description = description,
            fullUrl = baseUrl + fullUrl,
            rootCatId = rootCatId,
            nickname = nickname,
            published = published,
            imageUrl = URI(baseUrl + imageUrl),
            pinOrder = pinOrder,
            birthday = LifeDomainModel(
                yearInLHijri = birthYearInLHijri,
                validDate = validBirthDate,
                place = birthPlace,
                placeLongitude = birthPlaceLongitude,
                placeLatitude = birthPlaceLatitude
            ),
            death = LifeDomainModel(
                yearInLHijri = deathYearInLHijri,
                validDate = validDeathDate,
                place = deathPlace,
                placeLongitude = deathPlaceLongitude,
                placeLatitude = deathPlaceLatitude
            )
        )
    }
}