package com.berkt.fragmentandnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.berkt.fragmentandnavigation.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {
    private var _binding: FragmentSecondBinding? = null
    private val binding: FragmentSecondBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSecondBinding.bind(view)

        arguments?.let {
            val tempText = SecondFragmentArgs.fromBundle(it).textToArg2
            binding.textDataFrom1.text = tempText
        }

        binding.bt2to1.setOnClickListener {
            val action = SecondFragmentDirections.navigateToFirstFragment(textToArg1 = binding.text2to1.text.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}