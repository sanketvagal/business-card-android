package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCardApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier) {
    val image = painterResource(R.drawable.android_logo)
    BusinessCard(
        image = image,
        name = "Sanket Vagal",
        title = "Android Developer",
        contact = "123-456-7890",
        social = "@sanket",
        email = "sanketdvagal@gmail.com",
        modifier = modifier
    )
}

@Composable
fun BusinessCard(
    image: Painter,
    name: String,
    title: String,
    contact: String,
    social: String,
    email: String,
    modifier: Modifier){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(Color(0xffb9f6ca))
            .padding(16.dp)){
        Image(
            painter = image,
            contentDescription = "Android Logo",
            modifier = Modifier
                .padding(8.dp)
                .height(100.dp)
                .background(Color(0xff073042))
        )

        Text(
            text = name,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier

        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(40.dp))
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier

        ) {
            Row {
                Icon(
                    Icons.Rounded.Call,
                    contentDescription = "contact",
                )
                Text(
                    text = contact,
                )
            }
            Row {
                Icon(
                    Icons.Rounded.Share,
                    contentDescription = "social tag"
                )
                Text(
                    text = social,
                )
            }
            Row {
                Icon(
                    Icons.Rounded.Email,
                    contentDescription = "email"
                )
                Text(
                    text = email,
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardTheme {
        BusinessCardApp(modifier = Modifier)
    }
}