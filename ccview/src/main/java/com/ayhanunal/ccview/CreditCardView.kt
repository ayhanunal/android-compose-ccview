package com.ayhanunal.ccview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.ayhanunal.ccview.model.CreditCardData
import com.ayhanunal.core.base.extensions.orElse
import com.ayhanunal.core.base.theme.BaseComposeColor
import com.ayhanunal.core.base.theme.Shapes
import com.ayhanunal.core.base.theme.Spacing

@Composable
fun CreditCardView(
    modifier: Modifier = Modifier,
    data: CreditCardData
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = Shapes.medium,
        contentColor = BaseComposeColor.main_card_bg,
        elevation = Spacing.size_4
    ) {
        CardContentView(data = data)
    }
}

@Composable
private fun CardContentView(
    data: CreditCardData
) {
    Column(
        modifier = Modifier
            .background(BaseComposeColor.main_card_bg)
            .fillMaxWidth()
            .padding(Spacing.size_16)
    ) {
        if (data.isContactless) {
            Icon(
                modifier = Modifier
                    .size(Spacing.size_32)
                    .align(Alignment.End),
                painter = painterResource(id = R.drawable.nfc_icon),
                contentDescription = null,
                tint = BaseComposeColor.black
            )
        }
        data.cardNumber?.let {
            Text(
                style = typography.h6,
                color = BaseComposeColor.black,
                text = it,
                modifier = Modifier.padding(top = if (data.isContactless) Spacing.size_8 else Spacing.size_40)
            )
        }
        Row(
            modifier = Modifier.padding(top = Spacing.size_10)
        ) {
            Column(
                modifier = Modifier.weight(0.5f)
            ) {
                data.cardOwner?.let {
                    Text(
                        style = typography.subtitle2.copy(fontWeight = FontWeight.Light),
                        color = BaseComposeColor.black,
                        text = "Card Holder Name"
                    )
                    Text(
                        style = typography.subtitle1,
                        color = BaseComposeColor.black,
                        text = it
                    )
                }
            }
            Row(
                modifier = Modifier.weight(0.5f)
            ) {
                Column(
                    modifier = Modifier.weight(0.5f)
                ) {
                    data.expiryDate?.let {
                        Text(
                            style = typography.subtitle2.copy(fontWeight = FontWeight.Light),
                            color = BaseComposeColor.black,
                            text = "Exp Date"
                        )
                        Text(
                            style = typography.subtitle1,
                            color = BaseComposeColor.black,
                            text = it
                        )
                    }
                }
                data.cardLogo?.let {
                    Image(
                        modifier = Modifier
                            .padding(start = Spacing.size_4)
                            .size(Spacing.size_48),
                        painter = painterResource(id = it),
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )
                }.orElse {
                    Spacer(modifier = Modifier.size(Spacing.size_48))
                }
            }
        }
    }
}

@Preview
@Composable
private fun CreditCardPreview() {
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
        CreditCardView(data = visaWithNFC)
        Spacer(modifier = Modifier.height(Spacing.size_16))
        CreditCardView(data = visaWithoutNFC)
        Spacer(modifier = Modifier.height(Spacing.size_16))
        CreditCardView(data = masterCardWithNFC)
        Spacer(modifier = Modifier.height(Spacing.size_16))
        CreditCardView(data = invalidCard)
    }
}
