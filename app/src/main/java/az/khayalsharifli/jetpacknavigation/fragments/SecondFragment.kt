package az.khayalsharifli.jetpacknavigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import az.khayalsharifli.jetpacknavigation.R
import az.khayalsharifli.jetpacknavigation.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var navController: NavController
    private val args by navArgs<SecondFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        binding.textView.text = args.string
        binding.toolbar.setNavigationOnClickListener { navController.popBackStack() }
        binding.buttonGoToThird.setOnClickListener { navController.navigate(R.id.action_secondFragment_to_thirdFragment) }

        binding.buttonGoToGlobal.setOnClickListener {
            val bundle = bundleOf("string" to "Came from Second Fragment")
            navController.navigate(R.id.action_to_global_fragment, bundle)
        }
    }

}