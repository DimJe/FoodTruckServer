package com.dimje.foodtruck.service

import com.dimje.foodtruck.domain.Review
import com.dimje.foodtruck.domain.Truck
import com.dimje.foodtruck.domain.TruckRequest
import com.dimje.foodtruck.domain.TruckResponse
import com.dimje.foodtruck.repository.TruckRepository
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.modelmapper.ModelMapper
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TruckService(
    private val truckRepository: TruckRepository,
    private val modelMapper: ModelMapper
) {
    @Transactional
    fun createTruck(truckRequest: TruckRequest): Long?{
        //val truck = Truck(name = "tako")
        val menuData = jacksonObjectMapper().writeValueAsString(truckRequest.menu)
        val reviewData = jacksonObjectMapper().writeValueAsString(truckRequest.review)
        val truck = Truck(null,truckRequest.name,truckRequest.heartCount,truckRequest.latitude,truckRequest.longitude,menuData,reviewData,truckRequest.openDay,truckRequest.report,truckRequest.address)
        return truckRepository.save(truck).id
    }
    @Transactional
    fun readAllTruck(): ResponseEntity<List<TruckResponse>>{
        val response = truckRepository.findAll()
        val responseList = mutableListOf<TruckResponse>()
        response.forEach {
            val menu = jacksonObjectMapper().readValue(it.menu,Array<String>::class.java)
            val review = jacksonObjectMapper().readValue(it.review,Array<Review>::class.java)
            responseList.add(TruckResponse(it.id!!,it.name,it.heartCount,it.latitude,it.longitude,menu.toList(),review.toList(),it.openDay,it.report,it.address))
        }
        return ResponseEntity.ok(responseList.toList())
    }

}