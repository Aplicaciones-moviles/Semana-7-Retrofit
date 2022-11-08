package facci.pm.retrofitkotlin

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("users/1")
    suspend fun getUserData(): Response<User>

    @GET("users")
    suspend fun getUsers(): Response<List<User>>

}