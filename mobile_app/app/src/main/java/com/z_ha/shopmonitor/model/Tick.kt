package com.z_ha.shopmonitor.model

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date

class Tick {
    val isOpen : Boolean?
    val dateTime: LocalDateTime?
    val id: Long = 0


    constructor(status: Boolean, date: LocalDateTime){
        this.isOpen = status
        this.dateTime = date
    }


}