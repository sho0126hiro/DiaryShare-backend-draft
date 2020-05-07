package sho0126hiro.DiaryShareBackend.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class ErrorResponse (val message: String){
    companion object {
        fun createBadRequestException(e: RequestException): ResponseEntity<ErrorResponse> {
            return ResponseEntity<ErrorResponse>(ErrorResponse(e.errorMessage), HttpStatus.FORBIDDEN);
        }
    }
}