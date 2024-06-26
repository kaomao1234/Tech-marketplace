package com.example.tech_marketplace.views.home.categories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.tech_marketplace.viewmodels.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CategoriesHome(navController: NavController, viewModel: HomeViewModel) {
    val onBack: () -> Unit = {
        navController.popBackStack()
    }
    Scaffold(modifier = Modifier.fillMaxSize(), containerColor = Color.White) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {
            IconButton(
                onClick = onBack, colors = IconButtonDefaults.iconButtonColors(
                    contentColor = Color.Black
                )
            ) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.size(27.dp)
                )

            }
            Spacer(modifier = Modifier.height(26.dp))
            Text(
                "Categories",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(
                modifier = Modifier
                    .padding()
                    .fillMaxSize(),
                contentPadding = PaddingValues(top = 8.dp, start = 8.dp, end = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(viewModel.categories.size) {
                    val item = viewModel.categories[it]
                    ElevatedButton(
                        onClick = {
                            viewModel.onCategoryPress(item,
                                {
                                    if (item == viewModel.cateInfoLabel.value) {
                                        navController.navigate("category_info")
                                    }
                                })
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(77.dp),
                        colors = ButtonDefaults.elevatedButtonColors(
                            contentColor = Color.Black,
                            containerColor = Color.White
                        ),
                        shape = RoundedCornerShape(6.dp),
                        elevation = ButtonDefaults.elevatedButtonElevation(
                            defaultElevation = 4.dp
                        ),
                        contentPadding = PaddingValues(horizontal = 20.dp)
                    ) {
                        Text(
                            text = item,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Start
                        )
                    }
                }
            }

        }
    }
}