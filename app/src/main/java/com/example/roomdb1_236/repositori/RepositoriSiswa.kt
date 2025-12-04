package com.example.roomdb1_236.repositori

import com.example.roomdb1_236.room.Siswa
import com.example.roomdb1_236.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)
    fun deleteSiswa(toSiswa: Siswa) {}
    fun getSiswaStream(idSiswa: Int) {}
}

class OfflineRepositoriSiswa(
    private val siswaDao: SiswaDao
) : RepositoriSiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getAllSiswa()
    override suspend fun insertSiswa(siswa: Siswa) = siswaDao.insert(siswa)
}