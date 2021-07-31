package com.aa.speedviewtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.aa.speedviewtest.databinding.MyFragmentBinding

class MyFragment : Fragment() {
    lateinit var binding: MyFragmentBinding
    val score: MutableLiveData<String> by lazy { MutableLiveData("0") }
    val score2: MutableLiveData<String> by lazy { MutableLiveData("0") }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.my_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(BR.view, this)
        binding.executePendingBindings()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sm = binding.speedView
        sm.onSpeedChangeListener = { gauge, _, _ ->
            score.value = gauge.currentIntSpeed.toString()
        }
        val sm2 = binding.speedView2
        sm2.onSpeedChangeListener = { gauge, _, _ ->
            score2.value = gauge.currentIntSpeed.toString()
        }
        binding.speedTo.setOnClickListener {
            sm.speedTo(85f, 10000)
            sm2.speedTo(85f, 10000)
        }
    }

}