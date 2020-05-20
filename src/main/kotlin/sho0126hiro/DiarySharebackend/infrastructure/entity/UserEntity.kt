package sho0126hiro.DiaryShareBackend.infrastructure.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import sho0126hiro.DiaryShareBackend.domain.`object`.Diary
import sho0126hiro.DiaryShareBackend.domain.`object`.User
import sho0126hiro.DiaryShareBackend.domain.service.FriendService
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import kotlin.collections.ArrayList

@Entity
@Table(name = "Users")
@EntityListeners(AuditingEntityListener::class)
class UserEntity(

        @Id
        @Column(name = "id")
        private val id: ByteArray = uuidToBytes(UUID.randomUUID()),

        /**
         * アカウント名
         * 主にユーザ検索などで利用する
         * credential.loginIdと同じ
         */
        @Column(name = "username")
        private val username: String,

        /**
         * 表示名
         */
        @Column(name = "name")
        private var name: String,

        @Column(name = "email")
        private var email: String,

        @Column(name = "biography")
        private var biography: String? = null,

        @field:CreationTimestamp
        @Column(name = "created_at", nullable = false)
        private val createdAt: LocalDateTime? = null,

        @field:UpdateTimestamp
        @Column(name = "updated_at", nullable = false)
        private val updatedAt: LocalDateTime? = null,

        @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER, mappedBy = "userId")
        var friends: Set<FriendEntity> = emptySet(),

        @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER, mappedBy = "userId")
        var diaries: Set<DiaryEntity> = emptySet()

){
    fun toDomainUser(): User {
        return User(bytesToUuid(id), username, name,  email, biography)
    }

    fun setName(name: String){
        this.name = name
    }

    fun setBiography(bio: String){
        this.biography = bio
    }

    /**
     * ユーザに紐づくフレンド一覧を取得する
     * フレンド一覧の中には、フレンドのUser情報も含まれている
     */
    fun getFriendSet(): Set<FriendEntity> {
        return friends
    }

    /**
     * ユーザに紐づく日記一覧の取得
     */
    fun getDiarySet(): Set<DiaryEntity> {
        return diaries
    }
}