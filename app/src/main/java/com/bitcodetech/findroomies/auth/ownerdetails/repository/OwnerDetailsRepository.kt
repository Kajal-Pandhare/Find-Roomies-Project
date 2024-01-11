package com.bitcodetech.findroomies.auth.ownerdetails.repository

import com.bitcodetech.findroomies.auth.ownerdetails.models.OwnerDetails
import com.bitcodetech.findroomies.commons.repository.Repository

class OwnerDetailsRepository : Repository() {
    fun fetchOwnerDetails(
        ownerDetails: OwnerDetails
    ) : Boolean{
        return true
    }
}