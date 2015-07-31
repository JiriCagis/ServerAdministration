package view;

import data.ServerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import business.ServerService;
import data.Constant;
import view.listeners.MainWindowListener;

public class SetupServerDialog extends javax.swing.JDialog {

    private final ServerInfo serverInfo;
    private final MainWindowListener listener;
    private final ServerService service;

    public SetupServerDialog(java.awt.Frame parent, boolean modal,
            ServerInfo serverInfo, MainWindowListener listener) {
        
        super(parent, modal);
        initComponents();
        setResizable(false);
        this.serverInfo = serverInfo;
        this.listener = listener;
        service = ServerService.getInstance();
        convertServerInfoToInputBoxs();
        
        //setting texts
        setTitle(Constant.SETUP_SERVER_LABEL);
        headerLabel.setText(Constant.SETUP_SERVER_LABEL);
        okBtn.setText(Constant.OK_BUTTON_LABEL);
        cancelBtn.setText(Constant.CANCEL_BUTTON_LABEL);
        serverNameLabel.setText(Constant.SERVER_NAME_LABEL);
        startScriptLabel.setText(Constant.START_SCRIPT_LABEL);
        restartScriptLabel.setText(Constant.RESTART_SCRIPT_LABEL);
        stopScriptLabel.setText(Constant.STOP_SCRIPT_LABEL);
        checkBoxWebFolder.setText(Constant.AUTOMATIC_SYNCHRONIZE_LABEL);
        sourceForlderLabel.setText(Constant.SOURCE_FOLDER_LABEL);
        targetFolderLabel.setText(Constant.TARGET_FOLDER_LABEL);
        
        //enable drag and drop on text edits
        startScriptEdit.setDropTarget(new FileDropTarget(startScriptEdit));
        restartScriptEdit.setDropTarget(new FileDropTarget(restartScriptEdit));
        stopScriptEdit.setDropTarget(new FileDropTarget(stopScriptEdit));
        targetFolderEdit.setDropTarget(new FileDropTarget(targetFolderEdit));
        sourceFolderEdit.setDropTarget(new FileDropTarget(sourceFolderEdit));
        
        registrateButtonListeners();
    }

    private void registrateButtonListeners() {
        okBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                convertInputBoxToServerInfo();
                service.addOrUpdate(serverInfo);
                listener.updateWindow();
                dispose();
            }
        });

        cancelBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void convertServerInfoToInputBoxs() {
        serverNameEdit.setText(serverInfo.getServerName());
        startScriptEdit.setText(serverInfo.getStartScript());
        restartScriptEdit.setText(serverInfo.getRestartScript());
        stopScriptEdit.setText(serverInfo.getStopScript());
        checkBoxWebFolder.setSelected(serverInfo.isAutomaticSynchnize());
        sourceFolderEdit.setText(serverInfo.getSourceFolder());
        targetFolderEdit.setText(serverInfo.getTargetFolder());
    }

    private void convertInputBoxToServerInfo() {
        serverInfo.setServerName(serverNameEdit.getText());
        serverInfo.setStartScript(startScriptEdit.getText());
        serverInfo.setRestartScript(restartScriptEdit.getText());
        serverInfo.setStopScript(stopScriptEdit.getText());
        serverInfo.setAutomaticSynchnize(checkBoxWebFolder.isSelected());
        serverInfo.setSourceFolder(sourceFolderEdit.getText());
        serverInfo.setTargetFolder(targetFolderEdit.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        topPanel = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        serverNameLabel = new javax.swing.JLabel();
        serverNameEdit = new javax.swing.JTextField();
        startScriptLabel = new javax.swing.JLabel();
        startScriptEdit = new javax.swing.JTextField();
        restartScriptLabel = new javax.swing.JLabel();
        restartScriptEdit = new javax.swing.JTextField();
        stopScriptLabel = new javax.swing.JLabel();
        stopScriptEdit = new javax.swing.JTextField();
        checkBoxWebFolder = new javax.swing.JCheckBox();
        sourceForlderLabel = new javax.swing.JLabel();
        sourceFolderEdit = new javax.swing.JTextField();
        targetFolderLabel = new javax.swing.JLabel();
        targetFolderEdit = new javax.swing.JTextField();
        okBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        jLabel6.setText("Start script: ");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        topPanel.setBackground(new java.awt.Color(51, 153, 255));

        headerLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        headerLabel.setForeground(new java.awt.Color(255, 255, 255));
        headerLabel.setText("Setup server");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        serverNameLabel.setText("Server name:");

        serverNameEdit.setMaximumSize(new java.awt.Dimension(200, 20));
        serverNameEdit.setMinimumSize(new java.awt.Dimension(200, 20));

        startScriptLabel.setText("Start script:");

        restartScriptLabel.setText("Restart script:");

        stopScriptLabel.setText("Stop script: ");

        checkBoxWebFolder.setText(" Automatic synchronize web folder");

        sourceForlderLabel.setText("Source folder:");

        targetFolderLabel.setText("Target folder: ");

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(serverNameLabel)
                            .addComponent(startScriptLabel)
                            .addComponent(restartScriptLabel)
                            .addComponent(stopScriptLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stopScriptEdit)
                            .addComponent(restartScriptEdit)
                            .addComponent(serverNameEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(startScriptEdit)))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(checkBoxWebFolder)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(targetFolderLabel)
                            .addComponent(sourceForlderLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sourceFolderEdit)
                            .addComponent(targetFolderEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))))
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serverNameLabel)
                    .addComponent(serverNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startScriptLabel)
                    .addComponent(startScriptEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(restartScriptLabel)
                    .addComponent(restartScriptEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stopScriptLabel)
                    .addComponent(stopScriptEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(checkBoxWebFolder)
                .addGap(18, 18, 18)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sourceForlderLabel)
                    .addComponent(sourceFolderEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(targetFolderLabel)
                    .addComponent(targetFolderEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        okBtn.setText("O.K.");

        cancelBtn.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancelBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(okBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn)
                    .addComponent(okBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JCheckBox checkBoxWebFolder;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JButton okBtn;
    private javax.swing.JTextField restartScriptEdit;
    private javax.swing.JLabel restartScriptLabel;
    private javax.swing.JTextField serverNameEdit;
    private javax.swing.JLabel serverNameLabel;
    private javax.swing.JTextField sourceFolderEdit;
    private javax.swing.JLabel sourceForlderLabel;
    private javax.swing.JTextField startScriptEdit;
    private javax.swing.JLabel startScriptLabel;
    private javax.swing.JTextField stopScriptEdit;
    private javax.swing.JLabel stopScriptLabel;
    private javax.swing.JTextField targetFolderEdit;
    private javax.swing.JLabel targetFolderLabel;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
