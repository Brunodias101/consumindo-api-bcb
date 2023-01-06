package com.example.consome_apis.service

import com.example.consome_apis.client.ApiClient
import com.example.consome_apis.dto.RetornoResponse
import com.example.consome_apis.ports.ApiPort
import org.springframework.stereotype.Service

@Service
class ApiService(
    private val apiClient: ApiClient
) : ApiPort {
    override fun buscaPoCodigoSerie(codigoSerie: String): List<RetornoResponse> {
        val response = apiClient.buscaPoCodigoSerie(
            codigoSerie = codigoSerie
        )
        return response
    }

    override fun buscaPoDataIniciaFinal(
        codigoSerie: String,
        dataInicial: String,
        dataFinal: String
    ): List<RetornoResponse> {
        val response = apiClient.buscaPoDataIniciaFinal(
            codigoSerie = codigoSerie,
            dataInicial = dataInicial,
            dataFinal = dataFinal
        )
        return response
    }

    override fun buscaPoNUtimos(codigoSerie: String, n: String): List<RetornoResponse> {
        val response = apiClient.buscaPoNUtimos(
            codigoSerie = codigoSerie,
            n = n
        )
        return response
    }
}