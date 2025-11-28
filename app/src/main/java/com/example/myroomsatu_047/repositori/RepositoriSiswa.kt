package com.example.myroomsatu_047.repositori

import com.example.myroomsatu_047.room.Siswa
import com.example.myroomsatu_047.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa{
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)
}

class OfflineRepositorSiswa(
    private val siswaDao: SiswaDao
): RepositoriSiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao .getAllSiswa()
    override suspend fun insertSiswa(siswa: Siswa)  = siswaDao.insert(siswa)
}