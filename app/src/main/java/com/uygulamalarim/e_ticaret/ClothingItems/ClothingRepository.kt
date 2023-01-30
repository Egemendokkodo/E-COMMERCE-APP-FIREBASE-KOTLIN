package com.uygulamalarim.e_ticaret.ClothingItems

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*


class ClothingRepository {
    private val databaseReference: DatabaseReference =
        FirebaseDatabase.getInstance().getReference("Products").child("Clothing")

    @Volatile
    private var INSTANCE: ClothingRepository? = null
    fun getInstance(): ClothingRepository {
        return INSTANCE ?: synchronized(this) {
            val instance = ClothingRepository()
            INSTANCE = instance
            instance
        }
    }

    fun loadUsers(userModelList: MutableLiveData<List<ClothingUser>>) {
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    val _userModelLists: List<ClothingUser> =
                        snapshot.children.map { dataSnapshot ->
                            dataSnapshot.getValue(ClothingUser::class.java)!!
                        }
                    userModelList.postValue(_userModelLists)
                } catch (e: Exception) {

                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}