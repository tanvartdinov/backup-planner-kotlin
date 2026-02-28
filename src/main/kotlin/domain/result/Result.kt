package domain.result

import domain.error.DomainError

sealed interface Result<out T> {
    data class Ok<T>(val value: T) : Result<T>
    data class Err(val error: DomainError) : Result<Nothing>
}