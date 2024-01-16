package com.example.mod8tpbonus

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LaunchDiceVM : ViewModel() {
    val valueDice = MutableLiveData(0)
    fun launchDice(max : Int){
        valueDice.value = (1..max).random()
    }
}