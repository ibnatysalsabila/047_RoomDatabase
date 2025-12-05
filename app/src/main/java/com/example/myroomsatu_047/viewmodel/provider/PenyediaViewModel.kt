package com.example.myroomsatu_047.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myroomsatu_047.repositori.AplikasiSiswa
import com.example.myroomsatu_047.viewmodel.DetailViewModel
import com.example.myroomsatu_047.viewmodel.EntryViewModel
import com.example.myroomsatu_047.viewmodel.HomeViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiSiswa().container.repositoriSiswa)
        }
        initializer {
            EntryViewModel(aplikasiSiswa().container.repositoriSiswa)
        }
        initializer {
            DetailViewModel(savedStateHandle = this.createSavedStateHandle(),
                repositoriSiswa = aplikasiSiswa().container.repositoriSiswa)
        }
        initializer {
            EditViewModel(savedStateHandle = this.createSavedStateHandle(),
                repositoriSiswa = aplikasiSiswa().container.repositoriSiswa)
        }
    }
}

fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory
        .APPLICATION_KEY] as AplikasiSiswa)
