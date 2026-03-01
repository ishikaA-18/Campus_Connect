package com.example.campus_connect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CampusApp()
        }
    }
}

@Composable
fun CampusApp() {
    val navController = rememberNavController()
    val context = androidx.compose.ui.platform.LocalContext.current

    var startDestination by remember { mutableStateOf<String?>(null) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        val savedCollege = CollegePreference.getCollege(context)
        startDestination = if (savedCollege == null) {
            Screen.Welcome.route
        } else {
            Screen.Home.route
        }
    }

    if (startDestination != null) {
        NavHost(
            navController = navController,
            startDestination = startDestination!!
        ) {

            composable(Screen.Welcome.route) {
                WelcomeScreen { selectedCollege ->
                    coroutineScope.launch {
                        CollegePreference.saveCollege(context, selectedCollege)
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Welcome.route) { inclusive = true }
                        }
                    }
                }
            }

            composable(Screen.Home.route) {
                HomeScreen(navController)
            }

            composable(Screen.Notices.route) {
                NoticesScreen()
            }

            composable(Screen.FindTeacher.route) {
                FindTeacherScreen()
            }

            composable(Screen.FindRoom.route) {
                FindRoomScreen()
            }

            composable(Screen.CampusMap.route) {
                CampusMapScreen()
            }
        }
    }
}




