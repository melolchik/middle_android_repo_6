package ru.yandexpraktikum.core.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.yandexpraktikum.core.data.db.NoteDao
import ru.yandexpraktikum.core.data.db.NoteDatabase
import ru.yandexpraktikum.core.data.mappers.DataNoteMapper
import ru.yandexpraktikum.core.data.repository.NotesRepositoryImpl
import ru.yandexpraktikum.core.domain.repository.NotesRepository
import javax.inject.Singleton

private const val DATABASE_NAME = "note_database"

@Module
interface CoreModule {


    @Singleton
    @Binds
    fun bindsRepository(impl: NotesRepositoryImpl): NotesRepository

    companion object {

        @Singleton
        @Provides
        fun provideNoteDatabase(context: Context): NoteDatabase {
            return Room.databaseBuilder(
                context,
                NoteDatabase::class.java,
                DATABASE_NAME
            ).build()
        }

        @Singleton
        @Provides
        fun provideNoteDao(database: NoteDatabase): NoteDao {
            return database.noteDao()
        }
    }

}