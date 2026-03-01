package com.example.campus_connect

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FindTeacherScreen() {

    var searchQuery by remember { mutableStateOf("") }

    val filteredTeachers = TeacherRepository.teachers.filter {
        it.name.contains(searchQuery, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Find Teacher") }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
        ) {

            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Search Teacher") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (filteredTeachers.isEmpty()) {
                Text("No teacher found")
            } else {
                filteredTeachers.forEach { teacher ->
                    TeacherCard(teacher)
                }
            }
        }
    }
}
@Composable
fun TeacherCard(teacher: Teacher) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = teacher.name, style = MaterialTheme.typography.titleMedium)
            Text(text = "Department: ${teacher.department}")
            Text(text = "Room: ${teacher.room}")
        }
    }
}
