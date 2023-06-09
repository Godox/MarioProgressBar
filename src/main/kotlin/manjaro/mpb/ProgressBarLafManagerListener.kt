package manjaro.mpb

import com.intellij.ide.ui.LafManager
import com.intellij.ide.ui.LafManagerListener
import manjaro.mpb.ui.ProgressBarOverride
import javax.swing.UIManager

class ProgressBarLafManagerListener : LafManagerListener {
    init {
        updateProgressBarUI()
    }

    override fun lookAndFeelChanged(lafManager: LafManager) {
        updateProgressBarUI()
    }

    companion object {
        private fun updateProgressBarUI() {
            val overrideClass = ProgressBarOverride::class.java
            UIManager.put("ProgressBarUI", overrideClass.name)
            UIManager.getDefaults()[overrideClass.name] = overrideClass
        }
    }
}
