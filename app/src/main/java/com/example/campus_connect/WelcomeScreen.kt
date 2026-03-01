package com.example.campus_connect

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(
    onContinueClick: (String) -> Unit
) {
    val colleges = listOf(
        "Select your college",
        "Jadavpur University",
        "IIT Kharagpur",
        "Academy of Technology(Test)"
    )

    var expanded by remember { mutableStateOf(false) }
    var selectedCollege by remember { mutableStateOf(colleges[0]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Welcome to Campus Connect",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {

            TextField(
                value = selectedCollege,
                onValueChange = {},
                readOnly = true,
                label = { Text("Select College") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded)
                },
                modifier = Modifier.menuAnchor().fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                colleges.forEach { college ->
                    DropdownMenuItem(
                        text = { Text(college) },
                        onClick = {
                            selectedCollege = college
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { onContinueClick(selectedCollege) },
            enabled = selectedCollege != colleges[0],
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Continue")
        }
    }
}
