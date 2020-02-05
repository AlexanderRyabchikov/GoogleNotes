package com.client.googlenotes.util

import java.util.regex.Pattern

/**
 * Created by Konstantin Aleksashin on 17/11/2018.
 */

const val EMAIL_REG_EXP = "^\\w+([-.]\\w+)*@[a-z\\d]+([-.][a-z\\d]+)*\\.[a-z\\d]+(-[a-z\\d]+)*\$"
const val PASSWORD_MIN_LENGTH = 6
const val PHONE_REG_EXPR = "^(\\+7|7|8)\\d{10}$"

fun isValidEmail(email: String): Boolean {
    return Pattern.compile(EMAIL_REG_EXP).matcher(email).matches()
}

fun isValidPassword(password: String): Boolean {
    return password.length >= PASSWORD_MIN_LENGTH
}

fun isValidPhone(phone: String): Boolean {
    val pattern = Pattern.compile(PHONE_REG_EXPR)
    return pattern.matcher(phone).matches()
}