package az.khayalsharifli.jetpacknavigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import az.khayalsharifli.jetpacknavigation.databinding.FragmentGlobalBinding

class GlobalFragment : Fragment() {

    private lateinit var binding: FragmentGlobalBinding
    private lateinit var navController: NavController
    private val args by navArgs<GlobalFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentGlobalBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        binding.toolbar.setNavigationOnClickListener { navController.popBackStack() }
        binding.textView2.text = args.string
    }
}