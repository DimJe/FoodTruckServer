package com.dimje.foodtruck.controller

import com.dimje.foodtruck.domain.TruckRequest
import com.dimje.foodtruck.domain.TruckResponse
import com.dimje.foodtruck.service.TruckService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["http://localhost:8080"])
@RestController
@Controller
//@RequestMapping("/truck")
class TruckController(
    private val truckService: TruckService
) {


    @GetMapping("/item")
    fun apiTest(): ResponseEntity<List<TruckResponse>>{
        return truckService.readAllTruck()
    }
    @PostMapping
    fun createTruck(@RequestBody truckRequest: TruckRequest): ResponseEntity<Any> {
        val save = truckService.createTruck(truckRequest)
        return ResponseEntity.ok().body(save)

    }
}