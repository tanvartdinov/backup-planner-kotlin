package domain.error

sealed interface DomainError {
    data class InvalidId(val raw: String) : DomainError
    data class InvalidPath(val raw: String) : DomainError
    data class SourceEqualsTarget(val path: String) : DomainError
}