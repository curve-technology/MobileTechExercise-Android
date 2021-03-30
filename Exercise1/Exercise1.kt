/**
 * Curve Tech Exercise - Android
 * Objective: implement the layers between ViewModel and Datasource to fetch the schedule in
 * ViewModel's loadContent() function.
 * You can assume all dependencies are provided by DI or provide them yourself.
 *
 * Kotlin Playground: https://pl.kotl.in/fHen2hKOt
 */

class TvScheduleViewModel(private val useCase: TvScheduleUseCase) {
    fun loadContent() {
        val schedule = useCase.getSchedule()
        println(schedule)
    }
}

data class Entry(val title: String, val coverArtUrl: String)

// do not modify above this point

class TvScheduleUseCase() {
    fun getSchedule(): List<Entry> {

    }
}

class MoviesRepository() {

}

class SeriesRepository() {

}

// Do not modify below this point 

class MoviesDatasource() {
    private val MOVIES: List<DataMovie> = listOf(
            DataMovie("Matrix", 136, "Wachowski", "Keanu Reeves", "https://www.themoviedb.org/t/p/w1280/lB0QmvDN7GDpNzDYDS3hVbuDtSl.jpg", 1999),
            DataMovie("Interstellar", 169, "Nolan", "Matthew McConaughey", "https://www.themoviedb.org/t/p/w1280/9PTvvflydmTnfvMWMAwMMkV7X2s.jpg", 2014)
    )

    fun fetchMovies(): List<DataMovie> = MOVIES
}

class SeriesDatasource() {
    private val SERIES: List<DataSeries> = listOf(
            DataSeries("The Office (US)", 9, listOf("Steve Carell", "John Krasinski", "Rainn Wilson"), "https://www.themoviedb.org/t/p/w1280/qWnJzyZhyy74gjpSjIXWmuk0ifX.jpg", true),
            DataSeries("Breaking Bad", 5, listOf("Bryan Cranston", "Aaron Paul"), "https://www.themoviedb.org/t/p/w1280/ggFHVNu6YYI5L9pCfOacjizRGt.jpg", true)
    )

    fun fetchSeries(): List<DataSeries> = SERIES
}

data class DataMovie(
        val title: String,
        val minutes: Int,
        val director: String,
        val mainActor: String,
        val coverUrl: String,
        val year: Int
)

data class DataSeries(
        val title: String,
        val seasons: Int,
        val mainCast: List<String>,
        val coverUrl: String,
        val isComplete: Boolean
)