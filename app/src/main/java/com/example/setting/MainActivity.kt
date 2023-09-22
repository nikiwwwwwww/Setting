package com.example.setting

import android.annotation.SuppressLint
import android.graphics.Outline
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import com.example.setting.ui.theme.SettingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Window()

        }
    }
}

@Composable
fun Window() {
    Box(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(ScrollState(0))
        .background(colorResource(id = R.color.GlubokiyBlack)))
    {
        HighBlock()
        MiddleBlock()
    }
}

//@Preview(showBackground = true)
@Composable
fun HighBlock() {
//кнопка выйти
    Row(modifier = Modifier
        .background(
            color = colorResource(id = R.color.SvetloBlack),
            shape = RoundedCornerShape(25.dp)
        )
        .fillMaxWidth()
        .fillMaxHeight(0.30F))
        {
// ТУТ ЛИБО КНОПКИ НЕТ ЛИБО ОНА ПРОСТО ПРОПАЛА КУДА ПОТОМУ ЧТО ОНА НЕ ДВИГАЕТСЯ, ВОЗМОЖНО Я НЕ В ТОТ КОНТЕЙНЕР ЗАКИНУЛ
            Button(onClick = {  },
                modifier = Modifier
                    .fillMaxHeight(0.25F)
                    .height(10.dp)
                    .width(10.dp)
                    .padding(10.dp)
                    .background(
                        color = colorResource(id = R.color.ButtonBlack),
                        shape = RoundedCornerShape(16.dp)
                    )
                )
            {
                Text("<")
            }
//текст настройка группы
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),horizontalArrangement = Arrangement.Center)
            {
               Text(text = "Настройка группы", color = colorResource(R.color.white))
            }
    }
}
@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun MiddleBlock() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(1f)
        .padding(0.dp, 80.dp)
        .background(
            color = colorResource(id = R.color.SvetloBlack),
            shape = RoundedCornerShape(25.dp)
        ))
    {
//фото
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)) {
            Column(modifier = Modifier
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
// В ЭТОЙ КОПКЕ ПРОБЛЕМА С КРУГОМ
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        //.padding(15.dp)
                        .width(50.dp)
                        .background(
                            color = colorResource(
                                id = R.color.YrkiyRed
                            ),
                            shape = CircleShape
                        )
                )
                {
                    Text("+",color = colorResource(R.color.white))
                }
                Text(text = "Новое фото",
                    color = colorResource(R.color.white),
                    modifier = Modifier
                        .padding(10.dp)
                )
            }
//название
            Column(modifier = Modifier
                .fillMaxHeight()
                .padding(10.dp))
            {
                Text(text = "Название",
                     color = colorResource(R.color.white),
                     modifier = Modifier.padding(5.dp))

                Box(modifier = Modifier
                    .fillMaxHeight(0.15F)
                    .background(
                        colorResource(id = R.color.SvetloBlack),
                        shape = RoundedCornerShape(15.dp)
                    )
                    .border(
                        1.dp,
                        colorResource(id = R.color.BorderBlack),
                        shape = RoundedCornerShape(15.dp)
                    )
                    .fillMaxWidth())
                {
                    val maxCharacterCount = 10
                    val textState = remember { mutableStateOf(TextFieldValue()) }
                    val textValue by textState

                    TextField(
                        value = textValue,
                        onValueChange = { newText ->
                            // Ограничиваем ввод до 1000 символов
                            if (newText.text.length <= maxCharacterCount) {
                                textState.value = newText
                            }
                        },
                        textStyle = TextStyle(fontSize = 16.sp),
                        placeholder = {
                            Text(
                                text = "Название",
                                color = Color.White
                            )
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .border(
                                width = 1.dp,
                                color = Color.Transparent, // Устанавливаем цвет границы как прозрачный
                            )

                    )
                }

            }
//описание

            Column(modifier = Modifier
                .fillMaxHeight()
                .padding(10.dp))
            {
                Text(text = "Описание",
                    color = colorResource(R.color.white),
                    modifier = Modifier.padding(5.dp))

                Box(modifier = Modifier
                    .fillMaxHeight(0.45F)
                    .background(
                        colorResource(id = R.color.SvetloBlack),
                        shape = RoundedCornerShape(15.dp)
                    )
                    .border(
                        1.dp,
                        colorResource(id = R.color.BorderBlack),
                        shape = RoundedCornerShape(15.dp)
                    )
                    .fillMaxWidth()
                    .height(200.dp))

                {
                    val maxCharacterCount = 10
                    val textState = remember { mutableStateOf(TextFieldValue()) }
                    val textValue by textState

                    TextField(
                        value = textValue,
                        onValueChange = { newText ->
                            // Ограничиваем ввод до 1000 символов
                            if (newText.text.length <= maxCharacterCount) {
                                textState.value = newText
                            }
                        },
                        textStyle = TextStyle(fontSize = 16.sp),
                        placeholder = {
                            Text(
                                text = "Описание группы",
                                color = Color.White
                            )
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .border(
                                width = 1.dp,
                                color = Color.Transparent, // Устанавливаем цвет границы как прозрачный
                            )

                    )

                }


            }
//доп текст
            Text(text = "Дополнительная платформа публикация",
                color = colorResource(R.color.white),
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(5.dp)
                    )

//вконтакте

            Column(modifier = Modifier
                .fillMaxHeight()
                .padding(10.dp))
            {
                Row {
                    Box(modifier = Modifier
                        .height(30.dp)
                        .width(30.dp))
                    {
                        Image(painter = painterResource(id = R.drawable.vk), contentDescription = "")
                    }

                    Text(text = "ВК:",
                        color = colorResource(R.color.white),
                        modifier = Modifier.padding(5.dp))
                }


                Box(modifier = Modifier
                    .fillMaxHeight(0.45F)
                    .background(
                        colorResource(id = R.color.SvetloBlack),
                        shape = RoundedCornerShape(15.dp)
                    )
                    .border(
                        1.dp,
                        colorResource(id = R.color.BorderBlack),
                        shape = RoundedCornerShape(15.dp)
                    )
                    .fillMaxWidth()
                //    .height(200.dp)
                )

                {

                    var expanded by remember { mutableStateOf(false) }
                    var selectedItem by mutableStateOf("Выберите элемент")
                    val items = listOf("Элемент 1", "Элемент 2", "Элемент 3")

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(text = selectedItem, modifier = Modifier.clickable { expanded = true })

                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            items.forEach { item ->
                                DropdownMenuItem(onClick = {
                                    selectedItem = item
                                    expanded = false
                                }) {
                                    Text(text = item)
                                }
                            }
                        }
                    }
                }


            }

