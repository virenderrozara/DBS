package com.dbs.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.dbs.base.BaseActivity
import com.dbs.base.Injection
import com.dbs.base.Repository
import com.dbs.network.BaseResponse


open class SearchViewModel(private val repo: Repository) : ViewModel() {
    /**
     * set all error
     */
    fun getError(): LiveData<String> {

        return repo.getError()
    }
    fun getDataError(): LiveData<BaseResponse> {

        return repo.getDataError()
    }
    fun getPsiInfo(keyword : String): LiveData<BaseResponse> {

        return repo.getSearchData(keyword)

    }


    companion object {
        fun getInstance(activity: BaseActivity): SearchViewModel {

            return ViewModelProviders.of(activity).get(SearchViewModel::class.java)
        }
        fun create(activity: BaseActivity): SearchViewModel {

            return ViewModelProviders.of(activity, Injection.provideViewModelFactory(activity)).get(SearchViewModel::class.java)
        }
    }

}