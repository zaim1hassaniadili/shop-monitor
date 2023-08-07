package com.z_ha.shopmonitor.model

import java.time.LocalDate
import java.util.Date

class Tick {
    val status : Boolean?
    val date: LocalDate?

    constructor(status: Boolean, date: LocalDate){
        this.status = status
        this.date = date
    }
}