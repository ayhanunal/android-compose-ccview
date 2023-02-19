[![API](https://img.shields.io/badge/API-23%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=23)
[![Android-Studio](https://img.shields.io/badge/Android%20Studio-2021.1.1+-orange.svg?style=flat)](https://developer.android.com/studio/)
![Language](https://img.shields.io/badge/language-Kotlin-orange.svg)

<h1 align="center"> Android Compose Credit Card View </h1>

<p align="center">
CreditCardView is Android library that allows developers to create the UI which replicates an actual Credit Card. <br>
</p>

<p>
- The card number is checked according to the luhn algorithm. <br>
- Auto selection of logo drawable based on the credit card type i.e. Visa and Mastercard <br>
- Customizable
</p>

Screenshots
-----------
<p align="center">
  <img src='https://github.com/ayhanunal/android-compose-ccview/blob/main/art/art1.png' width=300 heihgt=300> 
</p>

Getting started
-----------
In your project's build.gradle

```gradle
repositories {
    maven { url "https://jitpack.io" }
}
```

In your modules's build.gradle

```gradle
implementation 'com.github.ayhanunal:android-compose-ccview:$latest_version'
```

Usage
-----------
<p>
  Create a CreditCardData object and pass it as a parameter to the CreditCardView compose function.
</p>

```kotlin
val visaWithNFC = CreditCardData(
    cardNumber = "4012 8888 8888 1881",
    cardOwner = "Ayhan Unal",
    expiryDate = "06/24",
    isContactless = true
)

CreditCardView(data = visaWithNFC) {
    if (!it) {
        Log.e("Credit Card Screen", "Invalid Card Number")
    }
}
```

License
-------

    Copyright 2023 Ayhan Unal

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
