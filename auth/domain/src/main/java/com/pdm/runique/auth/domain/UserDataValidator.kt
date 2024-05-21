package com.pdm.runique.auth.domain

class UserDataValidator(
    private val patternValidator: PatternValidator
) {

    fun isValidEmail(email: String) =
        patternValidator.matches(email.trim())


    fun validatePassword(password: String): PasswordValidationState {
        return PasswordValidationState(
            hasMinLength = password.length >= MIN_PASSWORD_LENGTH,
            hasNumber = password.any { it.isDigit() },
            hasLowerCaseCharacter = password.any { it.isLowerCase() },
            hasUpperCaseCharacter = password.any { it.isUpperCase() }
        )
    }


    companion object {
        const val MIN_PASSWORD_LENGTH = 9
    }
}