package sho0126hiro.DiaryShareBackend.infrastructure.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import sho0126hiro.DiaryShareBackend.domain.`object`.Diary
import javax.persistence.*


@Entity
@Table(name = "diaries")
data class DiaryEntity (
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Int? = null,

    @Column(name = "user_id")
    private val userId: Int,

    @Column(name = "status")
    private var status: String,

    @Column(name = "title")
    private var title: String,

    @Column(name = "content")
    private var content: String,

    @Column(name = "created_at")
    @CreatedDate
    private val createdAt: String? = null,

    @Column(name = "updated_at")
    @LastModifiedDate
    private val updatedAt: String? = null
){
    fun toDomainObject(): Diary {
        return Diary(
                id.toString(), userId.toString(), status, title, content, createdAt
        )
    }
    fun setStatus(status: String){
        this.status = status
    }
}
