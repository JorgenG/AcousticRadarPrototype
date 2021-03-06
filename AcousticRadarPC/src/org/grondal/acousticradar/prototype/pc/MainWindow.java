/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainWindow.java
 *
 * Created on 16.feb.2012, 08:53:40
 */
package org.grondal.acousticradar.prototype.pc;

import java.awt.Canvas;

/**
 *
 * @author JorgenG
 */
public class MainWindow extends javax.swing.JFrame 
{
    
    private CommunicationInterface communicationInterface;
    private static MainWindow instance;

    /** Creates new form MainWindow */
    public MainWindow() 
    {
        initComponents();
        communicationInterface = new CommunicationInterface();    
        modeButtonGroup.add(idleSelector);
        modeButtonGroup.add(soundModeSelector);
        modeButtonGroup.add(contModeSelector);
    }
    
    public static MainWindow getInstance()
    {
        return instance;
    }
    
    public void setStatusBarText(String newInfo)
    {
        statusBarLabel.setText("NXT Status: " + newInfo);
    }
    
    public MapPanel getMapPanel()
    {
        return mapPanel;
    }
    
    public void modeSelect(int mode)
    {
        switch(mode)
        {
            case CommunicationInterface.CMD_CHANGETOCONTMODE:
                modeButtonGroup.setSelected(contModeSelector.getModel(), true);
                break;
            case CommunicationInterface.CMD_CHANGETOIDLEMODE:
                modeButtonGroup.setSelected(idleSelector.getModel(), true);
                break;
            case CommunicationInterface.CMD_CHANGETOSOUNDMODE:
                modeButtonGroup.setSelected(soundModeSelector.getModel(), true);
                break;
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modeButtonGroup = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        bottomSeparator = new javax.swing.JSeparator();
        statusBarLabel = new javax.swing.JLabel();
        mapPanel = new org.grondal.acousticradar.prototype.pc.MapPanel();
        jPanel1 = new javax.swing.JPanel();
        contModeSelector = new javax.swing.JRadioButton();
        soundModeSelector = new javax.swing.JRadioButton();
        idleSelector = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        statusBarLabel.setForeground(new java.awt.Color(255, 255, 255));
        statusBarLabel.setText("NXT Status: Not connected");

        mapPanel.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
        mapPanel.setLayout(mapPanelLayout);
        mapPanelLayout.setHorizontalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        mapPanelLayout.setVerticalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        contModeSelector.setBackground(new java.awt.Color(51, 51, 51));
        contModeSelector.setForeground(new java.awt.Color(255, 255, 255));
        contModeSelector.setText("Continous mode");
        contModeSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contModeSelectorActionPerformed(evt);
            }
        });

        soundModeSelector.setBackground(new java.awt.Color(51, 51, 51));
        soundModeSelector.setForeground(new java.awt.Color(255, 255, 255));
        soundModeSelector.setText("Sound activated mode");
        soundModeSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soundModeSelectorActionPerformed(evt);
            }
        });

        idleSelector.setBackground(new java.awt.Color(51, 51, 51));
        idleSelector.setForeground(new java.awt.Color(255, 255, 255));
        idleSelector.setText("Idle / Stop");
        idleSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idleSelectorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contModeSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soundModeSelector)
                    .addComponent(idleSelector))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(contModeSelector)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(soundModeSelector)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idleSelector)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bottomSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(statusBarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bottomSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusBarLabel)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void soundModeSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soundModeSelectorActionPerformed
        communicationInterface.switchToSoundActivatedMode();
    }//GEN-LAST:event_soundModeSelectorActionPerformed

    private void contModeSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contModeSelectorActionPerformed
        communicationInterface.switchToContinuousMode();
    }//GEN-LAST:event_contModeSelectorActionPerformed

    private void idleSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idleSelectorActionPerformed
        communicationInterface.switchToIdleMode();
    }//GEN-LAST:event_idleSelectorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                instance = new MainWindow();
                instance.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator bottomSeparator;
    private javax.swing.JRadioButton contModeSelector;
    private javax.swing.JRadioButton idleSelector;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private org.grondal.acousticradar.prototype.pc.MapPanel mapPanel;
    private javax.swing.ButtonGroup modeButtonGroup;
    private javax.swing.JRadioButton soundModeSelector;
    private javax.swing.JLabel statusBarLabel;
    // End of variables declaration//GEN-END:variables
}
