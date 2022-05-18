package com.example.gametime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
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

        val image = arguments?.getString(FriendAdapter.BUNDLE_IMAGE) ?: Constants.DEFAULT_IMAGE
        val game = arguments?.getString(FriendAdapter.BUNDLE_GAME) ?: ""
        val time = arguments?.getString(FriendAdapter.BUNDLE_TIME) ?: ""
        val name = arguments?.getString(FriendAdapter.BUNDLE_NAME) ?: ""

        val imageView: ImageView = binding.imageViewFriendsDetail
        Picasso.get().load(image).placeholder(R.drawable.sammich).into(imageView)

        val textViewGame: TextView = binding.textViewFriendsDetailGame
        textViewGame.text = game
        val textViewTime: TextView = binding.textViewFriendsDetailTime
        textViewTime.text = "${time} hours played"
        val textViewName: TextView = binding.textViewFriendsDetailPlayedBy
        textViewName.text = "Played by ${name}"

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}