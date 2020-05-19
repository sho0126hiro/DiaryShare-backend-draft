package sho0126hiro.DiaryShareBackend.domain.repository

import sho0126hiro.DiaryShareBackend.domain.`object`.Like

interface LikeRepository {
    fun create(like: Like): Like
    fun delete(like: Like)
}