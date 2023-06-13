import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Variables {

    public static final String DATABASE_FILE = "/database";
    public static final String ACCOUNT_FILE = DATABASE_FILE + "/account.txt";
    public static final String PATIENT_FILE = DATABASE_FILE + "/patient.txt";
    public static final String DOCTOR_FILE = DATABASE_FILE + "/doctor.txt";
    public static final String KEY_FILE = DATABASE_FILE + "/key.txt";
    public static final String FOLDER = DATABASE_FILE + "/Schedules/";
    public static final String HOSPITAL_NAME = "TUP-Manila Medical Center";
    public static final int RESERVATION_FEE = 150;
    public static final int ENTER = 13;
    public static final int TAB = 9;
    public static final int BKSP = 8;
    public static final int DAYS = 3;
    public static final int MAX_PATIENTS = 20;
    public static final int MAX_DOCTORS = 3;
    public static final int RAND_SEED = 3;
    public static final int CHAR_NUM = 26;
    public static final int NUM_NUM = 10;
    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "admin123";

    // Determine the current working directory
    static String currentDirectory = System.getProperty("user.dir");

    // Construct the absolute paths using the current directory
    static String databaseFolderPath = currentDirectory + File.separator + Variables.DATABASE_FILE;
    static String accountFilePath = currentDirectory + File.separator + Variables.ACCOUNT_FILE;
    static String patientFilePath = currentDirectory + File.separator + Variables.PATIENT_FILE;
    static String doctorFilePath = currentDirectory + File.separator + Variables.DOCTOR_FILE;
    static String keyFilePath = currentDirectory + File.separator + Variables.KEY_FILE;
    static String schedulesFolderPath = currentDirectory + File.separator + Variables.FOLDER;

}

public class Main {
    // Linked List Declaration
    private LinkedList<LIST> L;
    private List<DOCTOR> doctors;
    String globalUsername;

    public void display() {
        int count = 0;

        for (LIST current : L) {
            System.out.println(++count + ".) Username: " + current.accounts.username + " | Password: "
                    + current.accounts.password + " | Name: " + current.accounts.name + " | Age: "
                    + current.accounts.age + " | Sex: " + current.accounts.sex + " | Birthday: " + current.accounts.bday
                    + " | Contact Number: " + current.accounts.contact_number);
            current = current.next;
        }
    }

    public static void main(String[] args) {

        // Create Directory
        File folder_path = new File(Variables.databaseFolderPath);
        folder_path.mkdir();
        File database_folder = new File(Variables.schedulesFolderPath);
        database_folder.mkdir();

        Main obj = new Main();
        Encryption encrypt = new Encryption();
        File scan = new File(Variables.keyFilePath);
        if (scan.exists()) {
            encrypt.retrieveKey();
        }
        else {
            encrypt.setKey(70);
            encrypt.saveKey();
        }
        obj.retrieve();
        obj.display();
        new UIPatientList(obj);
        // new UIWelcome();
        // new UILogin(obj);
    }

    // ===============================================
    // Class Attributes and Methods
    // ===============================================

    public class ACCOUNT {
        private String username;
        private String password;
        private String name;
        private String sex;
        private String bday;
        private String contact_number;
        private String appointment_date;
        private String appointment_doctor;
        private String appointment_doctor_department;
        private String appointment_doctor_schedule;
        private String appointment_doctor_email;
        private String appointment_doctor_contact_number;
        private String appointment_code;
        private int age;
        private int payment_status;

        ACCOUNT(String username, String password, String name, int age, String sex, String bday,
                String contact_number) {
            this.setUsername(username);
            this.setPassword(password);
            this.setName(name);
            this.setAge(age);
            this.setSex(sex);
            this.setBday(bday);
            this.setContactNumber(contact_number);
            this.setAppointmentDate("");
            this.setAppointmentDoctor("");
            this.setAppointmentDoctorDepartment("");
            this.setAppointmentDoctorSchedule("");
            this.setAppointmentDoctorEmail("");
            this.setAppointmentDoctorContactNumber("");
            this.setAppointmentCode("");
            this.setPaymentStatus(0);
        }

