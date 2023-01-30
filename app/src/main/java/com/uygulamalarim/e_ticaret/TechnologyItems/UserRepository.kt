package com.uygulamalarim.e_ticaret.TechnologyItems

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*

class UserRepository {
    private val databaseReference: DatabaseReference =
        FirebaseDatabase.getInstance().getReference("Products").child("Technology")

    @Volatile
    private var INSTANCE: UserRepository? = null
    fun getInstance(): UserRepository {
        return INSTANCE ?: synchronized(this) {
            val instance = UserRepository()
            INSTANCE = instance
            instance
        }
    }

    fun loadUsers(userModelList: MutableLiveData<List<User>>) {
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    val _userModelLists: List<User> = snapshot.children.map { dataSnapshot ->
                        dataSnapshot.getValue(User::class.java)!!
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