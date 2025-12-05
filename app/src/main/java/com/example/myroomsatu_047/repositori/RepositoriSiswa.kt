package com.example.myroomsatu_047.repositori

import androidx.compose.runtime.snapshots.SnapshotId
import com.example.myroomsatu_047.room.Siswa
import com.example.myroomsatu_047.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa{
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)

    fun getSiswaStream(id: Int): Flow<Siswa?>
    suspend fun deleteSiswa(siswa: Siswa)
    suspend fun updateSiswa(siswa: Siswa)
}

class OfflineRepositorSiswa(
    private val siswaDao: SiswaDao
): RepositoriSiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao .getAllSiswa()
    override suspend fun insertSiswa(siswa: Siswa)  = siswaDao.insert(siswa)
    override fun getSiswaStream(id: Int): Flow<Siswa?> =siswaDao.getSiswa(id)
    override suspend fun deleteSiswa(siswa: Siswa) = siswaDao.delete(siswa)
    override suspend fun updateSiswa(siswa: Siswa) = siswaDao.update(siswa)
}