package domain.model

import domain.error.DomainError
import domain.result.Result

@JvmInline
value class PlanId private constructor(val value: String) {

    companion object {
        private val regex = Regex("^[a-zA-Z0-9_-]{3,32}$")

        fun create(raw: String): Result<PlanId> {
            return if (regex.matches(raw)) {
                Result.Ok(PlanId(raw))
            } else {
                Result.Err(DomainError.InvalidId(raw))
            }
        }
    }
}