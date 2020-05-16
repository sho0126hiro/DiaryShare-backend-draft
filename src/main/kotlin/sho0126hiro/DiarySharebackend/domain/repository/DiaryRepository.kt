package sho0126hiro.DiaryShareBackend.domain.repository

import sho0126hiro.DiaryShareBackend.domain.`object`.Diary
import java.util.*

interface DiaryRepository {
    fun create(diary: Diary): Diary
    fun edit(diary: Diary): Diary
    fun changeStatus(id: UUID, status: String): Diary
}