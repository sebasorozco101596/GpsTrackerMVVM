package com.sebasorozcob.www.gpstrackermvvm.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.sebasorozcob.www.gpstrackermvvm.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository,
    application: Application
) : AndroidViewModel(application) {
}