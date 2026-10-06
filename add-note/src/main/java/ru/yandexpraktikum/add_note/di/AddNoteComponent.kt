package ru.yandexpraktikum.add_note.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import ru.yandexpraktikum.add_note.presentation.AddNoteViewModelFactory
import ru.yandexpraktikum.core.di.CoreComponent
import ru.yandexpraktikum.core.di.CoreDependencies


@AddNoteScope
@Component(dependencies = [CoreDependencies::class], modules = [AddNoteModule::class])
interface AddNoteComponent {


    fun getAddNoteViewModelFactory(): AddNoteViewModelFactory
    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreDependencies): AddNoteComponent
    }
}