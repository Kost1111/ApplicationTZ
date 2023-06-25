package com.example.myapplication_tz.first_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import com.example.myapplication_tz.KEY_SUM
import com.example.myapplication_tz.R
import com.example.myapplication_tz.base_fragment.BaseFragment
import com.example.myapplication_tz.databinding.FragmentFirstBinding
import com.example.myapplication_tz.second_fragment.SecondFragment


class FirstFragment : BaseFragment<FragmentFirstBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    FragmentFirstBinding =
        FragmentFirstBinding::inflate

    private lateinit var vm: FirstFragmentViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = Bundle()
        vm = FirstFragmentViewModel()
        binding.navigationButton.setOnClickListener {
            if (binding.firstNumber.text.isEmpty() || binding.secondNumber.text.isEmpty()) {
                bundle.putInt(KEY_SUM, 0)
                goToSecondFragment(bundle = bundle)
            } else {
                vm.setFirstNumber(binding.firstNumber.text.toString().toInt())
                vm.setSecondNumber(binding.secondNumber.text.toString().toInt())
                bundle.putInt(
                    KEY_SUM,
                    vm.sumNumber()
                )
                goToSecondFragment(bundle = bundle)
            }
        }
    }

    private fun goToSecondFragment(bundle: Bundle) {
        fragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_container, SecondFragment().apply {
                arguments = bundle
            })
            ?.commit()
    }
}