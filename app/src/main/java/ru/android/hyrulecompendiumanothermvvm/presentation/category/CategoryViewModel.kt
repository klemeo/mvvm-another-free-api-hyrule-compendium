package ru.android.hyrulecompendiumanothermvvm.presentation.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ru.android.hyrulecompendiumanothermvvm.base.ResultObserverDelegate
import ru.android.hyrulecompendiumanothermvvm.domain.HyruleInteractor
import ru.android.hyrulecompendiumanothermvvm.domain.models.HyruleInfo

class CategoryViewModel(
    private val hyruleInteractor: HyruleInteractor
) : ViewModel() {

    var hyrule = MutableLiveData<HyruleInfo?>()

    private var getCategoryObserver = Observer<Result<HyruleInfo>> { result ->
        handleCategoryResult(result)
    }

    private var getCategoryLiveData: LiveData<Result<HyruleInfo>>?
            by ResultObserverDelegate(getCategoryObserver)

    fun getCategory(category: String) {
        getCategoryLiveData = hyruleInteractor.getHyruleCategory(category)
    }

    private fun handleCategoryResult(result: Result<HyruleInfo>) {
        result
            .onSuccess {
                hyrule.postValue(it)
            }
            .onFailure {

            }
    }

}