package com.example.campus_connect

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object Home : Screen("home")
    object Notices : Screen("notices")
    object FindTeacher : Screen("find_teacher")
    object FindRoom : Screen("find_room")
    object CampusMap : Screen("campus_map")


}