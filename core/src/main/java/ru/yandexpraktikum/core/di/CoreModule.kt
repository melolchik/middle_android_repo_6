package ru.yandexpraktikum.core.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.yandexpraktikum.core.data.db.NoteDao
import ru.yandexpraktikum.core.data.db.NoteDatabase
import ru.yandexpraktikum.core.data.repository.NotesRepositoryImpl
import ru.yandexpraktikum.core.domain.repository.NotesRepository
import javax.inject.Singleton

private const val DATABASE_NAME = "note_database"

@Module
@InstallIn(SingletonComponent::class)
interface CoreModule {


    @Singleton
    @Binds
    fun bindsRepository(impl: NotesRepositoryImpl): NotesRepository

    companion object {

        @Singleton
        @Provides
        fun provideNoteDatabase(@ApplicationContext context: Context): NoteDatabase {
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