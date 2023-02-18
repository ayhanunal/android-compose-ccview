package com.ayhanunal.ccview.model

import com.ayhanunal.ccview.R
import com.ayhanunal.core.base.enum.CreditCardType
import com.ayhanunal.core.base.extensions.toCreditCardType

data class CreditCardData(
    val cardNumber: String? = null,
    val cardOwner: String? = null,
    val expiryDate: String? = null,
    val isContactless: Boolean = true
) {
    val cardType: CreditCardType = cardNumber.toCreditCardType()
    val isInvalidCard = cardType == CreditCardType.INVALID
    val cardLogo = when (cardType) {
        CreditCardType.MASTERCARD -> R.drawable.mastercard
        CreditCardType.VISA -> R.drawable.visa
        else -> null
    }
}
