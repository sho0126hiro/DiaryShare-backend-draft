package sho0126hiro.DiaryShareBackend.exception

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
@Component
class RequestExceptionHandler {
    @ExceptionHandler(RequestException::class)
    fun BatRequestException(req: HttpServletRequest, error: RequestException): ResponseEntity<ErrorResponse> {
        return ErrorResponse.createBadRequestException(error);
    }
}