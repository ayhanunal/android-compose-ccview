package com.ayhanunal.core.base.extensions

import com.ayhanunal.core.base.Constants
import com.ayhanunal.core.base.enum.CreditCardType

private fun isVisa(number: String) = number.isNotEmpty() && number.substring(0, 1).toIntOrNull() == 4
private fun isMastercard(number: String) = number.length >= 2 && number.substring(0, 2).toIntOrNull() in 51 until 56

fun String?.isValidCardNumber(): Boolean {
    val (digits, others) = this.orEmpty()
        .filterNot(Char::isWhitespace)
        .partition(Char::isDigit)
    if (others.isNotEmpty() || digits.length != Constants.CARD_NUMBER_LENGTH) {
        return false
    }
    val checksum = digits
        .map { it.code - '0'.code }
        .reversed()
        .mapIndexed { index, value ->
            if (index % 2 == 1 && value < 9) value * 2 % 9 else value
        }
        .sum()
    return checksum % 10 == 0
}

fun String?.toCreditCardType(): CreditCardType {
    return when {
        !isValidCardNumber() -> CreditCardType.INVALID
        isVisa(this.orEmpty()) -> CreditCardType.VISA
        isMastercard(this.orEmpty()) -> CreditCardType.MASTERCARD
        else -> CreditCardType.OTHER
    }
}

fun String?.isNotEmpty(): Boolean {
    return !this.isNullOrEmpty()
}
