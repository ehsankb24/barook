package kb.ehsan.barook.data.dataSource

import kb.ehsan.barook.data.model.PoetResponse
import retrofit2.http.GET

interface PoetApiService {
    @GET("ganjoor/poets")
    suspend fun getPoets(): List<PoetResponse>
}