package com.sebasorozcob.www.gpstrackermvvm.ui.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.sebasorozcob.www.gpstrackermvvm.R
import com.sebasorozcob.www.gpstrackermvvm.databinding.FragmentSettingsBinding
import com.sebasorozcob.www.gpstrackermvvm.util.Constants.KEY_NAME
import com.sebasorozcob.www.gpstrackermvvm.util.Constants.KEY_WEIGHT
import com.sebasorozcob.www.gpstrackermvvm.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private val viewModel: MainViewModel by viewModels()

    private var _binding: FragmentSettingsBinding? = null
    val binding get() = _binding!!

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadFieldsFromSharedPref()

        binding.btnApplyChanges.setOnClickListener {
            val success = applyChangesToSharedPref()

            if (success) {
                Snackbar.make(view, "Saved changes", Snackbar.LENGTH_LONG).show()
            } else {
                Snackbar.make(view, "Please fill out all fields", Snackbar.LENGTH_LONG).show()
            }
        }
    }

    private fun loadFieldsFromSharedPref() {
        val name = sharedPreferences.getString(KEY_NAME, "")
        val weight = sharedPreferences.getFloat(KEY_WEIGHT, 80f)
        binding.etName.setText(name)
        binding.etWeight.setText(weight.toString())
    }

    private fun applyChangesToSharedPref(): Boolean {
        val nameText = binding.etName.text.toString()
        val weight = binding.etWeight.text.toString()

        if (nameText.isEmpty() || weight.isEmpty()) {
            return false
        }

        sharedPreferences.edit()
            .putString(KEY_NAME, nameText)
            .putFloat(KEY_WEIGHT, weight.toFloat())
            .apply()
        val toolbarText = "Let's go $nameText"

        requireActivity().findViewById<TextView>(R.id.tvToolbarTitle).text = toolbarText
        return true
    }

}