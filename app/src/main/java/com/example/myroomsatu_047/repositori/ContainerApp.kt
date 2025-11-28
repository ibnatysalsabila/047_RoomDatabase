package com.example.myroomsatu_047.repositori

import android.app.Application
import android.content.Context
import com.example.myroomsatu_047.room.DatabaseSiswa

interface ContainerApp{
    val repositoriSiswa : RepositoriSiswa
}

class ContainerDataApp(private val context: Context):
        ContainerApp {
    override val repositoriSiswa: RepositoriSiswa by lazy {
        OfflineRepositorSiswa(
            siswaDao = DatabaseSiswa.getDatabase(context).siswaDao()
        )
    }
}

class AplikasiSiswa : Application () {
    lateinit var container : ContainerDataApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(context = this)
    }
}
