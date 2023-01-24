package com.example.consome_apis.ports

import com.example.consome_apis.dto.RetornoResponse

interface ApiPort {
    fun buscaPorCodigoSerie(codigoSerie: String): List<RetornoResponse>?

    fun buscaPorDataIniciaFinal(codigoSerie: String, dataInicial: String, dataFinal: String): List<RetornoResponse>

    fun buscaPorNUtimos(codigoSerie: String, n: String): List<RetornoResponse>
}