package com.example.androidtask.modules.documents.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.lifecycleScope
import com.example.androidtask.commons.presentation.BaseViewModel
import com.example.androidtask.commons.presentation.extensions.hide
import com.example.androidtask.commons.presentation.extensions.show
import com.example.androidtask.modules.documents.domain.mapper.toPresentationModel
import com.example.androidtask.modules.documents.domain.usecase.SearchDocumentsUseCases
import com.example.androidtask.modules.documents.presentation.model.BaseDocumentsModel
import com.example.androidtask.modules.documents.presentation.model.DocumentsShimmerModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Yasmine on September,2021
 */
class DocumentsFragmentViewModel @Inject constructor(private val searchDocumentsUseCases: SearchDocumentsUseCases) :
    BaseViewModel() {

    private var _documentsStateFlow = MutableStateFlow<List<BaseDocumentsModel>>(emptyList())
    val documentsStateFlow: StateFlow<List<BaseDocumentsModel>>
        get() = _documentsStateFlow

    val search = MutableLiveData("")
    var searchString: String = ""

    init {
        launchSafeCoroutine {
            search.asFlow().debounce(600L).collect {
                performSearch(it)
            }
        }
    }

    fun getDocumentsSearchResults(search: String, page: Int) {
        launchSafeCoroutine {
            _documentsStateFlow.emit(getShimmerList())
            _documentsStateFlow.emit(
                searchDocumentsUseCases.execute(search = search, page = page).map {
                    it.toPresentationModel()
                })

        }
    }

    private fun getShimmerList(): List<DocumentsShimmerModel> {
        return (1..10).map {
            DocumentsShimmerModel()
        }
    }

    private fun performSearch(search: String) {
        if (searchString == search) return
        if (search.isNotBlank()) {
            searchString = search
            getDocumentsSearchResults(search = searchString, page = 1)
        } else {
            searchString = ""
            launchSafeCoroutine {

                _documentsStateFlow.emit(emptyList())
            }
        }
    }

}


