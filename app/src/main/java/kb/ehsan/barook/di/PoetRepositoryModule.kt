package kb.ehsan.barook.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kb.ehsan.barook.data.dataSource.PoetApiService
import kb.ehsan.barook.data.mapper.PoetMapper
import kb.ehsan.barook.data.repository.PoetRepositoryImpl
import kb.ehsan.barook.domain.repository.PoetRepository

@InstallIn(SingletonComponent::class)
@Module
class PoetRepositoryModule {

    @Provides
    fun providePoetRepository(
        remoteDataSource: PoetApiService,
        poetMapper: PoetMapper
    ): PoetRepository = PoetRepositoryImpl(
        remoteDataSource, poetMapper
    )
}