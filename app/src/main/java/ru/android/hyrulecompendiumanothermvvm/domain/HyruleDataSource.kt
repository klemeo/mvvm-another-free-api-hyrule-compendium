package ru.android.hyrulecompendiumanothermvvm.domain

import ru.android.hyrulecompendiumanothermvvm.domain.models.HyruleInfo

interface HyruleDataSource {

    fun getHyruleCategory(category: String): HyruleInfo

}