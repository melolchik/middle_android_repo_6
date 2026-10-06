package ru.yandexpraktikum.core.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.yandexpraktikum.core.domain.repository.NotesRepository
import ru.yandexpraktikum.core.presentation.mappers.PresentationNoteMapper
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class])
interface CoreComponent : CoreDependencies{

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }
}