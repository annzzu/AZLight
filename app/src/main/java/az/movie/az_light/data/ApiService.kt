package az.movie.az_light.data

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("{turn}")
    suspend fun turn(
        @Path("turn") turn: String
    )
}