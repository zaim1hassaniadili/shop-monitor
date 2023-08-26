package com.z_ha.shopmonitor.model

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date

class Tick {
    val open : String?
    val dateTime: String?
    val id: Long = 0


    constructor(status: String, date: String){
        this.open = status
        this.dateTime = date
    }


    override fun toString(): String {
        return "isOpen: ${this.open}, dateTime: ${this.dateTime}"
    }

}