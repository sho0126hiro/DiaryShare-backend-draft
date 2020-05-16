package sho0126hiro.DiaryShareBackend.infrastructure.entity

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private const val FORMAT = "yyyy-MM-ddTHH:mm:ss.SSSSSS"
// ex: 2020-05-16T23:30:12.498058

fun stringToLocalDateTime(datetime: String): LocalDateTime{
    val dtf: DateTimeFormatter = DateTimeFormatter.ofPattern(FORMAT)
    return LocalDateTime.parse(datetime,dtf)
}