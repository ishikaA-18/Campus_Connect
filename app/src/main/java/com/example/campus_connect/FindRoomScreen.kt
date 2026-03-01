package com.example.campus_connect

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FindRoomScreen() {

    var searchQuery by remember { mutableStateOf("") }

    val filteredRooms = RoomRepository.rooms.filter {
        it.roomNo.contains(searchQuery, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Find Room") })
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
                label = { Text("Search Room") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (filteredRooms.isEmpty()) {
                Text("No room found")
            } else {
                filteredRooms.forEach { room ->
                    RoomCard(room)
                }
            }
        }
    }
}
@Composable
fun RoomCard(room: Room) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Room: ${room.roomNo}", style = MaterialTheme.typography.titleMedium)
            Text(text = "Department: ${room.department}")
            Text(text = "Building: ${room.building}")
        }
    }
}
