package com.ayhanunal.core.base.extensions

fun Any?.isNull(): Boolean = this == null

fun Any?.isNotNull(): Boolean = this != null

inline infix fun <T> T?.orElse(obj: () -> T): T = this ?: obj()
