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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Adjust
import androidx.compose.material.icons.filled.Airplay
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
    horizontalAlignment: Alignment.Horizontal = Alignment.End,
    verticalAlignment: Alignment.Vertical = Alignment.Top,

    ) {
    Surface( modifier = Modifier
        .size(45.dp, 45.dp)
        .padding(10.dp)
        .clip(CircleShape)
        .background(MaterialTheme.colorScheme.onPrimary))
    {
    Icon(imageVector = Icons.Default.Search , contentDescription = null )
    }
    }

// Step: Align your body - Alignment
@Composable
fun CuadroSuperiorElement(
    @DrawableRes drawable: Int,
      modifier: Modifier = Modifier
) {
    // Implement composable here

        Image(painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = 480.dp, height = 389.dp)
        )
    Spacer(modifier
        .height(10.dp))
}

@Composable
fun CuadriculaCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface (
        shape = MaterialTheme.shapes.small,
        color = MaterialTheme.colorScheme.surface,
        modifier = modifier
            .padding(8.dp)

    ){

        Column (horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .size(132.dp, 186.dp)) {


            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size (width = 132.dp, height = 133.dp)
            )
            Spacer(modifier.height(8.dp))

            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.titleMedium,
                //color = MaterialTheme.colorScheme.onPrimary,
                 modifier = Modifier,

            )

        }
    }

}
@Composable
fun RestanguloCard(
    @DrawableRes drawable: Int,

    modifier: Modifier = Modifier
) {
    Surface (
        shape = MaterialTheme.shapes.small,
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
            Spacer(modifier.height(2.dp))

        }
    }


@Composable
fun CuadroSuperiorRow(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        modifier = Modifier
            .size (width = 480.dp, height = 389.dp)
        //BUSCAR MODIFICADOR PARA QUE ME MUESTRE LAS IMAGENES DE 1 EN 1

    ){
        items (cuadroSuperior){
                item -> CuadroSuperiorElement(item.drawable)
        }
    }

}

@Composable
fun CuadriculaCollectionsGrid(
    modifier: Modifier = Modifier
) {
   Surface(modifier .padding(5.dp))
    {
        Column (
           horizontalAlignment = Alignment.Start){

        Text(
        "   Trending Now",
        style = MaterialTheme.typography.titleLarge,
        textAlign = TextAlign.Start,
        fontWeight = FontWeight.Bold,

    )
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        modifier = modifier
            .height(200.dp)
    ) {

        items(cuadricula) { item ->
            CuadriculaCard(item.drawable, item.text, modifier = modifier.height(21.dp))
        }
    }
    }
    }
}
@Composable
fun RestangulosCollectionsGrid(
    modifier: Modifier = Modifier
) {
    Column {

    Text(
        "   New Original",
        style = MaterialTheme.typography.titleLarge,
        textAlign = TextAlign.Justify,
        fontWeight = FontWeight.Bold,
    )
    LazyRow(

        modifier = modifier
            .height(332.dp)  // Altura del conjuto de 2 conjunto en vertical
    ) {
        items(restangulos) { item ->
            RestanguloCard(item.drawable)
        }
    }
    }
}

// Step: Home section - Slot APIs
@Composable
fun FuncionesPantalla(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
        content()
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    // Implement composable here
    Surface (modifier = Modifier
        .background(MaterialTheme.colorScheme.surface)){


        FuncionesPantalla {
            SearchBar()
        }
        Column (modifier = Modifier
            .verticalScroll(rememberScrollState()))
        {
        FuncionesPantalla {
                CuadroSuperiorRow()
            }

            FuncionesPantalla {
                CuadriculaCollectionsGrid()
            }

            FuncionesPantalla {
                RestangulosCollectionsGrid()
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

        NavigationBarItem(
            selected = true,
            onClick = {  },
            icon = { Icon(imageVector = Icons.Default.Adjust, contentDescription = null) }, //icono en imagen vertorial de la librería llamado Spa
            label = { Text (text = stringResource(R.string.for_you))}
        )
        NavigationBarItem(
            selected = false,
            onClick = {  },
            icon = { Icon(imageVector = Icons.Default.Airplay , contentDescription = null) }, //icono en imagen vertorial de la librería llamado Spa
            label = { Text (text = stringResource(R.string.originals))}
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Image , contentDescription = null) },
            label = { Text (text = stringResource(R.string.canvas))}
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Image , contentDescription = null) },
            label = { Text (text = stringResource(R.string.my))}
        )
        NavigationBarItem(
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

    MySootheTheme {
        Scaffold (
            bottomBar = { SootheBottomNavigation()
                   //SearchBar()
            }
        ){
                padding -> HomeScreen(Modifier.padding(padding))
        }
    }
}
/*
// Step: Bottom navigation - Material
@Composable
private fun SootheNavigationRail(modifier: Modifier = Modifier) {
    // Implement composable here
}*/
/*
// Step: Landscape Mode
@Composable
fun MySootheAppLandscape(){
    // Implement composable here
}*/

