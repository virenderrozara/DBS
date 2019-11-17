package com.dbs.base

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.dbs.WebService
import com.dbs.viewmodel.ViewModelFactory

object Injection {
    /**
     * Creates an instance of [Repository] based on the [WebService]
     */
    private fun provideRepository(context: Context): Repository {
        return Repository(WebService.create())
    }

    /**
     * Provides the [ViewModelProvider.Factory] that is then used to get a reference to
     * [ViewModel] objects.
     */
    fun provideViewModelFactory(context: Context): ViewModelProvider.Factory {
        return ViewModelFactory(provideRepository(context))
    }


}