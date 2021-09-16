package com.example.uidesigns.screens

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uidesigns.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun SplashScreen(onNavigation: () -> Unit) {
    androidx.compose.material.Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Kitaab", color = Color.Red, fontWeight = FontWeight.Bold, fontSize = 30.sp)
            Handler(Looper.myLooper()!!).postDelayed({
                onNavigation()
            }, 3000L)

        }
    }

}

@Composable
fun HomeScreen(onNavigation: () -> Unit) {
    androidx.compose.material.Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {

        val state = rememberScaffoldState()
        val corutineScope = rememberCoroutineScope()
        Scaffold(scaffoldState = state,modifier = Modifier.fillMaxWidth(),
            topBar = {
                     TopAppBar(
                         title = { Text(text = "Kitab",color = Color.White) },
                         navigationIcon = {
                             IconButton(onClick = {
                                 corutineScope.launch {
                                     state.drawerState.open()
                                 }
                             }) {
                                Icon( Icons.Default.Menu, contentDescription ="hamberger",tint = Color.White)
                             }
                         },
                         backgroundColor = Color.Blue
                     )
            },
            drawerShape= RoundedCornerShape(topEnd = 25.dp, bottomEnd = 25.dp),
            drawerContent = { DrawerItem(state,corutineScope)},

            content = {},
            backgroundColor = Color.White
        )

    }
}

@Composable
fun DrawerItem(state: ScaffoldState, corutineScope: CoroutineScope) {
    Column(modifier = Modifier.padding(18.dp)){
       Card(modifier = Modifier
           .fillMaxWidth()
           .height(170.dp)) {
           Column(modifier = Modifier.padding(18.dp),horizontalAlignment = Alignment.CenterHorizontally) {
             
              Image(painter = painterResource(id = R.drawable.business), contentDescription ="profile",alignment = Alignment.Center,modifier = Modifier
                  .width(100.dp)
                  .height(100.dp))
              Text(text = "Jayant Kumar", color = Color.Red,fontSize = 20.sp,fontWeight = FontWeight.Bold,textAlign = TextAlign.Center)
           }
       }
    }
    Divider(color = Color.LightGray,thickness = 1.dp)
    
    Spacer(modifier = Modifier.height(20.dp))
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Text(text = "All Categories", color = Color.Black,
            fontFamily = FontFamily.SansSerif,fontWeight = FontWeight.Light,fontSize = 18.sp
       )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "My Orders", color = Color.Black,
            fontFamily = FontFamily.SansSerif,fontWeight = FontWeight.Light,fontSize = 18.sp

        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Sell on kitab", color = Color.Black,
            fontFamily = FontFamily.SansSerif,fontWeight = FontWeight.Light,fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "My Cart", color = Color.Black,
            fontFamily = FontFamily.SansSerif,fontWeight = FontWeight.Light,fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Payments", color = Color.Black,
            fontFamily = FontFamily.SansSerif,fontWeight = FontWeight.Light,fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Account Setting", color = Color.Black,
            fontFamily = FontFamily.SansSerif,fontWeight = FontWeight.Light,fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Notification", color = Color.Black,
            fontFamily = FontFamily.SansSerif,fontWeight = FontWeight.Light,fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Divider(color = Color.LightGray,thickness = 1.dp)
        Spacer(modifier = Modifier.height(8.dp))


        Text(text = "Help Center", color = Color.Black,
            fontFamily = FontFamily.SansSerif,fontWeight = FontWeight.Light,fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Privacy Policy", color = Color.Black,
            fontFamily = FontFamily.SansSerif,fontWeight = FontWeight.Light,fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Terms And Condition", color = Color.Black,
            fontFamily = FontFamily.SansSerif,fontWeight = FontWeight.Light,fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Divider(color = Color.LightGray,thickness = 1.dp)
        Spacer(modifier = Modifier.height(8.dp))
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Logout", color = Color.Black,
            fontFamily = FontFamily.SansSerif,fontWeight = FontWeight.Bold,fontSize = 18.sp
        )
    }
    
}

