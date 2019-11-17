package com.dbs.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dbs.base.Repository

/**
 * Factory for ViewModels
 */
class ViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(SearchViewModel::class.java) -> @Suppress("UNCHECKED_CAST")
            return SearchViewModel(repository) as T

        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}