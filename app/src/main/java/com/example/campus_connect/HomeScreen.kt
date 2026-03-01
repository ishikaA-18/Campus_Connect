package com.example.campus_connect

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Campus Connect") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HomeButton(title = "Find Teacher",
                onClick={
                    navController.navigate(Screen.FindTeacher.route)
                }
            )
            HomeButton(title = "Find Room",
                onClick={
                navController.navigate(Screen.FindRoom.route)
            }
            )
            HomeButton(title = "Notices",
                onClick = {
                    navController.navigate(Screen.Notices.route)
                }
            )
            HomeButton(title = "Campus Map",
                onClick={
                    navController.navigate(Screen.CampusMap.route)
                }
            )
        }
    }
}

@Composable
fun HomeButton(
    title: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(text = title)
    }
}


