package ru.android.hyrulecompendiumanothermvvm.domain

import androidx.lifecycle.LiveData
import ru.android.hyrulecompendiumanothermvvm.domain.models.HyruleInfo

interface HyruleInteractor {

    fun getHyruleCategory(category: String): LiveData<Result<HyruleInfo>>

}