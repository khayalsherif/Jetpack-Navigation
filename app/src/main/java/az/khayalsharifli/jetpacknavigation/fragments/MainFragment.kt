package az.khayalsharifli.jetpacknavigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import az.khayalsharifli.jetpacknavigation.R
import az.khayalsharifli.jetpacknavigation.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()

        binding.buttonGoToSecond.setOnClickListener {
            navController.navigate(MainFragmentDirections.actionMainFragmentToSecondFragment("This text has been sent from the main screen"))
        }

        binding.buttonGoToGlobal.setOnClickListener {
            val bundle = bundleOf("string" to "Came from Main Fragment")
            navController.navigate(R.id.action_to_global_fragment, bundle)
        }
    }

}