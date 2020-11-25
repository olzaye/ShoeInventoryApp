package com.udacity.shoestore.screens.shoeDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.MainActivity


class ShoeDetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as? MainActivity)?.showBackButtonArrow(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )

        arguments?.let {
            ShoeDetailFragmentArgs.fromBundle(it).Shoe.let {
                binding.shoe = it
            }
        }

        binding.saveButton.setOnClickListener {
            (activity as? MainActivity)?.viewModel?.addNewShow(
                Shoe(
                    binding.shoeNameTextInputEditText.text.toString(),
                    binding.shoeSizeTextInputEditText.text.toString().toDouble(),
                    binding.companyTextInputEditText.text.toString(),
                    binding.descriptionTextInputEditText.text.toString(), listOf()
                )
            )
           it.findNavController().navigate(ShoeDetailFragmentDirections.actionFragmentShoeDetailToFragmentShowList())
        }

        binding.cancelButton.setOnClickListener {
            it.findNavController().navigate(ShoeDetailFragmentDirections.actionFragmentShoeDetailToFragmentShowList())
        }

        return binding.root
    }
}