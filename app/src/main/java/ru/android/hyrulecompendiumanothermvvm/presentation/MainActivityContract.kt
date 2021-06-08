package ru.android.hyrulecompendiumanothermvvm.presentation

interface MainActivityContract : CategoryScreen

interface CategoryScreen {
    fun openCategoryScreen(category: String)
}