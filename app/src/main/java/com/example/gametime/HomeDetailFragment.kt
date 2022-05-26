package com.example.gametime

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.backendless.Backendless
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault
import com.backendless.persistence.DataQueryBuilder
import com.example.gametime.LoginActivity
import com.example.gametime.MainActivity
import com.example.gametime.Person
import com.example.gametime.R
import com.example.gametime.databinding.FragmentHomeBinding
import com.example.gametime.databinding.FragmentHomeDetailBinding
import com.squareup.picasso.Picasso

class HomeDetailFragment : Fragment() {

    private var _binding: FragmentHomeDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val image = arguments?.getString(FriendAdapter.BUNDLE_IMAGE) ?: Constants.DEFAULT_IMAGE
        val game = arguments?.getString(FriendAdapter.BUNDLE_GAME) ?: ""
        val time = arguments?.getString(FriendAdapter.BUNDLE_TIME) ?: ""

        Log.d("homedetail", "onCreateView: ${arguments?.getString(FriendAdapter.BUNDLE_IMAGE)}")
        val imageView: ImageView = binding.imageViewHomeDetail
        Picasso.get().setLoggingEnabled(true)
        Picasso.get().load(image.trim()).resize(500,750).into(imageView)

        val textViewGame = binding.textViewHomeDetailGame
        textViewGame.text = game
        val textViewTime = binding.textViewHomeDetailTime
        textViewTime.text = "${time} hours played"

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}