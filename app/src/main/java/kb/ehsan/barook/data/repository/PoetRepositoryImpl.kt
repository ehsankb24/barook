package kb.ehsan.barook.data.repository

import kb.ehsan.barook.data.dataSource.PoetApiService
import kb.ehsan.barook.data.mapper.PoetMapper
import kb.ehsan.barook.domain.model.DomainResult
import kb.ehsan.barook.domain.model.PoetDomainModel
import kb.ehsan.barook.domain.repository.PoetRepository
import retrofit2.HttpException
import java.io.IOException

class PoetRepositoryImpl(
    private val remoteDataSource: PoetApiService,
    private val poetMapper: PoetMapper
) : PoetRepository {
    override suspend fun getPoets(): DomainResult<List<PoetDomainModel>> {
        return safeApiCall {
            remoteDataSource.getPoets().map { poetMapper.map(it) }
        }
    }

    private suspend fun <T> safeApiCall(apiCall: suspend () -> T): DomainResult<T> {
        return try {
            DomainResult.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
            when (throwable) {
                is IOException -> DomainResult.Exception.Network(throwable.message)
                is HttpException -> {
                    val code = throwable.code()
                    val errorResponse = throwable.response()?.errorBody()?.string()
                    DomainResult.Exception.Failed(code, errorResponse)
                }

                else -> DomainResult.Exception.General(throwable.message)
            }
        }
    }
}