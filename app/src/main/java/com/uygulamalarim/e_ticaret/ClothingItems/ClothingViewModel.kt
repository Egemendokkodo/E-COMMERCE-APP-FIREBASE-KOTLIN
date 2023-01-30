package com.uygulamalarim.e_ticaret.ClothingItems

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClothingViewModel : ViewModel() {
    private val repository: ClothingRepository
    private val _allUsers = MutableLiveData<List<ClothingUser>>()
    val allUsers: LiveData<List<ClothingUser>> = _allUsers

    init {
        repository = ClothingRepository().getInstance()
        repository.loadUsers(_allUsers)
    }
}