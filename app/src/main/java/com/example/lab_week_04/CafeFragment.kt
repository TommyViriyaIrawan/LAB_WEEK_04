package com.example.lab_week_04

// CafeFragment.kt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2 // Make sure you have this import
// Import your adapter
// import com.example.lab_week_04.YourViewPagerAdapter

class CafeFragment : Fragment() {

    private var viewPager: ViewPager2? = null // Declare as nullable if accessing before onViewCreated
    // or use lateinit if sure it will be initialized in onViewCreated

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cafe, container, false) // Replace R.layout.fragment_cafe with your actual layout file
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize viewPager by finding it in the inflated view
        viewPager = view.findViewById(R.id.cafeViewPager) // Replace R.id.your_viewpager_id with the ID from your XML

        // NOW it's safe to set the adapter (around your original line 38)
        if (viewPager != null) {
            // val myAdapter = YourViewPagerAdapter(this) // Initialize your adapter
            // viewPager?.adapter = myAdapter
            // The line that likely caused the crash was similar to:
            // viewPager.setAdapter(yourAdapterInstance) // This would crash if viewPager was null
        } else {
            // Log an error or handle the case where the ViewPager2 is not found
            // Log.e("CafeFragment", "ViewPager2 not found in the layout!")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewPager = null // Optional: Clear the reference to avoid memory leaks
    }
}