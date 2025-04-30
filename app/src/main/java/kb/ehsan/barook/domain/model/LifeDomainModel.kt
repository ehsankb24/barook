package kb.ehsan.barook.domain.model

data class LifeDomainModel(
    val yearInLHijri: Int,
    val validDate: Boolean,
    val place: String,
    val placeLatitude: Double,
    val placeLongitude: Double
)