package com.example.footbalkt.main.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.footbalkt.R
import com.example.footbalkt.model.Team
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class TeamsAdapter (private val teams: List<Team>, private val listener: (Team) -> Unit)
    : RecyclerView.Adapter<TeamsAdapter.TeamViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(
            TeamUi()
                .createView(AnkoContext.create(parent.context, parent))
        )
    }

    override fun getItemCount() = teams.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindItem(teams[position], listener)
    }

    class TeamViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val teamBadge: ImageView = view.findViewById(R.id.team_badge)
        private val teamName: TextView = view.findViewById(R.id.team_name)

        fun bindItem(items: Team, listener: (Team) -> Unit){
            Picasso.get().load(items.teamBadge).fit().into(teamBadge)
            teamName.text = items.teamName

            itemView.setOnClickListener { listener(items) }
        }
    }

    class TeamUi : AnkoComponent<ViewGroup>{
        override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
            return with(ui){
                linearLayout{
                    lparams(matchParent, wrapContent)
                    padding = dip(16)
                    orientation = LinearLayout.HORIZONTAL

                    imageView {
                        id = R.id.team_badge
                    }.lparams(50, 50)

                    textView{
                        id = R.id.team_name
                        textSize = 16f
                    }.lparams{
                        padding = dip(15)
                    }


                }
            }
        }
    }

}