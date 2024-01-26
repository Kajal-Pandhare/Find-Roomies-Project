package com.bitcodetech.findroomies.auth.login.network

import com.bitcodetech.findroomies.auth.login.models.Credentials
import com.bitcodetech.findroomies.auth.login.models.LoginResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LoginApiService {

    @POST("login")
    suspend fun login(
        @Body credentials: Credentials
    ) : LoginResponse

    companion object{
        private var loginApiService : LoginApiService? = null

        fun getInstance() : LoginApiService {
            if (loginApiService == null){

                val interceptor = HttpLoggingInterceptor()
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

                val retrofit = Retrofit.Builder()
                    .baseUrl("http://ec2-13-232-219-171.ap-south-1.compute.amazonaws.com:3000/api/users/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()

                loginApiService = retrofit.create(LoginApiService::class.java)
            }
            return loginApiService!!

        }
    }
}