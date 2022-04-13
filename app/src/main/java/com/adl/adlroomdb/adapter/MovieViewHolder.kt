package com.adl.adlroomdb.adapter

import android.os.Looper
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.adl.adlroomdb.database.MovieDatabase
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_movie.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.logging.Handler


class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    val judul = view.lblJudul
    val rating = view.txtRating
    val director = view.txtDirector
    val actor = view.txtActor
    val release = view.txtRelease
    val delete = view.btnDelete
    val image = view.imageView
    val context = view.context

    fun bindData(adapter:MovieAdapter,position: Int) {


        judul.setText(adapter.data.get(position).title)
        rating.setText(adapter.data.get(position).rating)
        director.setText(adapter.data.get(position).director)
        actor.setText(adapter.data.get(position).actor)
        release.setText(adapter.data.get(position).release)
        Glide.with(context).load(adapter.data.get(position).photo).into(image)

        delete.setOnClickListener {
            adapter.deleteDataAt(position)




        }
    }
}