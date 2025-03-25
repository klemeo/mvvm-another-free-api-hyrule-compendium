package ru.android.hyrulecompendiumanothermvvm.presentation.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.core.view.isGone
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.android.hyrulecompendiumanothermvvm.R
import ru.android.hyrulecompendiumanothermvvm.domain.models.HyruleData

class InfoBottomSheet : BottomSheetDialogFragment() {

    companion object {

        fun newInstance(
            data: HyruleData
        ): InfoBottomSheet = InfoBottomSheet().apply {
            arguments = bundleOf(
                ARG_HYRULE_DATA to data
            )
        }

        const val TAG = "InfoBottomSheet"

        private const val ARG_HYRULE_DATA = "ARG_HYRULE_DATA"

    }

    private val hyruleData by lazy {
        requireArguments().getSerializable(ARG_HYRULE_DATA) as HyruleData
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
        val nameText = view.findViewById<TextView>(R.id.nameText)
        val categoryText = view.findViewById<TextView>(R.id.categoryText)
        val linearLayout = view.findViewById<LinearLayout>(R.id.linearLayout)
        val attackText = view.findViewById<TextView>(R.id.attackText)
        val defenseText = view.findViewById<TextView>(R.id.defenseText)
        val descriptionText = view.findViewById<TextView>(R.id.descriptionText)

        when (hyruleData.category) {
            "equipment" -> {
                attackText.text = hyruleData.properties?.attack.toString()
                defenseText.text = hyruleData.properties?.defense.toString()
            }

            else -> linearLayout.isGone = true
        }
        hyruleData.name?.let { nameText.text = it }
        hyruleData.category?.let { categoryText.text = it }
        hyruleData.description?.let { descriptionText.text = it }
    }

}