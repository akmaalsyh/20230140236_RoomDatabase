package com.example.roomdb1_236.repositori

import com.example.roomdb1_236.room.Siswa
import com.example.roomdb1_236.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)

    // Edit 1 : tambah 3 fungsi berikut
    fun getSiswaStream(idSiswa: Int): Flow<Siswa?>
    suspend fun deleteSiswa(siswa: Siswa)
    suspend fun updateSiswa(siswa: Siswa)
}

class OfflineRepositoriSiswa(
    private val siswaDao: SiswaDao
) : RepositoriSiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getAllSiswa()
    override suspend fun insertSiswa(siswa: Siswa) = siswaDao.insert(siswa)

    // Edit 2 : tambah 3 override berikut
    override fun getSiswaStream(idSiswa: Int): Flow<Siswa?> = siswaDao.getSiswa(idSiswa)
    override suspend fun deleteSiswa(siswa: Siswa) = siswaDao.delete(siswa)
    override suspend fun updateSiswa(siswa: Siswa) = siswaDao.update(siswa)
}