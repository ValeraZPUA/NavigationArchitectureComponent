package com.procreation.navigationarchitecturecomponent


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_fragment2.*

/**
 * A simple [Fragment] subclass.
 */
class Fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*btn_next.setOnClickListener {
            //(activity as MainActivity).onFragment2NextClick()
            Navigation.findNavController(view).navigate(R.id.action_fragment2_to_fragment3)
        }*/
        btn_next.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_fragment2_to_fragment3))

        btn_back.setOnClickListener {
            (activity as MainActivity).onFragment2BackClick()
        }

        val fragment2Args = Fragment2Args.fromBundle(arguments!!)
        val str = fragment2Args.arg1
        tv_from_f1.text = str
    }
}
