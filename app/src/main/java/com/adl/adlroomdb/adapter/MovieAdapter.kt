package com.adl.adlroomdb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adl.adlroomdb.MovieModel
import com.adl.adlroomdb.R

class MovieAdapter(val data :ArrayList<MovieModel>) : RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false))


    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
      holder.bindData(this@MovieAdapter,position)
    }

    override fun getItemCount(): Int {
       return data.size
    }

    fun deleteDataAt( position: Int){
        data.removeAt(position)
        notifyDataSetChanged()
    }
}