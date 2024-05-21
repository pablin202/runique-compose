package com.pdm.runique.auth.domain

interface PatternValidator {
    fun matches(value: String): Boolean
}