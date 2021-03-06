package com.procreation.navigationarchitecturecomponent


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_fragment3.*

/**
 * A simple [Fragment] subclass.
 */
class Fragment3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_back.setOnClickListener {
            (activity as MainActivity).onFragment3BackClick()
        }

        btn_next.setOnClickListener {
            (activity as MainActivity).onFragment3NextClick()
        }
    }
}
