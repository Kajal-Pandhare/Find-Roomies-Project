package com.bitcodetech.findroomies.auth.register.network

import com.bitcodetech.findroomies.auth.register.models.RegisterResponse
import com.bitcodetech.findroomies.auth.register.models.UserPostModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST


interface RegisterApiService {
    @POST("signup")
    suspend fun addUser(
        @Body registrationViewModel: UserPostModel
    ) : RegisterResponse
    companion object {
        private var registerApiService : RegisterApiService? = null

        fun getInstance() : RegisterApiService {
            if(registerApiService == null) {

                val interceptor = HttpLoggingInterceptor()
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

                val retrofit = Retrofit.Builder()
                    .baseUrl("http://ec2-13-232-219-171.ap-south-1.compute.amazonaws.com:3000/api/users/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
                registerApiService = retrofit.create(RegisterApiService::class.java)
            }
            return registerApiService!!
        }
    }
}