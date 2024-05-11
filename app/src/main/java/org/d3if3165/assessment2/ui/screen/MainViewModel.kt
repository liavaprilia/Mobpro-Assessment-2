package org.d3if3165.assessment2.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if3165.assessment2.database.PelangganDao
import org.d3if3165.assessment2.model.Pelanggan

class MainViewModel(dao: PelangganDao) : ViewModel() {
    val data: StateFlow<List<Pelanggan>> = dao.getPelanggan().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )
}