package net.ezra.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Icon
import android.provider.MediaStore
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import net.ezra.R

import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import net.ezra.navigation.ROUTE_BEACHES

import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LAKES
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_MOUNTAINS
import net.ezra.navigation.ROUTE_POPULAR_HOTELS
import net.ezra.navigation.ROUTE_RADDISONBLU
import net.ezra.navigation.ROUTE_RECOMMENDED_PACKAGES
import net.ezra.navigation.ROUTE_RECOMMENDED_PLACES
import net.ezra.navigation.ROUTE_VASCODAGAMA
import net.ezra.navigation.ROUTE_WILDLIFE
import net.ezra.ui.destinations.DesertsScreen

import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable

fun HomePage(navController: NavHostController) {
    Scaffold(
        content = {
            Box(modifier = Modifier.fillMaxSize().background(Color.White)){

                LazyColumn ( horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly){

                    item {



                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Absolute.SpaceBetween)
                        {

                            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "", modifier= Modifier.size(30.dp),tint = Color(0xfff8c471))
                            Column {
                                Text(text = "Welcome back")
                                Text(text = "")
                            }

                            Icon(imageVector = Icons.Default.Notifications, contentDescription ="notificationIcon" , modifier =  Modifier.size(30.dp),tint = Color(0xfff8c471))
                        }
                        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically) {
                            var text by remember { mutableStateOf(TextFieldValue("")) }
                            OutlinedTextField(
                                value = text,
                                trailingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "searchIcon",modifier=Modifier.clickable {  navController.navigate(ROUTE_HOME) { popUpTo(ROUTE_WILDLIFE)} }) },
                                //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
                                onValueChange = {
                                    text = it
                                },
                                label = { Text(text = "Search destination") },
                                placeholder = { Text(text = "Search destination") },
                                modifier = Modifier
                                    .background(Color.White)
                                    .width(300.dp)
                            )
                        }
                        Row(modifier=Modifier.fillMaxWidth()){
                            LazyRow(modifier=Modifier.fillMaxWidth()){
                                item{




                                    Card( modifier = Modifier
                                        .padding(15.dp)
                                        .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                                        .shadow(elevation = 10.dp)
                                        .clickable { navController.navigate(ROUTE_WILDLIFE) { popUpTo(ROUTE_HOME) } })
                                    {
                                        Row (horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.background(
                                            Color.White)){
                                            Image(painter = painterResource(id = R.drawable.img_5), contentDescription = "" , modifier = Modifier.size(70.dp))
                                            Text(text = "Wildlife")
                                        }
                                    }
                                    Spacer(modifier = Modifier.width(15.dp))


                                    Card( modifier = Modifier
                                        .padding(15.dp)
                                        .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                                        .shadow(elevation = 10.dp)
                                        .clickable { navController.navigate(ROUTE_BEACHES) { popUpTo(ROUTE_HOME) } }) {
                                        Row(horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.background(
                                            Color.White)) {
                                            Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" , modifier = Modifier.size(70.dp))
                                            Text(text = "Beaches")
                                        }
                                    }
                                    Spacer(modifier = Modifier.width(15.dp))


                                    Card( modifier = Modifier
                                        .padding(15.dp)
                                        .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                                        .shadow(elevation = 10.dp)
                                        .clickable { navController.navigate(ROUTE_LAKES) { popUpTo(ROUTE_HOME) } }) {
                                        Row(horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.background(
                                            Color.White)){
                                            Image(painter = painterResource(id = R.drawable.img_2), contentDescription = "" , modifier = Modifier.size(70.dp))
                                            Text(text = "Lakes")
                                        }
                                    }
                                    Spacer(modifier = Modifier.width(15.dp))


                                    Card( modifier = Modifier
                                        .padding(15.dp)
                                        .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                                        .shadow(elevation = 10.dp)
                                        .clickable { navController.navigate(ROUTE_HOME) { popUpTo(ROUTE_HOME) } })
                                    {
                                        Row (horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.background(
                                            Color.White)){
                                            Image(painter = painterResource(id = R.drawable.img), contentDescription = "", modifier = Modifier.size(70.dp) )
                                            Text(text = "Deserts")
                                        }
                                    }
                                    Spacer(modifier = Modifier.width(15.dp))

                                    Card( modifier = Modifier
                                        .padding(15.dp)
                                        .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                                        .shadow(elevation = 10.dp)
                                        .clickable { navController.navigate(ROUTE_HOME) { popUpTo(ROUTE_HOME) } }) {
                                        Row (horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.background(
                                            Color.White)){
                                            Image(painter = painterResource(id = R.drawable.img_1), contentDescription = "" , modifier = Modifier.size(70.dp))
                                            Text(text = "Mountains")


                                        }
                                    }
                                    Spacer(modifier = Modifier.width(20.dp))

                                    Card( modifier = Modifier
                                        .padding(15.dp)
                                        .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                                        .shadow(elevation = 10.dp)
                                        .clickable { navController.navigate(ROUTE_HOME) { popUpTo(ROUTE_HOME) } }) {
                                        Row (horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.background(
                                            Color.White)){
                                            Image(painter = painterResource(id = R.drawable.img_6), contentDescription = "" , modifier = Modifier.size(70.dp))
                                            Text(text = "Culture")
                                        }
                                    }


                                }
                            }
                        }



                        Spacer(modifier = Modifier.height(15.dp) )
                        Row (
                            horizontalArrangement = Arrangement.SpaceBetween , modifier=Modifier.fillMaxWidth()
                        )
                        {
                            Column(horizontalAlignment = AbsoluteAlignment.Left){
                                Text(text = "Popular Packages",fontWeight = FontWeight.ExtraBold)
                            }
                            Spacer(modifier = Modifier.width(50.dp))
                            Column(horizontalAlignment = AbsoluteAlignment.Right){
                                Text(text = " View all", modifier = Modifier.clickable {  navController.navigate(
                                    ROUTE_RECOMMENDED_PACKAGES) { popUpTo(ROUTE_HOME)} })
                            }


                        }

                        LazyRow(modifier=Modifier.fillMaxWidth()) {

                            item {
                                Card(modifier = Modifier
                                    .padding(15.dp)
                                    .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                                    .shadow(elevation = 10.dp)
                                    .clickable { navController.navigate(ROUTE_MOUNTAINS) { popUpTo(ROUTE_HOME) } }) {
                                    Column(modifier = Modifier.background(
                                        Color.White)) {
                                        Image(painter = painterResource(id = R.drawable.img_3), contentDescription = "" , modifier = Modifier.fillMaxWidth().padding(5.dp),contentScale = ContentScale.Fit)
                                        Row(modifier=Modifier.fillMaxWidth()){
                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left){
                                                Text(text = "Along Rift Valley")
                                                Row (horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                                                    Icon(imageVector =Icons.Default.LocationOn , contentDescription ="",modifier=Modifier.size(15.dp) )
                                                    Text(text = "Turkana-Kajiado")
                                                }

                                            }
                                            Spacer(modifier = Modifier.width(5.dp))

                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Right){
                                                Text(text = "3 Days")
                                                Text(text = "2 Nights")
                                            }

                                        }

                                    }
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Card(modifier = Modifier
                                    .padding(15.dp)
                                    .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                                    .shadow(elevation = 10.dp)
                                    .clickable { navController.navigate(ROUTE_MOUNTAINS) { popUpTo(ROUTE_HOME) } }) {
                                    Column(modifier = Modifier.background(
                                        Color.White)) {
                                        Image(painter = painterResource(id = R.drawable.img_3), contentDescription = "" , modifier = Modifier.fillMaxWidth().padding(5.dp),contentScale = ContentScale.Fit)

                                            Row(){
                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left){
                                                Text(text = "Summit Madness")
                                                Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                                                    Icon(imageVector =Icons.Default.LocationOn , contentDescription ="",modifier=Modifier.size(15.dp) )
                                                    Text(text = "Mombasa-Kajiado", fontWeight = FontWeight.ExtraLight,)
                                                }


                                            }
                                              Spacer(modifier = Modifier.width(5.dp))

                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Right){
                                                Text(text = " 4 Days")
                                                Text(text = " 3 Nights")
                                            }
                                        }


                                    }
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Card(modifier = Modifier
                                    .padding(15.dp)
                                    .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                                    .shadow(elevation = 10.dp)
                                    .clickable { navController.navigate(ROUTE_MOUNTAINS) { popUpTo(ROUTE_HOME) } })  {
                                    Column(modifier = Modifier.background(
                                        Color.White)) {
                                        Image(painter = painterResource(id = R.drawable.img_3), contentDescription = "" , modifier = Modifier.fillMaxWidth().padding(5.dp),contentScale = ContentScale.Fit)
                                        Row (modifier=Modifier.fillMaxWidth()){
                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left){
                                                Text(text = "Kenya Classics")
                                                Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                                                    Icon(imageVector =Icons.Default.LocationOn , contentDescription ="",modifier=Modifier.size(15.dp) )
                                                    Text(text = "Nairobi-Mombasa", fontWeight = FontWeight.ExtraLight,)
                                                }

                                            }
                                            Spacer(modifier = Modifier.width(5.dp))

                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Right)
                                            {
                                                Text(text = "10 Days")
                                                Text(text = "9 Nights")
                                            }

                                        }


                                    }
                                }

                                Spacer(modifier = Modifier.width(15.dp))

                                Card(
                                    modifier = Modifier
                                        .padding(15.dp)
                                        .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                                        .shadow(elevation = 10.dp)
                                        .clickable { navController.navigate(ROUTE_MOUNTAINS) { popUpTo(ROUTE_HOME) } }
                                ) {
                                    Column(modifier = Modifier.background(Color.White)) {
                                        Image(
                                            painter = painterResource(id = R.drawable.img_3),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(5.dp),
                                            contentScale = ContentScale.Fit
                                        )
                                        Row(modifier = Modifier.fillMaxWidth()) {
                                            Column(
                                                verticalArrangement = Arrangement.Center,
                                                horizontalAlignment = AbsoluteAlignment.Left
                                            ) {
                                                Text(text = "Kenya Classics")
                                                Row(
                                                    horizontalArrangement = Arrangement.Center,
                                                    verticalAlignment = Alignment.CenterVertically
                                                ) {
                                                    Icon(imageVector = Icons.Default.LocationOn, contentDescription = "", modifier = Modifier.size(15.dp))
                                                    Text(text = "Nairobi-Mombasa", fontWeight = FontWeight.ExtraLight)
                                                }
                                            }
                                            Spacer(modifier = Modifier.width(5.dp))
                                            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Right) {
                                                Text(text = "10 Days")
                                                Text(text = "9 Nights")
                                            }
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.width(15.dp))

                                Card(modifier = Modifier
                                    .padding(15.dp)
                                    .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                                    .shadow(elevation = 10.dp)
                                    .clickable { navController.navigate(ROUTE_MOUNTAINS) { popUpTo(ROUTE_HOME) } })  {
                                    Column(modifier = Modifier.background(
                                        Color.White)) {
                                        Image(painter = painterResource(id = R.drawable.img_3), contentDescription = "" , modifier = Modifier.fillMaxWidth().padding(5.dp),contentScale = ContentScale.Fit)

                                            Row(){
                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left){
                                                Text(text = "Time travel")
                                                Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                                                    Icon(imageVector =Icons.Default.LocationOn , contentDescription ="",modifier=Modifier.size(15.dp) )
                                                    Text(text = "Mombasa-Turkana", fontWeight = FontWeight.ExtraLight,)
                                                }

                                            }
                                                Spacer(modifier = Modifier.width(5.dp))

                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Right){
                                                Text(text = "5 Days")
                                                Text(text = "4 Nights")
                                            }

                                    }
                                    }
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Card(modifier = Modifier
                                    .padding(15.dp)
                                    .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                                    .shadow(elevation = 10.dp)
                                    .clickable { navController.navigate(ROUTE_MOUNTAINS) { popUpTo(ROUTE_HOME) } })  {

                                    Column(modifier = Modifier.background(
                                        Color.White)) {
                                        Image(painter = painterResource(id = R.drawable.img_3), contentDescription = "" , modifier = Modifier.fillMaxSize().padding(5.dp),contentScale = ContentScale.Fit)
                                        Row (modifier=Modifier.fillMaxWidth()){
                                            Row{
                                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left)
                                                {
                                                    Text(text = "Karibu Kenya")
                                                    Row (horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically)
                                                    {
                                                        Icon(imageVector =Icons.Default.LocationOn , contentDescription ="",modifier=Modifier.size(15.dp) )
                                                        Text(text = "Kiambu-Mombasa", fontWeight = FontWeight.ExtraLight,)

                                                    }
                                                }
                                                Spacer(modifier = Modifier.width(5.dp))

                                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Right)
                                                {
                                                    Text(text = "7 Days")
                                                    Text(text = "6 Nights")
                                                }
                                            }


                                        }




                                    }
                                }

                            }
                        }
                        Spacer(modifier =Modifier.height(20.dp) )

                        Row (horizontalArrangement = Arrangement.SpaceBetween ,modifier=Modifier.fillMaxWidth()){
                            Column( horizontalAlignment = AbsoluteAlignment.Left) {
                                Text(text = "Recommended Places",fontWeight = FontWeight.ExtraBold,)
                            }
                            Spacer(modifier = Modifier.width(50.dp))

                            Column( horizontalAlignment = AbsoluteAlignment.Right) {
                                Text(text = "View all", modifier = Modifier.clickable {  navController.navigate(
                                    ROUTE_RECOMMENDED_PLACES) { popUpTo(ROUTE_HOME)}})
                            }


                        }


                        LazyRow (modifier = Modifier.fillMaxWidth()){
                            item {

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                                    Card (shape = CircleShape, modifier = Modifier
                                        .size(80.dp)
                                        .clickable { navController.navigate(ROUTE_VASCODAGAMA) { popUpTo(
                                            ROUTE_HOME) } }){
                                        Image(painter = painterResource(id = R.drawable.img_14), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                                    }
                                    Text(text = "Vasco da Gama")
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                                    Card (shape = CircleShape, modifier = Modifier
                                        .size(80.dp)
                                        .clickable { navController.navigate(ROUTE_VASCODAGAMA) { popUpTo(
                                            ROUTE_HOME) } }){
                                        Image(painter = painterResource(id = R.drawable.img_15), contentDescription = "", modifier = Modifier.fillMaxSize(),contentScale = ContentScale.Crop)
                                    }
                                    Text(text = "Fort Jesus")
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                                    Card (shape = CircleShape, modifier = Modifier
                                        .size(80.dp)
                                        .clickable { navController.navigate(ROUTE_VASCODAGAMA) { popUpTo(
                                        ROUTE_HOME) } }){
                                        Image(painter = painterResource(id = R.drawable.img_16), contentDescription = "", modifier = Modifier.fillMaxSize(),contentScale = ContentScale.Crop)
                                    }
                                    Text(text = "Hell's gate")
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                                    Card (shape = CircleShape, modifier = Modifier
                                        .size(80.dp)
                                        .clickable { navController.navigate(ROUTE_VASCODAGAMA) { popUpTo(
                                            ROUTE_HOME) } }){
                                        Image(painter = painterResource(id = R.drawable.img_10), contentDescription = "", modifier = Modifier.fillMaxSize(),contentScale = ContentScale.Crop)
                                    }
                                    Text(text = "Wildebeests")
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                                    Card (shape = CircleShape, modifier = Modifier
                                        .size(80.dp)
                                        .clickable { navController.navigate(ROUTE_VASCODAGAMA) { popUpTo(
                                            ROUTE_HOME) } }){
                                        Image(painter = painterResource(id = R.drawable.img_11), contentDescription = "", modifier = Modifier.fillMaxSize(),contentScale = ContentScale.Crop)
                                    }
                                    Text(text = "Fourteen falls")
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                                    Card (shape = CircleShape, modifier = Modifier
                                        .size(80.dp)
                                        .clickable { navController.navigate(ROUTE_VASCODAGAMA) { popUpTo(
                                            ROUTE_HOME) } }){
                                        Image(painter = painterResource(id = R.drawable.img_19), contentDescription = "", modifier = Modifier.fillMaxSize(),contentScale = ContentScale.Crop)
                                    }
                                    Text(text = "Hot Springs")
                                }
                                Spacer(modifier = Modifier.width(10.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                                    Card(shape = CircleShape, modifier = Modifier
                                        .size(80.dp)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(
                                                    ROUTE_VASCODAGAMA
                                                )
                                            }
                                        }) {
                                        Image(
                                            painter = painterResource(id = R.drawable.img_18),
                                            contentDescription = "",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                    Text(text = "Flamingos")



                                }
                            }
                        }

                        Spacer(modifier =Modifier.height(20.dp))

                        Row (horizontalArrangement = Arrangement.SpaceBetween ,modifier=Modifier.fillMaxWidth()){
                            Column( horizontalAlignment = AbsoluteAlignment.Left) {
                                Text(text = "Popular Hotels",fontWeight = FontWeight.ExtraBold,)
                            }

                            Column( horizontalAlignment = AbsoluteAlignment.Right) {
                                Text(text = "View all", modifier = Modifier.clickable {  navController.navigate(ROUTE_POPULAR_HOTELS) {
                                    popUpTo(
                                    ROUTE_HOME  )
                                }})
                            }


                        }


                        Column (modifier = Modifier.fillMaxWidth()) {

                            Card(
                                modifier = Modifier
                                .fillMaxWidth()
                                .padding(15.dp)
                                .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                                .shadow(elevation = 10.dp)
                                .clickable {  navController.navigate(ROUTE_RADDISONBLU) { popUpTo(
                                        ROUTE_HOME)}}
                            ) {
                                Row(horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.background(
                                    Color.White
                                ).width(500.dp)) {
                                    Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" , modifier = Modifier.size(70.dp))
                                    Column (){
                                        Row(horizontalArrangement = Arrangement.Absolute.Left){Text(text = "Raddison Blu")}
                                        Row(horizontalArrangement = Arrangement.Absolute.Left){
                                            Icon(
                                                imageVector = Icons.Default.Place ,
                                                contentDescription = ""
                                            )
                                            Text(text = "Nairobi")}
                                        Row(horizontalArrangement = Arrangement.Absolute.Left){

                                            Icon(
                                                imageVector = Icons.Default.Star,
                                                contentDescription = "Review",
                                                tint = Color.Yellow
                                            )


                                            Text(text = "4.9")}
                                        Row(horizontalArrangement = Arrangement.Absolute.Right){
                                            Text(text = "$30/night")}
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(20.dp))


                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(15.dp)
                                    .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                                    .shadow(elevation = 10.dp)
                                    .clickable {  navController.navigate(ROUTE_RADDISONBLU) { popUpTo(
                                        ROUTE_HOME)}}
                            ) {
                                Row(horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.background(
                                    Color.White
                                ).width(500.dp)) {
                                    Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" , modifier = Modifier.size(70.dp))
                                    Column (){
                                        Row(horizontalArrangement = Arrangement.Absolute.Left){Text(text = "Raddison Blu")}
                                        Row(horizontalArrangement = Arrangement.Absolute.Left){
                                            Icon(
                                                imageVector = Icons.Default.Place ,
                                                contentDescription = ""
                                            )
                                            Text(text = "Nairobi")}
                                        Row(horizontalArrangement = Arrangement.Absolute.Left){

                                            Icon(
                                                imageVector = Icons.Default.Star,
                                                contentDescription = "Review",
                                                tint = Color.Yellow
                                            )


                                            Text(text = "4.9")}
                                        Row(horizontalArrangement = Arrangement.Absolute.Right){
                                            Text(text = "$30/night")}
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(20.dp))

                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(15.dp)
                                    .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                                    .shadow(elevation = 10.dp)
                                    .clickable {  navController.navigate(ROUTE_RADDISONBLU) { popUpTo(
                                        ROUTE_HOME)}}
                            ) {
                                Row(horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.background(
                                    Color.White
                                ).width(500.dp)) {
                                    Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" , modifier = Modifier.size(70.dp))
                                    Column (){
                                        Row(horizontalArrangement = Arrangement.Absolute.Left){Text(text = "Raddison Blu")}
                                        Row(horizontalArrangement = Arrangement.Absolute.Left){
                                            Icon(
                                                imageVector = Icons.Default.Place ,
                                                contentDescription = ""
                                            )
                                            Text(text = "Nairobi")}
                                        Row(horizontalArrangement = Arrangement.Absolute.Left){

                                            Icon(
                                                imageVector = Icons.Default.Star,
                                                contentDescription = "Review",
                                                tint = Color.Yellow
                                            )


                                            Text(text = "4.9")}
                                        Row(horizontalArrangement = Arrangement.Absolute.Right){
                                            Text(text = "$30/night")}
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.width(15.dp))

                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(15.dp)
                                    .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                                    .shadow(elevation = 10.dp)
                                    .clickable {  navController.navigate(ROUTE_RADDISONBLU) { popUpTo(
                                        ROUTE_HOME)}}
                            ) {
                                Row(horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.background(
                                    Color.White
                                ).width(500.dp)) {
                                    Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" , modifier = Modifier.size(70.dp))
                                    Column (){
                                        Row(horizontalArrangement = Arrangement.Absolute.Left){Text(text = "Raddison Blu")}
                                        Row(horizontalArrangement = Arrangement.Absolute.Left){
                                            Icon(
                                                imageVector = Icons.Default.Place ,
                                                contentDescription = ""
                                            )
                                            Text(text = "Nairobi")}
                                        Row(horizontalArrangement = Arrangement.Absolute.Left){

                                            Icon(
                                                imageVector = Icons.Default.Star,
                                                contentDescription = "Review",
                                                tint = Color.Yellow
                                            )


                                            Text(text = "4.9")}
                                        Row(horizontalArrangement = Arrangement.Absolute.Right){
                                            Text(text = "$30/night")}
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(20.dp))

                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(15.dp)
                                    .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                                    .shadow(elevation = 10.dp)
                                    .clickable {  navController.navigate(ROUTE_RADDISONBLU) { popUpTo(
                                        ROUTE_HOME)}}
                            ) {
                                Row(horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.background(
                                    Color.White
                                ).width(500.dp)) {
                                    Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" , modifier = Modifier.size(70.dp))
                                    Column (){
                                        Row(horizontalArrangement = Arrangement.Absolute.Left){Text(text = "Raddison Blu")}
                                        Row(horizontalArrangement = Arrangement.Absolute.Left){
                                            Icon(
                                                imageVector = Icons.Default.Place ,
                                                contentDescription = ""
                                            )
                                            Text(text = "Nairobi")}
                                        Row(horizontalArrangement = Arrangement.Absolute.Left){

                                            Icon(
                                                imageVector = Icons.Default.Star,
                                                contentDescription = "Review",
                                                tint = Color.Yellow
                                            )


                                            Text(text = "4.9")}
                                        Row(horizontalArrangement = Arrangement.Absolute.Right){
                                            Text(text = "$30/night")}
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(20.dp))

                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(15.dp)
                                    .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                                    .shadow(elevation = 10.dp)
                                    .clickable {  navController.navigate(ROUTE_RADDISONBLU) { popUpTo(
                                        ROUTE_HOME)}}
                            ) {
                                Row(horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.background(
                                    Color.White
                                ).width(500.dp)) {
                                    Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" , modifier = Modifier.size(70.dp))
                                    Column (){
                                        Row(horizontalArrangement = Arrangement.Absolute.Left){Text(text = "Raddison Blu")}
                                        Row(horizontalArrangement = Arrangement.Absolute.Left){
                                            Icon(
                                                imageVector = Icons.Default.Place ,
                                                contentDescription = ""
                                            )
                                            Text(text = "Nairobi")}
                                        Row(horizontalArrangement = Arrangement.Absolute.Left){

                                            Icon(
                                                imageVector = Icons.Default.Star,
                                                contentDescription = "Review",
                                                tint = Color.Yellow
                                            )


                                            Text(text = "4.9")}
                                        Row(horizontalArrangement = Arrangement.Absolute.Right){
                                            Text(text = "$30/night")}
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(20.dp))

                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(15.dp)
                                    .border(shape = RoundedCornerShape(10.dp), width = 1.dp, color = Color.White)
                                    .shadow(elevation = 10.dp)
                                    .clickable {  navController.navigate(ROUTE_RADDISONBLU) { popUpTo(
                                        ROUTE_HOME)}}
                            )  {
                                Row(horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically,modifier = Modifier.background(
                                    Color.White
                                ).width(500.dp)) {
                                    Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" , modifier = Modifier.size(70.dp))
                                    Column (){
                                        Row(horizontalArrangement = Arrangement.Absolute.Left){Text(text = "Raddison Blu")}
                                        Row(horizontalArrangement = Arrangement.Absolute.Left){
                                            Icon(
                                                imageVector = Icons.Default.Place ,
                                                contentDescription = ""
                                            )
                                            Text(text = "Nairobi")}
                                        Row(horizontalArrangement = Arrangement.Absolute.Left){

                                            Icon(
                                                imageVector = Icons.Default.Star,
                                                contentDescription = "Review",
                                                tint = Color.Yellow
                                            )


                                            Text(text = "4.9")}
                                        Row(horizontalArrangement = Arrangement.Absolute.Right){
                                            Text(text = "$30/night")}
                                    }
                                }
                            }






                        }

                    }
                }
            }
        },
        bottomBar = {BottomBar(navController)}



    )
    var isDrawerOpen: Boolean = false
    fun onClose() {
        isDrawerOpen = false
    }

    AnimatedDrawer(
        isOpen = isDrawerOpen,
        onClose = { isDrawerOpen = false }
    )

}


@Composable
fun AnimatedDrawer(isOpen: Boolean, onClose: () -> Unit) {
    val drawerWidth = remember { Animatable(if (isOpen) 250f else 0f) }





    LaunchedEffect(isOpen) {
        drawerWidth.animateTo(if (isOpen) 250f else 0f, animationSpec = tween(durationMillis = 300))
    }

    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .width(drawerWidth.value.dp),
        color = Color(0xfff8c471),
        // color = Color.LightGray,
        elevation = 16.dp
    ) {


        val mContext = LocalContext.current

        Column {
//            Text(
//                text = "Drawer Item 1"
//
//            )
//            Text(
//                text = "Drawer Item 2"
//            )
//            Text(
//                text = "Drawer Item 3",
//                modifier = Modifier.clickable {  }
//            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "muleli kelvin developer")


            OutlinedButton(
                onClick = {
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/pain"
                    shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("kelvinmuleli514@gmail.com"))
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Welcome to the Business email address")
                    mContext.startActivity(shareIntent)
                },
                modifier = Modifier
                    // .fillMaxSize()
                    .padding(start = 10.dp, end = 10.dp),
                shape = RoundedCornerShape(11.dp),
                border = BorderStroke(2.dp, Color.White)
            )

            {
                Text(text = "Email", color = Color.Black, fontWeight = FontWeight.Black)
            }



            OutlinedButton(
                onClick = {
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Share Out")
                    //  _dagger_hilt_android_internal_modules_ApplicationContextModule.startActivity(Intent.createChooser(shareIntent,"Share"))
                    mContext.startActivity(Intent.createChooser(shareIntent, "Share"))

                },
                modifier = Modifier
                    //.fillMaxSize()
                    .padding(start = 10.dp, end = 10.dp),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(2.dp, color = Color.White)

            ) {
                Text(text = "Share", color = Color.Black)
            }





            Spacer(modifier = Modifier.height(15.dp))

            OutlinedButton(
                onClick = {

                    val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    if (cameraIntent.resolveActivity(mContext.packageManager) != null) {
                        mContext.startActivity(cameraIntent)
                    } else {
                        println("Camera app is not available")
                    }


                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(2.dp, Color.Red)
            ) {
                Text(text = "Camera", color = Color.Black)

            }
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedButton(
                onClick = {

                    val smsIntent = Intent(Intent.ACTION_SENDTO)
                    smsIntent.data = "smsto:0746434045".toUri()
                    smsIntent.putExtra("sms_body", "Hello muleli kelvin,how was your day?")
                    mContext.startActivity(smsIntent)


                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(2.dp, Color.Red)
            ) {
                Text(text = "Sms", color = Color.Black)

            }
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedButton(
                onClick = {

                    val callIntent = Intent(Intent.ACTION_DIAL)
                    callIntent.data = "tel:0746434045".toUri()
                    mContext.startActivity(callIntent)

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(2.dp, Color.Red)
            ) {
                Text(text = "Call", color = Color.Black)

            }
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedButton(
                onClick = {

                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("mulelikelvin21@gmail.com"))
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                    mContext.startActivity(shareIntent)


                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(2.dp, Color.Red)
            ) {
                Text(text = "email", color = Color.Black)

            }
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedButton(
                onClick = {
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this is a cool content")
                    mContext.startActivity(Intent.createChooser(shareIntent, "Share"))

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(2.dp, Color.Red)
            ) {
                Text(text = "Share", color = Color.Black)

            }
            Spacer(modifier = Modifier.height(15.dp))



            Text(text = "Already have an account",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { mContext.startActivity(Intent(mContext, ROUTE_LOGIN::class.java)) }

            )


        }
    }


}
    @Composable
    fun BottomBar(navController: NavHostController) {
        val selectedIndex = remember { mutableStateOf(0) }
        BottomNavigation(
            elevation = 10.dp,
            backgroundColor = Color.White,
            contentColor = Color(0xfff8c471),
        )
        {
            BottomNavigationItem(icon = {
                Icon(imageVector = Icons.Default.Home, "", tint = Color(0xfff8c471))
            },
                label = { Text(text = "Home", color = Color(0xfff8c471)) },
                selected = (selectedIndex.value == 0),
                onClick = {
                    selectedIndex.value = 0
                })
            BottomNavigationItem(icon = {
                Icon(imageVector = Icons.Default.Search, "", tint = Color(0xfff8c471))
            },
                label = { Text(text = "Search", color = Color(0xfff8c471)) },
                selected = (selectedIndex.value == 0),
                onClick = {
                    selectedIndex.value = 0
                })

            BottomNavigationItem(icon = {
                Icon(imageVector = Icons.Default.ShoppingCart, "", tint = Color(0xfff8c471))
            },
                label = { Text(text = "Cart", color = Color(0xfff8c471)) },
                selected = (selectedIndex.value == 2),
                onClick = {
                    selectedIndex.value = 2
                })
        }
    }



    









