package com.base.app.feature.main.presentation.settings

import com.base.app.core.ui.foundation.locale.AppLocale
import com.base.app.core.ui.foundation.vm.BaseViewModel

class SettingsViewModel : BaseViewModel<SettingsIntent, SettingsViewState, SettingsSingleEvent>() {

    override fun initState() = SettingsViewState(locale = AppLocale.current())

    override fun processIntent(intent: SettingsIntent) {
        when (intent) {
            SettingsIntent.BackClick -> navigateBack()
            is SettingsIntent.SelectLocale -> selectLocale(intent.locale)
        }
    }

    private fun navigateBack() {
        sendEvent(SettingsSingleEvent.NavigateBack)
    }

    private fun selectLocale(locale: AppLocale) {
        updateState { copy(locale = locale) }
        // Hệ thống sẽ recreate activity với locale mới; state ở trên chỉ để radio đổi ngay.
        AppLocale.apply(locale)
    }
}
