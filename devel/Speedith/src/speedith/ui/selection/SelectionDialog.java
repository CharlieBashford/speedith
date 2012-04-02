/*
 *   Project: Speedith
 * 
 * File name: SelectionDialog.java
 *    Author: Matej Urbas [matej.urbas@gmail.com]
 * 
 *  Copyright © 2012 Matej Urbas
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package speedith.ui.selection;

import speedith.core.reasoning.args.selection.SelectionSequence;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Collection;
import speedith.core.lang.SpiderDiagram;
import static speedith.i18n.Translations.i18n;
import speedith.core.reasoning.args.selection.SelectionStep;
import speedith.core.reasoning.args.selection.SelectionStepAny;

/**
 * This dialog provides a step-by-step diagram element selection method.
 * @author Matej Urbas [matej.urbas@gmail.com]
 */
public class SelectionDialog extends javax.swing.JDialog {

    // <editor-fold defaultstate="collapsed" desc="Fields">
    private boolean cancelled = true;
    // </editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    /**
     * Creates a new diagram selection dialog with a null diagram and a single
     * {@link SelectionStepAny select-any-element step}.
     * @param parent
     * @param modal
     */
    public SelectionDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * Creates a new diagram selection dialog with the given diagram and the given
     * {@link SelectionStep selection steps}.
     *  <p>The final selection of the user can be retrieved through {@link SelectionDialog#getSelection()}.</p>
     * @param diagram the diagram from which the user will choose elements.
     * @param selectionSteps the selection instruction steps that will lead the
     * user through the selection process.
     * @param parent
     * @param modal 
     */
    public SelectionDialog(Frame parent, boolean modal, SpiderDiagram diagram, SelectionStep... selectionSteps) {
        this(parent, modal, diagram, Arrays.asList(selectionSteps));
    }

    /**
     * Creates a new diagram selection dialog with the given diagram and the given
     * {@link SelectionStep selection steps}.
     *  <p>The final selection of the user can be retrieved through {@link SelectionDialog#getSelection()}.</p>
     * @param diagram the diagram from which the user will choose elements.
     * @param selectionSteps the selection instruction steps that will lead the
     * user through the selection process.
     * @param parent
     * @param modal 
     */
    public SelectionDialog(Frame parent, boolean modal, SpiderDiagram diagram, Collection<? extends SelectionStep> selectionSteps) {
        this(parent, modal);
        elementSelectionPanel.setDiagramAndSelectionSteps(diagram, selectionSteps);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Generated Code">
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        elementSelectionPanel = new speedith.ui.selection.SelectionPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(i18n("SELDIA_DEFAULT_TITLE")); // NOI18N
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        elementSelectionPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSelectionConcluded(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(elementSelectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(elementSelectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onSelectionConcluded(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onSelectionConcluded
        cancelled = evt.getID() == SelectionPanel.Cancel;
        dispose();
    }//GEN-LAST:event_onSelectionConcluded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SelectionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                SelectionDialog dialog = new SelectionDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosed(WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private speedith.ui.selection.SelectionPanel elementSelectionPanel;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Public Properties">
    /**
     * Returns the current selection made by the user.
     * @return the current selection made by the user.
     */
    public SelectionSequence getSelection() {
        return this.elementSelectionPanel.getSelection();
    }

    /**
     * Indicates whether the user pressed the cancel (or close window) button.
     * <p>If this value is set to {@code true} then the user cancelled the
     * selection.</p>
     * @return whether the user pressed the cancel (or close window) button.
     */
    public boolean isCancelled() {
        return cancelled;
    }
    // </editor-fold>
}
