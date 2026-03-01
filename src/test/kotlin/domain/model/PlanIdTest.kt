package domain.model

import domain.error.DomainError
import domain.result.Result
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PlanIdTest {
    @Test
    fun `create returns Ok for valid id`() {
        val result = PlanId.create("backup_01")

        assertTrue(result is Result.Ok)
        result as Result.Ok
        assertEquals("backup_01", result.value.value)
    }

    @Test
    fun `create returns Err for invalid id`() {
        val result = PlanId.create("!!")

        assertTrue(result is Result.Err)
        result as Result.Err
        assertTrue(result.error is DomainError.InvalidId)
    }
}