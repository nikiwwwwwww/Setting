package com.example.setting

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.*
import androidx.compose.ui.text.input.VisualTransformation


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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(ScrollState(0))
            .background(colorResource(id = R.color.GlubokiyBlack))
    )
    {
        HighBlock()
        MiddleBlock()
        LowButton()
    }
}

@Preview(showBackground = true)
@Composable
fun HighBlock() {

//кнопка выйти
    Row(
        modifier = Modifier
            .background(
                color = colorResource(id = R.color.SvetloBlack),
                shape = RoundedCornerShape(25.dp)
            )
            .fillMaxWidth()
            .fillMaxHeight(0.25F)
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // кнопка назад
        Box(
            modifier = Modifier
                .padding(20.dp)
                .height(30.dp)
                .width(30.dp)
        ) {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .background(
                        colorResource(id = R.color.ButtonBlack),
                        shape = RoundedCornerShape(10.dp)
                    )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_chevron_left_24),
                    contentDescription = "Стрелка вправо",
                    tint = Color.White,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        // Текст по центру
        Box(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxHeight()
                .weight(1f)
        ) {
            Text(
                text = "Настройка группы",
                modifier = Modifier.fillMaxSize(),
                fontSize = 16.sp,
                color = colorResource(R.color.white),
                textAlign = TextAlign.Center
            )
        }

        // Другой Box
        Box(
            modifier = Modifier
                .padding(10.dp)
                .width(50.dp)
                .height(50.dp)
        ) {
            // Ваш контент для этого Box
        }
    }
}


@SuppressLint("UnrememberedMutableState")
//@Preview(showBackground = true)
@Composable
fun MiddleBlock() {
    var isDialogVisible by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(1f)
            .padding(0.dp, 10.dp)
            .background(
                color = colorResource(id = R.color.SvetloBlack),
                shape = RoundedCornerShape(25.dp)
            )
    )
    {
//фото
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
// кнопка +
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(60.dp)
                    //.padding(4.dp)
                    ,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.YrkiyRed),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(50.dp)
                ) {
                    Text(
                        text = "+",
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Transparent),
                        fontSize = 30.sp,
                        color = colorResource(R.color.white),
                        textAlign = TextAlign.Center
                    )
                }



                Text(
                    text = "Новое фото",
                    color = colorResource(R.color.white),
                    modifier = Modifier
                        .padding(10.dp)
                )
            }
//название
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(10.dp)
            )
            {
                var maxCharacterCount = 10
                var isErrorInOpisanie by remember { mutableStateOf(false) }
                var textValue by remember { mutableStateOf("") }

                Text(
                    text = "Название",
                    color = colorResource(R.color.white),
                    modifier = Modifier.padding(5.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.15F)
                        .background(
                            colorResource(id = R.color.SvetloBlack),
                            shape = RoundedCornerShape(15.dp)
                        )
                        .border(
                            1.dp,
                            colorResource(id = R.color.BorderBlack),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .fillMaxWidth()
                )
                {

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(1.dp)
                    )
                    {


                        OutlinedTextField(

                            value = textValue,
                            onValueChange = {
                                textValue = it
                                // Ограничиваем ввод до 1000 символов
                                isErrorInOpisanie = textValue.length > maxCharacterCount

                            },
                            textStyle = TextStyle(fontSize = 16.sp),
                            placeholder = {
                                Text(
                                    text = "Название",
                                    color = Color.White
                                )
                            },
                            maxLines = 2,
                            visualTransformation = if (textValue.length >= 2) {
                                // Ограничение по максимальному количеству строк (в данном случае 5)
                                VisualTransformation.None
                            } else {
                                VisualTransformation.None
                            },
                            isError = isErrorInOpisanie,

//                        supportingText = {
//                            if (isErrorInOpisanie) {
//                                Text(
//                                    modifier = Modifier.fillMaxWidth(),
//                                    text = "Limit:",
//                                    color = Color.Red
//                                )
//                            }
//                        },

                            modifier = Modifier
                                .fillMaxSize()

                                .border(
                                    width = 1.dp,
                                    color = Color.Transparent,
                                    shape = RoundedCornerShape(0.dp),
                                )
                                .background(
                                    color = Color.Transparent,
                                    shape = RoundedCornerShape(0.dp),
                                )


                        )

                        if (isErrorInOpisanie) {


                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    // .padding(PaddingValues(start = 15.dp, end = 15.dp))

                                    .background(

                                        color = Color(
                                            red = 255,
                                            green = 0,
                                            blue = 0,
                                            alpha = 128
                                        ),

                                        shape = RoundedCornerShape(5.dp)

                                    )
                                    .border(
                                        width = 1.dp,
                                        color = Color.Red,
                                        shape = RoundedCornerShape(5.dp),
                                    ),

                                ) {
                                Row() {

                                    Icon(
                                        painter = painterResource(R.drawable.baseline_error_outline_24),
                                        contentDescription = "errorIcon",
                                        tint = Color.Red,

                                        modifier = Modifier
                                            //.fillMaxSize()
                                            .padding(10.dp)
                                            .align(Alignment.CenterVertically)
                                    )

                                    Text(
                                        text = "Превышено максимальное число символов",
                                        color = Color.White,

                                        modifier = Modifier
                                            .background(
                                                color = Color.Transparent,
                                                shape = RoundedCornerShape(5.dp)

                                            )
                                            .fillMaxSize()
                                            .padding(10.dp)

                                    )
                                }

                            }
                        }
                    }
                }
            }
