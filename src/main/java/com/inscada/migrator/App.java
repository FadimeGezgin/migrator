/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inscada.migrator;

import javax.swing.JOptionPane;

/**
 *
 * @author fadime
 */
public class App extends javax.swing.JFrame {

    

    /**
     * Creates new form App
     */
    public App() {
        initComponents();
        setSize(810, 630);
        setLocation((WIDTH+500)/2,(HEIGHT+50)/2 );
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        sql_panel = new javax.swing.JPanel();
        text_sql_host = new javax.swing.JLabel();
        text_sql_port = new javax.swing.JLabel();
        sql_port = new javax.swing.JTextField();
        text_sql_username = new javax.swing.JLabel();
        text_sql_password = new javax.swing.JLabel();
        sql_username = new javax.swing.JTextField();
        sql_host = new javax.swing.JTextField();
        sql_password = new javax.swing.JPasswordField();
        text_sql_dbname = new javax.swing.JLabel();
        sql_dbname = new javax.swing.JTextField();
        text_influxdb_host = new javax.swing.JLabel();
        influxdb_host = new javax.swing.JTextField();
        text_influxdb_port = new javax.swing.JLabel();
        influxdb_port = new javax.swing.JTextField();
        sql_connected = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sql_panel.setBackground(new java.awt.Color(36, 47, 65));

        text_sql_host.setBackground(new java.awt.Color(0, 0, 0));
        text_sql_host.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        text_sql_host.setForeground(new java.awt.Color(204, 204, 204));
        text_sql_host.setText(" POSTGRESQL HOST :");

        text_sql_port.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        text_sql_port.setForeground(new java.awt.Color(204, 204, 204));
        text_sql_port.setText(" POSTGRESQL PORT:");

        sql_port.setBackground(new java.awt.Color(36, 47, 65));
        sql_port.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        sql_port.setForeground(new java.awt.Color(204, 204, 204));
        sql_port.setText("Enter Your Port");
        sql_port.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        sql_port.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sql_portMouseClicked(evt);
            }
        });

        text_sql_username.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        text_sql_username.setForeground(new java.awt.Color(204, 204, 204));
        text_sql_username.setText(" POSTGRESQL USER NAME:");

        text_sql_password.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        text_sql_password.setForeground(new java.awt.Color(204, 204, 204));
        text_sql_password.setText(" POSTGRESQL PASSWORD:");

        sql_username.setBackground(new java.awt.Color(36, 47, 65));
        sql_username.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        sql_username.setForeground(new java.awt.Color(204, 204, 204));
        sql_username.setText("Enter Your User Name");
        sql_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        sql_username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sql_usernameMouseClicked(evt);
            }
        });

        sql_host.setBackground(new java.awt.Color(36, 47, 65));
        sql_host.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        sql_host.setForeground(new java.awt.Color(204, 204, 204));
        sql_host.setText("Enter Your Host");
        sql_host.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        sql_host.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sql_hostMouseClicked(evt);
            }
        });

        sql_password.setBackground(new java.awt.Color(36, 47, 65));
        sql_password.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        sql_password.setForeground(new java.awt.Color(204, 204, 204));
        sql_password.setText("Enter Your Password");
        sql_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        sql_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sql_passwordMouseClicked(evt);
            }
        });

        text_sql_dbname.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        text_sql_dbname.setForeground(new java.awt.Color(204, 204, 204));
        text_sql_dbname.setText(" POSTGRESQL DB NAME:");

        sql_dbname.setBackground(new java.awt.Color(36, 47, 65));
        sql_dbname.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        sql_dbname.setForeground(new java.awt.Color(204, 204, 204));
        sql_dbname.setText("Enter Your DB Name");
        sql_dbname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        sql_dbname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sql_dbnameMouseClicked(evt);
            }
        });

        text_influxdb_host.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        text_influxdb_host.setForeground(new java.awt.Color(204, 204, 204));
        text_influxdb_host.setText(" INFLUXDB HOST:");

        influxdb_host.setBackground(new java.awt.Color(36, 47, 65));
        influxdb_host.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        influxdb_host.setForeground(new java.awt.Color(204, 204, 204));
        influxdb_host.setText("Enter Your Host");
        influxdb_host.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        influxdb_host.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                influxdb_hostMouseClicked(evt);
            }
        });

        text_influxdb_port.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        text_influxdb_port.setForeground(new java.awt.Color(204, 204, 204));
        text_influxdb_port.setText(" INFLUXDB PORT:");

        influxdb_port.setBackground(new java.awt.Color(36, 47, 65));
        influxdb_port.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        influxdb_port.setForeground(new java.awt.Color(204, 204, 204));
        influxdb_port.setText("Enter Your Port");
        influxdb_port.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        influxdb_port.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                influxdb_portMouseClicked(evt);
            }
        });

        sql_connected.setBackground(new java.awt.Color(102, 102, 102));
        sql_connected.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        sql_connected.setForeground(new java.awt.Color(204, 204, 204));
        sql_connected.setText("TEST CONNECTED");
        sql_connected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sql_connectedActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(204, 0, 0));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout sql_panelLayout = new javax.swing.GroupLayout(sql_panel);
        sql_panel.setLayout(sql_panelLayout);
        sql_panelLayout.setHorizontalGroup(
            sql_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sql_panelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(sql_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sql_panelLayout.createSequentialGroup()
                        .addGroup(sql_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sql_dbname, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                            .addComponent(text_sql_port, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(text_sql_host, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sql_host)
                            .addComponent(sql_password)
                            .addComponent(sql_port, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(text_sql_dbname, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_sql_password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(sql_panelLayout.createSequentialGroup()
                        .addGroup(sql_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_sql_username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sql_username)
                            .addComponent(influxdb_port, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                            .addComponent(text_influxdb_port, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(influxdb_host)
                            .addComponent(text_influxdb_host, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(sql_panelLayout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(sql_connected, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sql_panelLayout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        sql_panelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {sql_dbname, sql_host, sql_password, sql_port, sql_username});

        sql_panelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {influxdb_host, influxdb_port});

        sql_panelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {text_sql_dbname, text_sql_host, text_sql_password, text_sql_port, text_sql_username});

        sql_panelLayout.setVerticalGroup(
            sql_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sql_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text_sql_host, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sql_host, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_sql_port, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sql_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_sql_username, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sql_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_sql_password, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sql_password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_sql_dbname, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sql_dbname, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(text_influxdb_host, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(influxdb_host, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_influxdb_port, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(influxdb_port, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sql_connected, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        sql_panelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {text_sql_dbname, text_sql_password});

        sql_panelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {text_influxdb_host, text_influxdb_port});

        sql_panelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {sql_dbname, sql_host, sql_password, sql_port, sql_username});

        sql_panelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {influxdb_host, influxdb_port});

        getContentPane().add(sql_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 530, 660));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setForeground(new java.awt.Color(0, 0, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sql_connectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sql_connectedActionPerformed
        MigratorImpl migratorImpl = new MigratorImpl();

        if (!validatePostgresqlConnection()) {
           // JOptionPane.showMessageDialog(null, "Please enter all required information.", "A Database Error Occurred", JOptionPane.ERROR_MESSAGE);
            jLabel1.setText("Please enter all required information.");
            return;
        }
        String host = influxdb_host.getText();
        Integer port = Integer.parseInt(influxdb_port.getText());
        ConnectionInfo postgresqlConnectionInfo = new ConnectionInfo(sql_host.getText(), (Integer.parseInt(sql_port.getText())), sql_dbname.getText(), sql_username.getText(), (Integer.parseInt(new String(sql_password.getPassword()))));
        ConnectionInfo influxDbConnectionInfo = new ConnectionInfo(host, port, null, null, 0);
        if (migratorImpl.testPostgresqlConnection(postgresqlConnectionInfo) && migratorImpl.testInfluxDbConnection(influxDbConnectionInfo)) {
            //JOptionPane.showMessageDialog(null, "SUCCESSFUL CONNECTİON !");
              jLabel1.setText("SUCCESSFUL CONNECTİON !");
              
            AppTable appTable = new AppTable();
            appTable.Allconnections(migratorImpl);
            appTable.setVisible(true);

        } else {
            if (!migratorImpl.testInfluxDbConnection(influxDbConnectionInfo)) {
                //JOptionPane.showMessageDialog(null, "failed to connect to influx !", "A Database Error Occurred", JOptionPane.ERROR_MESSAGE);
               jLabel1.setText("failed to connect to influx !");
            } else {
                jLabel1.setText("failed to connect to postgresql !");
                //JOptionPane.showMessageDialog(null, "failed to connect to postgresql !", "A Database Error Occurred", JOptionPane.ERROR_MESSAGE);

            }

        }

    }//GEN-LAST:event_sql_connectedActionPerformed

  
    private void influxdb_hostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_influxdb_hostMouseClicked
        influxdb_host.setText("");
    }//GEN-LAST:event_influxdb_hostMouseClicked

    private void sql_dbnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sql_dbnameMouseClicked
        sql_dbname.setText("");
    }//GEN-LAST:event_sql_dbnameMouseClicked

    private void sql_passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sql_passwordMouseClicked
        sql_password.setText("");
    }//GEN-LAST:event_sql_passwordMouseClicked

    private void sql_hostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sql_hostMouseClicked
        sql_host.setText("");
    }//GEN-LAST:event_sql_hostMouseClicked

    private void sql_usernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sql_usernameMouseClicked
        sql_username.setText("");
    }//GEN-LAST:event_sql_usernameMouseClicked

    private void sql_portMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sql_portMouseClicked
        sql_port.setText("");
    }//GEN-LAST:event_sql_portMouseClicked

    private void influxdb_portMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_influxdb_portMouseClicked
        influxdb_port.setText("");
    }//GEN-LAST:event_influxdb_portMouseClicked
    private boolean validatePostgresqlConnection() {
        if (sql_port.getText() == null || sql_password.getPassword() == null || sql_dbname.getText() == null
                || sql_username.getText() == null || sql_host.getText() == null || sql_dbname.getText().isEmpty()
                || sql_port.getText().isEmpty() || sql_host.getText().isEmpty() || sql_username.getText().isEmpty()) {
            return false;
        }
        if (influxdb_host.getText() == null || influxdb_host.getText().isEmpty()
                || influxdb_port.getText() == null || influxdb_port.getText().isEmpty()) {
            return false;
        }
        return true;
    }
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
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField influxdb_host;
    private javax.swing.JTextField influxdb_port;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JButton sql_connected;
    private javax.swing.JTextField sql_dbname;
    private javax.swing.JTextField sql_host;
    private javax.swing.JPanel sql_panel;
    private javax.swing.JPasswordField sql_password;
    private javax.swing.JTextField sql_port;
    private javax.swing.JTextField sql_username;
    private javax.swing.JLabel text_influxdb_host;
    private javax.swing.JLabel text_influxdb_port;
    private javax.swing.JLabel text_sql_dbname;
    private javax.swing.JLabel text_sql_host;
    private javax.swing.JLabel text_sql_password;
    private javax.swing.JLabel text_sql_port;
    private javax.swing.JLabel text_sql_username;
    // End of variables declaration//GEN-END:variables
}
