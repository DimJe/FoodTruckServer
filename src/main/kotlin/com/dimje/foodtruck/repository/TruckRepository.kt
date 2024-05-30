package com.dimje.foodtruck.repository

import com.dimje.foodtruck.model.Truck
import org.springframework.data.jpa.repository.JpaRepository

interface TruckRepository: JpaRepository<Truck,Long> {
}