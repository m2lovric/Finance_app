package com.example.finance_app.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BottomNavigationBar(){
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = {},
            label = { Text("Home") },
            icon = { Icon(
                imageVector = Icons.Outlined.Home,
                contentDescription = "Home"
            ) }
            )

        NavigationBarItem(
            selected = true,
            onClick = {},
            label = { Text("Home") },
            icon = { Icon(
                imageVector = Icons.Outlined.Add,
                contentDescription = "Home"
            ) }
        )

        NavigationBarItem(
            selected = true,
            onClick = {},
            label = { Text("Profile") },
            icon = { Icon(
                imageVector = Icons.Outlined.Person,
                contentDescription = "Profile"
            ) }
        )
    }
}

@Composable
@Preview
fun BottomNavigationBarPreview(modifier: Modifier = Modifier.fillMaxSize()) {
    BottomNavigationBar()
}