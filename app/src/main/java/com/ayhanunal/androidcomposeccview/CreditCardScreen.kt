package com.ayhanunal.androidcomposeccview

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ayhanunal.ccview.CreditCardView
import com.ayhanunal.ccview.model.CreditCardData
import com.ayhanunal.core.base.theme.Spacing

@Composable
fun CreditCardScreen() {
    val visaWithNFC = CreditCardData(
        cardNumber = "4012 8888 8888 1881",
        cardOwner = "Ayhan Unal",
        expiryDate = "06/24",
        isContactless = true
    )
    val visaWithoutNFC = CreditCardData(
        cardNumber = "4012 8888 8888 1881",
        cardOwner = "Ayhan Unal",
        expiryDate = "06/24",
        isContactless = false
    )
    val masterCardWithNFC = CreditCardData(
        cardNumber = "5555 5555 5555 4444",
        cardOwner = "Ayhan Unal",
        expiryDate = "06/24",
        isContactless = true
    )
    val invalidCard = CreditCardData(
        cardNumber = "1111 1111 1111 1111",
        cardOwner = "Ayhan Unal",
        expiryDate = "06/24",
        isContactless = true
    )
    Column(
        modifier = Modifier
            .padding(Spacing.size_16)
            .fillMaxSize()
    ) {
        CreditCardView(data = visaWithNFC) {
            if (!it) {
                Log.e("Credit Card Screen", "Invalid Card Number")
            }
        }
        Spacer(modifier = Modifier.height(Spacing.size_16))
        CreditCardView(data = visaWithoutNFC) {
            if (!it) {
                Log.e("Credit Card Screen", "Invalid Card Number")
            }
        }
        Spacer(modifier = Modifier.height(Spacing.size_16))
        CreditCardView(data = masterCardWithNFC) {
            if (!it) {
                Log.e("Credit Card Screen", "Invalid Card Number")
            }
        }
        Spacer(modifier = Modifier.height(Spacing.size_16))
        CreditCardView(data = invalidCard) {
            if (!it) {
                Log.e("Credit Card Screen", "Invalid Card Number")
            }
        }
    }
}
