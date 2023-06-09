package manjaro.mpb.ui;

import com.intellij.util.ui.JBUI;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class ProgressBarOverride extends BasicProgressBarUI {

    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(JComponent c) {
        c.setBorder(JBUI.Borders.empty().asUIResource());
        return new ProgressBarUi();
    }

}

