package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import com.example.androiddevchallenge.ui.PetDetail
import com.example.androiddevchallenge.ui.PetList
import com.example.androiddevchallenge.ui.theme.MyTheme
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    val viewModel: PetViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(viewModel)
                val openOffset by animateFloatAsState(
                    if (viewModel.openModule == null) {
                        1f
                    } else {
                        0f
                    }
                )
                if (viewModel.currentPet != null) {
                    PetDetail(
                        Modifier.percentOffsetX(openOffset),
                        pet = viewModel.currentPet,
                        viewModel = viewModel
                    ) {

                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        if (viewModel.openModule != null) {
            viewModel.closePetDetail()
        } else {
            super.onBackPressed()
        }
    }
}

fun Modifier.percentOffsetX(percent: Float) = this.layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    layout(placeable.width, placeable.height) {
        placeable.placeRelative(IntOffset((placeable.width * percent).roundToInt(), 0))
    }
}

// Start building your app here!
@Composable
fun MyApp(viewModel: PetViewModel) {
    Surface(color = MaterialTheme.colors.background) {
        PetList(viewModel)
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview(viewModel: PetViewModel) {
    MyTheme {
        MyApp(viewModel)
    }
}


@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview(viewModel: PetViewModel) {
    MyTheme(darkTheme = true) {
        MyApp(viewModel)
    }
}
