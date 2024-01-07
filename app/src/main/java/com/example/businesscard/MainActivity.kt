package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import com.example.businesscard.ui.theme.background
import com.example.businesscard.ui.theme.iconColor
import com.example.businesscard.ui.theme.titleColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(150.dp))
        PersonDetails()
        Spacer(modifier = Modifier.height(180.dp))
        ContactInformationDetails()
    }
}

@Composable
fun PersonDetails() {
    val image = painterResource(id = R.drawable.man_4140048)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        )
    {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.width(200.dp).height(200.dp)
        )

        Text(text = stringResource(R.string.name),
            modifier = Modifier.padding(bottom = 8.dp, top = 15.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )

        Text(text = stringResource(R.string.title),
            color = titleColor,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp))
    }
}

@Composable
fun ContactInformationDetails() {
    Column {
        IconWithText(
            iconResource = R.drawable.phone_iphone_fill1_wght400_grad0_opsz24,
            textResource = R.string.phone
        )

        IconWithText(
            iconResource = R.drawable.share_fill1_wght400_grad0_opsz24,
            textResource = R.string.social_media
        )

        IconWithText(
            iconResource = R.drawable.send_fill1_wght400_grad0_opsz24,
            textResource = R.string.email
        )
    }
}

@Composable
fun IconWithText(iconResource: Int, textResource: Int) {
    Row(Modifier.padding(bottom = 5.dp)) {
        Icon(
            painter = painterResource(id = iconResource),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 20.dp),
            tint = iconColor
        )
        Text(
            text = stringResource(id = textResource),
            fontWeight = FontWeight.Normal
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_2_XL)
@Composable
fun Preview() {
    BusinessCardTheme {
        BusinessCard()
    }
}