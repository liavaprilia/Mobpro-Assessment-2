package org.d3if3165.assessment2.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3165.assessment2.database.PelangganDao
import org.d3if3165.assessment2.model.Pelanggan
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DetailViewModel(private val dao: PelangganDao) : ViewModel() {
    private val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)

    fun insert(nama: String, alamat: String, beratCucian: String) {
        val pelanggan = Pelanggan(
            tanggal = formatter.format(Date()),
            nama = nama,
            alamat = alamat,
            beratCucian = beratCucian
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(pelanggan)
        }
    }

    suspend fun getPelanggan(id: Long): Pelanggan? {
        return dao.getPelangganById(id)
    }

    fun update(id: Long, nama: String, alamat: String, beratCucian: String) {
        val pelanggan = Pelanggan(
            id = id,
            tanggal = formatter.format(Date()),
            nama = nama,
            alamat = alamat,
            beratCucian = beratCucian
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.update(pelanggan)
        }
    }

    fun delete(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deletedById(id)
        }
    }
}