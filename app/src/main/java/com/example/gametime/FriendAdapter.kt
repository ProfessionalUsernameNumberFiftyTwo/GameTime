package com.example.gametime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.gametime.ui.friends.FriendsFragment

class FriendAdapter(var userList: List<Person>) : RecyclerView.Adapter<FriendAdapter.ViewHolder>() {
    // list that contains lists
    // we want to access those inner lists and add them to the original list

    companion object {
        val BUNDLE_NAME = "name"
        val BUNDLE_GAME = "game"
        val BUNDLE_TIME = "time"
        val BUNDLE_IMAGE = "image"
    }

    var gameList = userList.flatMap {
        it.gameplay
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val layout : ConstraintLayout
        val textViewGame : TextView
        val textViewUser : TextView
        val textViewTime : TextView

        init {
            layout = view.findViewById(R.id.layout_friendItem)
            textViewGame = view.findViewById(R.id.textView_friend_game)
            textViewUser = view.findViewById(R.id.textView_friend_user)
            textViewTime = view.findViewById(R.id.textView_friend_time)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_friend, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        val game = gameList[position]
        holder.textViewUser.text = user.name
        holder.textViewGame.text = game.game
        holder.textViewTime.text = "${game.time.toString()} hours played"
        holder.layout.setOnClickListener{
            val bundle = Bundle()
            bundle.putString(BUNDLE_NAME, user.name)
            bundle.putString(BUNDLE_GAME, game.game)
            bundle.putString(BUNDLE_TIME, game.time.toString())
            bundle.putString(BUNDLE_IMAGE, game.image)
            Navigation.findNavController(holder.itemView).navigate(R.id.action_nav_friends_to_nav_friendsDetail, bundle)
        }
    }

    override fun getItemCount(): Int {
        return gameList.size
    }
}