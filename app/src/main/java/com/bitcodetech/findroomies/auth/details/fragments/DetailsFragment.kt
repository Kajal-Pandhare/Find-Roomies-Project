package com.bitcodetech.findroomies.auth.details.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bitcodetech.findroomies.R
import com.bitcodetech.findroomies.auth.ownerdetails.fragments.OwnerDetailsFragment
import com.bitcodetech.findroomies.databinding.DetailsFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class DetailsFragment : Fragment() {
private lateinit var binding: DetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailsFragmentBinding.inflate(layoutInflater)

        initViews()
        initListener()
        return binding.root
    }
    private fun initListener(){
        binding.btnContact.setOnClickListener {
            /*val ownerDetailsFragment = OwnerDetailsFragment()

            parentFragmentManager.beginTransaction()
                .add(R.id.mainContainer,ownerDetailsFragment,null)
                .addToBackStack(null)
                .commit()*/
            val dialog = BottomSheetDialog(requireContext())
            val bottomSheetDialog = layoutInflater.inflate(R.layout.owner_details_fragment, null)

            dialog.setCancelable(false)
            dialog.setContentView(bottomSheetDialog)
            dialog.show()
        }
    }
    private fun initViews(){
        
    }
}