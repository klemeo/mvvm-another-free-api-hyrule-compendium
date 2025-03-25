package ru.android.hyrulecompendiumanothermvvm.data

import ru.android.hyrulecompendiumanothermvvm.base.RetrofitDataSource
import ru.android.hyrulecompendiumanothermvvm.data.converters.toDomain
import ru.android.hyrulecompendiumanothermvvm.domain.HyruleDataSource
import ru.android.hyrulecompendiumanothermvvm.domain.models.HyruleInfo

class HyruleDataSourceImpl : HyruleDataSource, RetrofitDataSource {

    override fun getHyruleCategory(category: String): HyruleInfo {
        val result = executeWithResponse {
            HyruleApiClient.getApiClient().getCompendiumCharacters(category)
        }
        return result.toDomain()
    }

}