/*
 * Copyright (c) 2015, Andrey Lavrov <lavroff@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package cy.alavrov.jminerguide.forms;

import cy.alavrov.jminerguide.data.DataContainer;
import cy.alavrov.jminerguide.data.api.APIKeyLoader;
import cy.alavrov.jminerguide.data.api.IKeyLoadingResultReceiver;
import cy.alavrov.jminerguide.data.character.APIKey;
import cy.alavrov.jminerguide.data.character.CharacterContainer;
import cy.alavrov.jminerguide.data.character.EVECharacter;
import javax.swing.DefaultListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;

/**
 * API management dialog.
 * @author alavrov
 */
public final class JAPIDialog extends javax.swing.JDialog implements IKeyLoadingResultReceiver{
    private volatile boolean loading = false;
    
    private DataContainer dCont;
    
    private final MainFrame parent;
    
    private boolean updated = false;

    /**
     * Creates new form JAPIDialog
     * @param parent
     * @param modal
     * @param container 
     */
    public JAPIDialog(MainFrame parent, boolean modal, DataContainer container) {        
        super(parent, modal);
        dCont = container;       
        this.parent = parent;
        
        initComponents();
        loadKeys(true);
        checkDataOnType();
        
        AbstractDocument verDoc = ((AbstractDocument)jTextFieldVerification.getDocument());
        verDoc.addDocumentListener(new APIDialogDocumentListener());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListAPIKey = new javax.swing.JList<APIKey>();
        jButtonAddKey = new javax.swing.JButton();
        jButtonRemoveKey = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldKeyID = new javax.swing.JTextField();
        jButtonReload = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldVerification = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListCharacters = new javax.swing.JList<EVECharacter>();
        jButtonClose = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabelExpires = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("API Key Management");
        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("API Keys"));

