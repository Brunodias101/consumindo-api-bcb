package com.example.consome_apis.ports

import com.example.consome_apis.dto.RetornoResponse

interface ApiPort {
    fun buscaPoCodigoSerie(codigoSerie: String): List<RetornoResponse>

    fun buscaPoDataIniciaFinal(codigoSerie: String, dataInicial: String, dataFinal: String): List<RetornoResponse>

    fun buscaPoNUtimos(codigoSerie: String, n: String): List<RetornoResponse>
}