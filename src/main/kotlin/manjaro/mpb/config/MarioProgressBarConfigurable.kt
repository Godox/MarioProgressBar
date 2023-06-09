package manjaro.mpb.config

import com.intellij.openapi.options.Configurable
import manjaro.mpb.config.MarioProgressBarSettingsState.Companion.instance
import org.jetbrains.annotations.Nls
import javax.swing.JComponent

class MarioProgressBarConfigurable : Configurable {
    private var mySettingsComponent: MarioProgressBarSettingsComponent? = null

    // A default constructor with no arguments is required because this implementation
    // is registered as an applicationConfigurable EP
    override fun getDisplayName(): @Nls(capitalization = Nls.Capitalization.Title) String {
        return "Mario Progress Bar"
    }

    override fun getPreferredFocusedComponent(): JComponent? {
        return mySettingsComponent!!.preferredFocusedComponent
    }

    override fun createComponent(): JComponent {
        mySettingsComponent = MarioProgressBarSettingsComponent()
        return mySettingsComponent!!.panel
    }

    override fun isModified(): Boolean {
        val settings = instance
        var modified = mySettingsComponent!!.chosenCharacter != settings.selectedCharacter
        modified = modified or (mySettingsComponent!!.chosenCharacter !== settings.selectedCharacter)
        return modified
    }

    override fun apply() {
        val settings = instance
        settings.selectedCharacter = mySettingsComponent!!.chosenCharacter
    }

    override fun reset() {
        val settings = instance
        mySettingsComponent!!.chosenCharacter = settings.selectedCharacter
    }

    override fun disposeUIResources() {
        mySettingsComponent = null
    }
}