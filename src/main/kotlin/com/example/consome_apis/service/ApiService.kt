package com.example.consome_apis.service

import com.example.consome_apis.client.ApiClient
import com.example.consome_apis.dto.RetornoResponse
import com.example.consome_apis.ports.ApiPort
import org.springframework.stereotype.Service

@Service
class ApiService(
    private val apiClient: ApiClient
) : ApiPort {
    override fun buscaPorCodigoSerie(codigoSerie: String): List<RetornoResponse> {
        val response = apiClient.buscaPorCodigoSerie(
            codigoSerie = codigoSerie
        )
        return response
    }

    override fun buscaPorDataIniciaFinal(
        codigoSerie: String,
        dataInicial: String,
        dataFinal: String
    ): List<RetornoResponse> {
        val response = apiClient.buscaPorDataIniciaFinal(
            codigoSerie = codigoSerie,
            dataInicial = dataInicial,
            dataFinal = dataFinal
        )
        return response
    }

    override fun buscaPorNUtimos(codigoSerie: String, n: String): List<RetornoResponse> {
        val response = apiClient.buscaPorNUtimos(
            codigoSerie = codigoSerie,
            n = n
        )
        return response
    }
}