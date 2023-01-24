package com.example.consome_apis.controler

import com.example.consome_apis.dto.RetornoResponse
import com.example.consome_apis.exception.NotFoundException
import com.example.consome_apis.service.ApiService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("retornoApi")
class ApiController(
    private val apiService: ApiService
) {

    @GetMapping("/{codigo_serie}")
    fun buscaPorCodigoSerie(@PathVariable("codigo_serie") codigoSerie: String): List<RetornoResponse>? {
        return apiService.buscaPorCodigoSerie(codigoSerie)
    }

    @GetMapping("/{codigo_serie}/data")
    fun buscaPorDataIniciaFinal(
        @PathVariable("codigo_serie") codigoSerie: String,
        @RequestParam dataInicial: String,
        @RequestParam dataFinal: String
    ): List<RetornoResponse> {
        return apiService.buscaPorDataIniciaFinal(codigoSerie, dataInicial, dataFinal)
    }

    @GetMapping("/{codigo_serie}/filtro")
    fun buscaPorNUtimos(
        @PathVariable("codigo_serie") codigoSerie: String,
        @PathVariable n: String
    ): List<RetornoResponse> {
        return apiService.buscaPorNUtimos(codigoSerie, n)
    }

}