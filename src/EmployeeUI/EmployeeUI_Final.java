
package EmployeeUI;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import business.*;
import java.lang.reflect.Method;
import java.util.*;
import static java.lang.Integer.parseInt;

/**
 *
 * @author soung
 */
public class EmployeeUI_Final extends javax.swing.JFrame {
String filename;
Map<Long,Employee> emps;
Map<String,Employee> empbyname; //declare variable
Map<String,JTextField> screenmap;//declare screenmap
String[] getMethods={"getEmployeeNumber","getFirstName","getLastName","getMiddleName"
        ,"getSuffix","getAddress1","getAddress2","getCity","getState","getZip"
        ,"getPhone","getGender","getPayCode","getStatus","getHireDate","getTerminationDate"
}; //all getters from employee

Map<String,JTextField> screenmapSet;
String[] setMethods={"setEmployeeNumber","setFirstName","setLastName","setMiddld",
            "setSuffix","setAddress1","setAddress2","setCity","setState","setZip",
            "setPhone","setGender","setPayCode","setStatus","setHireDate","setTerminateDate"}; //all getters from employee

JTextField[] fields; 
int loading = 0;// 
    /**
     * Creates new form EmployeeUI_Final
     */
    public EmployeeUI_Final() {
        initComponents();
        this.setLocationRelativeTo(this);
        JTextField[] flds={jTextFieldEmpNo, jTextFieldFirstnm, jTextFieldLastnm,
            jTextFieldMiddlenm, jTextFieldSuffix, jTextFieldAddr1, jTextFieldAddr2,
            jTextFieldCity, jTextFieldState, jTextFieldZip, jTextFieldPhone, jTextFieldGender,
            jTextFieldPaycd, jTextFieldStatus, jTextFieldHiredt, jTextFieldTermdt
        };//initiate constructor
        fields=flds;
        screenmap=new HashMap<>();
        screenmapSet=new HashMap<>();
       // associate combo box key with jTextFields
       for (int i=0; i<getMethods.length; i++){
           screenmap.put(getMethods[i],fields[i]);
       }
       for (int i=0; i<setMethods.length; i++){
           screenmapSet.put(setMethods[i],fields[i]);
       }
    }
private void displayValues(Employee e) {// 여기서는 public과 별차이 없음. 
        //clear all jTextFields
        clearFields(); //clearField method만들어주기
        //use java.lang.reflection package *****중요한부분***************************
        Class empClass=e.getClass();//starting point for using reflection
        Method[] methods=empClass.getMethods(); //Method class is obtained from Class
        try{
            for(Method m: methods){
                if(screenmap.containsKey((m.getName()))){ //ensure field exists in screenmap
                    JTextField field=screenmap.get(m.getName()); //obtain target field
                    switch (m.getName()) {
                        case "getEmployeeNumber":
                            long x=(long)m.invoke(e,null);
                            field=screenmap.get(m.getName());
                            field.setText((String.valueOf(x)));//conversion
                            break;
                        case "getPhone":
                            int y=(int)m.invoke(e,null);
                            field=screenmap.get(m.getName());
                            field.setText((String.valueOf(y)));
                            break;
                        case "getPayCode":
                            int z=(int)m.invoke(e,null);
                            field=screenmap.get(m.getName());
                            field.setText((String.valueOf(z)));
                            break;
                        default://EmpNum,phone,paycode외에 나머지는 다 default
                            if (String.valueOf(m.invoke(e, null)).equals("null")){
                            field.setText("");
                            }
                            else {
                                    field.setText(String.valueOf(m.invoke(e, null)));
                            }
                            break;         
                    }
                }
            }
        }
        catch(Exception ex) { 
            ex.printStackTrace();
        }
    }
    private void clearFields(){
        for (JTextField fld:fields){
            fld.setText("");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jRadioButtonRaw = new javax.swing.JRadioButton();
        jRadioButtonEmpno = new javax.swing.JRadioButton();
        jRadioButtonName = new javax.swing.JRadioButton();
        jButtonPrevious = new javax.swing.JButton();
        jComboBoxEmployee = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButtonNext = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldEmpNo = new javax.swing.JTextField();
        jTextFieldLastnm = new javax.swing.JTextField();
        jTextFieldMiddlenm = new javax.swing.JTextField();
        jTextFieldFirstnm = new javax.swing.JTextField();
        jTextFieldSuffix = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldAddr1 = new javax.swing.JTextField();
        jTextFieldAddr2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldCity = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldState = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldZip = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldPhone = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldGender = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldPaycd = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldStatus = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldHiredt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldTermdt = new javax.swing.JTextField();
        jLabelMessage = new javax.swing.JLabel();
        jButtonAddNew = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemLoadCSV = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(jRadioButtonRaw);
        jRadioButtonRaw.setText("Raw HashMap w.Empno Key");
        jRadioButtonRaw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonRawActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonEmpno);
        jRadioButtonEmpno.setText("TreeMap by Empno");
        jRadioButtonEmpno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEmpnoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonName);
        jRadioButtonName.setText("Map with Name Key (sorted)");
        jRadioButtonName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNameActionPerformed(evt);
            }
        });

        jButtonPrevious.setText("<-");
        jButtonPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreviousActionPerformed(evt);
            }
        });

        jComboBoxEmployee.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxEmployeeItemStateChanged(evt);
            }
        });

        jLabel1.setText("Employees:");

        jButtonNext.setText("->");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("EmpNo:");

        jLabel3.setText("Name: Last");

        jLabel4.setText("First");

        jLabel5.setText("Mid");

        jLabel6.setText("Suffix");

        jLabel7.setText("Addr:");

        jLabel8.setText("City:");

        jLabel9.setText("State:");

        jLabel10.setText("Zip:");

        jLabel11.setText("Phone:");

        jLabel12.setText("Gender:");

        jTextFieldGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGenderActionPerformed(evt);
            }
        });

        jLabel13.setText("Pay Cd:");

        jLabel14.setText("Status:");

        jLabel15.setText("Hire Date:");

        jLabel16.setText("Terminate Date:");

        jLabelMessage.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMessage.setText("Select a file to load first.");

        jButtonAddNew.setText("Add New Employee");
        jButtonAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddNewActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Update ");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonSave.setText("Save ");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonClear.setText("Clear ");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jButtonExit.setText("Exit ");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jTextFieldEmpNo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextFieldLastnm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextFieldFirstnm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldMiddlenm, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jTextFieldSuffix, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldAddr2, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                                            .addComponent(jTextFieldAddr1)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldCity, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel15)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldHiredt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldGender, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldState, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldPaycd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldZip, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldTermdt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(28, 28, 28))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButtonAddNew)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonClear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmpNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLastnm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMiddlenm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFirstnm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSuffix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldAddr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldAddr2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldPaycd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jTextFieldHiredt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldTermdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddNew)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonClear)
                    .addComponent(jButtonExit))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonRaw)
                            .addComponent(jButtonPrevious))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonNext))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jRadioButtonEmpno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButtonName)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonRaw)
                    .addComponent(jRadioButtonEmpno)
                    .addComponent(jRadioButtonName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPrevious)
                    .addComponent(jComboBoxEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButtonNext))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuFile.setText("File");
        jMenuFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFileActionPerformed(evt);
            }
        });

        jMenuItemLoadCSV.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemLoadCSV.setText("Load CSV");
        jMenuItemLoadCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLoadCSVActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemLoadCSV);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItem1);

        jMenuBar1.add(jMenuFile);

        jMenuEdit.setText("Edit");
        jMenuBar1.add(jMenuEdit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void jMenuItemLoadCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLoadCSVActionPerformed
        // declare a FileChooser
        JFileChooser f=new JFileChooser(".");//display current directory
        f.setDialogTitle("Select Employee File");
        FileNameExtensionFilter filter=new FileNameExtensionFilter("CSV file (*.csv"
            ,"CSV");
        f.setFileFilter(filter); //filter for CSV files
        JDialog jd=new JDialog();
        int val=f.showOpenDialog(jd);
        if (val==JFileChooser.CANCEL_OPTION) {
            jLabelMessage.setText("Open operation canceled");
        }
        else {
            filename=f.getSelectedFile().getAbsolutePath();
            emps=EmployeeIO.getEmployees(filename);
            jLabelMessage.setText(String.valueOf(emps.size())+" records found");
        }
        enableButtons();
    }//GEN-LAST:event_jMenuItemLoadCSVActionPerformed

     private void enableButtons(){
        jRadioButtonRaw.setEnabled(true);
        jRadioButtonEmpno.setEnabled(true);
        jRadioButtonName.setEnabled(true);
    }
    private void disableButtons(){
        jRadioButtonRaw.setEnabled(false);
        jRadioButtonEmpno.setEnabled(false);
        jRadioButtonName.setEnabled(false);
    }
    private void jMenuFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuFileActionPerformed

    private void jRadioButtonRawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonRawActionPerformed
        // call buildComboBox() method
        try {
            if (jRadioButtonRaw.isSelected())
            buildComboBox();
            jLabelMessage.setText("Raw HashMap populated. Select an employee"
                +" number to display employee information");
            loading = 0;
        }
        catch (NullPointerException ex){
            jLabelMessage.setText("Error occurred, no record loaded. Select a file to load");
            jMenuFile.doClick();
            buttonGroup1.clearSelection();
        }

    }//GEN-LAST:event_jRadioButtonRawActionPerformed

    private void jRadioButtonEmpnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEmpnoActionPerformed
        try{
            if(jRadioButtonRaw.isSelected())
            buildComboBox();
            jLabelMessage.setText("TreeMap populated. Select an employee"
                    +" number to display employee information");
            loading = 0;
        }
        catch(NullPointerException ex){
            jLabelMessage.setText("Error occured, no record loaded. Select a file to load");
            jMenuFile.doClick();
        }
        buildComboBox();
    }//GEN-LAST:event_jRadioButtonEmpnoActionPerformed

    private void jRadioButtonNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNameActionPerformed
        try{
            if(jRadioButtonRaw.isSelected())
            buildComboBox();
            jLabelMessage.setText("Map with name key populated. Select an employee"
                    +" number to display employee information");
            loading = 0;
        }
        catch(NullPointerException ex){
            jLabelMessage.setText("Error occured, no record loaded. Select a file to load");
            jMenuFile.doClick();
        }
        
        buildComboBox();
    }//GEN-LAST:event_jRadioButtonNameActionPerformed

    private void jButtonPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreviousActionPerformed
        // move to previous record. display a message if you are already on the first record
        if (!(jComboBoxEmployee.getSelectedIndex()<=0)) {
            jComboBoxEmployee.setSelectedIndex(jComboBoxEmployee.getSelectedIndex()-1);
        }
        else {
            jLabelMessage.setText("You are already on the first record. ");
        }
    }//GEN-LAST:event_jButtonPreviousActionPerformed

    private void jComboBoxEmployeeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxEmployeeItemStateChanged
        // ensure record loading is completed
        if (loading==1){
            return;
        }
        if (jComboBoxEmployee.getSelectedIndex()==-1){ //no employee is selected
            jLabelMessage.setText("No record is selected. Select a record.");
            return;
        }
        else {
            Employee e;
            if (jRadioButtonName.isSelected()){
                e=(Employee) empbyname.get((String)jComboBoxEmployee.getSelectedItem());
            }
            else {
                e=(Employee) emps.get((Long)jComboBoxEmployee.getSelectedItem());
            }
            //update display values
            String recordinfo="You are viewing record for ";
            displayValues(e);
            if (String.valueOf(e.getMiddleName()).equals("null")){
                jTextFieldMiddlenm.setText("");
                recordinfo+=e.getLastName()+", "+e.getFirstName();
            }
            else {
                recordinfo+=e.getLastName()+", "+e.getFirstName()+" "
                +e.getMiddleName();
            }
            jLabelMessage.setText(recordinfo);
        }
    }//GEN-LAST:event_jComboBoxEmployeeItemStateChanged

    private void jTextFieldGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGenderActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // make sure there is a file loaded
        if (filename==null) {
            JOptionPane.showMessageDialog(null, "Please load a file first "
                +"attemping to update employee records!","File not found",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if (jComboBoxEmployee.getSelectedIndex()==-1){
            JOptionPane.showConfirmDialog(null, "Please select an employee "
                +" before attempting to update","No employee selected",JOptionPane.ERROR_MESSAGE);
            return;
        }
        Long empnum=Long.parseLong(jTextFieldEmpNo.getText());
        String deleteEmp=emps.get(empnum).getFullName();
        if (emps.containsKey(empnum)){
            int confirm=JOptionPane.showConfirmDialog(null,
                "Are you sure you would like to delete this employee? \n\n"
                +"employee from the Employee records?\n\n"
                +"*****************THIS CANNOT BE UNDONE*****************\n\n"
                +"Employee Number: "+empnum.toString()+"\n"
                +"Employee Name: "+emps.get(empnum).getFullName(),"Confirm Delete",
                JOptionPane.YES_NO_OPTION);
            if (confirm==JOptionPane.YES_OPTION) {
                emps.remove(empnum); //only remove the record in the map
                clearFields();
                buildComboBox();
                jLabelMessage.setText("Employee '"+deleteEmp
                    +"' deleted. Click Save to make the change permanent");
            }
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        if (filename==null) {
            JOptionPane.showMessageDialog(null, "Please load a file first "
                +"attemping to update employee records!","File not found",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if (jComboBoxEmployee.getSelectedIndex()==-1){
            JOptionPane.showConfirmDialog(null, "Please select an employee "
                +" before attempting to update","No employee selected",JOptionPane.ERROR_MESSAGE);
            return;
        }
        try{
        Long empnum = Long.parseLong(jTextFieldEmpNo.getText());
       
       
        //String updateEmp=emp.get(empnum).getFullName();
        Employee z = new Employee();
        if (setDisplayValues(z)){
            JOptionPane.showMessageDialog(this.getParent(), "numbers only for phone/paycode/employee number");
        }
        else{
        if(emps.containsKey(empnum)){
            int confirm=JOptionPane.showConfirmDialog(null, "Are you sure? \n\n"
            +"confirm update", "update",
            JOptionPane.YES_NO_OPTION);
            
            if  (confirm == JOptionPane.YES_OPTION){
                emps.replace(empnum, z); //only replaces employee in the map
                
                buildComboBox();
                jLabelMessage.setText("Employee updated. Click save to make the change permanent");
            }  
        } 
        }      
        }   
                                              
    catch(Exception ex){
           System.out.println(ex);
           JOptionPane.showMessageDialog(this.getParent(), "enter at least an employee number to update");
}
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // call EmployeeIO.setEmps() method
        jLabelMessage.setText(EmployeeIO.setEmps(filename, emps));
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        // call clearValues()
        clearFields();
        buttonGroup1.clearSelection();
        jComboBoxEmployee.removeAllItems();
    }//GEN-LAST:event_jButtonClearActionPerformed
    
    private boolean setDisplayValues (Employee e){
        boolean imperrs=false;
        Class empClass=e.getClass();//starting point for using reflection
        Method[] methods=empClass.getMethods(); //Method class is obtained from Class
        try{
            for(Method m: methods){
                if(screenmapSet.containsKey((m.getName()))){ //ensure field exists in screenmap
                    JTextField field=screenmapSet.get(m.getName()); //obtain target field
                    switch (m.getName()) {
                        case "setEmployeeNumber":
//                            long x=(long)m.invoke(e,null);
                            field=screenmapSet.get(m.getName());
//                            field.setText((String.valueOf(x)));//conversion
                            long x=(long)parseInt(field.getText()); //
                            m.invoke(e,x);
                            break;
                        case "setPhone":
//                            int y=(int)m.invoke(e,null);
                            field=screenmapSet.get(m.getName());
//                            field.setText((String.valueOf(y)));
                            int y=(int)parseInt(field.getText()); //
                             m.invoke(e,y);
                            break;
                        case "setPayCode":
//                            int z=(int)m.invoke(e,null);
                            field=screenmapSet.get(m.getName());
//                            field.setText((String.valueOf(z)));
                            int z=(int)parseInt(field.getText()); //
                             m.invoke(e,z);
                            break;
                        default:
                            if (field.getText().equals("null")){
                                m.invoke(e,"");
//                            field.setText(e,"");
                            }
                            else {
                                    field=screenmapSet.get(m.getName());
                                            String h=(field.getText());
                                            m.invoke(e, h);
                            }
                            break;         
                    }
                }
            }
        }
        catch(NumberFormatException nfe){
            imperrs=true;
            nfe.printStackTrace();
            
        }
        catch(Exception ex) { 
            imperrs=true;
            ex.printStackTrace();
                
    }
      return imperrs;  
    }
    private void jButtonAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddNewActionPerformed
        if (filename==null) {
            JOptionPane.showMessageDialog(null, "Please load a file first "
                +"attemping to update employee records!","File not found",JOptionPane.ERROR_MESSAGE);
            return;
        }
        Employee e=new Employee();     
            
        if(setDisplayValues (e)){
            JOptionPane.showMessageDialog(this.getParent(),
                    "Please check information again, Phone/paycode/employee number only accept numeric");
        }
        else{
             Long empnum=Long.parseLong(jTextFieldEmpNo.getText());
        
        if (!emps.containsKey(empnum)){
            int confirm=JOptionPane.showConfirmDialog(null,
                "Are you sure you would like to add this employee? \n\n"
                ,"Confirm add",
                JOptionPane.YES_NO_OPTION);
            if (confirm==JOptionPane.YES_OPTION) {
                emps.put(empnum,e); 
               
                buildComboBox();
                jLabelMessage.setText("Employee added. Click Save to make the change permanent");
            }
        }
            else{
                jLabelMessage.setText("This employee already exists");
            }
        }    
        
    }//GEN-LAST:event_jButtonAddNewActionPerformed

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
         //move to next record. diplay a message if you are already on the first reord
        
        if(!(jComboBoxEmployee.getSelectedIndex()<=0)){            
                jComboBoxEmployee.setSelectedIndex(jComboBoxEmployee.getSelectedIndex()+1);
        }
        else {
            jLabelMessage.setText("You are already on the last record. ");
        }
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
         System.exit(0);
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public void buildComboBox(){//만들어야함.전체가 이해가안감 1:08분지점 설명
        loading=1; //loading. 처음에 0으로초기화하고 내가 로딩했을때 1부터(update불가능)볼수있게
        jComboBoxEmployee.removeAllItems();//이미 아이템이 있으면 다 지워야하므로
        if (jRadioButtonRaw.isSelected()) { 
            HashMap<Long,Employee> hashmap=new HashMap<>(emps); //key(employee No),value값 
            for(Map.Entry<Long,Employee>entry:hashmap.entrySet()){
                Long k=entry.getKey();
                jComboBoxEmployee.addItem(k);
            }
        }
        else if(jRadioButtonEmpno.isSelected()){
            TreeMap<Long,Employee> treemap=new TreeMap<>(emps);
            for(Map.Entry<Long,Employee> entry:treemap.entrySet()){
                Long k=entry.getKey();
                jComboBoxEmployee.addItem(k);
            }
        }
       else if(jRadioButtonName.isSelected()){
           empbyname=new TreeMap<>();
           for(Map.Entry<Long,Employee> entry:emps.entrySet()){
               Employee e=entry.getValue();
               String name=e.getLastName()+", "+e.getFirstName()
                       +" "+e.getMiddleName();
               empbyname.put(name,e);
           }
           for (Map.Entry<String,Employee> entry:empbyname.entrySet()){
               String k=entry.getKey();
               jComboBoxEmployee.addItem(k);
           }
       }
        jComboBoxEmployee.setSelectedIndex(-1); //아무것도 선택 안되게 -1로.
        loading=0; //not
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
            java.util.logging.Logger.getLogger(EmployeeUI_Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeUI_Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeUI_Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeUI_Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeUI_Final().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonAddNew;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPrevious;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox jComboBoxEmployee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemLoadCSV;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButtonEmpno;
    private javax.swing.JRadioButton jRadioButtonName;
    private javax.swing.JRadioButton jRadioButtonRaw;
    private javax.swing.JTextField jTextFieldAddr1;
    private javax.swing.JTextField jTextFieldAddr2;
    private javax.swing.JTextField jTextFieldCity;
    private javax.swing.JTextField jTextFieldEmpNo;
    private javax.swing.JTextField jTextFieldFirstnm;
    private javax.swing.JTextField jTextFieldGender;
    private javax.swing.JTextField jTextFieldHiredt;
    private javax.swing.JTextField jTextFieldLastnm;
    private javax.swing.JTextField jTextFieldMiddlenm;
    private javax.swing.JTextField jTextFieldPaycd;
    private javax.swing.JTextField jTextFieldPhone;
    private javax.swing.JTextField jTextFieldState;
    private javax.swing.JTextField jTextFieldStatus;
    private javax.swing.JTextField jTextFieldSuffix;
    private javax.swing.JTextField jTextFieldTermdt;
    private javax.swing.JTextField jTextFieldZip;
    // End of variables declaration//GEN-END:variables
}
