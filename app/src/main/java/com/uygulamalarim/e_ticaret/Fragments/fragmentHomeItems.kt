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
import com.uygulamalarim.e_ticaret.HomeItems.HomeAdapter
import com.uygulamalarim.e_ticaret.HomeItems.HomeViewModel
import com.uygulamalarim.e_ticaret.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragmentHomeItems.newInstance] factory method to
 * create an instance of this fragment.
 */

private lateinit var homeViewModel: HomeViewModel
private lateinit var homeRecyclerView: RecyclerView
lateinit var adapterHome: HomeAdapter

class fragmentHomeItems : Fragment() {


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_items, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragmentHomeItems.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragmentHomeItems().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeRecyclerView = view.findViewById(R.id.recyclerHome)
        homeRecyclerView.layoutManager = LinearLayoutManager(context)
        homeRecyclerView.setHasFixedSize(true)
        adapterHome = HomeAdapter()
        homeRecyclerView.adapter = adapterHome
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.allUsers.observe(viewLifecycleOwner, Observer {
            adapterHome.updateUserList(it)
        })


        adapterHome.onItemClick = {
            val intent = Intent(context, DetailedPage::class.java)
            intent.putExtra("home", it)
            intent.putExtra("keyhome", "home")
            startActivity(intent)

        }

    }


}