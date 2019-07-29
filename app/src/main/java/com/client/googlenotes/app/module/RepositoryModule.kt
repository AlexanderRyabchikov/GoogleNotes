package com.client.googlenotes.app.module

import com.client.googlenotes.data.repositories.notes.NotesDefaultRepository
import com.client.googlenotes.data.repositories.notes.NotesRepository
import com.client.googlenotes.data.repositories.user.UserDefaultRepository
import com.client.googlenotes.data.repositories.user.UserRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun provideNotesRepository(repository: NotesDefaultRepository): NotesRepository

    @Binds
    @Singleton
    fun provideUserRepository(repository: UserDefaultRepository): UserRepository
}