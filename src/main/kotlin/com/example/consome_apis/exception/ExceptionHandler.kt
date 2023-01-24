package com.example.consome_apis.exception

import com.example.consome_apis.dto.ErroView
import feign.FeignException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest


@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(FeignException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleFeignStatusException(exception: FeignException, request: HttpServletRequest): ErroView {
        return ErroView(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            message = exception.message,
            path = request.servletPath
        )
    }
}