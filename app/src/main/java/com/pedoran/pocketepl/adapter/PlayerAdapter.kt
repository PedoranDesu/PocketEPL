package com.pedoran.pocketepl.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.pedoran.pocketepl.Entity.Player
import com.pedoran.pocketepl.R
import com.pedoran.pocketepl.utils.DateConverter
import kotlinx.android.synthetic.main.item_detail_team_player.view.*

class PlayerAdapter (val context: Context,
                     private val playerList : List<Player>
) : RecyclerView.Adapter<PlayerAdapter.PlayerVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerAdapter.PlayerVH {
        return PlayerVH(LayoutInflater.from(context).inflate(R.layout.item_detail_team_player,parent,false))
    }

    override fun getItemCount(): Int = playerList.size

    override fun onBindViewHolder(holder: PlayerAdapter.PlayerVH, position: Int) {
        holder.bind(playerList[position])
    }

    inner class PlayerVH(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(player : Player){
            itemView.tvPlayerName.text = player.strPlayer
//            itemView.tvPlayerAge.text = DateConverter.formatStringDateToAge(player.dateBorn)
//            itemView.tvPlayerHeight.text = player.strHeight
            itemView.tvPlayerPos.text = player.strPosition
        }
    }
}