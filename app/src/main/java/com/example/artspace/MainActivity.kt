package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var artworkIndex by remember { mutableStateOf(0) }

    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {

        when (artworkIndex) {
            0 -> ArtWorkScroller(
                title = "Camping 0",
                artist = "Artist 0",
                year = "2000",
                imageId = R.drawable.vecteezy_camping_graphic_illustration_7140290,
                onLeftButtonPresssed = {
                    artworkIndex = calculatePreviousArtworkIndex(artworkIndex)
                },
                onRightButtonPressed = { artworkIndex = calculateNextArtworkIndex(artworkIndex) })

            1 -> ArtWorkScroller(
                title = "Camping 1",
                artist = "Artist 1",
                year = "2001",
                imageId = R.drawable.camp_1,
                onLeftButtonPresssed = {
                    artworkIndex = calculatePreviousArtworkIndex(artworkIndex)
                },
                onRightButtonPressed = { artworkIndex = calculateNextArtworkIndex(artworkIndex) })
            2 -> ArtWorkScroller(
                title = "Camping 2",
                artist = "Artist 2",
                year = "2002",
                imageId = R.drawable.camp_2,
                onLeftButtonPresssed = {
                    artworkIndex = calculatePreviousArtworkIndex(artworkIndex)
                },
                onRightButtonPressed = { artworkIndex = calculateNextArtworkIndex(artworkIndex) })
            3 -> ArtWorkScroller(
                title = "Camping 3",
                artist = "Artist 3",
                year = "2003",
                imageId = R.drawable.camp_3,
                onLeftButtonPresssed = {
                    artworkIndex = calculatePreviousArtworkIndex(artworkIndex)
                },
                onRightButtonPressed = { artworkIndex = calculateNextArtworkIndex(artworkIndex) })
            4 -> ArtWorkScroller(
                title = "Camping 4",
                artist = "Artist 4",
                year = "2004",
                imageId = R.drawable.camp_4,
                onLeftButtonPresssed = {
                    artworkIndex = calculatePreviousArtworkIndex(artworkIndex)
                },
                onRightButtonPressed = { artworkIndex = calculateNextArtworkIndex(artworkIndex) })
        }
    }
}


@Composable
fun ArtWorkScroller(
    title: String, artist: String, year: String, imageId: Int, onLeftButtonPresssed: () -> Unit,
    onRightButtonPressed: () -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .weight(7f)
                .fillMaxWidth()
                .padding(4.dp),
            painter = painterResource(id = imageId),
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .weight(2f)
                .padding(4.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "$title",
                fontSize = 38.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                "$artist ($year)",
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
        ArtworkButtons(
            onLeftButtonPresssed = onLeftButtonPresssed,
            onRightButtonPressed = onRightButtonPressed
        )
    }
}

fun calculateNextArtworkIndex(currentIndex: Int): Int {
    var idx = currentIndex
    if (currentIndex == 4) {
        return 0
    } else {
        idx++
        return idx
    }
}

fun calculatePreviousArtworkIndex(currentIndex: Int): Int {
    var idx = currentIndex
    if (currentIndex == 0) {
        return 4
    } else {
        idx--
        return idx
    }
}

@Composable
fun ArtworkButtons(
    modifier: Modifier = Modifier,
    leftButtonText: String = "Previous",
    rightButtonText: String = "Next",
    onLeftButtonPresssed: () -> Unit,
    onRightButtonPressed: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Button(modifier = Modifier.width(140.dp), onClick = onLeftButtonPresssed) {
            Text("Previous")
        }
        Button(modifier = Modifier.width(140.dp), onClick = onRightButtonPressed) {
            Text("Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}