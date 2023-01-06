package com.example.consome_apis.client

import com.example.consome_apis.dto.RetornoResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    value = "consulta-taxaJuros-e-inadimplenciaConsignado",
    url = "https://api.bcb.gov.br/dados/serie"
)
interface ApiClient {

    @GetMapping("/bcdata.sgs.{codigo_serie}/dados?formato=json")
    fun buscaPoCodigoSerie(
        @PathVariable("codigo_serie") codigoSerie: String,
    ): List<RetornoResponse>

    @GetMapping("/bcdata.sgs.{codigo_serie}/dados?formato=json&dataInicial={data_inicial}&dataFinal={data_final}")
    fun buscaPoDataIniciaFinal(
        @PathVariable("codigo_serie") codigoSerie: String,
        @PathVariable("data_inicial") dataInicial: String,
        @PathVariable("data_final") dataFinal: String
    ): List<RetornoResponse>

    @GetMapping("/bcdata.sgs.{codigo_serie}/dados/ultimos/{N}?formato=json")
    fun buscaPoNUtimos(
        @PathVariable("codigo_serie") codigoSerie: String,
        @PathVariable("N") n: String
    ): List<RetornoResponse>
}