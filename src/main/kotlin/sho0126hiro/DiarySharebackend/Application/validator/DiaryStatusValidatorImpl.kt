package sho0126hiro.DiaryShareBackend.application.validator

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class DiaryStatusValidatorImpl : ConstraintValidator<DiaryStatusValidator, String> {
    override fun initialize(constraintAnnotation: DiaryStatusValidator) {
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return Constant.DiaryStatus.paramList.contains(value)
    }
}