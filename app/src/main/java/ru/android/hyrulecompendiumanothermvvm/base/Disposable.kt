package ru.android.hyrulecompendiumanothermvvm.base

interface Disposable {
    /**
     * Cancel running jobs.
     */
    fun dispose()
}