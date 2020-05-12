package sho0126hiro.DiaryShareBackend.domain.repository

import sho0126hiro.DiaryShareBackend.domain.`object`.Diary

interface DiaryRepository {
    fun create(diary: Diary): Diary
    fun edit(diary: Diary): Diary
    fun changeStatus(id: String, status: String): Diary
}