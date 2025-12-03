package com.fullmanager.app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform