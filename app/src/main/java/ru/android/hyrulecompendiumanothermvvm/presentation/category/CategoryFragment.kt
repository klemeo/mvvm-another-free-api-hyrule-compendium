package ru.android.hyrulecompendiumanothermvvm.presentation.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.android.hyrulecompendiumanothermvvm.R
import ru.android.hyrulecompendiumanothermvvm.databinding.FragmentCategoryBinding
import ru.android.hyrulecompendiumanothermvvm.domain.models.HyruleData

class CategoryFragment : Fragment() {

    private val viewModel: CategoryViewModel by viewModel()

    private val navArgs by navArgs<CategoryFragmentArgs>()

    private val categoryAdapter = CategoryAdapter(HyruleListener {
        showDialog(it)
    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DataBindingUtil.inflate<FragmentCategoryBinding>(
        inflater,
        R.layout.fragment_category,
        container,
        false
    ).apply {
        viewModel = this@CategoryFragment.viewModel
        lifecycleOwner = viewLifecycleOwner

    }
        .root

    private var buttonBack: Button? = null
    private var recyclerView: RecyclerView? = null
    private var pbPost: ProgressBar? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(view) {
            buttonBack = findViewById(R.id.buttonBack)
            recyclerView = findViewById(R.id.recyclerView)
            pbPost = findViewById(R.id.pbPost)
        }

        initView()
        observeViewModel()
    }

    private fun initView() {
        viewModel.getCategory(navArgs.category)

        recyclerView?.apply {
            val manager = GridLayoutManager(activity, 2)
            layoutManager = manager
            adapter = categoryAdapter
        }
        buttonBack?.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }

    }

    private fun observeViewModel() {
        viewModel.hyrule.observe(viewLifecycleOwner, {
            if (it != null) {
                it.data?.let { data -> categoryAdapter.addHeaderAndSubmitList(data) }
                pbPost?.isGone = true
            }
        })
    }

    private fun showDialog(data: HyruleData) {
        InfoBottomSheet.newInstance(
            data = data
        ).show(childFragmentManager, InfoBottomSheet.TAG)
    }

}