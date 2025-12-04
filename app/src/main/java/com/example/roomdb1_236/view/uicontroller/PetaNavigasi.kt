package com.example.roomdb1_236.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.roomdb1_236.view.DetailSiswaScreen
import com.example.roomdb1_236.view.EditSiswaScreen
import com.example.roomdb1_236.view.EntrySiswaScreen
import com.example.roomdb1_236.view.HomeScreen
import com.example.roomdb1_236.view.route.DestinasiDetailSiswa
import com.example.roomdb1_236.view.route.DestinasiEditSiswa
import com.example.roomdb1_236.view.route.DestinasiEntry
import com.example.roomdb1_236.view.route.DestinasiHome

@Composable
fun SiswaApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    HostNavigasi(navController = navController, modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {

        // HOME SCREEN
        composable(route = DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = {
                    navController.navigate(DestinasiEntry.route)
                },
                navigateToItemDetail = { siswaId ->
                    navController.navigate(
                        DestinasiDetailSiswa.createRoute(siswaId)
                    )
                }
            )
        }

        // ENTRY / ADD SCREEN
        composable(route = DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = { navController.popBackStack() }
            )
        }

        // DETAIL SCREEN
        composable(
            route = DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiDetailSiswa.itemIdArg) {
                    type = NavType.IntType
                }
            )
        ) {
            DetailSiswaScreen(
                navigateToEditItem = { siswaId ->
                    navController.navigate("edit_siswa/$siswaId")
                },
                navigateBack = { navController.popBackStack() }
            )
        }
    }
}