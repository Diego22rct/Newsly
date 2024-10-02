package com.github.diego22rct.newsly.common

object Screens {
    val homeScreen = Screen("home_screen")
    val favoriteNews = Screen("favorite_news")
    val findNews = Screen("find_news")

    data class Screen(val route: String)
}