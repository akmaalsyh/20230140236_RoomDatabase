package com.example.roomdb1_236.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdb1_236.repositori.RepositoriSiswa
import com.example.roomdb1_236.room.Siswa
import kotlinx.coroutines.launch

class EntryViewModel(
    private val repositoriSiswa: RepositoriSiswa
) : ViewModel() {

    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa = UIStateSiswa(
            detailSiswa = detailSiswa,
            isEntryValid = validateInput(detailSiswa)
        )
    }
    private fun validateInput(detailSiswa: DetailSiswa = uiStateSiswa.detailSiswa): Boolean {
        return detailSiswa.nama.isNotBlank() &&
                detailSiswa.alamat.isNotBlank() &&
                detailSiswa.telpon.isNotBlank()
    }

    fun saveSiswa() {
        if (validateInput()) {
            viewModelScope.launch {
                repositoriSiswa.insertSiswa(uiStateSiswa.detailSiswa.toSiswa())
            }
        }
    }
}

data class UIStateSiswa(
    val detailSiswa: DetailSiswa = DetailSiswa(),
    val isEntryValid: Boolean = false
)

data class DetailSiswa(
    val id: Int = 0,
    val nama: String = "",
    val alamat: String = "",
    val telpon: String = ""
)

/* Fungsi untuk mengkonversi data input ke data dalam tabel sesuai jenis datanya */

fun DetailSiswa.toSiswa(): Siswa = Siswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon
)

fun Siswa.toUiStateSiswa(isEntryValid: Boolean = false): UIStateSiswa = UIStateSiswa(
    detailSiswa = this.toDetailSiswa(),
    isEntryValid = isEntryValid
)

fun Siswa.toDetailSiswa(): DetailSiswa = DetailSiswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon
)