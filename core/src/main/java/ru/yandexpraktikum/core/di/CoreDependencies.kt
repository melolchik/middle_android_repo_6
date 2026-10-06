package ru.yandexpraktikum.core.di

import ru.yandexpraktikum.core.domain.repository.NotesRepository
import ru.yandexpraktikum.core.presentation.mappers.PresentationNoteMapper

interface CoreDependencies {
    fun notesRepository(): NotesRepository
    fun presentationNoteMapper(): PresentationNoteMapper
}