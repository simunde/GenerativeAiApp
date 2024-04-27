package com.msid.generativeaiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.ai.client.generativeai.GenerativeModel
import com.msid.generativeaiapp.databinding.ActivityMainBinding
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSubmit.setOnClickListener {

            val userPrompt = binding.edtUserPrompt.text.toString()
            val generativeModel = GenerativeModel(
                // Use a model that's applicable for your use case (see "Implement basic use cases" below)
                modelName = "gemini-pro",
                // Access your API key as a Build Configuration variable (see "Set up your API key" above)
                apiKey = " "
            )

            runBlocking {
                val response = generativeModel.generateContent(userPrompt)
                binding.tvResult.text = response.text
            }


        }
    }
}


//AIzaSyDr2sjL2ehPnb7Hj0XM9DriAjo5VYe8oQQ