// Step: MySoothe App
@Composable
fun MySootheApp() {
    // Implement composable here
}

private val cuadroSuperior = listOf(
    R.drawable.onepieceestampide to R.string.onepieceestampide,
    R.drawable.kaguya to R.string.kaguya,
    R.drawable.ninobestia to R.string.ninobestia,
    R.drawable.patema to R.string.patema,
    R.drawable.yourname to R.string.yourname,
    R.drawable.lachicaquesaltabatiempo to R.string.lachicaquesaltabatiempo
).map { DrawableStringPair(it.first, it.second) }

private val cuadricula = listOf(
    R.drawable.cowboybebop to R.string.cowboybebop,
    R.drawable.escaflone to R.string.escaflone,
    R.drawable.evangelion to R.string.evangelion,
    R.drawable.flcl to R.string.flcl,
    R.drawable.sailormoon to R.string.sailormoon,
    R.drawable.fullmetal to R.string.fullmetal
).map { DrawableStringPair(it.first, it.second) }


private val restangulos = listOf(
    R.drawable.captaintsubasa to R.string.captainshubasa,
    R.drawable.goblinslayer to R.string.goblinslayer,
    R.drawable.hametsunooukoku to R.string.hametsunooukoku,
    R.drawable.mashle to R.string.mashe,
    R.drawable.onepiecered to R.string.onepiecered,
    R.drawable.spyxfamily to R.string.spyxfamily
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun SearchBarPreview() {
    MySootheTheme { SearchBar() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun CuadroSuperiorElementPreview() {
    MySootheTheme {
        CuadroSuperiorElement(
            modifier = Modifier.padding(8.dp) ,
            drawable = R.drawable.onepieceestampide,

        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun CuadriculaCardPreview() {
    MySootheTheme {
        CuadriculaCard(
            modifier = Modifier.padding(8.dp),
            drawable = R.drawable.cowboybebop,
            text = R.string.cowboybebop,
        )
    }
}
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun  RestanguloCardPreview() {
    MySootheTheme {
        RestanguloCard(
            modifier = Modifier.padding(8.dp),
            drawable = R.drawable.captaintsubasa,

        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun CuadriculaCollectionsGridPreview() {
    MySootheTheme { CuadriculaCollectionsGrid() }
}
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun RestangulosCollectionsGridPreview() {
    MySootheTheme { RestangulosCollectionsGrid() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun CuadroSuperiorRowPreview() {
    MySootheTheme { CuadroSuperiorRow() }
}
/*
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun HomeSectionPreview() {
  /*  MySootheTheme {
        Surface (modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)){

            FuncionesPantalla {
                SearchBar()
            }
        Column (modifier = Modifier
                .verticalScroll(rememberScrollState())) //IMPORTANTE. recuerda la posicion del scroll para abajo.
        {
        FuncionesPantalla {
            CuadroSuperiorRow()
            }
            Spacer(modifier = Modifier
                .height(30.dp))

        FuncionesPantalla {
            CuadriculaCollectionsGrid()
            }
            Spacer(modifier = Modifier
                .height(30.dp))

            FuncionesPantalla {
                RestangulosCollectionsGrid()
            }
            Spacer(modifier = Modifier
                .height(30.dp))
        }

        }
    }*/
}
*/
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
/*
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun NavigationRailPreview() {
    MySootheTheme { SootheNavigationRail() }
}*/

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun MySoothePortraitPreview() {
    MySootheAppPortrait()
}
/*
@Preview(widthDp = 640, heightDp = 360)
@Composable
fun MySootheLandscapePreview() {
    MySootheAppLandscape()
}
*/