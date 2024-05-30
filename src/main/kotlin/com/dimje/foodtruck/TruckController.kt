package com.dimje.foodtruck

import com.dimje.foodtruck.model.Truck
import com.dimje.foodtruck.model.TruckDto
import com.dimje.foodtruck.service.TruckService
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["http://localhost:8080"])
@RestController
@Controller
//@RequestMapping("/truck")
class TruckController(
    private val truckService: TruckService
) {


    @GetMapping("/item")
    fun apiTest(): List<Truck>{
        return truckService.readAllTruck()
    }
    @PostMapping
    fun createTruck(@RequestParam("name", required = true) truckName: String): ResponseEntity<Any> {
        val data = TruckDto(truckName)
        val save = truckService.createTruck(data)
        return ResponseEntity.ok().body(save)

    }
}