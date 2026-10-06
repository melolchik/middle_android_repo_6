package ru.yandexpraktikum.notekeeper.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.yandexpraktikum.add_note.di.AddNoteComponent
import ru.yandexpraktikum.add_note.presentation.AddNoteScreen
import ru.yandexpraktikum.add_note.presentation.AddNoteViewModel
import ru.yandexpraktikum.all_notes.di.AllNotesComponent
import ru.yandexpraktikum.all_notes.presentation.AllNotesScreen
import ru.yandexpraktikum.all_notes.presentation.AllNotesViewModel
import ru.yandexpraktikum.notekeeper.di.AppComponent

@Composable
fun NoteKeeperNavHost(
    appComponent: AppComponent,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.AllNotes.route
    ) {
        val componentProvider = appComponent.componentProvider()
        composable(route = Screen.AllNotes.route) {
            val allNotesComponent  = componentProvider.initAllNotesComponent()
            DisposableEffect(Unit) {
                onDispose {
                    componentProvider.clearAllNotesComponent()
                }
            }
            val vm: AllNotesViewModel = viewModel(
                factory = allNotesComponent.allNotesViewModelFactory()
            )
            AllNotesScreen(
                viewModel = vm,
                onAddNoteClick = {
                    navController.navigate(Screen.AddNote.route)
                }
            )
        }
        composable(route = Screen.AddNote.route) {
            var addNoteComponent  = componentProvider.initAddNoteComponent()
            DisposableEffect(Unit) {
                onDispose {
                    componentProvider.clearAddNoteComponent()
                }
            }
            val vm: AddNoteViewModel = viewModel(
                factory = addNoteComponent?.getAddNoteViewModelFactory()
            )
            AddNoteScreen(
                viewModel = vm,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}