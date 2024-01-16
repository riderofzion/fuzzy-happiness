package com.example.mod8tpbonus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.mod8tpbonus.databinding.ActivityLaunchDiceBinding

class LaunchDiceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLaunchDiceBinding
    val vm by viewModels<LaunchDiceVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchDiceBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.vm = vm
        binding.lifecycleOwner = this
    }
}