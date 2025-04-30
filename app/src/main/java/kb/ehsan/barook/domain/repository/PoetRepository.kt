package kb.ehsan.barook.domain.repository

import kb.ehsan.barook.domain.model.DomainResult
import kb.ehsan.barook.domain.model.PoetDomainModel

interface PoetRepository {
    suspend fun getPoets(): DomainResult<List<PoetDomainModel>>
}