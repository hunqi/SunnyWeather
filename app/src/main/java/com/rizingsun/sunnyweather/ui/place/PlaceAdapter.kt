package com.rizingsun.sunnyweather.ui.place

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.rizingsun.sunnyweather.R
import com.rizingsun.sunnyweather.logic.model.Place
import com.rizingsun.sunnyweather.logic.model.Province

class PlaceAdapter(private val fragment: Fragment, private val placeList: List<Any>) :
    RecyclerView.Adapter<PlaceAdapter.ViewHolder>(){

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val placeName: TextView = view.findViewById(R.id.placeName)
        val placeAddress: TextView = view.findViewById(R.id.placeAddress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place: Province = placeList[position] as Province
        holder.placeName.text = place.quName
        holder.placeAddress.text = place.citeName
    }

    override fun getItemCount() = placeList.size

}