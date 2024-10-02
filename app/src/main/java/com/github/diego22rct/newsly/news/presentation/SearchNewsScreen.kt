package com.github.diego22rct.newsly.news.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SearchNewsScreen() {
    Scaffold { paddingValues ->
        Column (
            modifier = Modifier.fillMaxWidth().padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Search News")
        }
    }
}