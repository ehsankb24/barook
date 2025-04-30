package kb.ehsan.barook.domain.model

import java.net.URI

data class PoetDomainModel(
    val id: Int,
    val name: String,
    val description: String?,
    val fullUrl: String,
    val rootCatId: Int,
    val nickname: String,
    val published: Boolean,
    val imageUrl: URI,
    val pinOrder: Int,
    val birthday : LifeDomainModel,
    val death: LifeDomainModel
)