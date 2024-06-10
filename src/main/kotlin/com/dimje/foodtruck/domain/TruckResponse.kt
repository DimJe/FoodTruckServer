package com.dimje.foodtruck.domain

data class TruckResponse(
    var id: Long,
    var name: String,
    var heartCount: Int,
    var latitude: Long,
    var longitude: Long,
    var menu: List<String>,
    var review: List<Review>,
    var openDay: Short,
    var report: Int,
    var address: String
)
