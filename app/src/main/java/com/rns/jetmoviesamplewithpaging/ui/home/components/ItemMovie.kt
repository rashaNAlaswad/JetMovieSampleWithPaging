package com.rns.jetmoviesamplewithpaging.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.rns.jetmoviesamplewithpaging.R
import com.rns.jetmoviesamplewithpaging.ui.home.MovieUiState

@Composable
fun ItemMovie(
    movie: MovieUiState,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(8.dp)),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Spacer(Modifier.width(16.dp))

            DetailsSection(movie, modifier.weight(1f))

            Spacer(Modifier.width(10.dp))

            ImageFromInternet(movie)
        }
    }
}

@Composable
private fun DetailsSection(movie: MovieUiState, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = movie.title,
            style = MaterialTheme.typography.titleMedium,
            color = Color.Unspecified, textAlign = TextAlign.Center,
        )

        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Star",
                tint = Color.Yellow
            )
            Text(
                text = "${movie.rating}/10",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(start = 6.dp)
            )
        }

    }
}

@Composable
private fun ImageFromInternet(movie: MovieUiState, modifier: Modifier = Modifier) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(movie.imageUrl)
            .crossfade(true)
            .placeholder(R.drawable.movie_placeholder)
            .error(R.drawable.ic_broken_image)
            .build()
    )

    Image(
        painter = painter,
        contentScale = ContentScale.FillWidth,
        contentDescription = null,
        modifier = modifier
            .size(178.dp)
            .clip(RoundedCornerShape(8.dp))
    )
}