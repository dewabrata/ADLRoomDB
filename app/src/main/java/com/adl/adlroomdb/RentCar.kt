package com.adl.adlroomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.adl.adlroomdb.database.RentCarDatabases
import com.adl.adlroomdb.database.model.Driver
import com.adl.adlroomdb.database.model.DriverMobil
import com.adl.adlroomdb.database.model.Mobil
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RentCar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rent_car)
        GlobalScope.launch {

            initData()


        }

    }

    fun initData(){

        RentCarDatabases.getInstance(applicationContext).daoRentCar().insertDriver(Driver(1,"Tono","30","Jakarta","0888888888"))
        RentCarDatabases.getInstance(applicationContext).daoRentCar().insertDriver(Driver(2,"Bejo","39","Bogor","09999999999"))

        RentCarDatabases.getInstance(applicationContext).daoRentCar().insertMobil(Mobil(1,"Toyota Avansa","1200","SUV",1))
        RentCarDatabases.getInstance(applicationContext).daoRentCar().insertMobil(Mobil(2,"Toyota Rust","1300","SUV",1))
        RentCarDatabases.getInstance(applicationContext).daoRentCar().insertMobil(Mobil(3,"Daihatsu Xenia","1200","SUV",2))

        val lstDriver:List<DriverMobil> = RentCarDatabases.getInstance(applicationContext).daoRentCar().getDriverMobil()
        Log.d("Driver",lstDriver.toString())
    }



}