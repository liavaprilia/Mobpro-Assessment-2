package org.d3if3165.assessment2.navigation

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
    data object About: Screen("aboutScreen")
    data object MainMenu: Screen("mainMenu")
    data object FormBaru: Screen("detailScreen")
}