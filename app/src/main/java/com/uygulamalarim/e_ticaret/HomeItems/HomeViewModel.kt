package com.uygulamalarim.e_ticaret.HomeItems

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val repository: HomeRepository
    private val _allUsers = MutableLiveData<List<HomeUser>>()
    val allUsers: LiveData<List<HomeUser>> = _allUsers

    init {
        repository = HomeRepository().getInstance()
        repository.loadUsers(_allUsers)
    }
}