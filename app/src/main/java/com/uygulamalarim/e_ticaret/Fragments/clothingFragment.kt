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
import com.uygulamalarim.e_ticaret.ClothingItems.ClothingAdapter
import com.uygulamalarim.e_ticaret.ClothingItems.ClothingViewModel
import com.uygulamalarim.e_ticaret.DetailedPage
import com.uygulamalarim.e_ticaret.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


private lateinit var clothingViewModel: ClothingViewModel
private lateinit var clothingRecyclerView: RecyclerView
lateinit var clothingAdapter: ClothingAdapter

class clothingFragment : Fragment() {


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
        return inflater.inflate(R.layout.fragment_clothing, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment clothingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            clothingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clothingRecyclerView = view.findViewById(R.id.recyclerClothing)
        clothingRecyclerView.layoutManager = LinearLayoutManager(context)
        clothingRecyclerView.setHasFixedSize(true)
        clothingAdapter = ClothingAdapter()
        clothingRecyclerView.adapter = clothingAdapter
        clothingViewModel = ViewModelProvider(this).get(ClothingViewModel::class.java)
        clothingViewModel.allUsers.observe(viewLifecycleOwner, Observer {
            clothingAdapter.updateUserList(it)
        })

        clothingAdapter.onItemClick = {
            val intent = Intent(context, DetailedPage::class.java)
            intent.putExtra("clothing", it)
            intent.putExtra("keyclothing", "clothing")
            startActivity(intent)

        }


    }


}