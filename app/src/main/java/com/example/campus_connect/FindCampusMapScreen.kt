package com.example.campus_connect
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
@OptIn(ExperimentalMaterial3Api::class)


@Composable
fun FindCampusMapScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Find Teacher") }
            )
        }
    ) { paddingValues ->
        Text(
            text = "Coming Soon",
            modifier = Modifier.padding(paddingValues).padding(16.dp)
        )
    }
}
