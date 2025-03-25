package ru.android.hyrulecompendiumanothermvvm.presentation.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import ru.android.hyrulecompendiumanothermvvm.R
import ru.android.hyrulecompendiumanothermvvm.base.FragmentListenerUtils
import ru.android.hyrulecompendiumanothermvvm.databinding.FragmentHomeBinding
import ru.android.hyrulecompendiumanothermvvm.presentation.MainActivityContract

class HomeFragment : Fragment() {

    private lateinit var homeListener: MainActivityContract

    override fun onAttach(context: Context) {
        super.onAttach(context)
        homeListener =
            FragmentListenerUtils.getFragmentListener(this, MainActivityContract::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )
        return binding.root
    }

    private var monstersButton: Button? = null
    private var treasureButton: Button? = null
    private var materialsButton: Button? = null
    private var equipmentButton: Button? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(view) {
            monstersButton = findViewById(R.id.monstersButton)
            treasureButton = findViewById(R.id.treasureButton)
            materialsButton = findViewById(R.id.materialsButton)
            equipmentButton = findViewById(R.id.equipmentButton)
        }

        initView()
    }

    private fun initView() {
        monstersButton?.setOnClickListener {
            homeListener.openCategoryScreen("monsters")
        }
        treasureButton?.setOnClickListener {
            homeListener.openCategoryScreen("treasure")
        }
        materialsButton?.setOnClickListener {
            homeListener.openCategoryScreen("materials")
        }
        equipmentButton?.setOnClickListener {
            homeListener.openCategoryScreen("equipment")
        }
    }

}