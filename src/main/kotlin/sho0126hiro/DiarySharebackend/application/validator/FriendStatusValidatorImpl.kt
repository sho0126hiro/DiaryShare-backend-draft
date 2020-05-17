package sho0126hiro.DiaryShareBackend.application.validator

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext


class FriendStatusValidatorImpl: ConstraintValidator<FriendStatusValidator, String>{

    override fun initialize(constraintAnnotation: FriendStatusValidator?) {
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return Constant.FriendStatus.paramList.contains(value)
    }
}