//описание

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(10.dp)
            )
            {
                Text(
                    text = "Описание",
                    color = colorResource(R.color.white),
                    modifier = Modifier.padding(5.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.45F)
                        .background(
                            colorResource(id = R.color.SvetloBlack),
                            shape = RoundedCornerShape(15.dp)
                        )
                        .border(
                            1.dp,
                            colorResource(id = R.color.BorderBlack),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .fillMaxWidth()
                    //.height(200.dp)
                )

                {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(1.dp)
                    ) {


                        var maxCharacterCount = 10
                        var isErrorInOpisanie by remember { mutableStateOf(false) }
                        var textValue by remember { mutableStateOf("") }

                        OutlinedTextField(
                            value = textValue,
                            onValueChange = {
                                textValue = it
                                // Ограничиваем ввод до 1000 символов
                                isErrorInOpisanie = textValue.length > maxCharacterCount

                            },
                            textStyle = TextStyle(fontSize = 16.sp),
                            placeholder = {
                                Text(
                                    text = "Описание группы",
                                    color = Color.White
                                )
                            },
                            maxLines = 10,

                            isError = isErrorInOpisanie,
                            modifier = Modifier
                                .fillMaxSize()
                                .height(200.dp)
                                .border(
                                    width = 1.dp,
                                    color = Color.Transparent,
                                    shape = RoundedCornerShape(0.dp),
                                )
                                .background(
                                    color = Color.Transparent,
                                    shape = RoundedCornerShape(0.dp),
                                )
                        )
                        if (isErrorInOpisanie) {


                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    // .padding(PaddingValues(start = 15.dp, end = 15.dp))

                                    .background(

                                        color = Color(
                                            red = 255,
                                            green = 0,
                                            blue = 0,
                                            alpha = 128
                                        ),

                                        shape = RoundedCornerShape(5.dp)

                                    )
                                    .border(
                                        width = 1.dp,
                                        color = Color.Red,
                                        shape = RoundedCornerShape(5.dp),
                                    ),

                                ) {
                                Row() {

                                    Icon(
                                        painter = painterResource(R.drawable.baseline_error_outline_24),
                                        contentDescription = "errorIcon",
                                        tint = Color.Red,

                                        modifier = Modifier
                                            //.fillMaxSize()
                                            .padding(10.dp)
                                            .align(Alignment.CenterVertically)
                                    )

                                    Text(
                                        text = "Превышено максимальное число символов",
                                        color = Color.White,

                                        modifier = Modifier
                                            .background(
                                                color = Color.Transparent,
                                                shape = RoundedCornerShape(5.dp)

                                            )
                                            .fillMaxSize()
                                            .padding(10.dp)

                                    )
                                }

                            }


                        }
                    }
                }
            }
//доп текст
            Text(
                text = "Дополнительная платформа публикация",
                color = colorResource(R.color.white),
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(5.dp)
            )

