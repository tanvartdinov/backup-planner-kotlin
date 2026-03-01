package domain.model

import domain.error.DomainError
import domain.result.Result
import kotlin.test.Test
import kotlin.test.assertTrue

class BackupPlanTest {
    @Test
    fun `create returns Err when source path blank`() {
        val id = (PlanId.create("plan_01") as Result.Ok).value
        val result = BackupPlan.create(
            id = id,
            sourcePath = "   ",
            targetPath = "/backup",
            schedule = Schedule.EveryDay
        )

        assertTrue(result is Result.Err)
        result as Result.Err
        assertTrue(result.error is DomainError.InvalidPath)
    }

    @Test
    fun `create returns Err when source equals target`() {
        val id = (PlanId.create("plan_01") as Result.Ok).value
        val result = BackupPlan.create(
            id = id,
            sourcePath = "/data",
            targetPath = "/data",
            schedule = Schedule.EveryDay,
        )

        assertTrue(result is Result.Err)
        result as Result.Err
        assertTrue(result.error is DomainError.SourceEqualsTarget)
    }

    @Test
    fun `create returns Ok for valid plan`() {
        val id = (PlanId.create("plan_01") as Result.Ok).value
        val result = BackupPlan.create(
            id = id,
            sourcePath = "/data",
            targetPath = "/backup",
            schedule = Schedule.EveryHours(6),
        )

        assertTrue(result is Result.Ok)
    }
}