package com.example.androiddevchallenge

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.Module
import com.example.androiddevchallenge.data.Pet

class PetViewModel : ViewModel() {
    var pets by mutableStateOf(
        listOf(
            Pet("cici", "Ragdoll", "eat,sleep", R.drawable.ragdoll),
            Pet("sun", "Tabby ", "eat", R.drawable.tabby),
            Pet("tim", "Golden hair", "play,eat", R.drawable.golden_hair),
            Pet("cat", "Devon", "play", R.drawable.devon),
        )
    )

    var openModule: Module? by mutableStateOf(null)

    var currentPet: Pet? by mutableStateOf(null)

    fun startPetDetail(pet: Pet) {
        currentPet = pet
        openModule = Module.PetDetail
    }

    fun closePetDetail() {
        openModule = null
    }
}