package com.jonzarate.clydesdaledirectory.view.directory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.jonzarate.clydesdaledirectory.R
import kotlinx.android.synthetic.main.activity_directory.*

class DirectoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_directory)

        bottom_nav.setupWithNavController(findNavController(R.id.nav_host_fragment))
    }

    override fun onSupportNavigateUp() = findNavController(R.id.nav_host_fragment).navigateUp()
}