        ACCOUNT() {
        }

        // Getter methods
        public String getUsername() {
            return this.username;
        }

        public String getPassword() {
            return this.password;
        }

        public String getName() {
            return this.name;
        }

        public int getAge() {
            return this.age;
        }

        public String getSex() {
            return this.sex;
        }

        public String getBday() {
            return this.bday;
        }

        public String getContactNumber() {
            return this.contact_number;
        }

        public String getAppointmentDate() {
            return this.appointment_date;
        }

        public String getAppointmentDoctor() {
            return this.appointment_doctor;
        }

        public String getAppointmentDoctorDepartment() {
            return this.appointment_doctor_department;
        }

        public String getAppointmentDoctorSchedule() {
            return this.appointment_doctor_schedule;
        }

        public String getAppointmentDoctorEmail() {
            return this.appointment_doctor_email;
        }

        public String getAppointmentDoctorContactNumber() {
            return this.appointment_doctor_contact_number;
        }

        public String getAppointmentCode() {
            return this.appointment_code;
        }

        public int getPaymentStatus() {
            return this.payment_status;
        }

        // Setter methods
        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public void setBday(String bday) {
            this.bday = bday;
        }

        public void setContactNumber(String contact_number) {
            this.contact_number = contact_number;
        }

        public void setAppointmentDate(String appointment_date) {
            this.appointment_date = appointment_date;
        }

        public void setAppointmentDoctor(String appointment_doctor) {
            this.appointment_doctor = appointment_doctor;
        }

        public void setAppointmentDoctorDepartment(String appointment_doctor_department) {
            this.appointment_doctor_department = appointment_doctor_department;
        }

        public void setAppointmentDoctorSchedule(String appointment_doctor_schedule) {
            this.appointment_doctor_schedule = appointment_doctor_schedule;
        }

        public void setAppointmentDoctorEmail(String appointment_doctor_email) {
            this.appointment_doctor_email = appointment_doctor_email;
        }

        public void setAppointmentDoctorContactNumber(String appointment_doctor_contact_number) {
            this.appointment_doctor_contact_number = appointment_doctor_contact_number;
        }

        public void setAppointmentCode(String appointment_code) {
            this.appointment_code = appointment_code;
        }

        public void setPaymentStatus(int payment_status) {
            this.payment_status = payment_status;
        }
    }

    public class APPOINTMENT {
        private String date;
        private int num_patients;

        APPOINTMENT(String date, int num_patients) {
            this.setDate(date);
            this.setNumPatients(num_patients);
        }

        APPOINTMENT() {
        }

        // getters method
        public String getDate() {
            return this.date;
        }

        public int getNumPatients() {
            return this.num_patients;
        }

        // setters for methods
        public void setDate(String date) {
            this.date = date;
        }

        public void setNumPatients(int num_patients) {
            this.num_patients = num_patients;
        }
    }

    public class DOCTOR {
        private String name;
        private String department;
        private String schedule;
        private String email;
        private String contact_number;

        DOCTOR(String name, String department, String schedule, String email, String contact_number) {
            this.setName(name);
            this.setDepartment(department);
            this.setSchedule(schedule);
            this.setEmail(email);
            this.setContactNumber(contact_number);
        }

        DOCTOR() {
        }

        // getters method
        public String getName() {
            return this.name;
        }

        public String getDepartment() {
            return this.department;
        }

        public String getSchedule() {
            return this.schedule;
        }

        public String getEmail() {
            return this.email;
        }

        public String getContactNumber() {
            return this.contact_number;
        }

