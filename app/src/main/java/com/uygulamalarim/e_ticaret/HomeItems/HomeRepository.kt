package com.uygulamalarim.e_ticaret.HomeItems

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*


class HomeRepository {
    private val databaseReference: DatabaseReference =
        FirebaseDatabase.getInstance().getReference("Products").child("Home")

    @Volatile
    private var INSTANCE: HomeRepository? = null
    fun getInstance(): HomeRepository {
        return INSTANCE ?: synchronized(this) {
            val instance = HomeRepository()
            INSTANCE = instance
            instance
        }
    }

    fun loadUsers(userList: MutableLiveData<List<HomeUser>>) {
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    val _userList: List<HomeUser> = snapshot.children.map { dataSnapshot ->
                        dataSnapshot.getValue(HomeUser::class.java)!!
                    }
                    userList.postValue(_userList)
                } catch (e: Exception) {

                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}