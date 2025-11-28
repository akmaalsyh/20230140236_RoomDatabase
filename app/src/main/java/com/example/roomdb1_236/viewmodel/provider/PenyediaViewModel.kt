package com.example.roomdb1_236.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.roomdb1_236.repositori.AplikasiSiswa
import com.example.roomdb1_236.repositori.RepositoriSiswa
import com.example.roomdb1_236.viewmodel.EntryViewModel
import com.example.roomdb1_236.viewmodel.HomeViewModel

object PenyediaViewModel {

    val Factory = viewModelFactory {

        initializer {
            HomeViewModel(repositoriSiswa = aplikasiSiswa().containerApp.repositoriSiswa)
        }

        initializer {
            EntryViewModel(repositoriSiswa = aplikasiSiswa().containerApp.repositoriSiswa)
        }
    }
}

/**
 * Fungsi ekstensi query untuk objek [Application] dan mengembalikan sebuah instance dari
 * [AplikasiSiswa].
 */
fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)