//вконтакте
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(10.dp)
            )
            {
                Row {
                    Box(
                        modifier = Modifier
                            .height(30.dp)
                            .width(30.dp)
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.vk),
                            contentDescription = ""
                        )
                    }

                    Text(
                        text = "ВК:",
                        color = colorResource(R.color.white),
                        modifier = Modifier.padding(5.dp)
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.45F)
                        .background(
                            colorResource(id = R.color.SvetloBlack),
                            shape = RoundedCornerShape(15.dp)
                        )
                        .border(
                            1.dp,
                            colorResource(id = R.color.BorderBlack),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .fillMaxWidth()
                    //    .height(200.dp)
                )

                {
                    var expanded by remember { mutableStateOf(false) }
                    var selectedItem by mutableStateOf("Выберите группу")
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
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(10.dp)
            )
            {
                Row {
                    Box(
                        modifier = Modifier
                            .height(30.dp)
                            .width(30.dp)
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.tg),
                            contentDescription = ""
                        )
                    }

                    Text(
                        text = "ТГ:",
                        color = colorResource(R.color.white),
                        modifier = Modifier.padding(5.dp)
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.45F)
                        .background(
                            colorResource(id = R.color.SvetloBlack),
                            shape = RoundedCornerShape(15.dp)
                        )
                        .border(
                            1.dp,
                            colorResource(id = R.color.BorderBlack),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .fillMaxWidth()
                    //    .height(200.dp)
                )

                {

                    var expanded by remember { mutableStateOf(false) }
                    var selectedItem by mutableStateOf("Выберите группу")
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

//короткое имя
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(10.dp)
            )
            {
                Text(
                    text = "Короткое имя",
                    color = colorResource(R.color.white),
                    modifier = Modifier.padding(5.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.45F)
                        .background(
                            colorResource(id = R.color.SvetloBlack),
                            shape = RoundedCornerShape(15.dp)
                        )
                        .border(
                            1.dp,
                            colorResource(id = R.color.BorderBlack),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .fillMaxWidth()
                    // .height(200.dp)
                )

                {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(1.dp)
                    ) {
                        var maxCharacterCount = 1
                        var isErrorInOpisanie by remember { mutableStateOf(false) }
                        var textValue by remember { mutableStateOf("") }

                        OutlinedTextField(
                            value = textValue,
                            onValueChange = {
                                textValue = it
                                // Ограничиваем ввод до 1000 символов
                                isErrorInOpisanie = textValue.length > maxCharacterCount

                            },
                            textStyle = TextStyle(fontSize = 16.sp),
                            placeholder = {
                                Text(
                                    text = "@mdk",
                                    color = Color.White
                                )
                            },
                            maxLines = 2,
                            visualTransformation = if (textValue.length >= 2) {
                                // Ограничение по максимальному количеству строк (в данном случае 5)
                                VisualTransformation.None
                            } else {
                                VisualTransformation.None
                            },
                            isError = isErrorInOpisanie,
                            modifier = Modifier
                                .fillMaxSize()
                                .border(
                                    width = 1.dp,
                                    color = Color.Transparent, // Устанавливаем цвет границы как прозрачный
                                )
                                .background(
                                    color = Color.Transparent,
                                    shape = RoundedCornerShape(15.dp),
                                )
                        )
                        if (isErrorInOpisanie) {


                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    // .padding(PaddingValues(start = 15.dp, end = 15.dp))

                                    .background(

                                        color = Color(
                                            red = 255,
                                            green = 0,
                                            blue = 0,
                                            alpha = 128
                                        ),

                                        shape = RoundedCornerShape(5.dp)

                                    )
                                    .border(
                                        width = 1.dp,
                                        color = Color.Red,
                                        shape = RoundedCornerShape(5.dp),
                                    ),

                                ) {
                                Row() {

                                    Icon(
                                        painter = painterResource(R.drawable.baseline_error_outline_24),
                                        contentDescription = "errorIcon",
                                        tint = Color.Red,

                                        modifier = Modifier
                                            //.fillMaxSize()
                                            .padding(10.dp)
                                            .align(Alignment.CenterVertically)
                                    )

                                    Text(
                                        text = "Превышено максимальное число символов",
                                        color = Color.White,

                                        modifier = Modifier
                                            .background(
                                                color = Color.Transparent,
                                                shape = RoundedCornerShape(5.dp)

                                            )
                                            .fillMaxSize()
                                            .padding(10.dp)

                                    )
                                }

                            }


                        }

                    }

                }
            }

