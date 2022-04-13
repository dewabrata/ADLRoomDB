package com.adl.adlroomdb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.adl.adlroomdb.database.model.MovieModel
import com.adl.adlroomdb.R
import com.adl.adlroomdb.database.MovieDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MovieAdapter(val data :ArrayList<MovieModel>) : RecyclerView.Adapter<MovieViewHolder>() {
    lateinit var parent: ViewGroup

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        this.parent =parent

        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false))


    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
      holder.bindData(this@MovieAdapter,position)
    }

    override fun getItemCount(): Int {
       return data.size
    }

    fun deleteDataAt( position: Int){
        GlobalScope.launch {

            val deleteData = MovieDatabase.getInstance(parent.context).movieDao()
                .deleteModel(data.get(position))

            data.clear()
            data.addAll( ArrayList(MovieDatabase.getInstance(parent.context).movieDao().getAll()))
            val mainExecutor = ContextCompat.getMainExecutor(parent.context)

// Execute a task in the main thread
            mainExecutor.execute {
                // You code logic goes here.
            notifyDataSetChanged()
            }

        }

    }
}