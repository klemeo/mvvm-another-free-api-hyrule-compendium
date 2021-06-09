package ru.android.hyrulecompendiumanothermvvm.presentation.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_fragment.*
import ru.android.hyrulecompendiumanothermvvm.R
import ru.android.hyrulecompendiumanothermvvm.base.args

class InfoBottomSheet : BottomSheetDialogFragment() {

    companion object {

        fun newInstance(
            name: String? = null,
            category: String? = null,
            description: String? = null,
            attack: Int? = null,
            defense: Int? = null
        ) = InfoBottomSheet().args {

            name?.let { putString(ARG_NAME, it) }
            category?.let { putString(ARG_CATEGORY, it) }
            description?.let { putString(ARG_DESCRIPTION, it) }
            attack?.let { putInt(ARG_ATTACK, it) }
            defense?.let { putInt(ARG_DEFENSE, it) }

        }

        const val TAG = "InfoBottomSheet"

        private const val ARG_NAME = "ARG_NAME"
        private const val ARG_CATEGORY = "ARG_CATEGORY"
        private const val ARG_DESCRIPTION = "ARG_DESCRIPTION"
        private const val ARG_ATTACK = "ARG_ATTACK"
        private const val ARG_DEFENSE = "ARG_DEFENSE"

    }

    private val name by lazy {
        arguments?.getString(ARG_NAME)
    }

    private val category by lazy {
        arguments?.getString(ARG_CATEGORY)
    }

    private val description by lazy {
        arguments?.getString(ARG_DESCRIPTION)
    }

    private val attack by lazy {
        arguments?.getInt(ARG_ATTACK).toString()
    }

    private val defense by lazy {
        arguments?.getInt(ARG_DEFENSE).toString()
    }

    override fun getTheme(): Int {
        return R.style.CustomBottomSheetDialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.bottom_sheet_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when (category) {
            "equipment" -> {
                attackText.text = attack
                defenseText.text = defense
            }
            else -> linearLayout.isGone = true
        }
        name?.let { nameText.text = it }
        category?.let { categoryText.text = it }
        description?.let { descriptionText.text = it }
    }

}