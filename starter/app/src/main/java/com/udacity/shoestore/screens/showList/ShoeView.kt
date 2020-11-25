package com.udacity.shoestore.screens.showList

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.udacity.shoestore.databinding.ShowViewBinding


class ShoeView(context: Context, attributes: AttributeSet? = null, defStyleAttr: Int = 0) :
    ConstraintLayout(context, attributes, defStyleAttr) {

    private var binding: ShowViewBinding = ShowViewBinding.inflate(LayoutInflater.from(context))

    init {
        addView(binding.root)
    }

    fun setShoeName(name: String) {
        binding.shoeNameTextView.text = name
    }

    fun fabOnClickListener(onClick: (view: View) -> Unit) {
        binding.floatingActionBar.setOnClickListener {
            onClick(it)
        }
    }
}