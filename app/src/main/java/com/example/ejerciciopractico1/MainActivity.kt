package com.example.ejerciciopractico1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.res.painterResource


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NavegacionApp()
        }
    }
}

@Composable
fun NavegacionApp() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "bienvenida"
    ) {

        composable("bienvenida") {
            PantallaBienvenida(navController)
        }

        composable("ejercicios") {
            PantallaEjercicios(navController)
        }

        composable("tabla") {
            PantallaTabla(navController)
        }

        composable("area") {
            PantallaArea(navController)
        }

        composable("formulario") {
            PantallaFormulario(navController)
        }
    }
}


@Composable
fun PantallaBienvenida(navController: NavHostController) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = "Fondo de programación",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Capa oscura para que el texto se pueda leer
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color.Black.copy(alpha = 0.40f)
                )
        )

        // Contenido
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "App de Ejercicios",
                fontSize = 32.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Practica ejercicios básicos de programación",
                fontSize = 18.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Por Cristian Hernandez",
                fontSize = 14.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    navController.navigate("ejercicios")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
            ) {
                Text(
                    text = "Comenzar",
                    fontSize = 18.sp
                )
            }
        }
    }
}
@Composable
fun PantallaEjercicios(navController: NavHostController) {

    FondoApp {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Lista de ejercicios",
                fontSize = 30.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    navController.navigate("tabla")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
            ) {
                Text("Tabla de multiplicar")
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = {
                    navController.navigate("area")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
            ) {
                Text("Área rectangular")
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = {
                    navController.navigate("formulario")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
            ) {
                Text("Formulario")
            }

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text("Regresar")
            }
        }
    }
}

