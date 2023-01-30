package com.uygulamalarim.e_ticaret.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uygulamalarim.e_ticaret.Adapters.KategoriAdapter
import com.uygulamalarim.e_ticaret.Adapters.NewsAdapter
import com.uygulamalarim.e_ticaret.Adapters.popularAdapter
import com.uygulamalarim.e_ticaret.Model.Kategori
import com.uygulamalarim.e_ticaret.Model.News
import com.uygulamalarim.e_ticaret.Model.Popular
import com.uygulamalarim.e_ticaret.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/*private lateinit var adapter: KategoriAdapter
private lateinit var kategoriRecycler:RecyclerView
private lateinit var listKategori:ArrayList<Kategori>

private lateinit var adapterNews: NewsAdapter
private lateinit var newsRecycler:RecyclerView
private lateinit var listNews:ArrayList<News>*/


private lateinit var adapterPopular: popularAdapter
private lateinit var popularRecycler: RecyclerView
private lateinit var listPopular: ArrayList<Popular>

lateinit var popularPic: Array<Int>
lateinit var popularTv: Array<String>

//lateinit var newsPic:Array<Int>
lateinit var kategoriPic: Array<Int>
lateinit var kategoriTv: Array<String>


/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment(private val emailId: String?) : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapterKategori: KategoriAdapter
    private lateinit var kategoriRecycler: RecyclerView
    private lateinit var listKategori: ArrayList<Kategori>

    private lateinit var adapterNews: NewsAdapter
    private lateinit var newsRecycler: RecyclerView
    private lateinit var listNews: ArrayList<News>


    lateinit var newsPic: Array<Int>


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
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitializeKategori()
        dataInitializeNews()
        dataInitializePopular()
        val layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        kategoriRecycler = view.findViewById(R.id.kategoriRecycler)
        kategoriRecycler.layoutManager = layoutManager
        kategoriRecycler.setHasFixedSize(true)
        adapterKategori = KategoriAdapter(listKategori)
        kategoriRecycler.adapter = adapterKategori

        val layoutManagerNews = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        newsRecycler = view.findViewById(R.id.newsRecycler)
        newsRecycler.layoutManager = layoutManagerNews
        newsRecycler.setHasFixedSize(true)
        adapterNews = NewsAdapter(listNews)
        newsRecycler.adapter = adapterNews

        val layoutManagerPopular = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        popularRecycler = view.findViewById(R.id.popularRecycler)
        popularRecycler.layoutManager = layoutManagerPopular
        popularRecycler.setHasFixedSize(true)
        adapterPopular = popularAdapter(listPopular)
        popularRecycler.adapter = adapterPopular

        val helloText: TextView = view.findViewById(R.id.helloText)
        var letters = ""
        if (emailId != null) {

            for (i in emailId) {
                if (i.toString().equals("@")) {
                    break
                } else {
                    letters += i.toString()
                }

            }
            helloText.text = "Hello, " + letters
        } else {
            helloText.text = "Hello,please login"
        }
    }

    private fun dataInitializeKategori() {
        listKategori = arrayListOf<Kategori>()
        kategoriPic = arrayOf(
            R.drawable.ic_devices,
            R.drawable.ic__weekend,
            R.drawable.ic_clothing,
        )
        kategoriTv = arrayOf(
            "Technology",
            "Home",
            "Clothing"
        )

        for (i in kategoriPic.indices) {
            val items = Kategori(kategoriPic[i], kategoriTv[i])
            listKategori.add(items)
        }

    }


    private fun dataInitializeNews() {
        listNews = arrayListOf<News>()
        newsPic = arrayOf(
            R.drawable.ad1,
            R.drawable.ad2_,
            R.drawable.ad3,
        )

        for (i in newsPic.indices) {
            val items = News(newsPic[i])
            listNews.add(items)
        }


    }

    private fun dataInitializePopular() {
        listPopular = arrayListOf<Popular>()
        popularPic = arrayOf(
            R.drawable.iphone_13,
            R.drawable.cyan_sofa,
            R.drawable.woman_jacket,
            R.drawable.samsung,
            R.drawable.apple_watch,


            )
        popularTv = arrayOf(
            "Apple iPhone 13 Pro Max",
            "Cyan Sofa",
            "Woman's Lightweight Gray Jacket",
            "Samsung Galaxy S22 Ultra",
            "Apple Watch SE(2nd Gen)"
        )

        for (i in popularPic.indices) {
            val items = Popular(popularPic[i], popularTv[i])
            listPopular.add(items)
        }
    }


}