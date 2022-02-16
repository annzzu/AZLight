package az.movie.az_light.data

import javax.inject.Inject


class Repository @Inject constructor(private val dataSource: DataSource) {

    suspend fun turn(turn: Boolean) {
        dataSource.turn(turn)
    }

}