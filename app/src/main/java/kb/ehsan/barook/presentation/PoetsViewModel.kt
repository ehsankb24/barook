package kb.ehsan.barook.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kb.ehsan.barook.domain.model.DomainResult
import kb.ehsan.barook.domain.model.PoetDomainModel
import kb.ehsan.barook.domain.repository.PoetRepository
import kb.ehsan.barook.presentation.component.item.ItemUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PoetsViewModel @Inject constructor(
    private val repository: PoetRepository
) : ViewModel() {
    private val _viewState = MutableStateFlow<PoetsViewState>(PoetsViewState.Loading)
    val viewState = _viewState.asStateFlow()

    init {
        getPoets()
    }

    fun onEvent(event: PoetsViewEvent) {
        when (event) {
            PoetsViewEvent.Retry -> retry()
        }
    }

    private fun getPoets() {
        viewModelScope.launch {
            when (val result = repository.getPoets()) {
                is DomainResult.Exception -> _viewState.update { PoetsViewState.Failed(result.message.orEmpty()) }
                is DomainResult.Success<List<PoetDomainModel>> -> _viewState.update {
                    PoetsViewState.ShowData(
                        result.data.map { ItemUiModel(it.name, it.imageUrl.toString()) })
                }
            }
        }
    }

    private fun retry() {
        _viewState.update { PoetsViewState.Loading }
        getPoets()
    }
}