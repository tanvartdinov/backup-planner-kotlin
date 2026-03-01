package domain.model

import kotlin.test.Test
import kotlin.test.assertFailsWith


class ScheduleTest {
    @Test
    fun `EveryHours throws when hours invalid`() {
        assertFailsWith<IllegalArgumentException> {
            Schedule.EveryHours(0)
        }
    }
}