/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codelab.basiclayouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Adjust
import androidx.compose.material.icons.filled.Airplay
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codelab.basiclayouts.ui.theme.MySootheTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MySootheApp() }
    }
}

// Step: Search bar - Modifiers
@Composable
fun SearchBar(
    modifier: Modifier = Modifier
        .size(45.dp, 45.dp),
    verticalAlignment = ..........
) {
    // Implement composable here
    Icon(imageVector = Icons.Default.Search , contentDescription = null )


}

// Step: Align your body - Alignment
@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int, //parametros para crear que sea dinámico INVESTIGAR
      modifier: Modifier = Modifier //parametro opcional, no tenemos porque pasarlo. Por eso no lleva @
) {
    // Implement composable here

        Image(painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop, // .Fit o FillBounds(mete toda la foto en el espacio que le des) modifica el cacho del recorte
            modifier = Modifier
                .size(width = 480.dp, height = 389.dp) // tamaño de la imagen

        )

}
// Step: Favorite collection card - Material Surface
@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface (
        shape = MaterialTheme.shapes.extraSmall, //redondea las esquinas
        color = MaterialTheme.colorScheme.surface,
        modifier = modifier
           .padding(16.dp) //aprox revisar
    ){

        Column (horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .size(132.dp, 186.dp)) {

            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop, //Lo mismo que en el ejemplo del yoga
                modifier = Modifier
                    .size (width = 132.dp, height = 133.dp)
            )
            Spacer(modifier.height(8.dp))

            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                 modifier = Modifier,
                //VerticalAlignmentLine = Arrangement.Bottom
                    //.padding(horizontal = 16.dp)
            )

        }
    }

}
@Composable
fun FavoriteCollectionCard2(
    @DrawableRes drawable: Int,

    modifier: Modifier = Modifier
) {
    Surface (
        shape = MaterialTheme.shapes.extraSmall, //redondea las esquinas
        color = MaterialTheme.colorScheme.surface,
        modifier = modifier
            .padding(9.dp) //aprox revisar
    ){

            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop, //Lo mismo que en el ejemplo del yoga
                modifier = Modifier
                    .size (width = 180.dp, height = 263.dp)
            )
            Spacer(modifier.height(8.dp))

        }
    }



// Step: Align your body row - Arrangements
@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = Modifier
        //BUSCAR MODIFICADOR PARA QUE ME MUESTRE LAS IMAGENES DE 1 EN 1

    ){
        items (alignYourBodyData){// Llama a objetos por cada vez que ejecuta la funcióm
                item -> AlignYourBodyElement(item.drawable)
        }
    }
    // Implement composable here
}

// Step: Favorite collections grid - LazyGrid
@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    // Implement composable here
    LazyHorizontalGrid(   //asignacion más atractiva pero igual que el LazyRow grid se lo toma celda
        rows = GridCells.Fixed(1), //número de celdas
        //contentPadding = PaddingValues(horizontal = 16.dp), // no me termina de quedar claro
        //horizontalArrangement = Arrangement.spacedBy(8.dp),

        modifier = modifier
            .height(242.dp)  // Altura del conjuto de 2 conjunto en vertical
    ){
        items(favoriteCollectionsData){
                item -> FavoriteCollectionCard(item.drawable, item.text, modifier = modifier. height(21.dp))
        }
    }
}
@Composable
fun FavoriteCollectionsGrid2(
    modifier: Modifier = Modifier
) {
    // Implement composable here
    LazyRow(
        //rows = GridCells.Fixed(1),//asignacion más atractiva pero igual que el LazyRow grid se lo toma celda
              //contentPadding = PaddingValues(horizontal = 16.dp), // no me termina de quedar claro
        //horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .height(332.dp)  // Altura del conjuto de 2 conjunto en vertical
    ){
        items(favoriteCollectionsData){
                item -> FavoriteCollectionCard2(item.drawable)
        }
    }
}

// Step: Home section - Slot APIs
@Composable
fun HomeSection(  //TENEMOS QUE AVERIGUAR QUE ESTAMOS HACIENDO CON ESTO

    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    // Implement composable here
        content()
}

// Step: Home screen - Scrolling
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    // Implement composable here
    Surface (modifier = Modifier
        .background(MaterialTheme.colorScheme.surface)){



        Column (modifier = Modifier
            .verticalScroll(rememberScrollState())) //IMPORTANTE. recuerda la posicion del scroll para abajo.
        {
            HomeSection {
                AlignYourBodyRow()
            }
            Spacer(modifier = Modifier
                .height(30.dp))

            HomeSection {
                FavoriteCollectionsGrid()
            }
            Spacer(modifier = Modifier
                .height(30.dp))

            HomeSection {
                FavoriteCollectionsGrid2()
            }
            Spacer(modifier = Modifier
                .height(30.dp))
        }

    }
}

