package ru.yandexpraktikum.all_notes.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import ru.yandexpraktikum.all_notes.presentation.AllNotesViewModelFactory
import ru.yandexpraktikum.core.di.CoreDependencies

@AllNotesScope
@Component(
    dependencies = [CoreDependencies::class],
    modules = [AllNotesModule::class])
interface AllNotesComponent {


    fun allNotesViewModelFactory(): AllNotesViewModelFactory

    @Component.Factory
    interface Factory {
        fun create(coreDependencies: CoreDependencies): AllNotesComponent
    }


}