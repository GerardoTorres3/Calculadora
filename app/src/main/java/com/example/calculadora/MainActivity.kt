package com.example.calculadora

import android.os.Bundle
import android.text.TextUtils
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import com.example.calculadora.ui.theme.CalculadoraTheme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtimeticScreen()
                }
            }
        }
    }
}

fun checkWroteNumber(text: String): Int {
    if (text.toIntOrNull() != null) {
        return text.toInt()
    } else if (TextUtils.isEmpty(text)) {
        return 0
    }
    return 1
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtimeticScreen() {
    var numberOne: Int by remember { mutableStateOf(0) }
    var numberTwo: Int by remember { mutableStateOf(0) }
    var result: String by remember { mutableStateOf("") }

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = numberOne.toString(),
            onValueChange = {
                numberOne = checkWroteNumber(it)
            },
            label = {
                Text(text = "Write a number")
            },
            placeholder = {
                Text(text = "Write another")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Star, contentDescription = "Icon")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            value = numberTwo.toString(),
            onValueChange = {
                numberTwo = checkWroteNumber(it)
            },
            label = {
                Text(text = "Write a number")
            },
            placeholder = {
                Text(text = "Write another")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Star, contentDescription = "Icon")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick={
            result = (numberOne + numberTwo).toString()
        }, colors = ButtonDefaults.buttonColors(Color(0xFF3F51B5)), modifier = Modifier.width(200.dp)){
            Text(text= "Sumar" )
        }


        Button(onClick={
            result = (numberOne - numberTwo).toString()
        }, colors = ButtonDefaults.buttonColors(Color(0xFFF44336)), modifier = Modifier.width(200.dp)){
            Text(text= "Restar")
        }

        Button(onClick={
            result = (numberOne * numberTwo).toString()
        },colors = ButtonDefaults.buttonColors(Color(0xFFE91E63)), modifier = Modifier.width(200.dp)){
            Text(text= "Multiplicar" )
        }

        Button(onClick={
            result = (numberOne / numberTwo).toString()
        },colors = ButtonDefaults.buttonColors(Color(0xFF9C27B0)), modifier = Modifier.width(200.dp)){
            Text(text= "Dividir" )
        }
        Text(text= result )
    }
}

@Preview(showBackground = true)
@Composable
fun ArtimeticPreview() {
    CalculadoraTheme {
        ArtimeticScreen()
    }
}