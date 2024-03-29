package az.khayalsharifli.jetpacknavigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import az.khayalsharifli.jetpacknavigation.R
import az.khayalsharifli.jetpacknavigation.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private lateinit var binding: FragmentThirdBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        binding.toolbar.setNavigationOnClickListener { navController.popBackStack() }
        binding.buttonGoToGlobal.setOnClickListener {
            val bundle = bundleOf("string" to "Came from Third Fragment")
            navController.navigate(R.id.action_to_global_fragment, bundle)
        }
    }

}