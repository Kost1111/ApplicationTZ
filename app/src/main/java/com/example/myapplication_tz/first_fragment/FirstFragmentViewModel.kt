package com.example.myapplication_tz.first_fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.coroutineScope

class FirstFragmentViewModel: ViewModel() {

    private val firstNumberLiveData = MutableLiveData<Int>()
    val vmFirstNumberLiveData = firstNumberLiveData

    private val secondNumberLiveData = MutableLiveData<Int>()
    val vmSecondNumberLiveData = secondNumberLiveData

     fun setFirstNumber(num: Int){
        firstNumberLiveData.value = num
    }

     fun setSecondNumber(num: Int){
        secondNumberLiveData.value = num
    }

    fun sumNumber(): Int = firstNumberLiveData.value!! + secondNumberLiveData.value!!


}