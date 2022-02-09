package com.example.coronavaccinemanagementsystem

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter( var list:List<VaccineItems>,val vaccineItemClickInterface:VaccineItemClickInterface, val vaccineItemDeleteClickInterface:VaccineItemDeleteClickInterface):
    RecyclerView.Adapter<RVAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val prsnName: TextView = itemView.findViewById(R.id.prsnName)
        val vccnName: TextView = itemView.findViewById(R.id.vccnName)
        val adhrNum: TextView = itemView.findViewById(R.id.adhrNum)
        val dose: TextView = itemView.findViewById(R.id.dose)
        val dlt: ImageView = itemView.findViewById(R.id.dlt)
        val tick: ImageView = itemView.findViewById(R.id.tick)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.prsnName.text = list.get(position).personName
        holder.vccnName.text = list.get(position).vaccineName
        holder.adhrNum.text = list.get(position).aadharNum.toString()
        holder.dose.text = list.get(position).dose.toString()
        if(holder.dose.text=="2"){
            holder.tick.visibility=View.VISIBLE
        }
        holder.dlt.setOnClickListener {
            vaccineItemDeleteClickInterface.onItemClickDelete(list.get(position))
        }
        holder.itemView.setOnClickListener {
            vaccineItemClickInterface.OnVaccineItemClick(list.get(position))

        }


    }

    override fun getItemCount(): Int {
        return list.size
    }


    interface VaccineItemDeleteClickInterface {

        fun onItemClickDelete(vaccineItems: VaccineItems)
    }

    interface VaccineItemClickInterface {
        fun OnVaccineItemClick(record: VaccineItems)
    }
}