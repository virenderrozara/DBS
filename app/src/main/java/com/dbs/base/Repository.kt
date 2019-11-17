package com.dbs.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dbs.WebService
import com.dbs.network.BaseResponse

/**
 * class that implement Webservice Api
 */
open class Repository(private val service: WebService) {

    private var mError: MutableLiveData<String> = MutableLiveData()
    val statusCode: MutableLiveData<Int> = MutableLiveData()
    fun getError(): LiveData<String> {
        mError = MutableLiveData()
        return mError
    }

    fun getData(): String {
        return "name"
    }

    private var mDataError: MutableLiveData<BaseResponse> = MutableLiveData()

    fun getDataError(): LiveData<BaseResponse> {
        mDataError = MutableLiveData()
        return mDataError
    }


    fun getSearchData(keyWord: String): LiveData<BaseResponse> {
        val data = MutableLiveData<BaseResponse>()

        service.getSearchData(keyWord).enqueue(object : BaseCallback<BaseResponse>() {
            override fun onSuccess(response: BaseResponse?) {
                data.value = response
            }
            override fun onFail(baseResponse: BaseResponse?) {
                mDataError.value = baseResponse
            }

        })
        return data

    }


}