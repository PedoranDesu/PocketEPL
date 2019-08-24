package com.pedoran.pocketepl.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pedoran.pocketepl.Entity.Team
import com.pedoran.pocketepl.R
import com.pedoran.pocketepl.ui.teamDetail.TeamDetail
import kotlinx.android.synthetic.main.team_item.view.*
import org.jetbrains.anko.startActivity

class TeamAdapter(
    val context: Context?,
    private val teamList: List<Team>
) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamAdapter.TeamViewHolder {
        return TeamViewHolder(LayoutInflater.from(context).inflate(R.layout.team_item,parent,false))
    }

    override fun getItemCount(): Int = teamList.size

    override fun onBindViewHolder(holder: TeamAdapter.TeamViewHolder, position: Int) {
        holder.bind(teamList[position])
    }

    inner class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(team : Team){
            itemView.tvTeam.text = team.strTeam
            Glide.with(itemView.context)
                .load(team.strTeamBadge)
                .apply(RequestOptions().placeholder(R.drawable.pennant))
                .into(itemView.imgTeam)

            itemView.setOnClickListener{
                itemView.context.startActivity<TeamDetail>("team" to team)
            }
        }
    }
}