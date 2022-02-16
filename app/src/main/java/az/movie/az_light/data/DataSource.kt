package az.movie.az_light.data

import javax.inject.Inject

class DataSource @Inject constructor(private val api: ApiService) {

    suspend fun turn(turn: Boolean) = api.turn(if (turn) "on" else "off")

}