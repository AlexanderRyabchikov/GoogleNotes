package com.client.googlenotes.dagger.core

import com.client.googlenotes.ui.core.ActivityComponent
import com.client.googlenotes.ui.core.ActivityModule
import com.client.googlenotes.ui.core.PerActivity
import com.client.googlenotes.ui.login.LoginActivity
import com.client.googlenotes.ui.main.MainActivity
import com.client.googlenotes.ui.map.MapActivity
import com.client.googlenotes.ui.note.NoteActivity
import com.client.googlenotes.ui.splash.Splash
import dagger.Component

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityCoreComponent : ActivityComponent {

    fun inject(activity: MainActivity)

    fun inject(activity: Splash)

    fun inject(activity: NoteActivity)

    fun inject(activity: MapActivity)

    fun inject(activity: LoginActivity)
}