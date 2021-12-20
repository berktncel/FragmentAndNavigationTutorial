package com.berkt.fragmentandnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.berkt.fragmentandnavigation.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {
    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFirstBinding.bind(view)

        arguments?.let {
            val tempText = FirstFragmentArgs.fromBundle(it).textToArg1
            binding.textDataFrom2.text = tempText
        }

        binding.bt1to2.setOnClickListener {
            val action = FirstFragmentDirections.navigateToSecondFragment(textToArg2 = binding.text1to2.text.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}