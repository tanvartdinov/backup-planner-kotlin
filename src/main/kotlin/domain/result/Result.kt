package domain.result

sealed interface Result<out T> {
    data class Ok<T>(val value: T) : Result<T>
    data class Err(val error: domain.error.DomainError) : Result<Nothing>
}