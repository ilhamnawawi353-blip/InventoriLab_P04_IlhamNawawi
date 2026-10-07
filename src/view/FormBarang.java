package view;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Barang;

public class FormBarang extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormBarang.class.getName());
    private static final long serialVersionUID = 1L;
    private final List<Barang> daftarBarang = new ArrayList<Barang>();
    private DefaultTableModel modelTabel;

    public FormBarang() {
        initComponents();
        siapkanTabel();
        isiDataContoh();
        setLocationRelativeTo(null);
    }
    
    private void siapkanTabel() {
    modelTabel = new DefaultTableModel(
            new Object[]{"Kode", "Nama Barang", "Tersedia"}, 0) {
        private static final long serialVersionUID = 1L;

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    tblBarang.setModel(modelTabel);
    tblBarang.setRowHeight(26);
    tblBarang.getTableHeader().setReorderingAllowed(false);
}

private void isiDataContoh() {
    daftarBarang.add(new Barang("BRG-001", "Keyboard USB", 10));
    daftarBarang.add(new Barang("BRG-002", "Mouse USB", 8));
    perbaruiTabel();
    lblStatus.setText("Siap. Dua data contoh dimuat di memori.");
}

private void perbaruiTabel() {
    modelTabel.setRowCount(0);
    for (Barang barang : daftarBarang) {
        modelTabel.addRow(new Object[]{
            barang.getKode(),
            barang.getNama(),
            barang.getjumlahTersedia()
        });
    }
}

private void bersihkanInput() {
    txtKode.setText("");
    txtNama.setText("");
    txtJumlah.setText("");
    txtKode.requestFocusInWindow();
}

private void tambahDemo() {
    String kode = txtKode.getText().trim();
    String nama = txtNama.getText().trim();
    String teksJumlah = txtJumlah.getText().trim();

    try {
        if (kode.isEmpty() || nama.isEmpty() || teksJumlah.isEmpty()) {
            throw new IllegalArgumentException(
                    "Kode, nama, dan jumlah wajib diisi.");
        }

        int jumlah = Integer.parseInt(teksJumlah);
        Barang barang = new Barang(kode, nama, jumlah);
        daftarBarang.add(barang);
        perbaruiTabel();
        bersihkanInput();
        lblStatus.setText("Barang " + barang.getNama()
                + " ditambahkan ke daftar sementara.");
    } catch (NumberFormatException e) {
        lblStatus.setText("Jumlah belum valid. Data tidak ditambahkan.");
        JOptionPane.showMessageDialog(this,
                "Jumlah harus bilangan bulat antara 0 dan 2147483647.",
                "Input jumlah", JOptionPane.WARNING_MESSAGE);
        txtJumlah.requestFocusInWindow();
        txtJumlah.selectAll();
    } catch (IllegalArgumentException e) {
        lblStatus.setText("Data tidak ditambahkan: " + e.getMessage());
        JOptionPane.showMessageDialog(this, e.getMessage(),
                "Periksa data barang", JOptionPane.WARNING_MESSAGE);
    }
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblInfo = new javax.swing.JLabel();
        lblJudul = new javax.swing.JLabel();
        pnlInput = new javax.swing.JPanel();
        lblNama = new javax.swing.JLabel();
        lblKode1 = new javax.swing.JLabel();
        lblJumlah = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnBersihkan = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventori Laboratorium - Data Barang");
        setPreferredSize(new java.awt.Dimension(760, 520));

        lblInfo.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        lblInfo.setText("Latihan antarmuka - data tersimpan sementara.");

        lblJudul.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        lblJudul.setText("INVENTORI LABORATORIUM");

        pnlInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Barang"));
        pnlInput.setName(""); // NOI18N

        lblNama.setText("Nama Barang");

        lblKode1.setText("Kode Barang");

        lblJumlah.setText("Jumlah Tersedia");

        txtKode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeActionPerformed(evt);
            }
        });

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnBersihkan.setText("Bersihkan Input");
        btnBersihkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBersihkanActionPerformed(evt);
            }
        });

        btnTutup.setText("Tutup");
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInputLayout = new javax.swing.GroupLayout(pnlInput);
        pnlInput.setLayout(pnlInputLayout);
        pnlInputLayout.setHorizontalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlInputLayout.createSequentialGroup()
                        .addComponent(lblJumlah)
                        .addGap(18, 18, 18)
                        .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInputLayout.createSequentialGroup()
                        .addComponent(btnBersihkan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTutup))
                    .addComponent(btnTambah)
                    .addGroup(pnlInputLayout.createSequentialGroup()
                        .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNama)
                            .addComponent(lblKode1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        pnlInputLayout.setVerticalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKode1)
                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNama)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJumlah)
                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnTambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBersihkan)
                    .addComponent(btnTutup))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(tblBarang);

        lblStatus.setText("Status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblInfo)
                    .addComponent(lblJudul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJudul)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfo)
                .addGap(18, 18, 18)
                .addComponent(pnlInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblStatus)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBersihkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBersihkanActionPerformed
        bersihkanInput();
        lblStatus.setText("Input dibersihkan. Daftar barang tetap.");
    }//GEN-LAST:event_btnBersihkanActionPerformed

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        dispose();
    }//GEN-LAST:event_btnTutupActionPerformed

    private void txtKodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        tambahDemo();
    }//GEN-LAST:event_btnTambahActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            new FormBarang().setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBersihkan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTutup;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblKode1;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPanel pnlInput;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}
