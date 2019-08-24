package com.pedoran.pocketepl.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pedoran.pocketepl.Entity.Event
import com.pedoran.pocketepl.R
import com.pedoran.pocketepl.ui.matchDetail.MatchDetail
import com.pedoran.pocketepl.utils.DateConverter
import kotlinx.android.synthetic.main.match_item.view.*
import org.jetbrains.anko.startActivity

class MatchAdapter(val context: Context?,
                   private val eventList : List<Event>
                  ) : RecyclerView.Adapter<MatchAdapter.ClubViewHolder>(){

    inner class ClubViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(event : Event){
            if(event.intHomeScore == null){
                itemView.dateScheduleTv.setTextColor(itemView.context.resources.getColor(android.R.color.black,itemView.context.theme))
            }

            itemView.homeNameTv.text = event.strHomeTeam
            itemView.homeScoreTv.text = event.intHomeScore
            itemView.awayNameTv.text = event.strAwayTeam
            itemView.awayScoreTv.text = event.intAwayScore
            itemView.dateScheduleTv.text = event.dateEvent?.let { DateConverter.formatDateToMatch(it) }

            itemView.setOnClickListener{
                itemView.context.startActivity<MatchDetail>("match" to event)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchAdapter.ClubViewHolder {
        return ClubViewHolder(LayoutInflater.from(context).inflate(R.layout.match_item,parent,false))
    }

    override fun getItemCount(): Int = eventList.size

    override fun onBindViewHolder(holder: MatchAdapter.ClubViewHolder, position: Int) {
        holder.bind(eventList[position])
    }
}