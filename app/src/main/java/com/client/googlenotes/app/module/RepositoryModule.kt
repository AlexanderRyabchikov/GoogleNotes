package com.client.googlenotes.app.module

import com.client.googlenotes.data.repositories.NotesDefaultRepository
import com.client.googlenotes.data.repositories.NotesRepository
import com.client.googlenotes.data.repositories.UserDefaultRepository
import com.client.googlenotes.data.repositories.UserRepository
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