        // setters method
        public void setName(String name) {
            this.name = name;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public void setSchedule(String schedule) {
            this.schedule = schedule;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setContactNumber(String contact_number) {
            this.contact_number = contact_number;
        }
    }

    public class LIST {
        private ACCOUNT accounts;
        private LIST next;
    }

    public Main() {
        L = new LinkedList<>();
        doctors = new ArrayList<>();
        listofDoctors();
    }

    // ===============================================
    // Data Structure Function
    // ===============================================

    public void add(ACCOUNT x) {
        LIST newNode = new LIST();
        newNode.accounts = x;

        newNode.next = L.isEmpty() ? null : L.getFirst();
        L.addFirst(newNode);
    }

    // ===============================================
    // Account Methods
    // ===============================================

    private boolean isUsernameExists(String username) {
        if (L == null) {
            return false;
        }

        for (LIST node : L) {
            if (node.accounts.username.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean inputPatientInformation(String username, String password, String name, int age, String sex, String bday,
            String contact_number) {
        if (isUsernameExists(username)) {
            return false;
        }

        // If does not exists store in global variable
        globalUsername = username;

        ACCOUNT acc = new ACCOUNT(username, password, name, age, sex, bday, contact_number);
        add(acc);
        return true;
    }

    public boolean login_Account(String username, String password) {
        // If exists store in global variable
        globalUsername = username;

        // Validate Username
        for (LIST lists : L) {
            if (lists.accounts.username.equals(username)) {
                if (lists != null && lists.accounts.password.equals(password)) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }

    // ===============================================
    // Patient Appointment Methods
    // ===============================================

    public APPOINTMENT[] generateAppointmentSchedules() {
        APPOINTMENT[] slot = new APPOINTMENT[Variables.DAYS];
        LocalDate tomorrowdate = LocalDate.now().plusDays(1);

        for (int i = 0; i < Variables.DAYS; i++) {
            APPOINTMENT patientslot = new APPOINTMENT();
            patientslot.date = tomorrowdate.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));

            // Chech the Slot Number in the File
            patientslot.num_patients = checkPatientSlotFile(patientslot.date);

            slot[i] = patientslot;
            tomorrowdate = tomorrowdate.plusDays(1);
        }
        return slot;
    }

    private static int checkPatientSlotFile(String DTIME) {
        String filePath = Variables.schedulesFolderPath + DTIME;
        try (BufferedReader inFile = new BufferedReader(new FileReader(filePath));) {
            String slotNum;
            slotNum = inFile.readLine();
            return Integer.parseInt(slotNum);
        }
        catch (IOException e) {
            System.out.println("Error opening/reading to file: " + e.getMessage());
        }
        return 0;
    }

    public static void savePatientSlotFile(String DTIME, int numPatient) {
        String filePath = Variables.schedulesFolderPath + DTIME;
        try (BufferedWriter outFile = new BufferedWriter(new FileWriter(filePath));) {
            outFile.write(Integer.toString(numPatient));
        }
        catch (IOException e) {
            System.out.println("Error opening/reading to file: " + e.getMessage());
        }
    }

    public String appointmentCode() {
        Random random = new Random();
        StringBuffer code = new StringBuffer();

        // Generate the appointment code
        char randChar = (char) (random.nextInt(26) + 'A');
        code.append(randChar);
        int min = 100, max = 999;
        int randNum = random.nextInt(max - min + 1) + min;
        code.append(randNum);

        return code.toString();
    }

    public DOCTOR appointDoctor() {     
        Random random = new Random();
        int randNum = random.nextInt(Variables.MAX_DOCTORS);

        return doctors.get(randNum);
    }

    public void listofDoctors() {
        doctors.add(new DOCTOR("Dr. John Smith", "OPD", "Monday to Tuesday - 9:00am to 5:00pm", "john.smith@tupmc.com",
                        "09123456789"));
        doctors.add(new DOCTOR("Dr. Sarah Lee", "OPD", "Wednesday to Thursday - 10:00am to 6:00pm", "sarah.lee@hospital.com",
                        "09987654321"));
        doctors.add(new DOCTOR("Dr. Alex Murray", "OPD", "Friday to Saturday - 9:00am to 5:00pm", "alex.murray@tupmc.com", "09918273645"));
    }

    private static void updatePatientAppointment(LIST current, APPOINTMENT sched, DOCTOR doc, String code) {
        current.accounts.setAppointmentCode(code);
        current.accounts.setAppointmentDate(sched.getDate());
        current.accounts.setAppointmentDoctor(doc.getName());
        current.accounts.setAppointmentDoctorContactNumber(doc.getContactNumber());
        current.accounts.setAppointmentDoctorDepartment(doc.getDepartment());
        current.accounts.setAppointmentDoctorEmail(doc.getEmail());
        current.accounts.setAppointmentDoctorSchedule(doc.getSchedule());
    }

    public void updatePatientInformation (String username, String password, String name, int age, String sex, String bday,
            String contact_number) {
        for (LIST current : L) {
            if (current != null && current.accounts != null && current.accounts.getUsername() != null) {
                if (current.accounts.getUsername().equals(globalUsername)) {
                    current.accounts.setUsername(username);
                    current.accounts.setPassword(password);
                    current.accounts.setName(name);
                    current.accounts.setAge(age);
                    current.accounts.setBday(bday);
                    current.accounts.setContactNumber(contact_number);
                }
            }
        }
    }

    public void appointmentSchedule(APPOINTMENT selectedSlot, DOCTOR selectedDoctor, String code) {
        LIST currentAccount = getCurrentUserAccount();

        selectedSlot.num_patients++;
        updatePatientAppointment(currentAccount, selectedSlot, selectedDoctor, code);
        savePatientSlotFile(currentAccount.accounts.getAppointmentDate(), selectedSlot.num_patients);
    }

    public String confirmationCode() {
        Random random = new Random();
        StringBuffer code = new StringBuffer();
        int length = 5;

        // Generate confirmation code
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                char randChar = (char) (random.nextInt(26) + 'A');
                code.append(randChar);
            }
            else {
                int randNum = random.nextInt(10);
                code.append(randNum);
            }
        }
        return code.toString();
    }

    public void paymentMethod() {
        // Check if the user has already paid the appointment
        LIST currentAccount = getCurrentUserAccount();

        // Update Payment Status
        if (currentAccount != null && currentAccount.accounts != null) {
            currentAccount.accounts.setPaymentStatus(1);
        }
        return;
    }
    
    // ===============================================
    // Getter Methods
    // ===============================================
    
    public LIST getCurrentUserAccount() {
        for (LIST current : L) {
            if (current != null && current.accounts != null && current.accounts.getUsername() != null) {
                if (current.accounts.getUsername().equals(globalUsername)) {
                    return current;
                }
            }
        }
        return null;
    }

    public String getCurrentUserName() {
        return globalUsername;
    }

    public String getCurrentPassword() {
        for (LIST current : L) {
            if (current != null && current.accounts != null && current.accounts.getUsername() != null) {
                if (current.accounts.getUsername().equals(globalUsername)) {
                    return current.accounts.getPassword();
                }
            }
        }
        return null;
    }

    public String getCurrentSchedule() {
        for (LIST current : L) {
            if (current != null && current.accounts != null && current.accounts.getUsername() != null) {
                if (current.accounts.getUsername().equals(globalUsername)) {
                    return current.accounts.getAppointmentDate();
                }
            }
        }
        return "";
    }

    public String getCurrentName() {
        for (LIST current : L) {
            if (current != null && current.accounts != null && current.accounts.getUsername() != null) {
                if (current.accounts.getUsername().equals(globalUsername)) {
                    return current.accounts.getName();
                }
            }
        }
        return "";
    }

    public int getCurrentAge() {
        for (LIST current : L) {
            if (current != null && current.accounts != null && current.accounts.getUsername() != null) {
                if (current.accounts.getUsername().equals(globalUsername)) {
                    return current.accounts.getAge();
                }
            }
        }
        return 1;
    }

    public String getCurrentContactNumber() {
        for (LIST current : L) {
            if (current != null && current.accounts != null && current.accounts.getUsername() != null) {
                if (current.accounts.getUsername().equals(globalUsername)) {
                    return current.accounts.getContactNumber();
                }
            }
        }
        return "";
    }

    public String getCurrentSex() {
        for (LIST current : L) {
            if (current != null && current.accounts != null && current.accounts.getUsername() != null) {
                if (current.accounts.getUsername().equals(globalUsername)) {
                    return current.accounts.getSex();
                }
            }
        }
        return "";
    }

    public String getCurrentBirthday() {
        for (LIST current : L) {
            if (current != null && current.accounts != null && current.accounts.getUsername() != null) {
                if (current.accounts.getUsername().equals(globalUsername)) {
                    return current.accounts.getBday();
                }
            }
        }
        return "";
    }

    public int getCurrentPayment() {
        for (LIST current : L) {
            if (current != null && current.accounts != null && current.accounts.getUsername() != null) {
                if (current.accounts.getUsername().equals(globalUsername)) {
                    return current.accounts.getPaymentStatus();
                }
            }
        }
        return 0;
    }

    public String getCurrentAppointmentCode() {
        for (LIST current : L) {
            if (current != null && current.accounts != null && current.accounts.getUsername() != null
                    && current.accounts.getAppointmentCode() != null) {
                if (current.accounts.getUsername().equals(globalUsername)) {
                    return current.accounts.getAppointmentCode();
                }
            }
        }
        return "";
    }

    public String getCurrentAppointmentDate() {
        for (LIST current : L) {
            if (current != null && current.accounts != null && current.accounts.getUsername() != null
                    && current.accounts.getAppointmentDate() != null) {
                if (current.accounts.getUsername().equals(globalUsername)) {
                    return current.accounts.getAppointmentDate();
                }
            }
        }
        return "";
    }

    public String getCurrentAppointmentDoctor() {
        for (LIST current : L) {
            if (current != null && current.accounts != null && current.accounts.getUsername() != null
                    && current.accounts.getAppointmentDoctor() != null) {
                if (current.accounts.getUsername().equals(globalUsername)) {
                    return current.accounts.getAppointmentDoctor();
                }
            }
        }
        return "";
    }

    public String getCurrentAppointmentDoctorDepartment() {
        for (LIST current : L) {
            if (current != null && current.accounts != null && current.accounts.getUsername() != null
                    && current.accounts.getAppointmentDoctorDepartment() != null) {
                if (current.accounts.getUsername().equals(globalUsername)) {
                    return current.accounts.getAppointmentDoctorDepartment();
                }
            }
        }
        return "";
    }

    public String getCurrentAppointmentDoctorSchedule() {
        for (LIST current : L) {
            if (current != null && current.accounts != null && current.accounts.getUsername() != null
                    && current.accounts.getAppointmentDoctorSchedule() != null) {
                if (current.accounts.getUsername().equals(globalUsername)) {
                    return current.accounts.getAppointmentDoctorSchedule();
                }
            }
        }
        return "";
    }

    public String getCurrentAppointmentDoctorEmail() {
        for (LIST current : L) {
            if (current != null && current.accounts != null && current.accounts.getUsername() != null
                    && current.accounts.getAppointmentDoctorEmail() != null) {
                if (current.accounts.getUsername().equals(globalUsername)) {
                    return current.accounts.getAppointmentDoctorEmail();
                }
            }
        }
        return "";
    }

    public String getCurrentAppointmentDoctorContactNumber() {
        for (LIST current : L) {
            if (current != null && current.accounts != null && current.accounts.getUsername() != null
                    && current.accounts.getAppointmentDoctorContactNumber() != null) {
                if (current.accounts.getUsername().equals(globalUsername)) {
                    return current.accounts.getAppointmentDoctorContactNumber();
                }
            }
        }
        return "";
    }

    public ArrayList<ACCOUNT> getAccountList() {
        ArrayList<ACCOUNT> accountList = new ArrayList<>();

        for (LIST current : L) {
            accountList.add(current.accounts);
        }

        return accountList;
    }

    public ArrayList<DOCTOR> getDoctorList() {
        ArrayList<DOCTOR> doctorlists = new ArrayList<>();

        for (DOCTOR current : doctors) {
            doctorlists.add(current);
        }
        return doctorlists;
    }
    
    // ===============================================
    // File Handling Methods
    // ===============================================

    public void save() {
        Encryption encryptions = new Encryption(); // instantiation

        try (BufferedWriter outFile = new BufferedWriter(new FileWriter(Variables.accountFilePath));
                BufferedWriter outFile2 = new BufferedWriter(new FileWriter(Variables.patientFilePath));
                BufferedWriter outFile3 = new BufferedWriter(new FileWriter(Variables.doctorFilePath));) {

            outFile.write("Username, Password\n");
            outFile2.write("Name,Sex,Birthday,Contact_Number,Appointment_Date,Code,Age\n");
            outFile3.write("Name,Department,Schedule,Email,Contact_Number,Payment_Status\n");

            for (LIST current : L) {
                // Encrypt the File Informations
                String encryptedUsername = encryptions.encryptDecrypt(current.accounts.getUsername());
                String encryptedPassword = encryptions.encryptDecrypt(current.accounts.getPassword());
                String encryptedName = encryptions.encryptDecrypt(current.accounts.getName());
                String encryptedSex = encryptions.encryptDecrypt(current.accounts.getSex());
                String encryptedBday = encryptions.encryptDecrypt(current.accounts.getBday());
                String encryptedContactNumber = encryptions.encryptDecrypt(current.accounts.getContactNumber());
                String encryptedAppointmentDate = encryptions.encryptDecrypt(current.accounts.getAppointmentDate());
                String encryptedAppointmentCode = encryptions.encryptDecrypt(current.accounts.getAppointmentCode());
                String encryptedAge = encryptions.encryptDecrypt(Integer.toString(current.accounts.getAge()));
                String encryptedAppointmentDoctor = encryptions.encryptDecrypt(current.accounts.getAppointmentDoctor());
                String encryptedAppointmentDoctorDepartment = encryptions
                        .encryptDecrypt(current.accounts.getAppointmentDoctorDepartment());
                String encryptedAppointmentDoctorSchedule = encryptions
                        .encryptDecrypt(current.accounts.getAppointmentDoctorSchedule());
                String encryptedAppointmentDoctorEmail = encryptions
                        .encryptDecrypt(current.accounts.getAppointmentDoctorEmail());
                String encryptedAppointmentDoctorContactNumber = encryptions
                        .encryptDecrypt(current.accounts.getAppointmentDoctorContactNumber());
                String encryptedPaymentStatus = encryptions
                        .encryptDecrypt(Integer.toString(current.accounts.getPaymentStatus()));

                // Encoded the Encrypted Texts with Base64
                String encodedUsername = encryptions.encodeToBase64(encryptedUsername);
                String encodedPassword = encryptions.encodeToBase64(encryptedPassword);
                String encodedName = encryptions.encodeToBase64(encryptedName);
                String encodedSex = encryptions.encodeToBase64(encryptedSex);
                String encodedBday = encryptions.encodeToBase64(encryptedBday);
                String encodedContactNumber = encryptions.encodeToBase64(encryptedContactNumber);
                String encodedAppointmentDate = encryptions.encodeToBase64(encryptedAppointmentDate);
                String encodedAppointmentCode = encryptions.encodeToBase64(encryptedAppointmentCode);
                String encodedAge = encryptions.encodeToBase64(encryptedAge);
                String encodedAppointmentDoctor = encryptions.encodeToBase64(encryptedAppointmentDoctor);
                String encodedAppointmentDoctorDepartment = encryptions
                        .encodeToBase64(encryptedAppointmentDoctorDepartment);
                String encodedAppointmentDoctorSchedule = encryptions
                        .encodeToBase64(encryptedAppointmentDoctorSchedule);
                String encodedAppointmentDoctorEmail = encryptions.encodeToBase64(encryptedAppointmentDoctorEmail);
                String encodedAppointmentDoctorContactNumber = encryptions
                        .encodeToBase64(encryptedAppointmentDoctorContactNumber);
                String encodedPaymentStatus = encryptions.encodeToBase64(encryptedPaymentStatus);

                // Write in the File
                outFile.write(encodedUsername + "," + encodedPassword + "\n");
                outFile2.write(encodedName + "," + encodedSex + "," + encodedBday + "," + encodedContactNumber + ","
                        + encodedAppointmentDate + "," + encodedAppointmentCode + "," + encodedAge + "\n");
                outFile3.write(encodedAppointmentDoctor + "," + encodedAppointmentDoctorDepartment + ","
                        + encodedAppointmentDoctorSchedule + "," + encodedAppointmentDoctorEmail + ","
                        + encodedAppointmentDoctorContactNumber + "," + encodedPaymentStatus + "\n");
            }
        }
        catch (IOException e) {
            System.out.println("Error opening/writing to file: " + e.getMessage());
        }
    }

    public void retrieve() {
        Encryption encryptions = new Encryption();
        try (BufferedReader inFile = new BufferedReader(new FileReader(Variables.accountFilePath));
                BufferedReader inFile2 = new BufferedReader(new FileReader(Variables.patientFilePath));
                BufferedReader inFile3 = new BufferedReader(new FileReader(Variables.doctorFilePath));) {
            // Skip First Line
            inFile.readLine();
            inFile2.readLine();
            inFile3.readLine();

            String line1, line2, line3;
            while ((line1 = inFile.readLine()) != null && (line2 = inFile2.readLine()) != null
                    && (line3 = inFile3.readLine()) != null) {
                // Read the data from the file and split it
                String[] accountList = line1.split(",");
                String[] patientList = line2.split(",");
                String[] doctorlist = line3.split(",");

                // Decode the encrypted texts using Base64
                byte[] decodeUsername = encryptions.decodeToBase64(accountList[0]);
                byte[] decodePassword = encryptions.decodeToBase64(accountList[1]);
                byte[] decodeName = encryptions.decodeToBase64(patientList[0]);
                byte[] decodeSex = encryptions.decodeToBase64(patientList[1]);
                byte[] decodeBday = encryptions.decodeToBase64(patientList[2]);
                byte[] decodeContactNumber = encryptions.decodeToBase64(patientList[3]);
                byte[] decodeAppointmentDate = encryptions.decodeToBase64(patientList[4]);
                byte[] decodeAppointmentCode = encryptions.decodeToBase64(patientList[5]);
                byte[] decodeAge = encryptions.decodeToBase64(patientList[6]);
                byte[] decodeAppointmentDoctor = encryptions.decodeToBase64(doctorlist[0]);
                byte[] decodeAppointmentDoctorDepartment = encryptions.decodeToBase64(doctorlist[1]);
                byte[] decodeAppointmentDoctorSchedule = encryptions.decodeToBase64(doctorlist[2]);
                byte[] decodeAppointmentDoctorEmail = encryptions.decodeToBase64(doctorlist[3]);
                byte[] decodeAppointmentDoctorContactNumber = encryptions.decodeToBase64(doctorlist[4]);
                byte[] decodePaymentStatus = encryptions.decodeToBase64(doctorlist[5]);

                // Convert the decoded arrays to Strings
                String convertToStringUsername = encryptions.convertToString(decodeUsername);
                String convertToStringPassword = encryptions.convertToString(decodePassword);
                String convertToStringName = encryptions.convertToString(decodeName);
                String convertToStringSex = encryptions.convertToString(decodeSex);
                String convertToStringBday = encryptions.convertToString(decodeBday);
                String convertToStringContactNumber = encryptions.convertToString(decodeContactNumber);
                String convertToStringAppointmentDate = encryptions.convertToString(decodeAppointmentDate);
                String convertToStringAppointmentCode = encryptions.convertToString(decodeAppointmentCode);
                String convertToStringAge = encryptions.convertToString(decodeAge);
                String convertToStringAppointmentDoctor = encryptions.convertToString(decodeAppointmentDoctor);
                String convertToStringAppointmentDoctorDepartment = encryptions
                        .convertToString(decodeAppointmentDoctorDepartment);
                String convertToStringAppointmentDoctorSchedule = encryptions
                        .convertToString(decodeAppointmentDoctorSchedule);
                String convertToStringAppointmentDoctorEmail = encryptions
                        .convertToString(decodeAppointmentDoctorEmail);
                String convertToStringAppointmentDoctorContactNumber = encryptions
                        .convertToString(decodeAppointmentDoctorContactNumber);
                String convertToStringPaymentStatus = encryptions.convertToString(decodePaymentStatus);

                // Decrypt the Strings
                String decryptedUsername = encryptions.encryptDecrypt(convertToStringUsername);
                String decryptedPassword = encryptions.encryptDecrypt(convertToStringPassword);
                String decryptedName = encryptions.encryptDecrypt(convertToStringName);
                String decryptedSex = encryptions.encryptDecrypt(convertToStringSex);
                String decryptedBday = encryptions.encryptDecrypt(convertToStringBday);
                String decryptedContactNumber = encryptions.encryptDecrypt(convertToStringContactNumber);
                String decryptedAppointmentDate = encryptions.encryptDecrypt(convertToStringAppointmentDate);
                String decryptedAppointmentCode = encryptions.encryptDecrypt(convertToStringAppointmentCode);
                String decryptedAge = encryptions.encryptDecrypt(convertToStringAge);
                String decryptedAppointmentDoctor = encryptions.encryptDecrypt(convertToStringAppointmentDoctor);
                String decryptedAppointmentDoctorDepartment = encryptions
                        .encryptDecrypt(convertToStringAppointmentDoctorDepartment);
                String decryptedAppointmentDoctorSchedule = encryptions
                        .encryptDecrypt(convertToStringAppointmentDoctorSchedule);
                String decryptedAppointmentDoctorEmail = encryptions
                        .encryptDecrypt(convertToStringAppointmentDoctorEmail);
                String decryptedAppointmentDoctorContactNumber = encryptions
                        .encryptDecrypt(convertToStringAppointmentDoctorContactNumber);
                String decryptedPaymentStatus = encryptions.encryptDecrypt(convertToStringPaymentStatus);

                // Create an ACCOUNT Objects
                ACCOUNT account = new ACCOUNT();
                account.setUsername(decryptedUsername);
                account.setPassword(decryptedPassword);
                account.setName(decryptedName);
                account.setSex(decryptedSex);
                account.setBday(decryptedBday);
                account.setContactNumber(decryptedContactNumber);
                account.setAppointmentDate(decryptedAppointmentDate);
                account.setAppointmentCode(decryptedAppointmentCode);
                account.setAge(Integer.parseInt(decryptedAge));
                account.setAppointmentDoctor(decryptedAppointmentDoctor);
                account.setAppointmentDoctorDepartment(decryptedAppointmentDoctorDepartment);
                account.setAppointmentDoctorSchedule(decryptedAppointmentDoctorSchedule);
                account.setAppointmentDoctorEmail(decryptedAppointmentDoctorEmail);
                account.setAppointmentDoctorContactNumber(decryptedAppointmentDoctorContactNumber);
                account.setPaymentStatus(Integer.parseInt(decryptedPaymentStatus));

                add(account);
            }
        }
        catch (IOException e) {
            System.out.println("Error opening/reading to file: " + e.getMessage());
        }
    }

}