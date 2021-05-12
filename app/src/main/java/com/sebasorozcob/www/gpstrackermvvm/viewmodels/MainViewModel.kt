package com.sebasorozcob.www.gpstrackermvvm.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.sebasorozcob.www.gpstrackermvvm.db.Run
import com.sebasorozcob.www.gpstrackermvvm.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository,
    application: Application
) : AndroidViewModel(application) {

    val runsSortedByDate = repository.getAllRunsSortedByDate()

    fun insertRun(run: Run) = viewModelScope.launch {
        repository.insertRun(run)
    }

}