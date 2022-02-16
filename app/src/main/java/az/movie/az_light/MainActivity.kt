package az.movie.az_light

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import az.movie.az_light.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import androidx.fragment.app.viewModels

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initMain()
    }

    private fun initMain() = with(binding) {
        btnLight.setOnClickListener {
            changeColor(viewModel.turn)
            turn(viewModel.turn)
        }
    }

    private fun changeColor(turn: Boolean) = with(binding) {
        if (turn) {
            root.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.grey_l))
        } else {
            root.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.yellow_l))
        }
    }

    private fun turn(turn: Boolean) {
        lifecycleScope.launch {
            changeColor(turn)
            viewModel.turn(turn)
        }
    }
}