// Step: Bottom navigation - Material
@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    // Implement composable here
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surfaceVariant //Le damos el marroncito del fondo
    ){

        NavigationBarItem( //el simbolo de Home es el primero y aparece como seleccionado
            selected = true,
            onClick = {  }, //uso de estados
            icon = { Icon(imageVector = Icons.Default.Adjust, contentDescription = null) }, //icono en imagen vertorial de la librería llamado Spa
            label = { Text (text = stringResource(R.string.for_you))}
        )
        NavigationBarItem( //el simbolo de Home es el primero y aparece como seleccionado
            selected = true,
            onClick = {  }, //uso de estados
            icon = { Icon(imageVector = Icons.Default.Airplay , contentDescription = null) }, //icono en imagen vertorial de la librería llamado Spa
            label = { Text (text = stringResource(R.string.originals))}
        )
        NavigationBarItem( //icono perfil
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Image , contentDescription = null) },
            label = { Text (text = stringResource(R.string.canvas))}
        )
        NavigationBarItem( //icono perfil
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Image , contentDescription = null) },
            label = { Text (text = stringResource(R.string.my))}
        )
        NavigationBarItem( //icono perfil
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Image , contentDescription = null) },
            label = { Text (text = stringResource(R.string.more))}
        )

    }
}

// Step: MySoothe App - Scaffold
@Composable
fun MySootheAppPortrait() {
    // Implement composable here
    MySootheTheme { //Nuestro tema de diseño
        Scaffold ( // implenta el material basico de diseño de una extructura. Usa varios materiales conjuntamente en la pantalla
            bottomBar = { SootheBottomNavigation()}
        ){

                padding -> HomeScreen(Modifier.padding(padding))

        }
    }
}

// Step: Bottom navigation - Material
@Composable
private fun SootheNavigationRail(modifier: Modifier = Modifier) {
    // Implement composable here
}

// Step: Landscape Mode
@Composable
fun MySootheAppLandscape(){
    // Implement composable here
}

// Step: MySoothe App
@Composable
fun MySootheApp() {
    // Implement composable here
}

private val alignYourBodyData = listOf(
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
    R.drawable.ab3_stretching to R.string.ab3_stretching,
    R.drawable.ab4_tabata to R.string.ab4_tabata,
    R.drawable.ab5_hiit to R.string.ab5_hiit,
    R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
).map { DrawableStringPair(it.first, it.second) }

private val favoriteCollectionsData = listOf(
    R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
    R.drawable.fc4_self_massage to R.string.fc4_self_massage,
    R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
    R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun SearchBarPreview() {
    MySootheTheme { SearchBar(Modifier.padding(8.dp)) }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun AlignYourBodyElementPreview() {
    MySootheTheme {
        AlignYourBodyElement(
            modifier = Modifier.padding(8.dp) ,
            drawable = R.drawable.ab1_inversions,

        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun FavoriteCollectionCardPreview() {
    MySootheTheme {
        FavoriteCollectionCard(
            modifier = Modifier.padding(8.dp),
            drawable = R.drawable.fc2_nature_meditations,
            text = R.string.fc2_nature_meditations,
        )
    }
}
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun FavoriteCollectionCardPreview2() {
    MySootheTheme {
        FavoriteCollectionCard2(
            modifier = Modifier.padding(8.dp),
            drawable = R.drawable.fc2_nature_meditations,

        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun FavoriteCollectionsGridPreview() {
    MySootheTheme { FavoriteCollectionsGrid() }
}
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun FavoriteCollectionsGridPreview2() {
    MySootheTheme { FavoriteCollectionsGrid2() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun AlignYourBodyRowPreview() {
    MySootheTheme { AlignYourBodyRow() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun HomeSectionPreview() {
    MySootheTheme {
        Surface (modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)){

        Column (modifier = Modifier
                .verticalScroll(rememberScrollState())) //IMPORTANTE. recuerda la posicion del scroll para abajo.
        {
        HomeSection {
            AlignYourBodyRow()
            }
            Spacer(modifier = Modifier
                .height(30.dp))

        HomeSection {
            FavoriteCollectionsGrid()
            }
            Spacer(modifier = Modifier
                .height(30.dp))

            HomeSection {
                FavoriteCollectionsGrid2()
            }
            Spacer(modifier = Modifier
                .height(30.dp))
        }

        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun ScreenContentPreview() {
    MySootheTheme { HomeScreen() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun BottomNavigationPreview() {
    MySootheTheme { SootheBottomNavigation(Modifier.padding(top = 24.dp)) }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun NavigationRailPreview() {
    MySootheTheme { SootheNavigationRail() }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun MySoothePortraitPreview() {
    MySootheAppPortrait()
}

@Preview(widthDp = 640, heightDp = 360)
@Composable
fun MySootheLandscapePreview() {
    MySootheAppLandscape()
}
