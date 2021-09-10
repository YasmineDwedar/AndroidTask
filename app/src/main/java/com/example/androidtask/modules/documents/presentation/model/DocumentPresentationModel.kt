package com.example.androidtask.modules.documents.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Yasmine on September,2021
 */
@Parcelize
data class DocumentPresentationModel (
        val title: String="",
        val author: String="",
        val isbnList: List<String>?= emptyList()
):BaseDocumentsModel(), Parcelable