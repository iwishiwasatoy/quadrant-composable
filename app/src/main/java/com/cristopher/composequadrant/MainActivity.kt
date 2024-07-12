package com.cristopher.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cristopher.composequadrant.ui.theme.ComposeQuadrantTheme
import org.intellij.lang.annotations.JdkConstants

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GroupedQuadrants()
                }
            }
        }
    }
}

@Composable
fun GroupedQuadrants(modifier: Modifier = Modifier) {
    Column (modifier = modifier.fillMaxSize()){
        Row (modifier = Modifier.weight(1f)){
            Quadrant(
                title = stringResource(R.string.text_composable),
                content = stringResource(R.string.displays_text_and_follows_the_recommended_material_design_guidelines),
                modifier = Modifier
                    .background(color = Color(0xFFEADDFF))
                    .weight(1f)
            )
            Quadrant(
                title = stringResource(R.string.image_composable),
                content = stringResource(R.string.creates_a_composable_that_lays_out_and_draws_a_given_painter_class_object),
                modifier = Modifier
                    .background(color = Color(0xFFD0BCFF))
                    .weight(1f)
            )
        }
        Row (modifier = Modifier.weight(1f)){
            Quadrant(
                title = stringResource(R.string.row_composable),
                content = stringResource(R.string.a_layout_composable_that_places_its_children_in_a_horizontal_sequence),
                modifier = Modifier
                    .background(color = Color(0xFFB69DF8))
                    .weight(1f)
            )
            Quadrant(
                title = stringResource(R.string.column_composable),
                content = stringResource(R.string.a_layout_composable_that_places_its_children_in_a_vertical_sequence),
                modifier = Modifier
                    .background(color = Color(0xFFF6EDFF))
                    .weight(1f)
            )
        }
    }
}
@Composable
fun Quadrant(title: String, content: String, modifier: Modifier = Modifier){
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))
        Text(text = content, textAlign = TextAlign.Justify)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        GroupedQuadrants()
    }
}