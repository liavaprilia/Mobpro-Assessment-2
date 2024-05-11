package org.d3if3165.assessment2.navigation

import org.d3if3165.assessment2.ui.screen.KEY_ID_PELANGGAN

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
    data object About: Screen("aboutScreen")
    data object MainMenu: Screen("mainMenu")
    data object FormBaru: Screen("detailScreen")
    data object FormUbah: Screen("detailScreen/{$KEY_ID_PELANGGAN}") {
        fun withId(id: Long) = "detailScreen/$id"
    }
}