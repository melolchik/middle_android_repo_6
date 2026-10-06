package ru.yandexpraktikum.add_note.di

import dagger.Binds
import dagger.Module
import ru.yandexpraktikum.add_note.domain.interactors.AddNoteInteractor
import ru.yandexpraktikum.add_note.domain.interactors.AddNoteInteractorImpl

@Module
interface AddNoteModule {

    @AddNoteScope
    @Binds
    fun bindAddNoteInteractor(impl : AddNoteInteractorImpl) : AddNoteInteractor
}