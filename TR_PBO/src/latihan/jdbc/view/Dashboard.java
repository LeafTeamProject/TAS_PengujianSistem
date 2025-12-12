
package latihan.jdbc.view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import latihan.jdbc.controller.AdminController;
import com.barcodelib.barcode.Linear;
import java.io.File;

public class Dashboard extends javax.swing.JFrame {
    private String a, b;
    
    public Dashboard() {
        initComponents();
    }
    
    public Dashboard(String nama) {
        initComponents();
        this.a = nama;
        
        this.lblAdmin.setText(this.a);
        AdminController ac = new AdminController();
        DefaultTableModel detm2 = ac.createTable();

        this.tbKaryawan.setModel(detm2);
        this.tbUKaryawan.setModel(detm2);

        ac.tampilkanKaryawan();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblAdmin = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKaryawan = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtHp = new javax.swing.JTextField();
        rdLaki = new javax.swing.JRadioButton();
        rdPerem = new javax.swing.JRadioButton();
        rdPegawai = new javax.swing.JRadioButton();
        rdManager = new javax.swing.JRadioButton();
        rdceo = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbUKaryawan = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lblUId = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUNama = new javax.swing.JTextField();
        txtUHp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        rdLaki2 = new javax.swing.JRadioButton();
        rdPerem2 = new javax.swing.JRadioButton();
        rdPegawai2 = new javax.swing.JRadioButton();
        rdManager2 = new javax.swing.JRadioButton();
        rdceo2 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setText("Selamat Datang");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setText("Admin,");

        lblAdmin.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblAdmin.setText("mimin");

        jButton6.setBackground(new java.awt.Color(255, 255, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton6.setText("Data Absensi");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 255, 0));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton8.setText("Data Karyawan");
        jButton8.setSelected(true);

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setText("Logout");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(lblAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAdmin)
                .addGap(106, 106, 106)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(20, 20, 20))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 153));

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));

        tbKaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(tbKaryawan);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nama Karyawan");

        jLabel11.setBackground(new java.awt.Color(0, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tambah Data Karyawan");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Nomor Hp");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Kelamin");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Jabatan");

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdLaki);
        rdLaki.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdLaki.setForeground(new java.awt.Color(255, 255, 255));
        rdLaki.setText("Laki-laki");
        rdLaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdLakiActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdPerem);
        rdPerem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdPerem.setForeground(new java.awt.Color(255, 255, 255));
        rdPerem.setText("Perempuan");

        buttonGroup2.add(rdPegawai);
        rdPegawai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdPegawai.setForeground(new java.awt.Color(255, 255, 255));
        rdPegawai.setText("Pegawai");

        buttonGroup2.add(rdManager);
        rdManager.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdManager.setForeground(new java.awt.Color(255, 255, 255));
        rdManager.setText("Manager");

        buttonGroup2.add(rdceo);
        rdceo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdceo.setForeground(new java.awt.Color(255, 255, 255));
        rdceo.setText("CEO");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DATA KARYAWAN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(rdPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rdLaki, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(rdManager, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(rdceo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(rdPerem, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNama, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                                            .addComponent(txtHp)))))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(212, 212, 212))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(rdLaki)
                    .addComponent(rdPerem))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(rdPegawai)
                    .addComponent(rdManager)
                    .addComponent(rdceo))
                .addGap(36, 36, 36)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Data Karyawan", jPanel3);

        jPanel5.setBackground(new java.awt.Color(0, 0, 102));

        tbUKaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbUKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUKaryawanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbUKaryawan);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Id");

        lblUId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUId.setForeground(new java.awt.Color(255, 255, 255));
        lblUId.setText("id");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nama");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nomor Hp");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Kelamin");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("EDIT DATA KARYAWAN");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Jabatan");

        buttonGroup1.add(rdLaki2);
        rdLaki2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdLaki2.setForeground(new java.awt.Color(255, 255, 255));
        rdLaki2.setText("Laki-laki");
        rdLaki2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdLaki2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdPerem2);
        rdPerem2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdPerem2.setForeground(new java.awt.Color(255, 255, 255));
        rdPerem2.setText("Perempuan");

        buttonGroup2.add(rdPegawai2);
        rdPegawai2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdPegawai2.setForeground(new java.awt.Color(255, 255, 255));
        rdPegawai2.setText("Pegawai");

        buttonGroup2.add(rdManager2);
        rdManager2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdManager2.setForeground(new java.awt.Color(255, 255, 255));
        rdManager2.setText("Manager");

        buttonGroup2.add(rdceo2);
        rdceo2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdceo2.setForeground(new java.awt.Color(255, 255, 255));
        rdceo2.setText("CEO");

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Hapus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUNama, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUId, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(rdPegawai2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdManager2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdceo2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(rdLaki2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdPerem2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtUHp, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40))))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblUId))
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtUNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtUHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(rdLaki2)
                    .addComponent(rdPerem2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(rdPegawai2)
                    .addComponent(rdManager2)
                    .addComponent(rdceo2)
                    .addComponent(jButton2))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Edit Data Karyawan", jPanel5);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jTabbedPane1)
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbUKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUKaryawanMouseClicked
        //bikin table tbUKarywan jadi table default biar bisa diambil nilainya
        DefaultTableModel dtm2 = (DefaultTableModel) tbUKaryawan.getModel();
        
        //buat milh baris
        int pilih = tbUKaryawan.getSelectedRow();
        //ambil nilai berdasarkan kolom berapa
        this.b = dtm2.getValueAt(pilih, 1).toString();
        lblUId.setText(dtm2.getValueAt(pilih, 0).toString()); 
        txtUNama.setText(dtm2.getValueAt(pilih, 1).toString()); 
        txtUHp.setText(dtm2.getValueAt(pilih, 2).toString()); 
        //sama kek tadi klo ini pas di pilih nnt bakal nyalain radio yg mana dari yg di pilih
        String kelamin = dtm2.getValueAt(pilih, 3).toString();
        if (kelamin.equals("Laki-laki")) {
            rdLaki2.setSelected(true);
        } else if (kelamin.equals("Perempuan")) {
            rdPerem2.setSelected(true);
        }
        // sama tp versi jabatan
        String jabatan = dtm2.getValueAt(pilih, 4).toString();
        if (jabatan.equals("pegawai")) {
            rdPegawai2.setSelected(true);
        } else if (jabatan.equals("manager")) {
            rdManager2.setSelected(true);
        } else if (jabatan.equals("CEO")) {
            rdceo2.setSelected(true);
        }
    }//GEN-LAST:event_tbUKaryawanMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AdminController ac = new AdminController();
        String stat = "karyawan";
        String gender = null;
        String jabatan = null;
        //sama ini buat ngasih nilai gender ama jabatan
        if (rdLaki.isSelected()) {
            gender = "Laki-laki";
        } else if (rdPerem.isSelected()) {
            gender = "Perempuan";
        }

        if (rdPegawai.isSelected()) {
            jabatan = "pegawai";
        } else if (rdManager.isSelected()) {
            jabatan = "manager";
        } else if (rdceo.isSelected()) {
            jabatan = "CEO";
        }
        //dicek
        if (gender == null || jabatan == null || txtNama.getText().isEmpty() || txtHp.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua input harus diisi!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //jalanin buat nambahin karyawannya (INSERT)
        boolean status = ac.tambahKaryawan(this.txtNama.getText(), this.txtHp.getText(), gender, jabatan);
        if(status == true){
            JOptionPane.showMessageDialog(this, "Data Berhasil ditambahkan", "Error", JOptionPane.WARNING_MESSAGE);
            DefaultTableModel detm2 = ac.createTable();
            
            try{
            Linear barcode = new Linear();
            barcode.setType(Linear.CODE128B);
            barcode.setData(txtNama.getText());
            barcode.setI(11.0f);
            
            String namabc = txtNama.getText();
            barcode.renderBarcode("D:\\Skul\\PBO\\Barcode\\"+namabc+".png");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Error", "Error", JOptionPane.WARNING_MESSAGE);
            }
            this.tbKaryawan.setModel(detm2);
            this.tbUKaryawan.setModel(detm2);
            
            ac.tampilkanKaryawan();
        }
        else{
            JOptionPane.showMessageDialog(this, "Gagal ditambahkan", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
    }//GEN-LAST:event_txtNamaActionPerformed

    private void rdLaki2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdLaki2ActionPerformed
    }//GEN-LAST:event_rdLaki2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //bikin klo pencet CLEAR buat semua pilihan ke reset
        this.b = "";
        this.lblUId.setText("");
        this.txtUNama.setText("");
        this.txtUHp.setText("");
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //klo ni bagian edit data yang udah ada (UPDATE)
        AdminController ac = new AdminController();
        File file = new File("D:\\Skul\\PBO\\Barcode\\"+this.b+".png");
        int id = Integer.parseInt(this.lblUId.getText());
        String nama = this.txtUNama.getText();
        String hp = this.txtUHp.getText();
        String kelamin = null;
        String jabatan = null;
        
        if (file.delete()) {
            this.b = nama;
        } else {
            JOptionPane.showMessageDialog(this, "Barcode gagal dihapus", "Error", JOptionPane.WARNING_MESSAGE);
        }
        
        if (rdLaki2.isSelected()) {
            kelamin = "Laki-laki";
        } else if (rdPerem2.isSelected()) {
            kelamin = "Perempuan";
        }
        
        if (rdPegawai2.isSelected()) {
            jabatan = "pegawai";
        } else if (rdManager2.isSelected()) {
            jabatan = "manager";
        } else if (rdceo2.isSelected()) {
            jabatan = "CEO";
        }
        
        if (nama.isEmpty() || hp.isEmpty() || kelamin == null || jabatan == null) {
            JOptionPane.showMessageDialog(this, "Semua input harus diisi!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        boolean status = ac.ubahKaryawan(id, nama, hp, kelamin, jabatan);
        if(status == true){
            JOptionPane.showMessageDialog(this, "Berhasil Ubah");
            DefaultTableModel detm2 = ac.createTable();
            
            try{
            Linear barcode = new Linear();
            barcode.setType(Linear.CODE128B);
            barcode.setData(txtUNama.getText());
            barcode.setI(11.0f);
            
            String namabc = txtUNama.getText();
            barcode.renderBarcode("D:\\Skul\\PBO\\Barcode\\"+namabc+".png");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Error", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
            this.tbKaryawan.setModel(detm2);
            this.tbUKaryawan.setModel(detm2);
            
            ac.tampilkanKaryawan();
        }
        else{
            JOptionPane.showMessageDialog(this, "Gagal Ubah", "Error", JOptionPane.WARNING_MESSAGE);

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //untuk hapus DATA KARYAWAN (DELETE)
        AdminController ac = new AdminController();
        File file = new File("D:\\Skul\\PBO\\Barcode\\"+this.b+".png");
        int id = Integer.parseInt(this.lblUId.getText());
        if (file.delete()) {
            this.b = "";
        } else {
            JOptionPane.showMessageDialog(this, "Barcode gagal dihapus", "Error", JOptionPane.WARNING_MESSAGE);
        }
        boolean status = ac.hapusKaryawan(id);
        if(status == true){
            JOptionPane.showMessageDialog(this, "Berhasil dihapus");
            DefaultTableModel detm2 = ac.createTable();
            
            this.tbKaryawan.setModel(detm2);
            this.tbUKaryawan.setModel(detm2);
            
            ac.tampilkanKaryawan();
            
            this.lblUId.setText("");
            this.txtUNama.setText("");
            this.txtUHp.setText("");

            buttonGroup1.clearSelection();
            buttonGroup2.clearSelection();
        }
        else{
            JOptionPane.showMessageDialog(this, "Gagal dihapus", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //buat ke window bagian DATA ABSEN
        DA da = new DA(this.a);
        da.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //balik ke login (LOGOUT)
        FormLogin fl = new FormLogin();
        fl.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void rdLakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdLakiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdLakiActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblUId;
    private javax.swing.JRadioButton rdLaki;
    private javax.swing.JRadioButton rdLaki2;
    private javax.swing.JRadioButton rdManager;
    private javax.swing.JRadioButton rdManager2;
    private javax.swing.JRadioButton rdPegawai;
    private javax.swing.JRadioButton rdPegawai2;
    private javax.swing.JRadioButton rdPerem;
    private javax.swing.JRadioButton rdPerem2;
    private javax.swing.JRadioButton rdceo;
    private javax.swing.JRadioButton rdceo2;
    private javax.swing.JTable tbKaryawan;
    private javax.swing.JTable tbUKaryawan;
    private javax.swing.JTextField txtHp;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtUHp;
    private javax.swing.JTextField txtUNama;
    // End of variables declaration//GEN-END:variables
}
