package com.example.gametime.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.backendless.Backendless
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault
import com.backendless.persistence.DataQueryBuilder
import com.example.gametime.*
import com.example.gametime.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var userId : String

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onStart() {
        super.onStart()

        // load the data from the database
        // put it into the recyclerview
        loadDataFromBackendless()
    }

    private fun loadDataFromBackendless() {

        // retrieve only objects whose ownerId matches the user's objectId
        //val objectId = Backendless.UserService.CurrentUser().objectId
        val mainActivity = activity as MainActivity
        userId = mainActivity.getUserId()
        val whereClause = "ownerId = '$userId'"
        val queryBuilder = DataQueryBuilder.create()
        queryBuilder.whereClause = whereClause

        Backendless.Data.of(Person::class.java).find(queryBuilder, object :
            AsyncCallback<List<Person>?> {
            override fun handleResponse(foundPeople: List<Person>?) {
                // all Person instances have been found
                Log.d("HomeFragment", "handleResponse: ${foundPeople.toString()}")
                val adapter = GameAdapter((foundPeople ?: listOf()))
                binding.recyclerViewHome.adapter = adapter
                binding.recyclerViewHome.layoutManager =
                    LinearLayoutManager(this@HomeFragment.context)

            }

            override fun handleFault(fault: BackendlessFault) {
                // an error has occurred, the error code can be retrieved with fault.getCode()
                Log.d("BirthdayListActivity", "handleFault: ${fault.message}")
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}