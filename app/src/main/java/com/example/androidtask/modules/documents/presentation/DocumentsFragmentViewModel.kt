package com.example.androidtask.modules.documents.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.lifecycleScope
import com.example.androidtask.commons.data.Constants.ITEMS_PER_PAGE
import com.example.androidtask.commons.data.ControlledRunner
import com.example.androidtask.commons.presentation.BaseViewModel
import com.example.androidtask.commons.presentation.extensions.hide
import com.example.androidtask.commons.presentation.extensions.show
import com.example.androidtask.modules.documents.domain.mapper.toPresentationModel
import com.example.androidtask.modules.documents.domain.usecase.SearchByAuthorUseCase
import com.example.androidtask.modules.documents.domain.usecase.SearchByTitleUseCase
import com.example.androidtask.modules.documents.domain.usecase.SearchDocumentsUseCases
import com.example.androidtask.modules.documents.presentation.model.BaseDocumentsModel
import com.example.androidtask.modules.documents.presentation.model.DocumentPresentationModel
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
class DocumentsFragmentViewModel @Inject constructor(
    private val searchDocumentsUseCases: SearchDocumentsUseCases,
    private val searchByAuthorUseCase: SearchByAuthorUseCase,
    private val searchByTitleUseCase: SearchByTitleUseCase
) :
    BaseViewModel() {

    private var _documentsStateFlow = MutableStateFlow<List<BaseDocumentsModel>>(emptyList())
    val documentsStateFlow: StateFlow<List<BaseDocumentsModel>>
        get() = _documentsStateFlow

    private var _hasNextStateFlow = MutableStateFlow<Boolean>(true)
    val hasNextStateFlow: StateFlow<Boolean>
        get() = _hasNextStateFlow

    val search = MutableLiveData("")
    var searchString: String = ""
    var hasNext = true
    var pageNumber = 1
    var responsee = ArrayList<DocumentPresentationModel>()
    private val controlCall = ControlledRunner<Unit>()


    init {
        launchSafeCoroutine {
            search.asFlow().debounce(600L).collect {
                performSearch(it)
            }
        }
    }

    fun getDocumentsSearchResults() {
        launchSafeCoroutine {
            controlCall.cancelPreviousThenRun {
                if (hasNext) {
                    if (pageNumber == 1) _documentsStateFlow.emit(getShimmerList())
                    val result = searchDocumentsUseCases.execute(searchString, pageNumber)
                        .map { it.toPresentationModel() }
                    if (responsee.isEmpty()) {  //First network call
                        responsee.addAll(result)
                        pageNumber++
                        _documentsStateFlow.emit(result)
                    } else {                  // SecondOrMore network call
                        if (result.size == ITEMS_PER_PAGE) {
                            pageNumber++
                            val oldProducts = responsee
                            oldProducts.addAll(result)
                            _documentsStateFlow.emit(oldProducts.toList())
                        } else if (result.size < ITEMS_PER_PAGE) {
                            val oldProducts = responsee
                            oldProducts.addAll(result)
                            _documentsStateFlow.emit(oldProducts)
                            hasNext = false
                            _hasNextStateFlow.emit(false)
                        }
                    }
                }
            }
        }
    }

    private fun getShimmerList(): List<DocumentsShimmerModel> {
        return (1..10).map {
            DocumentsShimmerModel()
        }
    }

    private fun performSearch(search: String) {
        if (searchString == search.trim()) return
        if (search.isNotBlank()) {
            searchString = search
            launchSafeCoroutine {
                initializePagination()
            }
        } else {
            searchString = ""
            launchSafeCoroutine {
                _documentsStateFlow.emit(emptyList())
            }
        }
    }

    private fun initializePagination() {
        launchSafeCoroutine {
            responsee.clear()
            pageNumber = 1
            hasNext = true
            getDocumentsSearchResults()
        }
    }

     fun getSearchResultsFromTitle(title: String) {
        launchSafeCoroutine {
           val results= searchByTitleUseCase.execute(title).map { it.toPresentationModel() }
            _documentsStateFlow.emit(results)
        }
    }

     fun getSearchResultsFromAuthor(author: String) {
        launchSafeCoroutine {
          val results= searchByAuthorUseCase.execute(author).map { it.toPresentationModel() }
            _documentsStateFlow.emit(results)
        }
    }
}


