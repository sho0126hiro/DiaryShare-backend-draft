package sho0126hiro.DiaryShareBackend.domain.repository

import sho0126hiro.DiaryShareBackend.domain.`object`.User

interface UserRepository {
    /**
     * idからUserを検索
     * @param id
     * @return ユーザ
     */
    fun findById(id: String): User?

    /**
     * ユーザ作成・更新
     * @param user 作成したいユーザ
     * @return 更新後
     */
    fun save(user: User): User?

    /**
     * ユーザ削除
     * @param id user id
     */
    fun deleteById(id: String): Unit
}