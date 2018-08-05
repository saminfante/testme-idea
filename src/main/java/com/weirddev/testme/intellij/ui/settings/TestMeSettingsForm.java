package com.weirddev.testme.intellij.ui.settings;

import com.intellij.openapi.Disposable;
import com.weirddev.testme.intellij.configuration.TestMeConfig;
import com.intellij.openapi.util.Disposer;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Date: 28/07/2018
 *
 * @author Yaron Yamin
 */
public class TestMeSettingsForm implements Disposable {
    private JCheckBox generateTestsForInheritedCheckBox;
    private JCheckBox optimizeImportsCheckBox;
    private JCheckBox reformatCodeCheckBox;
    private JCheckBox replaceFullyQualifiedNamesCheckBox;
    private JPanel rootPanel;

    public JPanel getRootPanel() {
        return rootPanel;
    }

    @Override
    public void dispose() {
        Disposer.dispose(this);
    }

    public void persistState(TestMeConfig testMeConfig) {
        if (testMeConfig != null) {
            testMeConfig.setGenerateTestsForInherited(generateTestsForInheritedCheckBox.isSelected());
            testMeConfig.setOptimizeImports(optimizeImportsCheckBox.isSelected());
            testMeConfig.setReformatCode(reformatCodeCheckBox.isSelected());
            testMeConfig.setReplaceFullyQualifiedNames(replaceFullyQualifiedNamesCheckBox.isSelected());
        }
    }

    public void reset(TestMeConfig state) {
        if (state != null) {
            generateTestsForInheritedCheckBox.setSelected(state.getGenerateTestsForInherited());
            optimizeImportsCheckBox.setSelected(state.getOptimizeImports());
            reformatCodeCheckBox.setSelected(state.getReformatCode());
            replaceFullyQualifiedNamesCheckBox.setSelected(state.getReplaceFullyQualifiedNames());
        }
    }

    public boolean isDirty(TestMeConfig state) {
        return state != null &&
                (generateTestsForInheritedCheckBox.isSelected() != state.getGenerateTestsForInherited() ||
                        optimizeImportsCheckBox.isSelected() != state.getOptimizeImports() ||
                        reformatCodeCheckBox.isSelected() != state.getReformatCode() ||
                        replaceFullyQualifiedNamesCheckBox.isSelected() != state.getReplaceFullyQualifiedNames()
                );
    }
}
