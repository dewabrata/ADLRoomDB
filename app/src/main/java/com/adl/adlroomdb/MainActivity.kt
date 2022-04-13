package com.adl.adlroomdb

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.adl.adlroomdb.adapter.MovieAdapter
import com.adl.adlroomdb.database.PelangganDatabase
import com.adl.adlroomdb.database.model.EntPelanggan
import com.adl.adlroomdb.database.model.MovieModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var db:PelangganDatabase

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if(result.resultCode == Activity.RESULT_OK){

            if(result.data?.hasExtra("data")!!){
                lstMovie.add(result.data!!.extras?.getParcelable<MovieModel>("data")!!)
            }

            movieadapter.notifyDataSetChanged()

        }
    }

    lateinit var movieadapter: MovieAdapter
    var lstMovie = ArrayList<MovieModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(
            applicationContext,
            PelangganDatabase::class.java, "pelanggandb"
        ).build()

        movieadapter = MovieAdapter(lstMovie)
        lstItemMovie.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = movieadapter
        }

        btnAddMovie.setOnClickListener({
            val intent = Intent(this@MainActivity,AddMovie::class.java)
            resultLauncher.launch(intent)
        })

    }


    fun initData(){
        val pelangganModel = EntPelanggan(0,"Dewa","Pakuan","08777777","dewa@gmail.com")
        val pelangganModel2 = EntPelanggan(0,"Dewi","Pakuan","0866666","dewi@gmail.com")
      //  db.pelangganDao().insertAll(pelangganModel)
      //  db.pelangganDao().insertAll(pelangganModel2)
    }

    fun selectAllData(){
        var lstPelanggan:List<EntPelanggan> = db.pelangganDao().getAll()

        lstPelanggan.forEach { entPelanggan -> Log.d("Data","${entPelanggan.namapelanggan}") }

    }

    fun deleteData(){
        val pelangganModel = EntPelanggan(1,"Dewa","Pakuan","08777777","dewa@gmail.com")
        db.pelangganDao().deleteAll()

        selectAllData()
    }
}