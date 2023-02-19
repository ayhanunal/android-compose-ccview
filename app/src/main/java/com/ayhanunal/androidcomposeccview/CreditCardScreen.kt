package com.ayhanunal.androidcomposeccview

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ayhanunal.ccview.CreditCardView
import com.ayhanunal.ccview.model.CreditCardData

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
            .fillMaxSize()
    ) {
        CreditCardView(data = visaWithNFC) {
            if (!it) {
                Log.e("Credit Card Screen", "Invalid Card Number")
            }
        }
        CreditCardView(data = visaWithoutNFC) {
            if (!it) {
                Log.e("Credit Card Screen", "Invalid Card Number")
            }
        }
        CreditCardView(data = masterCardWithNFC) {
            if (!it) {
                Log.e("Credit Card Screen", "Invalid Card Number")
            }
        }
        CreditCardView(data = invalidCard) {
            if (!it) {
                Log.e("Credit Card Screen", "Invalid Card Number")
            }
        }
    }
}
