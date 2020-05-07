package sho0126hiro.DiaryShareBackend.infrastructure.entity

import org.hibernate.annotations.Columns
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "credentials")
class CredentialEntity (
        @Id
        @Column(name = "login_id")
        val login_id: String,
        @Column(name = "password")
        val pass: String
)
