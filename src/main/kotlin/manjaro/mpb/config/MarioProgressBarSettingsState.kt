package manjaro.mpb.config

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil
import manjaro.mpb.component.MBCharacter

@State(
    name = "manjaro.mpb.config.MarioProgressBarSettingsState",
    storages = [Storage("MarioProgressBarPluginSettings.xml")]
)
class MarioProgressBarSettingsState : PersistentStateComponent<MarioProgressBarSettingsState?> {

    var selectedCharacter = MBCharacter.MARIO

    override fun getState(): MarioProgressBarSettingsState {
        return this
    }

    override fun loadState(state: MarioProgressBarSettingsState) {
        XmlSerializerUtil.copyBean(state, this)
    }

    companion object {
        @JvmStatic
        val instance: MarioProgressBarSettingsState
            get() = ApplicationManager.getApplication().getService(
                MarioProgressBarSettingsState::class.java
            )
    }
}