//сайт
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(10.dp)
            )
            {
                Text(
                    text = "Сайт",
                    color = colorResource(R.color.white),
                    modifier = Modifier.padding(5.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.45F)
                        .background(
                            colorResource(id = R.color.SvetloBlack),
                            shape = RoundedCornerShape(15.dp)
                        )
                        .border(
                            1.dp,
                            colorResource(id = R.color.BorderBlack),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .fillMaxWidth()
                    // .height(200.dp)
                )
                {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(1.dp)
                    ) {
                        var maxCharacterCount = 10
                        var isErrorInOpisanie by remember { mutableStateOf(false) }
                        var textValue by remember { mutableStateOf("") }

                        OutlinedTextField(
                            value = textValue,
                            onValueChange = {
                                textValue = it
                                // Ограничиваем ввод до 1000 символов
                                isErrorInOpisanie = textValue.length > maxCharacterCount

                            },
                            textStyle = TextStyle(fontSize = 16.sp),
                            placeholder = {
                                Text(
                                    text = "mdk.ru",
                                    color = Color.White
                                )
                            },
                            maxLines = 2,
                            visualTransformation = if (textValue.length >= 2) {
                                // Ограничение по максимальному количеству строк (в данном случае 5)
                                VisualTransformation.None
                            } else {
                                VisualTransformation.None
                            },
                            isError = isErrorInOpisanie,
                            modifier = Modifier
                                .fillMaxSize()
                                .border(
                                    width = 1.dp,
                                    color = Color.Transparent, // Устанавливаем цвет границы как прозрачный
                                )
                                .background(
                                    color = Color.Transparent,
                                    shape = RoundedCornerShape(5.dp),
                                )
                        )

                    }

                }
            }

//Контакты
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(10.dp)
            )
            {
                Row {
                    Text(
                        text = "Контакты",
                        color = colorResource(R.color.white),
                        modifier = Modifier.padding(5.dp)
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.45F)
                        .background(
                            colorResource(id = R.color.SvetloBlack),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .border(
                            1.dp,
                            colorResource(id = R.color.BorderBlack),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .fillMaxWidth()
                    //    .height(200.dp)
                )

                {

                    var expanded by remember { mutableStateOf(false) }
                    var selectedItem by mutableStateOf("Выберите контакт")
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

//кнопка добавить контакт
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                //.padding(5.dp)
                ,
                horizontalArrangement = Arrangement.Center
            ) {

                Button(//colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxHeight()
                    // .size(60.dp)
                    //.padding(4.dp)
                    ,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Transparent,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(5.dp),
                    border = BorderStroke(1.dp, Color.White)

                ) {
                    Text(text = "+ Добавить контакт")
                }


            }
//градиентная штука
            Column(
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth(),

                ) {
                Text(
                    text = "Обложка",
                    color = colorResource(R.color.white),
                    modifier = Modifier.padding(PaddingValues(top = 10.dp, start = 15.dp))
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 5.dp, start = 10.dp, end = 10.dp)
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(
                            shape = RoundedCornerShape(25.dp),
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    //wцвета для смены градиента
                                    colorResource(id = R.color.GradientBlack),
                                    colorResource(id = R.color.white)
                                ),
                                startX = 0f,
                                endX = 1000f
                            )
                        ),
                    contentAlignment = Alignment.TopEnd
                ) {

                    Button(
                        onClick = { isDialogVisible = true },
                        modifier = Modifier
                            .height(40.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.GreyButton),
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(
                            //topStart = CornerSize.Zero,
                            topEnd = 25.dp,
                            bottomStart = 25.dp,
                            //  bottomEnd = CornerSize.Zero
                        ),
                        // border = BorderStroke(1.dp, Color.White)
                    ) {
                        Text(text = "✏ Изменить обложку")
                    }

                    // Модальное окно
                    if (isDialogVisible) {
                        AlertDialog(
                            onDismissRequest = {
                                // Закрыть модальное окно
                                isDialogVisible = false
                            },
                            title = {
                                Text("Изменение цвета обложки")
                            },
                            text = {
                                Column(

                                ) {

                                }
                            },

                            confirmButton = {
                                TextButton(
                                    onClick = {
                                        // Закрыть модальное окно при подтверждении
                                        isDialogVisible = false
                                    }
                                ) {
                                    Text("Подтвердить")
                                }
                            },
                            dismissButton = {
                                TextButton(
                                    onClick = {
                                        // Закрыть модальное окно при отказе
                                        isDialogVisible = false
                                    }
                                ) {
                                    Text("Отмена")
                                }
                            },

                            backgroundColor = colorResource(id = R.color.SvetloBlack)
                        )
                    }

                }
            }
        }


    }
}

@Composable
fun LowButton() {
    //кнопка сохранить
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 15.dp, start = 30.dp, end = 30.dp, bottom = 20.dp)
            .fillMaxWidth()
            .height(50.dp)

            .background(
                shape = RoundedCornerShape(25.dp),
                color = Color.Transparent
            ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.YrkiyRed),
            contentColor = Color.White
        ),
    )
    {
        Text(
            text = " Сохранить",
            modifier = Modifier
                //.fillMaxSize()
                .background(
                    color = Color.Transparent
                ),
            fontSize = 16.sp,
            color = colorResource(R.color.white),
            textAlign = TextAlign.Center,

            )
    }
}





