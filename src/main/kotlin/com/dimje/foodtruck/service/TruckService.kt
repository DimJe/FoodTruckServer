package com.dimje.foodtruck.service

import com.dimje.foodtruck.model.Truck
import com.dimje.foodtruck.model.TruckDto
import com.dimje.foodtruck.repository.TruckRepository
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TruckService(
    private val truckRepository: TruckRepository,
    private val modelMapper: ModelMapper
) {
    @Transactional
    fun createTruck(truckDto: TruckDto): Long?{
        //val truck = Truck(name = "tako")
        return truckRepository.save(modelMapper.map(truckDto,Truck::class.java)).id
    }
    @Transactional
    fun readAllTruck(): List<Truck>{
        return truckRepository.findAll()
    }

}