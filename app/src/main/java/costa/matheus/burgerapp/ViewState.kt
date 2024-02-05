package costa.matheus.burgerapp

sealed class ViewState<out T> {

    object Loading: ViewState<Nothing>()

    data class Success<T>(val data: T?): ViewState<T>()

    data class Error(val throwable: Throwable): ViewState<Nothing>()
}