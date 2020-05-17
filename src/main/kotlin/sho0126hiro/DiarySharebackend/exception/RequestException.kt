package sho0126hiro.DiaryShareBackend.exception

class RequestException (var errorMessage: String) : Exception() {
    fun BadRequestException(errorMessage: String) {
        this.errorMessage = errorMessage
    }
}