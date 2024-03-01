package com.bignerdranch.android.jetpackcrashcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bignerdranch.android.jetpackcrashcourse.ui.theme.JetpackCrashCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCrashCourseTheme {
                var name by remember{
                    mutableStateOf("")
                }
                var names by remember {
                    mutableStateOf(listOf<String>())
                }
                Column(
                    modifier= Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ){
                    Row(
                         modifier = Modifier.fillMaxWidth()
                    ) {
                        OutlinedTextField(value =name, onValueChange = {
                            text -> name=text
                        }, modifier = Modifier.weight(1f))
                        Spacer(modifier=Modifier.width(16.dp))
                        Button(onClick = {
                            if(name.isNotBlank()){
                                names=names+name
                                name=""
                            }
                             }) {
                           Text("Add")
                            
                        }
                    }
                    NameList(names = names)
                    
                }

            }
        }
    }
}


@Composable
fun NameList(names : List<String>, modifier: Modifier = Modifier) {
    LazyColumn{
        items(names){ currentName ->
            Column{
                Text(
                    text = currentName,
                    modifier= Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                Divider()
            }


        }
    }
}
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Column{
//        Text("hhii")
//        LazyColumn(modifier = modifier.fillMaxSize()) {
//            items(20) { i ->
//                Icon(
//                    imageVector = Icons.Default.Add,
//                    contentDescription = null,
//                    modifier=modifier.size(100.dp)
//                )
//                Spacer(modifier = modifier.padding(16.dp))
//            }
//        }
//    }
//
//
//
//
//
//
////    Column{
////        for( i in 1..10){
////            Icon(imageVector = Icons.Default.Add,
////                contentDescription = null
////            )
////        }
////    }
//
//
//
////    if(name.length==5)
////    {
////        Icon(imageVector = Icons.Default.Add,
////        contentDescription = null
////    )
////    }
//
//
////    Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
////        contentDescription = null,
////        modifier=modifier.background(Color.Blue))
////    Box(
////        modifier=modifier
////            .background(Color.Red)
////            .size(400.dp),
////        contentAlignment=Alignment.BottomEnd
////
////    ){
////        Text(
////            text = "Hello $name!",
////            modifier = modifier.align(alignment = Alignment.Center)
////
////        )
////        Spacer(modifier = modifier.padding(16.dp))
////        Text(
////            text = "Hello $name!",
////            modifier = modifier
////        )
////    }
//
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    JetpackCrashCourseTheme {
//        Greeting("Android")
//    }
//}

//JetpackCrashCourseTheme {
//    val count = remember {mutableStateOf(0)}
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ){
//        Text(text=count.value.toString()
//            ,fontSize=30.sp)
//        Button(onClick ={
//            count.value++
//        }) {
//            Text("Click me")
//        }
//    }
//   var count by remember {mutableStateOf(0)}
//               Column(
//                   modifier = Modifier.fillMaxSize(),
//                   verticalArrangement = Arrangement.Center,
//                   horizontalAlignment = Alignment.CenterHorizontally
//               ){
//                   Text(text=count.toString()
//                       ,fontSize=30.sp)
//                   Button(onClick ={
//                        count++
//                   }) {
//                        Text("Click me $count")
//                   }
//               }
//
//
//}