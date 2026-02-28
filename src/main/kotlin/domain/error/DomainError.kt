package domain.error

sealed interface DomainError {
    data class InvalidId(val raw: String) : DomainError
}