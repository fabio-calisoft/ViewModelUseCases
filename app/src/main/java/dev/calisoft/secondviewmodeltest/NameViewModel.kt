package dev.calisoft.secondviewmodeltest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameViewModel : ViewModel() {

    var name: MutableLiveData<String>? = MutableLiveData()


    companion object {
        private var instance: NameViewModel? = null
        fun getInstance() =
            instance ?: synchronized(NameViewModel::class.java) {
                instance ?: NameViewModel().also { instance = it }
            }
    }


}