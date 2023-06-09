package manjaro.mpb.config

import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBRadioButton
import com.intellij.util.ui.FormBuilder
import com.intellij.util.ui.UIUtil
import manjaro.mpb.component.MBCharacter
import java.util.*
import javax.swing.ButtonGroup
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel

// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
class MarioProgressBarSettingsComponent {

    var panel: JPanel
    private val charactersRadioButtons: MutableList<JBRadioButton> = ArrayList()
    private val backgroundsRadioButtons: MutableList<JBRadioButton> = ArrayList()

    init {
        val titleCharacter = JBLabel("Chose your character :", UIUtil.ComponentStyle.REGULAR)
        val characterSelectGroup = ButtonGroup()
        val formBuilder = FormBuilder.createFormBuilder().addComponent(titleCharacter)
        for (character in MBCharacter.values()) {
            val radioButton = JBRadioButton(character.displayName)
            characterSelectGroup.add(radioButton)
            charactersRadioButtons.add(radioButton)
            val icon = character.icon
            formBuilder.addLabeledComponent(JLabel(icon), radioButton)
        }
        panel = formBuilder.addComponentFillVertically(JPanel(), 0).panel
    }

    val preferredFocusedComponent: JComponent?
        get() = try {
            charactersRadioButtons[0]
        } catch (e: IndexOutOfBoundsException) {
            null
        }
    var chosenCharacter: MBCharacter
        get() = charactersRadioButtons.stream()
            .filter { obj: JBRadioButton -> obj.isSelected }.findFirst()
            .map { radioButton: JBRadioButton -> MBCharacter.valueOf(radioButton.text.uppercase(Locale.getDefault())) }
            .orElse(MBCharacter.MARIO)
        set(newBros) {
            for (charactersRadioButton in charactersRadioButtons) {
                charactersRadioButton.isSelected =
                    newBros.name == charactersRadioButton.text.uppercase(Locale.getDefault())
            }
        }

}