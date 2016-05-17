package fisioeng.collector.home;

import fisioeng.collector.*;
import fisioeng.collector.serial.Discover;
import fisioeng.collector.serial.XBee;
import java.io.IOException;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Home extends javax.swing.JFrame {
    protected XBee xbee;
    protected Logger log;
    protected Boolean thStopFlag;
    protected Settings settings;
    protected Request request;

    public Home() {
        settings = new Settings();
        request = new Request();
        
               
        initComponents();
        listDevices();
        xbee = new XBee();
        log = new Logger(jTextAreaLog);

    }

    private void listDevices () {
        Discover d = new Discover();
        List<String> list = d.getAvailablePorts();
        String[] listData = new String[10];
        Integer count = 0;

        for (String deviceName : list) {
            listData[count] = deviceName;
            count++;
        }

        jList1.setListData(listData);

        jList1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
              String portName = jList1.getSelectedValue().toString();
              if (!evt.getValueIsAdjusting() && portName.length() > 0) {
                try {
                    if (xbee.isConnected()) {
                        xbee.disconnect();
                        log.info("Desconectado da porta '" + xbee.getPortName() + "' com sucesso.");
                    }

                    xbee.setPortName(portName);

                    xbee.connect();

                    updateButtonsStatus();
                    log.info("Conectado a porta '" + portName + "' com sucesso.");
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
              }
            }
          });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogAbout = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButtonCloseAbout = new javax.swing.JButton();
        jDialogSettings = new javax.swing.JDialog();
        jLabel13 = new javax.swing.JLabel();
        jButtonSaveConfig = new javax.swing.JButton();
        jButtonCloseConfig = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldUrl = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldApiKey = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldHttpVerb = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldCommand = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxUnit = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButtonSend = new javax.swing.JButton();
        jButtonStart = new javax.swing.JButton();
        jCheckBoxSave = new javax.swing.JCheckBox();
        jPanelSave = new javax.swing.JPanel();
        jTextFieldFrequency = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDuration = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldSerie = new javax.swing.JTextField();
        jButtonStop = new javax.swing.JButton();
        jLabelMeasure = new javax.swing.JLabel();
        jLabelUnit = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaLog = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jList1 = new javax.swing.JList();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuHelp = new javax.swing.JMenu();
        jMenuIAbout = new javax.swing.JMenuItem();

        jDialogAbout.setTitle("Sobre Fisioeng Collector");
        jDialogAbout.setLocation(new java.awt.Point(100, 100));
        jDialogAbout.setMinimumSize(new java.awt.Dimension(472, 313));
        jDialogAbout.setModal(true);
        jDialogAbout.setName("Sobre Fisioeng Collector"); // NOI18N
        jDialogAbout.setResizable(false);

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel5.setText("Fisioeng Colletor");

        jLabel7.setText("Software de coleta de dados de sensores");

        jLabel8.setText("v0.0.1-beta");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fisioeng/collector/imagens/univasf.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fisioeng/collector/imagens/fapesb-logo.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel10.setText("Apoio");

        jLabel11.setText("Licença GPL V3");

        jLabel12.setText("https://github.com/fisioeng/fisioeng-collector");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(jLabel11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9))
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jButtonCloseAbout.setText("Fechar");
        jButtonCloseAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseAboutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogAboutLayout = new javax.swing.GroupLayout(jDialogAbout.getContentPane());
        jDialogAbout.getContentPane().setLayout(jDialogAboutLayout);
        jDialogAboutLayout.setHorizontalGroup(
            jDialogAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAboutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogAboutLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCloseAbout)))
                .addContainerGap())
        );
        jDialogAboutLayout.setVerticalGroup(
            jDialogAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAboutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCloseAbout))
        );

        jDialogSettings.setTitle("Configurações");
        jDialogSettings.setLocation(new java.awt.Point(100, 100));
        jDialogSettings.setMinimumSize(new java.awt.Dimension(360, 310));
        jDialogSettings.setModal(true);

        jLabel13.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel13.setText("Configurações");

        jButtonSaveConfig.setText("Salvar");
        jButtonSaveConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSaveConfigMouseClicked(evt);
            }
        });

        jButtonCloseConfig.setText("Cancelar");
        jButtonCloseConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseConfigActionPerformed(evt);
            }
        });

        jLabel14.setText("API Url");

        jTextFieldUrl.setBackground(new java.awt.Color(254, 254, 254));
        jTextFieldUrl.setText(settings.getUrl());

        jLabel16.setText("Apikey");

        jTextFieldApiKey.setText(settings.getApiKey());

        jLabel17.setText("Serie");

        jTextFieldHttpVerb.setText(settings.getSerie());

        javax.swing.GroupLayout jDialogSettingsLayout = new javax.swing.GroupLayout(jDialogSettings.getContentPane());
        jDialogSettings.getContentPane().setLayout(jDialogSettingsLayout);
        jDialogSettingsLayout.setHorizontalGroup(
            jDialogSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDialogSettingsLayout.createSequentialGroup()
                        .addComponent(jButtonCloseConfig)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSaveConfig))
                    .addGroup(jDialogSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldApiKey, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                        .addComponent(jTextFieldHttpVerb, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldUrl, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(0, 18, Short.MAX_VALUE))
        );
        jDialogSettingsLayout.setVerticalGroup(
            jDialogSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogSettingsLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldHttpVerb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldApiKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDialogSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSaveConfig)
                    .addComponent(jButtonCloseConfig))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fisioeng Collector");
        setMinimumSize(new java.awt.Dimension(600, 480));

        jTextFieldCommand.setText("G1");
        jTextFieldCommand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCommandActionPerformed(evt);
            }
        });

        jLabel2.setText("Comando");

        jComboBoxUnit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "bpm", "UR%", " " }));
        jComboBoxUnit.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxUnitItemStateChanged(evt);
            }
        });

        jLabel1.setText("Unidade de Medida");

        jButtonSend.setText("Enviar");
        jButtonSend.setEnabled(false);
        jButtonSend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSendMouseClicked(evt);
            }
        });

        jButtonStart.setText("Iniciar");
        jButtonStart.setEnabled(false);
        jButtonStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonStartMouseClicked(evt);
            }
        });

        jCheckBoxSave.setText("Salvar?");
        jCheckBoxSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxSaveMouseClicked(evt);
            }
        });

        jPanelSave.setVisible(false);

        jTextFieldFrequency.setText("10");

        jLabel4.setText("Duração (minutos)");

        jLabel3.setText("Frequência (segundos)");

        jTextFieldDuration.setText("5");

        jLabel18.setText("Serie");

        jTextFieldSerie.setText("1");

        javax.swing.GroupLayout jPanelSaveLayout = new javax.swing.GroupLayout(jPanelSave);
        jPanelSave.setLayout(jPanelSaveLayout);
        jPanelSaveLayout.setHorizontalGroup(
            jPanelSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSaveLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelSaveLayout.createSequentialGroup()
                        .addGroup(jPanelSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel18))
                        .addGap(64, 64, 64)
                        .addGroup(jPanelSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldDuration, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(jTextFieldSerie)))
                    .addGroup(jPanelSaveLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(jTextFieldFrequency, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelSaveLayout.setVerticalGroup(
            jPanelSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSaveLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanelSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldFrequency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextFieldSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        jButtonStop.setText("Parar");
        jButtonStop.setEnabled(false);
        jButtonStop.setMaximumSize(new java.awt.Dimension(61, 23));
        jButtonStop.setMinimumSize(new java.awt.Dimension(61, 23));
        jButtonStop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonStopMouseClicked(evt);
            }
        });

        jLabelMeasure.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 48)); // NOI18N
        jLabelMeasure.setText("N/A");

        jLabelUnit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelUnit.setText("bpm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanelSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jCheckBoxSave)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jComboBoxUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldCommand, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelMeasure, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButtonSend)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonStart)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelUnit)
                            .addComponent(jButtonStop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(29, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCommand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSend)
                    .addComponent(jButtonStart)
                    .addComponent(jButtonStop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxSave))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMeasure)
                            .addComponent(jLabelUnit))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        jTextAreaLog.setEditable(false);
        jTextAreaLog.setBackground(new java.awt.Color(240, 240, 240));
        jTextAreaLog.setColumns(20);
        jTextAreaLog.setRows(5);
        jScrollPane2.setViewportView(jTextAreaLog);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jList1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jList1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
        );

        jMenu1.setText("Arquivo");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Configurações");

        jMenuItem1.setText("Acesso");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenuHelp.setText("Ajuda");

        jMenuIAbout.setText("Sobre");
        jMenuIAbout.setToolTipText("");
        jMenuIAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuIAboutActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuIAbout);

        jMenuBar1.add(jMenuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setBounds(100, 100, 650, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuIAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuIAboutActionPerformed
        jDialogAbout.setVisible(true);
    }//GEN-LAST:event_jMenuIAboutActionPerformed

    private void jButtonCloseAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseAboutActionPerformed
        jDialogAbout.setVisible(false);
    }//GEN-LAST:event_jButtonCloseAboutActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jDialogSettings.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButtonCloseConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseConfigActionPerformed
        jDialogSettings.setVisible(false);
    }//GEN-LAST:event_jButtonCloseConfigActionPerformed

    private void jButtonSaveConfigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSaveConfigMouseClicked
        settings
                .setUrl(jTextFieldUrl.getText())
                .setApiKey(jTextFieldApiKey.getText())
                .Save();
        jDialogSettings.setVisible(false);
    }//GEN-LAST:event_jButtonSaveConfigMouseClicked

    private void jButtonStopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStopMouseClicked

        thStopFlag = true;
        jButtonStop.setEnabled(false);
        updateButtonsStatus();
    }//GEN-LAST:event_jButtonStopMouseClicked

    private void jCheckBoxSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxSaveMouseClicked
        jPanelSave.setVisible(jCheckBoxSave.isSelected());

        updateButtonsStatus();
    }//GEN-LAST:event_jCheckBoxSaveMouseClicked

    private void jButtonStartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStartMouseClicked

        int freqTime = Integer.parseInt(jTextFieldFrequency.getText());
        if(freqTime<=2) {
            log.error("A frequencia deve ser maior que 2 segundos.");
            return;
        }

        jButtonStop.setEnabled(xbee.isConnected());
        updateButtonsStatus();
        thStopFlag = false;

        Runnable dataLoop = new Runnable() {
            String command = jTextFieldCommand.getText();
            String data = "";
            String[] dataArray = new String[3];

            int frequencia = Integer.parseInt(jTextFieldFrequency.getText());
            int duracao = Integer.parseInt(jTextFieldDuration.getText())*60;

            @Override
            public void run() {
                for (int i = 0; i < duracao; i += frequencia) {

                    try {
                        xbee.sendMensage(command);

                        data = xbee.getData();
                        if(null == data){
                            throw new Exception("Os dados retornados são inválidos");
                        }

                        dataArray = xbee.getData().split(" ");

                        data = dataArray[2];
                        if(thStopFlag)
                        break;
                        jLabelMeasure.setText(data);
                        log.info("Comando '" + command + "' retornou '" + data + "'");

                        Measure measure = new Measure();

                        measure.setValue(Integer.parseInt(data))
                        .setUnit(jComboBoxUnit.getSelectedItem().toString())
                        .setSerie(1);

                        try {
                            log.info("Status code: " + request.saveMeasure(settings.getUrl(), measure).getStatusLine().getStatusCode());
                        } catch (IOException ex) {
                            log.error(ex.getMessage());
                        }

                        Thread.sleep((frequencia-2)*1000);
                    } catch (Exception e) {
                        log.error(e.getMessage());
                        jLabelMeasure.setText("N/A");
                    }
                }
            }
        };

        Thread thDataLoop = new Thread(dataLoop);
        thDataLoop.start();

    }//GEN-LAST:event_jButtonStartMouseClicked

    private void jButtonSendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSendMouseClicked
        String command = jTextFieldCommand.getText();
        String data = "";
        String[] dataArray = new String[3];
        Measure measure = new Measure();

        try {
            xbee.sendMensage(command);

            data = xbee.getData();
            if(null == data){
                throw new Exception("Os dados retornados são inválidos");
            }

            dataArray = xbee.getData().split(" ");

            data = dataArray[2];

            jLabelMeasure.setText(data);
        } catch (Exception e) {
            log.error(e.getMessage());
            jLabelMeasure.setText("N/A");
        }

        log.info("Comando '" + command + "' foi enviado para '" + xbee.getPortName() + "'.");
        log.info("Comando '" + command + "' retornou '" + data + "'");
    }//GEN-LAST:event_jButtonSendMouseClicked

    private void jComboBoxUnitItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxUnitItemStateChanged
        jLabelUnit.setText(jComboBoxUnit.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBoxUnitItemStateChanged

    private void jTextFieldCommandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCommandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCommandActionPerformed

    private void updateButtonsStatus() {
        jButtonSend.setEnabled(!jCheckBoxSave.isSelected() && xbee.isConnected());
        jButtonStart.setEnabled(jCheckBoxSave.isSelected() && xbee.isConnected() && !jButtonStop.isEnabled());
        jButtonStop.setEnabled(jCheckBoxSave.isSelected() && xbee.isConnected() && !jButtonStart.isEnabled());
    }


    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCloseAbout;
    private javax.swing.JButton jButtonCloseConfig;
    private javax.swing.JButton jButtonSaveConfig;
    private javax.swing.JButton jButtonSend;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JCheckBox jCheckBoxSave;
    private javax.swing.JComboBox jComboBoxUnit;
    private javax.swing.JDialog jDialogAbout;
    private javax.swing.JDialog jDialogSettings;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelMeasure;
    private javax.swing.JLabel jLabelUnit;
    private javax.swing.JList jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuIAbout;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelSave;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaLog;
    private javax.swing.JTextField jTextFieldApiKey;
    private javax.swing.JTextField jTextFieldCommand;
    private javax.swing.JTextField jTextFieldDuration;
    private javax.swing.JTextField jTextFieldFrequency;
    private javax.swing.JTextField jTextFieldHttpVerb;
    private javax.swing.JTextField jTextFieldSerie;
    private javax.swing.JTextField jTextFieldUrl;
    // End of variables declaration//GEN-END:variables
}
