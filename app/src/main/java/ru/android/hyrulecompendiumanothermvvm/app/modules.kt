package ru.android.hyrulecompendiumanothermvvm.app

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.android.hyrulecompendiumanothermvvm.data.HyruleDataSourceImpl
import ru.android.hyrulecompendiumanothermvvm.domain.HyruleDataSource
import ru.android.hyrulecompendiumanothermvvm.domain.HyruleInteractor
import ru.android.hyrulecompendiumanothermvvm.domain.HyruleInteractorImpl
import ru.android.hyrulecompendiumanothermvvm.presentation.category.CategoryViewModel

private val allModules = module {

    single<HyruleDataSource> {
        HyruleDataSourceImpl()
    }

    single<HyruleInteractor> {
        HyruleInteractorImpl(
            hyruleDataSource = get()
        )
    }

    viewModel {
        CategoryViewModel(
            hyruleInteractor = get()
        )
    }

}

val modules = listOf(allModules)
