package org.d3if3165.assessment2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pelanggan")
data class Pelanggan(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val tanggal: String,
    val nama: String,
    val alamat: String,
    val beratCucian: String
)