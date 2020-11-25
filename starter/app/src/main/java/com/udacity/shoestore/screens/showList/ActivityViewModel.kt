package com.udacity.shoestore.screens.showList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ActivityViewModel : ViewModel() {

    private var listOfShoe = ArrayList<Shoe>()
    private val _showList = MutableLiveData<ArrayList<Shoe>>()
    val showList: LiveData<ArrayList<Shoe>>
        get() = _showList

    init {
        initData()
    }

    private fun initData() {
        listOfShoe = arrayListOf(
            Shoe(
                "Nike Air Max 270 1",
                44.5,
                "Nike",
                "Refresh your step in the Nike Air Max 270 React SE.", listOf()
            ),
            Shoe(
                "Nike Air Max 270 2",
                44.5,
                "Nike",
                "Refresh your step in the Nike Air Max 270 React SE.", listOf()
            ),
            Shoe(
                "Nike Air Max 270 3",
                44.5,
                "Nike",
                "Refresh your step in the Nike Air Max 270 React SE.", listOf()
            ),
            Shoe(
                "Nike Air Max 270 4",
                44.5,
                "Nike",
                "Refresh your step in the Nike Air Max 270 React SE.", listOf()
            ),
            Shoe(
                "Nike Air Max 270 5",
                44.5,
                "Nike",
                "Refresh your step in the Nike Air Max 270 React SE.", listOf()
            )
        )

        _showList.value = listOfShoe
    }

    fun addNewShow(shoe: Shoe) {
        listOfShoe.add(shoe)
    }
}