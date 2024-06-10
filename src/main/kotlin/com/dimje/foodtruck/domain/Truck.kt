package com.dimje.foodtruck.domain

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Entity
@Table(name="truckInfo") //사용하지 않으면 클래스 이름이 테이블 이름이 됨
@Getter //lombok getter
@Setter //lombok setter
class Truck(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(name = "name")
    var name: String,
    @Column(name = "heartCount")
    var heartCount: Int,
    @Column
    var latitude: Long,
    @Column
    var longitude: Long,
    @Column(columnDefinition = "JSON")
    var menu: String,
    @Column(columnDefinition = "JSON")
    //@ElementCollection
    var review: String,
    @Column
    var openDay: Short,
    @Column
    var report: Int,
    @Column
    var address: String
){
    constructor(): this(name = "", heartCount = 0, latitude = 0L, longitude = 0L, menu = "",review = "", openDay = 0, report = 0, address = "")
}
//@Embeddable
class Review(

    var userName: String,
    var content: String? = "",
    var point: Float,
    var day: String
)