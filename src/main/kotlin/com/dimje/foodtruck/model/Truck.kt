package com.dimje.foodtruck.model

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
    var name: String
){
    constructor(): this(name = "")
}
