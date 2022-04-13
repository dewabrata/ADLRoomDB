package com.adl.adlroomdb

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adl.adlroomdb.database.model.MovieModel
import kotlinx.android.synthetic.main.activity_add_movie.*

class AddMovie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)



        btnAddMovieInput.setOnClickListener({
            val moviedata = MovieModel(txtTitle.text.toString(),txtReleaseDate.text.toString(),
                txtDirectorInput.text.toString(),txtActorInput.text.toString(),txtRatingInput.text.toString(),txtPhoto.text.toString())

            val intent = Intent()
            intent.putExtra("data",moviedata)
            setResult(Activity.RESULT_OK,intent)
            finish()
        })
    }
}