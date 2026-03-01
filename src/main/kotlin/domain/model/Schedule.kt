package domain.model

sealed interface Schedule {

    data object EveryDay : Schedule

    data class EveryHours(val hours: Int) : Schedule {
        init {
            require(hours in 1..24) {
                "Hours must be between 1 and 24"
            }
        }
    }
}