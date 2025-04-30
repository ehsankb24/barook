package kb.ehsan.barook.domain.model

sealed interface DomainResult<out T> {
    data class Success<out T>(val data: T) : DomainResult<T>
    sealed interface Exception : DomainResult<Nothing> {
        val message: String?

        data class Failed(val code: Int, override val message: String?) : Exception
        data class Network(override val message: String?) : Exception
        data class General(override val message: String?) : Exception
    }
}