@Composable
fun PantallaTabla(navController: NavHostController) {

    var numeroTexto by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    FondoApp {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Tabla de multiplicar",
                fontSize = 28.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = numeroTexto,
                onValueChange = {
                    numeroTexto = it
                },
                label = {
                    Text("Ingrese el número")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),

                // Color del número escrito
                textStyle = androidx.compose.ui.text.TextStyle(
                    color = Color.White,
                    fontSize = 18.sp
                ),

                colors = OutlinedTextFieldDefaults.colors(
                    // Borde cuando estás escribiendo
                    focusedBorderColor = Color(0xFFB388FF),

                    // Borde cuando no estás escribiendo
                    unfocusedBorderColor = Color(0xFF7E57C2),

                    // Texto de la etiqueta
                    focusedLabelColor = Color(0xFFB388FF),
                    unfocusedLabelColor = Color.LightGray,

                    // Cursor
                    cursorColor = Color.White,

                    // Fondo del campo
                    focusedContainerColor = Color(0xFF151238),
                    unfocusedContainerColor = Color(0xFF151238)
                )
            )

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = {

                    val numero = numeroTexto.toIntOrNull()

                    if (numero != null) {

                        resultado = ""

                        for (i in 1..10) {
                            resultado += "$numero x $i = ${numero * i}\n"
                        }

                    } else {
                        resultado = "Ingrese un número válido"
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
            ) {
                Text("Calcular")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = resultado,
                color = Color.White,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text("Regresar")
            }
        }
    }
}
@Composable
fun PantallaArea(navController: NavHostController) {

    var altura by remember { mutableStateOf("") }
    var base by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    FondoApp {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Área de un rectángulo",
                fontSize = 28.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = altura,
                onValueChange = {
                    altura = it
                },
                label = {
                    Text("Ingrese la altura")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                ),
                textStyle = androidx.compose.ui.text.TextStyle(
                    color = Color.White,
                    fontSize = 18.sp
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFB388FF),
                    unfocusedBorderColor = Color(0xFF7E57C2),
                    focusedLabelColor = Color(0xFFB388FF),
                    unfocusedLabelColor = Color.LightGray,
                    cursorColor = Color.White,
                    focusedContainerColor = Color(0xFF151238),
                    unfocusedContainerColor = Color(0xFF151238)
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = base,
                onValueChange = {
                    base = it
                },
                label = {
                    Text("Ingrese la base")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                ),
                textStyle = androidx.compose.ui.text.TextStyle(
                    color = Color.White,
                    fontSize = 18.sp
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFB388FF),
                    unfocusedBorderColor = Color(0xFF7E57C2),
                    focusedLabelColor = Color(0xFFB388FF),
                    unfocusedLabelColor = Color.LightGray,
                    cursorColor = Color.White,
                    focusedContainerColor = Color(0xFF151238),
                    unfocusedContainerColor = Color(0xFF151238)
                )
            )

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = {

                    val alturaNumero = altura.toDoubleOrNull()
                    val baseNumero = base.toDoubleOrNull()

                    if (alturaNumero != null && baseNumero != null) {

                        val area = alturaNumero * baseNumero
                        resultado = "El área del rectángulo es: $area"

                    } else {
                        resultado = "Ingrese valores válidos"
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
            ) {
                Text("Calcular")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = resultado,
                color = Color.White,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text("Regresar")
            }
        }
    }
}
@Composable
fun PantallaFormulario(navController: NavHostController) {

    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") }

    FondoApp {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Formulario de registro",
                fontSize = 28.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = {
                    Text("Nombre")
                },
                textStyle = androidx.compose.ui.text.TextStyle(
                    color = Color.White,
                    fontSize = 18.sp
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFB388FF),
                    unfocusedBorderColor = Color(0xFF7E57C2),
                    focusedLabelColor = Color(0xFFB388FF),
                    unfocusedLabelColor = Color.LightGray,
                    cursorColor = Color.White,
                    focusedContainerColor = Color(0xFF151238),
                    unfocusedContainerColor = Color(0xFF151238)
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = apellido,
                onValueChange = { apellido = it },
                label = {
                    Text("Apellido")
                },
                textStyle = androidx.compose.ui.text.TextStyle(
                    color = Color.White,
                    fontSize = 18.sp
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFB388FF),
                    unfocusedBorderColor = Color(0xFF7E57C2),
                    focusedLabelColor = Color(0xFFB388FF),
                    unfocusedLabelColor = Color.LightGray,
                    cursorColor = Color.White,
                    focusedContainerColor = Color(0xFF151238),
                    unfocusedContainerColor = Color(0xFF151238)
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = telefono,
                onValueChange = { telefono = it },
                label = {
                    Text("Teléfono")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                ),
                textStyle = androidx.compose.ui.text.TextStyle(
                    color = Color.White,
                    fontSize = 18.sp
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFB388FF),
                    unfocusedBorderColor = Color(0xFF7E57C2),
                    focusedLabelColor = Color(0xFFB388FF),
                    unfocusedLabelColor = Color.LightGray,
                    cursorColor = Color.White,
                    focusedContainerColor = Color(0xFF151238),
                    unfocusedContainerColor = Color(0xFF151238)
                )
            )
            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = correo,
                onValueChange = { correo = it },
                label = {
                    Text("Correo")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                textStyle = androidx.compose.ui.text.TextStyle(
                    color = Color.White,
                    fontSize = 18.sp
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFB388FF),
                    unfocusedBorderColor = Color(0xFF7E57C2),
                    focusedLabelColor = Color(0xFFB388FF),
                    unfocusedLabelColor = Color.LightGray,
                    cursorColor = Color.White,
                    focusedContainerColor = Color(0xFF151238),
                    unfocusedContainerColor = Color(0xFF151238)
                )
            )

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = {

                    if (
                        nombre.isNotBlank() &&
                        apellido.isNotBlank() &&
                        telefono.isNotBlank() &&
                        correo.isNotBlank()
                    ) {
                        mensaje = "Información guardada correctamente"
                    } else {
                        mensaje = "Complete todos los campos"
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
            ) {
                Text("Guardar")
            }

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = mensaje,
                color = Color.White,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text("Regresar")
            }
        }
    }
}

@Composable
fun FondoApp(
    contenido: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF050816),
                        Color(0xFF151238),
                        Color(0xFF311B60)
                    )
                )
            )
    ) {
        contenido()
    }
}