package com.bitcodetech.findroomies.auth.ownerdetails.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bitcodetech.findroomies.auth.ownerdetails.models.OwnerDetails
import com.bitcodetech.findroomies.auth.ownerdetails.repository.OwnerDetailsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class OwnerDetailsViewModel(private val ownerDetailsRepository: OwnerDetailsRepository) : ViewModel() {
    val ownerDetailsMutableLiveData = MutableLiveData<Boolean>()
   //val ownerDetails = ArrayList<OwnerDetails>()

    fun fetchOwnerDetails(
         image : Int,
         name : String,
         whatsppNo : Int,
         contactNo  : Int
    ){
        CoroutineScope(Dispatchers.IO).launch {
            val ownerDetails = ownerDetailsRepository.fetchOwnerDetails(
                OwnerDetails(
                image,
                name,
                whatsppNo,
                contactNo
            )
            )
            withContext(Dispatchers.Main){
            ownerDetailsMutableLiveData.postValue(true)
            }
        }
    }
}