package com.fullmanager.app.core

import com.fullmanager.app.core.coroutine.DispatcherProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.job

abstract class BaseViewModel(
    protected open val dispatchers: DispatcherProvider
) {

    protected val viewModelScope = CoroutineScope(
        SupervisorJob() + dispatchers.Main
    )

    open fun onCleared() {
        viewModelScope.coroutineContext.job.cancel()
    }
}
