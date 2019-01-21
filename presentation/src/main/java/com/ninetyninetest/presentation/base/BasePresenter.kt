package com.ninetyninetest.presentation.base


open class BasePresenter<T : BaseView>(protected var view: T?) {


    open fun onViewCreated() {}

    open fun onViewResumed() {}

    open fun onViewDestroyed() {
        view = null
    }

}