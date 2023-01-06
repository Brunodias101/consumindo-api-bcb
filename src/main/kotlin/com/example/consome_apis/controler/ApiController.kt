package com.example.consome_apis.controler

import com.example.consome_apis.dto.RetornoResponse
import com.example.consome_apis.service.ApiService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("retornoApi")
class ApiController(
    private val apiService: ApiService
) {

    @GetMapping("/{codigo_serie}")
    fun buscaPoCodigoSerie(@PathVariable("codigo_serie") codigoSerie: String): List<RetornoResponse> {
        return apiService.buscaPoCodigoSerie(codigoSerie)
    }

    @GetMapping("/{codigo_serie}/{data_inicial}/{data_final}")
    fun buscaPoDataIniciaFinal(
        @PathVariable("codigo_serie") codigoSerie: String,
        @PathVariable("data_inicial") dataInicial: String,
        @PathVariable("data_final") dataFinal: String
    ): List<RetornoResponse> {
        return apiService.buscaPoDataIniciaFinal(codigoSerie, dataInicial, dataFinal)
    }

    @GetMapping("/{codigo_serie}/{N}")
    fun buscaPoNUtimos(
        @PathVariable("codigo_serie") codigoSerie: String,
        @PathVariable("N") n: String
    ): List<RetornoResponse> {
        return apiService.buscaPoNUtimos(codigoSerie, n)
    }

}