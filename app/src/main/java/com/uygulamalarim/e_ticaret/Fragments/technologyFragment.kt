package com.uygulamalarim.e_ticaret.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uygulamalarim.e_ticaret.DetailedPage
import com.uygulamalarim.e_ticaret.R
import com.uygulamalarim.e_ticaret.TechnologyItems.MyAdapter
import com.uygulamalarim.e_ticaret.TechnologyItems.UserViewModel


private lateinit var viewModel: UserViewModel
private lateinit var userRecyclerView: RecyclerView
lateinit var adapter: MyAdapter

class technologyFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_technology, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        userRecyclerView = view.findViewById(R.id.recyclerTech)
        userRecyclerView.layoutManager = LinearLayoutManager(context)
        userRecyclerView.setHasFixedSize(true)
        adapter = MyAdapter()
        userRecyclerView.adapter = adapter
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModel.allUsers.observe(viewLifecycleOwner, Observer {
            adapter.updateUserList(it)
        })

        adapter.onItemClick = {
            val intent = Intent(context, DetailedPage::class.java)
            intent.putExtra("user", it)
            intent.putExtra("keytech", "technology")
            startActivity(intent)

        }

    }

}

