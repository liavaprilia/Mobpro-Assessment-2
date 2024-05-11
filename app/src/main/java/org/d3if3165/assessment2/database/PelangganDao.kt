package org.d3if3165.assessment2.database

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.d3if3165.assessment2.model.Pelanggan

interface PelangganDao {
    @Insert
    suspend fun insert(pelanggan: Pelanggan)

    @Update
    suspend fun update(pelanggan: Pelanggan)

    @Query("SELECT * FROM pelanggan ORDER BY nama ASC")
    fun getPelanggan() : Flow<List<Pelanggan>>

    @Query("SELECT * FROM pelanggan WHERE id = :id")
    suspend fun getPelangganById(id: Long): Pelanggan?

    @Query("DELETE FROM pelanggan WHERE id = :id")
    suspend fun deletedById(id: Long)
}