package sho0126hiro.DiaryShareBackend.application.validator

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [DiaryStatusValidatorImpl::class])
annotation class DiaryStatusValidator (
    val message: String = "diary status failed",
    val groups: Array<KClass<out Any>> = [],
    val payload: Array<KClass<out Payload>> = []
)