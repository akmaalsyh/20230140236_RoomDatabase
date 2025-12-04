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
import com.example.roomdb1_236.view.EntrySiswaScreen
import com.example.roomdb1_236.view.HomeScreen
import com.example.roomdb1_236.view.route.DestinasiDetailSiswa
import com.example.roomdb1_236.view.route.DestinasiDetailSiswa.itemIdArg
import com.example.roomdb1_236.view.route.DestinasiEntry
import com.example.roomdb1_236.view.route.DestinasiHome

@Composable
fun SiswaApp(navController: NavHostController = rememberNavController(), modifier: Modifier){
    HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier)
{
    NavHost(navController=navController, startDestination = DestinasiHome.route, modifier = Modifier)
    {
        composable(DestinasiHome.route){
            HomeScreen(
                navigateToItemEntry = {navController.navigate(route = DestinasiEntry.route)},
                navigateToItemDetail = {navController.navigate(route = "${DestinasiDetailSiswa.route}/${it}")}
            )
        }
        composable(DestinasiEntry.route){
            EntrySiswaScreen(
                navigateBack = { navController.popBackStack() }
            )
        }
        composable(route = DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(navArgument(name = itemIdArg) {
                type = NavType.IntType
            })
        ){
            DetailSiswaScreen(
                navigateBack = { navController.navigateUp() }
            )
        }
    }
}