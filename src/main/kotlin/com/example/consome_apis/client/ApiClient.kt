package com.example.consome_apis.client

import com.example.consome_apis.dto.RetornoResponse
import com.example.consome_apis.exception.NotFoundException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.type.TypeFactory
import feign.FeignException
import feign.Response
import feign.Util
import feign.codec.Decoder
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.io.IOException
import java.lang.reflect.Type

@FeignClient(
    value = "consulta-taxaJuros-e-inadimplenciaConsignado",
    url = "https://api.bcb.gov.br/dados/serie"
)
interface ApiClient {

    @GetMapping("/bcdata.sgs.{codigo_serie}/dados?formato=json")
    fun buscaPorCodigoSerie(
        @PathVariable("codigo_serie") codigoSerie: String,
    ): List<RetornoResponse>

    @GetMapping("/bcdata.sgs.{codigo_serie}/dados?formato=json&dataInicial={data_inicial}&dataFinal={data_final}")
    fun buscaPorDataIniciaFinal(
        @PathVariable("codigo_serie") codigoSerie: String,
        @PathVariable("data_inicial") dataInicial: String,
        @PathVariable("data_final") dataFinal: String
    ): List<RetornoResponse>

    @GetMapping("/bcdata.sgs.{codigo_serie}/dados/ultimos/{N}?formato=json")
    fun buscaPorNUtimos(
        @PathVariable("codigo_serie") codigoSerie: String,
        @PathVariable("N") n: String
    ): List<RetornoResponse>

    class Config : Decoder {
        @Throws(IOException::class, FeignException::class)
        override fun decode(response: Response, type: Type): Any {
            val resultadoDaResposta = Util.toString(response.body().asReader(Util.UTF_8))
            if (resultadoDaResposta.contains("Requisição inválida")) {
                throw NotFoundException("Código não encontrado")
            }
            return objectMapper!!.readValue(resultadoDaResposta, TypeFactory.defaultInstance().constructType(type))
        }

        companion object {
            private var objectMapper: ObjectMapper? = null

            init {
                objectMapper = ObjectMapper()
            }
        }
    }
}