//телеграмм
            Column(modifier = Modifier
                .fillMaxHeight()
                .padding(10.dp))
            {
                Row {
                    Box(modifier = Modifier
                        .height(30.dp)
                        .width(30.dp))
                    {
                        Image(painter = painterResource(id = R.drawable.tg), contentDescription = "")
                    }

                    Text(text = "ТГ:",
                        color = colorResource(R.color.white),
                        modifier = Modifier.padding(5.dp))
                }


                Box(modifier = Modifier
                    .fillMaxHeight(0.45F)
                    .background(
                        colorResource(id = R.color.SvetloBlack),
                        shape = RoundedCornerShape(15.dp)
                    )
                    .border(
                        1.dp,
                        colorResource(id = R.color.BorderBlack),
                        shape = RoundedCornerShape(15.dp)
                    )
                    .fillMaxWidth()
                    //    .height(200.dp)
                )

                {

                    var expanded by remember { mutableStateOf(false) }
                    var selectedItem by mutableStateOf("Выберите элемент")
                    val items = listOf("Элемент 1", "Элемент 2", "Элемент 3")

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(text = selectedItem, modifier = Modifier.clickable { expanded = true })

                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            items.forEach { item ->
                                DropdownMenuItem(onClick = {
                                    selectedItem = item
                                    expanded = false
                                }) {
                                    Text(text = item)
                                }
                            }
                        }
                    }
                }
            }

            Column(modifier = Modifier
                .fillMaxHeight()
                .padding(10.dp))
            {
                Text(text = "Короткое имя",
                    color = colorResource(R.color.white),
                    modifier = Modifier.padding(5.dp))

                Box(modifier = Modifier
                    .fillMaxHeight(0.45F)
                    .background(
                        colorResource(id = R.color.SvetloBlack),
                        shape = RoundedCornerShape(15.dp)
                    )
                    .border(
                        1.dp,
                        colorResource(id = R.color.BorderBlack),
                        shape = RoundedCornerShape(15.dp)
                    )
                    .fillMaxWidth()
                    .height(200.dp))

                {
                    val maxCharacterCount = 10
                    val textState = remember { mutableStateOf(TextFieldValue()) }
                    val textValue by textState

                    TextField(
                        value = textValue,
                        onValueChange = { newText ->
                            // Ограничиваем ввод до 1000 символов
                            if (newText.text.length <= maxCharacterCount) {
                                textState.value = newText
                            }
                        },
                        textStyle = TextStyle(fontSize = 16.sp),
                        placeholder = {
                            Text(
                                text = "Короткое имя",
                                color = Color.White
                            )
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .border(
                                width = 1.dp,
                                color = Color.Transparent, // Устанавливаем цвет границы как прозрачный
                            )

                    )

                }


            }

                ///

        }
    }
}
