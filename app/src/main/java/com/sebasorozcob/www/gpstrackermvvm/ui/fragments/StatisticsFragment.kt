package com.sebasorozcob.www.gpstrackermvvm.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sebasorozcob.www.gpstrackermvvm.R
import com.sebasorozcob.www.gpstrackermvvm.viewmodels.MainViewModel
import com.sebasorozcob.www.gpstrackermvvm.viewmodels.StatisticsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatisticsFragment: Fragment(R.layout.fragment_statistics) {

    private val viewModel: StatisticsViewModel by viewModels()

}