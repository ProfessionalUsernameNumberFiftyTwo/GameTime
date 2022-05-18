package com.example.gametime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

class GameAdapter(var userList: List<Person>) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    companion object {
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
        val textViewTime : TextView

        init{
            layout = view.findViewById(R.id.layout_gameItem)
            textViewGame = view.findViewById(R.id.textView_game_game)
            textViewTime = view.findViewById(R.id.textView_game_time)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_game, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context = holder.layout.context
        val game = gameList[position]
        holder.textViewGame.text = game.game
        holder.textViewTime.text = "${game.time.toString()} hours played"
        holder.layout.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(BUNDLE_GAME, game.game)
            bundle.putString(BUNDLE_TIME, game.time.toString())
            bundle.putString(BUNDLE_IMAGE, game.image)
            Navigation.findNavController(holder.itemView).navigate(R.id.action_nav_home_to_nav_homeDetail)
        }
    }

    override fun getItemCount(): Int {
        return gameList.size
    }
}