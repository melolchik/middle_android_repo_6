package ru.yandexpraktikum.notekeeper

import android.app.Application
import ru.yandexpraktikum.notekeeper.di.AppComponent
import ru.yandexpraktikum.notekeeper.di.DaggerAppComponent

class NoteKeeperApp : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent.factory().create(this)

    }

}