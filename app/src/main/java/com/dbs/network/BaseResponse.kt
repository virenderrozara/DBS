package com.dbs.network

import com.dbs.network.response.Result

open class BaseResponse {
     var resultCount: Int=0
    lateinit var results: ArrayList<Result>
}
