package com.sebasorozcob.www.gpstrackermvvm.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.sebasorozcob.www.gpstrackermvvm.R
import com.sebasorozcob.www.gpstrackermvvm.databinding.ActivityMainBinding
import com.sebasorozcob.www.gpstrackermvvm.util.Constants.ACTION_SHOW_TRACKING_FRAGMENT
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateToTrackingFragmentIfNeeded(intent)

        setSupportActionBar(binding.toolbar)
        with(binding) {
            bottomNavigationView.setupWithNavController(
                flFragment.findViewById<View>(
                    R.id.navHostFragment
                ).findNavController()
            )

            flFragment.findViewById<View>(
                R.id.navHostFragment
            ).findNavController().addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.settingsFragment, R.id.runFragment, R.id.statisticsFragment ->
                        bottomNavigationView.visibility = View.VISIBLE
                    else -> bottomNavigationView.visibility = View.GONE
                }
            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navigateToTrackingFragmentIfNeeded(intent)
    }

    private fun navigateToTrackingFragmentIfNeeded(intent: Intent?) {
        if (intent?.action == ACTION_SHOW_TRACKING_FRAGMENT) {
            binding.flFragment.findViewById<View>(R.id.navHostFragment).findNavController()
                .navigate(R.id.action_global_trackingFragment)
        }
    }
}