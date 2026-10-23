package com.base.app.feature.main.presentation.profile

import com.base.app.core.ui.foundation.vm.BaseViewModel

class ProfileViewModel : BaseViewModel<ProfileIntent, ProfileViewState, ProfileSingleEvent>() {

    override fun initState() = ProfileViewState()

    override fun processIntent(intent: ProfileIntent) {
        when (intent) {
            ProfileIntent.SettingsClick -> sendEvent(ProfileSingleEvent.NavigateToSettings)
        }
    }
}
