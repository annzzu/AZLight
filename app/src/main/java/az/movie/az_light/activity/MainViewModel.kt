package az.movie.az_light.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import az.movie.az_light.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    var turn: Boolean = false

    suspend fun turn(turn: Boolean) = viewModelScope.launch {
        repository.turn(turn)
        this@MainViewModel.turn = !turn
    }
}