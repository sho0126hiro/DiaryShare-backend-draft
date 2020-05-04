package sho0126hiro.DiaryShareBackend.exception

import org.springframework.web.bind.annotation.ControllerAdvice

class RequestException (var errorMessage: String) : Exception() {
    fun BadRequestException(errorMessage: String) {
        this.errorMessage = errorMessage
    }
}