        jListAPIKey.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListAPIKey.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListAPIKeyValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListAPIKey);

        jButtonAddKey.setText("Add");
        jButtonAddKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddKeyActionPerformed(evt);
            }
        });

        jButtonRemoveKey.setText("Remove");
        jButtonRemoveKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveKeyActionPerformed(evt);
            }
        });

        jLabel4.setText("API Keys");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonAddKey)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRemoveKey))
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonRemoveKey)
                    .addComponent(jButtonAddKey))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Key"));

        jLabel1.setText("ID");

        jTextFieldKeyID.setEnabled(false);

        jButtonReload.setText("Reload");
        jButtonReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReloadActionPerformed(evt);
            }
        });

        jLabel2.setText("Verification Key");

        jLabel3.setText("Characters");

        jListCharacters.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jListCharacters);

        jButtonClose.setText("Close");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jLabel5.setText("Expires:");

        jLabelExpires.setText("Never");

        jLabel6.setText("Status:");

        jLabelStatus.setText("Ready");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldVerification)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonClose))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextFieldKeyID, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonReload))
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelExpires))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelStatus)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonReload, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jTextFieldKeyID))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldVerification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelExpires))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelStatus))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonClose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Loads API keys from the storage to the interface.
     * May select something and do appropriate actions if asked nicely.
     * @param loadSelection if true, will try to preserve selection and load selected
     * key data into the interface (if any).
     */
    public void loadKeys(boolean loadSelection) {
        CharacterContainer cCont = dCont.getCharacterContainer();    
        
        APIKey sel = jListAPIKey.getSelectedValue();
        
        DefaultListModel<APIKey> model = cCont.getListModel();
        jListAPIKey.setModel(model);
        
        if (model.size() > 0) {        
            if (loadSelection) {
                if (sel != null) {
                    jListAPIKey.setSelectedValue(sel, true);
                } else {
                    jListAPIKey.setSelectedIndex(0);
                }

                loadSelectedKey();
            }
        } else {
            disableAll(true);                        
        }
    }
    
    /**
     * Selects a given key in the list. Key must be there, obviously,
     * otherwise magic won't happen.
     * @param key 
     */
    public void selectKey(APIKey key) {
        jListAPIKey.setSelectedValue(key, true);
    }
    
    /**
     * Loads selected key's data into a sidebar.
     */
    public void loadSelectedKey() {
        APIKey sel = jListAPIKey.getSelectedValue();
        if (sel == null) {
            disableAll(true);
        } else {
            enableAll();
            
            jLabelExpires.setText(sel.getExpires());
            jLabelStatus.setText("Ready");
            
            jTextFieldKeyID.setText(String.valueOf(sel.getID()));
            jTextFieldVerification.setText(sel.getVerification());
            
            jListCharacters.setModel(sel.getListModel());
        }
    }
    
    /**
     * Disables all key manipulation fields and clears them (when needed 
     * and where applicable).
     * @param resetData if true, data fields are to be cleared.
     */
    public void disableAll(boolean resetData) {
        jButtonRemoveKey.setEnabled(false);
        jButtonReload.setEnabled(false);              
        jTextFieldVerification.setEnabled(false);
        jListCharacters.setEnabled(false);
        
        if (resetData) {
            jLabelExpires.setText("");
            jLabelStatus.setText("");
            jTextFieldVerification.setText("");
            jTextFieldKeyID.setText("");
            jListCharacters.setListData(new EVECharacter[0]);
        }
    }
    
    /**
     * Enables all key manipulation fields.
     */
    public void enableAll() {
        jButtonRemoveKey.setEnabled(true);
        jButtonReload.setEnabled(true);
        
        jTextFieldVerification.setEnabled(true);
        
        jListCharacters.setEnabled(true);
    }
    
    /**
     * Checks API key data on typing and makes appropriate changes in the interface.
     */
    public void checkDataOnType() {
        String ver = jTextFieldVerification.getText();
        if (ver == null ||  ver.isEmpty()) {
            jLabelStatus.setText("Verification code can't be empty");
            jButtonReload.setEnabled(false);
        } else if (ver.length() != 64) {
            jLabelStatus.setText("Verification code must be 64 symbols long ("+ver.length()+" now)");
            jButtonReload.setEnabled(false);
        } else {
            jLabelStatus.setText("Ready to verify");     
            jButtonReload.setEnabled(true);                    
        }        
    }
    
    public void updateParent() {
        if (updated) {
            parent.loadMinerList(true);
        }
    }
    
    /**
     * "Close" button. Closes the dialog.
     * @param evt 
     */
    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        if (!loading) {
            updateParent();
            
            this.setVisible(false);
            this.dispose();            
        }
    }//GEN-LAST:event_jButtonCloseActionPerformed

    /**
     * "Add" button. Opens dialog to add a new API key.
     * @param evt 
     */
    private void jButtonAddKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddKeyActionPerformed
        if (loading) return;
        
        updated = true;
        JNewAPIDialog dlg = new JNewAPIDialog(this, true, dCont);
        dlg.setLocationRelativeTo(this);
        dlg.setVisible(true);
    }//GEN-LAST:event_jButtonAddKeyActionPerformed

    /**
     * "Remove" button. Removes selected API key, if any.
     * @param evt 
     */
    private void jButtonRemoveKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveKeyActionPerformed
        if (loading) return;
        
        APIKey key = jListAPIKey.getSelectedValue();       
        if (key == null) {
            disableAll(true);
            return;            
        }
        
        updated = true;
        
        int pos = jListAPIKey.getSelectedIndex();
        
        dCont.getCharacterContainer().removeAPIKey(key);
        dCont.save();
        loadKeys(false);
        
        int keysTotal = jListAPIKey.getModel().getSize();
        
        if (keysTotal > 0) {
            if (pos >= keysTotal) pos = keysTotal - 1;
        
            jListAPIKey.setSelectedIndex(pos);
            loadSelectedKey();
        } else {
            disableAll(true);
        }                
    }//GEN-LAST:event_jButtonRemoveKeyActionPerformed

    /**
     * Selection was changed in the API key list.
     * @param evt 
     */
    private void jListAPIKeyValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListAPIKeyValueChanged
        if (loading) return;
        
        loadSelectedKey();
    }//GEN-LAST:event_jListAPIKeyValueChanged
    
    /**
     * "Reload" button. Starts API reloading process.
     * @param evt 
     */
    private void jButtonReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReloadActionPerformed
        if (loading) return;
        
        APIKey key = jListAPIKey.getSelectedValue();       
        if (key == null) {
            disableAll(true);
            return;            
        }
        
        String ver = jTextFieldVerification.getText();
        if (ver == null ||  ver.isEmpty()) {
            jLabelStatus.setText("Verification code can't be empty");
            jButtonReload.setEnabled(false);
        }
        
        updated = true;
        loading = true;
        disableAll(false);
        jButtonAddKey.setEnabled(false);
        jButtonClose.setEnabled(false);
        jLabelStatus.setText("Fetching key data...");
        
        APIKey newkey = new APIKey(key.getID(), ver);
        APIKeyLoader loader = new APIKeyLoader(newkey, this);
        dCont.startAPILoader(loader);
    }//GEN-LAST:event_jButtonReloadActionPerformed

    /**
     * Called when the user is trying to close dialog.
     * @param evt 
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (!loading) {
            updateParent();
            
            this.setVisible(false);
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddKey;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonReload;
    private javax.swing.JButton jButtonRemoveKey;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelExpires;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JList<APIKey> jListAPIKey;
    private javax.swing.JList<EVECharacter> jListCharacters;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldKeyID;
    private javax.swing.JTextField jTextFieldVerification;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loadingDone(boolean success, String result, APIKey processedKey) {
        jButtonClose.setEnabled(true);
        jButtonAddKey.setEnabled(true);
        
        loading = false;
        
        CharacterContainer cCont = dCont.getCharacterContainer();
        
        enableAll();
        if (success) {
            cCont.updateAPIKey(processedKey);
            dCont.save();
            loadKeys(false);

            int keysTotal = jListAPIKey.getModel().getSize();

            if (keysTotal > 0) {                
                jListAPIKey.setSelectedValue(processedKey, true);
                loadSelectedKey();
                jLabelStatus.setText("Key loaded successfully");
            } else {
                disableAll(true);
            }   
        } else {
            jLabelStatus.setText(result);
        }
        
        jButtonReload.setEnabled(false);
    }

    /**
     * Document listener to check verification key data.
     */
    private class APIDialogDocumentListener implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) {
            checkDataOnType();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            checkDataOnType();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            checkDataOnType();
        }
        
    }
}
