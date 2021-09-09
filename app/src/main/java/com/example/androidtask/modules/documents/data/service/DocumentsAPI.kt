package com.example.androidtask.modules.documents.data.service

import com.example.androidtask.modules.documents.data.model.response.DocumentResponse
import com.example.androidtask.utils.Constants.SEARCH
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Yasmine on September,2021
 */
interface DocumentsAPI {
    @GET(SEARCH)
    suspend fun getDocumentsSearchResults(
            @Query("q") searchText:String?,
            @Query("page") page:Int=1
    ): DocumentResponse
}