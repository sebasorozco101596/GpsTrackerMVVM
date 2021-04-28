package com.sebasorozcob.www.gpstrackermvvm.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sebasorozcob.www.gpstrackermvvm.R
import com.sebasorozcob.www.gpstrackermvvm.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrackingFragment: Fragment(R.layout.fragment_tracking) {

    private val viewModel: MainViewModel by viewModels()

}