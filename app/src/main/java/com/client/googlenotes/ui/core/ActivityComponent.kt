package com.client.googlenotes.ui.core

import com.client.googlenotes.dagger.core.AppComponent
import dagger.Component

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
}