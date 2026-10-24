package com.example.myapplication 

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Navy = Color(0xFF0B2D4D)
private val Green = Color(0xFF32D583)
private val ScreenBackground = Color(0xFFF4F7F9)
private val GreyText = Color(0xFF777777)

@Composable
fun AttendanceCounter(modifier: Modifier = Modifier) {

    var count by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ScreenBackground)
    ) {

        // Top bar
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Navy)
                .padding(16.dp)
        ) {
            Text(
                text = "Attendance Counter",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Task 8 - remember & state",
                color = Color.White,
                fontSize = 12.sp
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "STUDENTS PRESENT",
                color = GreyText,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Counter card
            Card(
                modifier = Modifier
                    .width(180.dp)
                    .height(110.dp),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                )
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = count.toString(),
                        color = Navy,
                        fontSize = 52.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            // Minus and Plus buttons
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {

                Button(
                    onClick = {
                        if (count > 0) {
                            count--
                        }
                    },
                    enabled = count > 0,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE5EDF4),
                        contentColor = Navy
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "−",
                        fontSize = 20.sp
                    )
                }

                Button(
                    onClick = {
                        count++
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Green,
                        contentColor = Navy
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "+",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Reset button
            Button(
                onClick = {
                    count = 0
                },
                enabled = count > 0,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = GreyText
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Reset")
            }

            Spacer(modifier = Modifier.height(18.dp))

            // Caption changes depending on count
            Text(
                text = if (count == 0) {
                    "Tap + to check a student in."
                } else {
                    "$count of 30 students checked in."
                },
                color = GreyText,
                fontSize = 13.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AttendanceCounterPreview() {
    AttendanceCounter()
}