package sho0126hiro.DiaryShareBackend.infrastructure.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "credentials")
data class CredentialEntity (

        /**
         * users.usernameと同じ
         */
        @Id
        @Column(name = "login_id")
        val login_id: String,

        @Column(name = "password")
        val pass: String
)
