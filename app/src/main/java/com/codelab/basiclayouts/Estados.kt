package com.codelab.basiclayouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Estados {


    @Composable
    fun Marcadores(colorBoleano: Boolean) {

        //var verde = color.Green

        if (colorBoleano == true) {

        }

    }

    fun ImageButton(onClick: () -> Boolean,
                    painter: Painter,
                    contentDescription: Nothing?,
                    contentScale: ContentScale,
                    modifier: Modifier, function: () -> Unit) {

    }




    @Preview
    @Composable
    fun Preview()
    {

    }




}
