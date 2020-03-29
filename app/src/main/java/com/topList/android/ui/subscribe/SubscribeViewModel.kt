package com.topList.android.ui.subscribe

import androidx.lifecycle.*
import com.topList.android.base.BaseViewModel
import com.topList.android.ui.subscribe.domain.SubscribeUseCase
import com.topList.android.ui.subscribe.model.SubscribeUseItem

class SubscribeViewModel(
    private val subscribeUserCase: SubscribeUseCase
) : BaseViewModel() {

    fun fetchSubscribeItems(): LiveData<SubscribeUseItem> {
        return liveData {
            emit(subscribeUserCase())
        }.map {
            SubscribeHelper.getCategoryData(it)
        }
    }
}

class SubscribeViewModelFactory(
    private val subscribeUserCase: SubscribeUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SubscribeViewModel(subscribeUserCase) as T
    }
}
