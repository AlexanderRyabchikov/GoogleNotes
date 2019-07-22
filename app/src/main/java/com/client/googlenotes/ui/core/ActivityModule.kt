package com.client.googlenotes.ui.core

import com.client.googlenotes.ui.base.AbstractActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: AbstractActivity) {

    @Provides
    @PerActivity
    fun provideActivity(): AbstractActivity = activity

}