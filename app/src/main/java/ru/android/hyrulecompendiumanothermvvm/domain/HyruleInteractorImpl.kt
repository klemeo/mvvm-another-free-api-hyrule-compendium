package ru.android.hyrulecompendiumanothermvvm.domain

import androidx.lifecycle.LiveData
import ru.android.hyrulecompendiumanothermvvm.base.CoroutineInteractor
import ru.android.hyrulecompendiumanothermvvm.base.scopedLiveData
import ru.android.hyrulecompendiumanothermvvm.domain.models.HyruleInfo

class HyruleInteractorImpl(
    private val hyruleDataSource: HyruleDataSource
) : CoroutineInteractor(), HyruleInteractor {

    override fun getHyruleCategory(category: String): LiveData<Result<HyruleInfo>> =
        scopedLiveData {
            try {
                val result = hyruleDataSource.getHyruleCategory(category)
                emit(Result.success(result))
            } catch (e: Exception) {

            }
        }

}