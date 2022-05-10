package com.example.gametime

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class FriendAdapter(var userList: List<Person>) : RecyclerView.Adapter<FriendAdapter.ViewHolder>() {
    // list that contains lists
    // we want to access those inner lists and add them to the original list
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
        val context = holder.layout.context
        val user = userList[position]
        val game = gameList[position]
        holder.textViewUser.text = user.name
        holder.textViewGame.text = game.game
        holder.textViewTime.text = game.time.toString()
        // holder.layout.setOnClickListener{}
    }

    override fun getItemCount(): Int {
        return gameList.size
    }
}