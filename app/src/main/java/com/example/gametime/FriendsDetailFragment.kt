package com.example.gametime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.gametime.databinding.FragmentFriendsBinding
import com.example.gametime.databinding.FragmentFriendsDetailBinding
import com.squareup.picasso.Picasso

class FriendsDetailFragment : Fragment() {

    private var _binding: FragmentFriendsDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFriendsDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val imageView: ImageView = binding.imageViewFriendsDetail



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}