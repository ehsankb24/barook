package kb.ehsan.barook.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PoetResponse(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("description") val description: String?,
    @SerialName("fullUrl") val fullUrl: String,
    @SerialName("rootCatId") val rootCatId: Int,
    @SerialName("nickname") val nickname: String,
    @SerialName("published") val published: Boolean,
    @SerialName("imageUrl") val imageUrl: String,
    @SerialName("birthYearInLHijri") val birthYearInLHijri: Int,
    @SerialName("validBirthDate") val validBirthDate: Boolean,
    @SerialName("deathYearInLHijri") val deathYearInLHijri: Int,
    @SerialName("validDeathDate") val validDeathDate: Boolean,
    @SerialName("pinOrder") val pinOrder: Int,
    @SerialName("birthPlace") val birthPlace: String,
    @SerialName("birthPlaceLatitude") val birthPlaceLatitude: Double,
    @SerialName("birthPlaceLongitude") val birthPlaceLongitude: Double,
    @SerialName("deathPlace") val deathPlace: String,
    @SerialName("deathPlaceLatitude") val deathPlaceLatitude: Double,
    @SerialName("deathPlaceLongitude") val deathPlaceLongitude: Double
)