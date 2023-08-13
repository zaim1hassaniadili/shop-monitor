package com.z_ha.shopmonitor.model

import java.time.LocalDate
import java.util.Date

class Tick {
    val isOpen : Boolean?
    val dateTime: LocalDate?


    constructor(status: Boolean, date: LocalDate){
        this.isOpen = status
        this.dateTime = date
    }


}