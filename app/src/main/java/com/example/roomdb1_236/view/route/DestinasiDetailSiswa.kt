package com.example.roomdb1_236.view.route

import com.example.roomdb1_236.R

object DestinasiDetailSiswa {
    const val route = "detail_siswa"
    const val itemIdArg = "itemId"

    val routeWithArgs = "$route/{$itemIdArg}"

    val titleRes = R.string.detail_siswa

    fun createRoute(itemId: Int): String = "$route/$itemId"
}