package com.example.consome_apis.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class RetornoResponse(
    @JsonProperty("data")
    val data: String,
    @JsonProperty("valor")
    val valor: String
)
