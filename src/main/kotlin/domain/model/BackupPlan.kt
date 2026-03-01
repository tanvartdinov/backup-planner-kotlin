package domain.model

import domain.error.DomainError
import domain.result.Result

data class BackupPlan(
    val id: PlanId,
    val sourcePath: String,
    val targetPath: String,
    val schedule: Schedule,
    val isActive: Boolean,
) {
    companion object {
        fun create(
            id: PlanId,
            sourcePath: String,
            targetPath: String,
            schedule: Schedule,
            isActive: Boolean = true,
        ): Result<BackupPlan> {
            val src = sourcePath.trim()
            val dst = targetPath.trim()

            if (src.isBlank()) return Result.Err(DomainError.InvalidPath(sourcePath))
            if (dst.isBlank()) return Result.Err(DomainError.InvalidPath(targetPath))
            if (src == dst) return Result.Err(DomainError.SourceEqualsTarget(src))

            return Result.Ok(BackupPlan(
                id = id,
                sourcePath = sourcePath,
                targetPath = dst,
                schedule = schedule,
                isActive = isActive,
            ))
        }
    }

}