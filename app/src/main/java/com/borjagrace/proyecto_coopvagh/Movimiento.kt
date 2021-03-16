package com.borjagrace.proyecto_coopvagh

import java.io.Serializable

data class Movimiento (
        val  fecha:String,
        val detalle:String,
        val operacion:Double ,
        val saldo:Double
        ) : Serializable
