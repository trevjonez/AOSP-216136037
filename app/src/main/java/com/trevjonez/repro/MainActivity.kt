package com.trevjonez.repro

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.trevjonez.repro.databinding.ActivityMainBinding
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        var explode = true
        val splash = installSplashScreen()
        splash.setOnExitAnimationListener { provider ->
            Log.w("MainActivity", "On exit callback")
            provider.remove()
            binding.boom.text = "Ehh Boom!"
            explode = false
        }
        var count = 0
        splash.setKeepOnScreenCondition {
            count++
            Log.w("MainActivity", "count: $count")
            count < 10
        }
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launchWhenResumed {
            delay(1000)
            if(explode) error("Should be unreachable on all api levels")
        }
    }
}