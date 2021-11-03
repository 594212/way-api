package com.example.way.api

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.sql.RowIdLifetime

@Component
object AppProperties {
    @Value("\${jwtlifetime}")
    var lifetimeToken: Long = 45
}