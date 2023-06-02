import java.io.*;
import java.util.*;

class Variables {

    public static final String DATABASE_FILE = "./database";
    public static final String ACCOUNT_FILE = "./database/account.txt";
    public static final String PATIENT_FILE = "./database/patient.txt";
    public static final String DOCTOR_FILE = "./database/doctor.txt";
    public static final String FOLDER = "./database/Schedules/";
    public static final String HOSPITAL_NAME = "TUP-Manila Medical Center";
    public static final int RESERVATION_FEE = 150;
    public static final int ENTER = 13;
    public static final int TAB = 9;
    public static final int BKSP = 8;
    public static final int DAYS = 3;
    public static final int MAX_PATIENTS = 20;
    public static final int MAX_DOCTORS = 2;
    public static final int RAND_SEED = 3;
    public static final int CHAR_NUM = 26;
    public static final int NUM_NUM = 10;

}

public class Main {
    // Linked List Declaration
    private LinkedList<LIST> L;
    String globalUsername;

    public void display() {
        int count = 0;

        for (LIST current : L) {
            System.out.println(++count + ".) Username: " + current.accounts.username
                    + " | Password: " + current.accounts.password + " | Name: "
                    + current.accounts.name + " | Age: " + current.accounts.age
                    + " | Sex: " + current.accounts.sex + " | Birthday: "
                    + current.accounts.bday + " | Contact Number: "
                    + current.accounts.contact_number);
            current = current.next;
        }
    }

    public static void main(String[] args) {

        // Create Directory
        File folder_path = new File(Variables.FOLDER);
        folder_path.mkdir();
        File database_folder = new File(Variables.DATABASE_FILE);
        database_folder.mkdir();

        Main obj = new Main();
        obj.retrieve();
        obj.display();
        // Ask for user Account
        while (true) {
            boolean create = true, login = true;
            int choice1, choice2;
            switch (choice1 = obj.menu(1)) {
            case 1:
                login = obj.login_Account();
                break;
            case 2:
                create = obj.inputPatientInformation();
                break;
            case 3:
                obj.save();
                System.out.println(
                        "Programmed By: Monter, John Paul | Garcia, Almira Jill | Carolino, Jeanne May");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Choice, Try Again!!");
                obj.pause();
                break;
            }
            if ((choice1 == 2 && create) || (choice1 == 1 && login))
                break;
        }

        obj.display();

        // Main Menu
        while (true) {
            switch (obj.menu(3)) {
            case 1:
                obj.displayPatientInformation();
                break;
            case 2: // schedule_Appointment();
                break;
            case 3: // view_Schedule();
                break;
            case 4: // payment_Method();
                break;
            case 5:
                obj.save();
                System.out.println(
                        "Programmed By: Monter, John Paul | Garcia, Almira Jill | Carolino, Jeanne May");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Choice, Try Again!!");
                obj.pause();
                break;
            }
        }
    }

    // ===============================================
    // Class Attributes and Methods
    // ===============================================

    private class ACCOUNT {
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

        ACCOUNT(String username, String password, String name, int age, String sex,
                String bday, String contact_number) {
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

        // // Constructur for whole class
        // ACCOUNT (ACCOUNT x) {
        // this.Copy(x);
        // }

        // // Copy method for constructor
        // public void Copy(ACCOUNT x) {
        // this.setUsername(x.getUsername());
        // this.setPassword(x.getPassword());
        // this.setName(x.getName());
        // this.setAge(x.getAge());
        // this.setSex(x.getSex());
        // this.setBday(x.getBday());
        // this.setContactNumber(x.getContactNumber());
        // this.appointment_date = x.appointment_date;
        // this.appointment_doctor = x.appointment_doctor;
        // this.appointment_doctor_department = x.appointment_doctor_department;
        // this.appointment_doctor_schedule = x.appointment_doctor_schedule;
        // this.appointment_doctor_email = x.appointment_doctor_email;
        // this.appointment_doctor_contact_number =
        // x.appointment_doctor_contact_number;
        // this.appointment_code = x.appointment_code;
        // this.payment_status = x.payment_status;
        // }

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

        public void setAppointmentDoctorContactNumber(
                String appointment_doctor_contact_number) {
            this.appointment_doctor_contact_number = appointment_doctor_contact_number;
        }

        public void setAppointmentCode(String appointment_code) {
            this.appointment_code = appointment_code;
        }

        public void setPaymentStatus(int payment_status) {
            this.payment_status = payment_status;
        }
    }

    private class APPOINTMENT {
        private String date;
        private int num_patients;

        APPOINTMENT(String date, int num_patients) {
            this.setDate(date);
            this.setNumPatients(num_patients);
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

    private class DOCTOR {
        private String name;
        private String department;
        private String schedule;
        private String email;
        private String contact_number;

        DOCTOR(String name, String department, String schedule, String email,
                String contact_number) {
            this.setName(name);
            this.setDepartment(department);
            this.setSchedule(schedule);
            this.setEmail(email);
            this.setContactNumber(contact_number);
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

    private class LIST {
        private ACCOUNT accounts;
        private APPOINTMENT slots;
        private DOCTOR doctors;
        private LIST next;
    }

    public Main() {
        L = new LinkedList<>();
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

    private String get_Password(String prompt) {
        char[] passwordChars = System.console().readPassword(prompt);
        return new String(passwordChars);
    }

    public boolean inputPatientInformation() {
        Scanner scan = new Scanner(System.in);
        System.out.println("X|||||||||||||||||E-SCHED MEDICAL|||||||||||||||||X");
        System.out.println("X|||||||||||||||PATIENT APPOINTMENT|||||||||||||||X");
        System.out.println("===================================================");
        System.out.println("|||               CREATE ACCOUNT                 |||");
        System.out.println("===================================================");
        System.out.println("|||   PLEASE FILL UP THE FOLLOWING INFORMATION   |||");
        System.out.println("===================================================");

        System.out.print("Enter Username: ");
        String username = scan.nextLine();
        if (isUsernameExists(username)) {
            System.out.println("Username already exists!!");
            return false;
        }

        // If does not exists store in global variable
        globalUsername = username;

        String password = get_Password("Enter Password: ");

        System.out.print("Enter Name (FIRST NAME MIDDLE INITIAL SURNAME): ");
        String name = scan.nextLine();

        System.out.print("Enter Age: ");
        int age = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter Sex (M | F): ");
        String sex = scan.nextLine();

        System.out.print("Enter Birthday (MM/DD/YYYY): ");
        String bday = scan.nextLine();

        System.out.print("Enter Contact Number (11 Digit Number): ");
        String contact_number = scan.nextLine();

        ACCOUNT acc = new ACCOUNT(username, password, name, age, sex, bday,
                contact_number);
        add(acc);

        System.out.println("===================================================");
        System.out.println("Account Created Successfully!!");
        System.out.println("===================================================");
        pause();
        return true;
    }

    public boolean login_Account() {
        Scanner scan = new Scanner(System.in);
        System.out.println("X|||||||||||||||||E-SCHED MEDICAL|||||||||||||||||X");
        System.out.println("X|||||||||||||||PATIENT APPOINTMENT|||||||||||||||X");
        System.out.println("===================================================");
        System.out.println("|||               LOG IN ACCOUNT                |||");
        System.out.println("===================================================");
        System.out.println("|||      PLEASE ENTER YOUR ACCOUNT DETAILS      |||");
        System.out.println("===================================================");

        // Ask for Username
        System.out.print("Enter Username: ");
        String username = scan.nextLine();

        // Validate Username
        if (!isUsernameExists(username)) {
            System.out.println("Username does not exists!!");
            System.out.println("Please Create an Account first.");
            return false;
        }

        // If exists store in global variable
        globalUsername = username;

        // Temporary Account List for validation
        LIST tempAccountList = new LIST();
        for (LIST lists : L) {
            if (lists.accounts.username.equals(username)) {
                tempAccountList = lists;
                break;
            }
        }

        // Ask for Password 3 times
        int tries = 3;
        while (tries > 0) {
            String password = get_Password("Enter Password: ");

            // Validate Password
            if (tempAccountList != null
                    && password.equals(tempAccountList.accounts.password)) {
                System.out.println("===================================================");
                System.out.println("Login Successful!!");
                System.out.println("===================================================");
                pause();
                return true;
            }
            else {
                tries--;
                System.out.println("===================================================");
                System.out.println("Incorrect Password!!");
                System.out.printf("You have %d Tries Left\n", tries);
                System.out.println("===================================================");
                pause();

                if (tries == 0) {
                    System.out.println(
                            "===================================================");
                    System.out.println("You have exceeded the maximum number of tries!!");
                    System.out.println("Please try again later.");
                    System.out.println(
                            "===================================================");
                    pause();
                    System.exit(0);
                }
            }
        }
        return false;
    }

    public int menu(int x) {
        Scanner scan = new Scanner(System.in);
        clearScreen();
        if (x == 1) {
            System.out.println("X|||||||||||||||||E-SCHED MEDICAL|||||||||||||||||X");
            System.out.println("X|||||||||||||||PATIENT APPOINTMENT|||||||||||||||X");
            System.out.println("=======================================");
            System.out.println("[1] LOG IN ACCOUNT");
            System.out.println("=======================================");
            System.out.println("[2] CREATE ACCOUNT");
            System.out.println("=======================================");
            System.out.println("[3] EXIT");
            System.out.println("=======================================");
            System.out.println("ENTER CHOICE: ");
            System.out.println("=======================================");
            System.out.println("X|||||||||||||||||||||||||||||||||||||||||||||||||X");
            System.out.println("X|||||||||||||||||||||||||||||||||||||||||||||||||X");
            return scan.nextInt();
        }
        else if (x == 2) {
            System.out.println("=======================================");
            System.out.println("[1] CASH");
            System.out.println("=======================================");
            System.out.println("[2] ONLINE TRANSACTION");
            System.out.println("=======================================");
            System.out.println("[3] BACK");
            System.out.println("=======================================");
            System.out.println("ENTER CHOICE: ");
            System.out.println("=======================================");
            return scan.nextInt();
        }
        else {
            System.out.println("X|||||||||||||||||E-SCHED MEDICAL|||||||||||||||||X");
            System.out.println("X|||||||||||||||PATIENT APPOINTMENT|||||||||||||||X");
            System.out.println("=======================================");
            System.out.println("[1] View Patient Information");
            System.out.println("=======================================");
            System.out.println("[2] Schedule an Appointment");
            System.out.println("=======================================");
            System.out.println("[3] View Schedule");
            System.out.println("=======================================");
            System.out.println("[4] Payment for Appointment");
            System.out.println("=======================================");
            System.out.println("[5] Sign Out");
            System.out.println("=======================================");
            System.out.println("Enter Choice: ");
            System.out.println("=======================================");
            return scan.nextInt();
        }
    }

    // ===============================================
    // Patient Methods
    // ===============================================

    public void displayPatientInformation() {
        for (LIST current : L) {
            if (current.accounts.username.equals(globalUsername)) {
                System.out.println("X|||||||||||||||||E-SCHED MEDICAL|||||||||||||||||X");
                System.out.println("X|||||||||||||||PATIENT APPOINTMENT|||||||||||||||X");
                System.out.println("===================================================");
                System.out.println("|||               PATIENT INFORMATION           |||");
                System.out.println("===================================================");
                System.out.println(
                        "USERNAME       :           " + current.accounts.getUsername());
                System.out.println(
                        "PASSWORD       :           " + current.accounts.getPassword());
                System.out.println(
                        "NAME           :           " + current.accounts.getName());
                System.out.println(
                        "AGE            :           " + current.accounts.getAge());
                System.out.println(
                        "SEX            :           " + current.accounts.getSex());
                System.out.println(
                        "BIRTHDAY       :           " + current.accounts.getBday());
                System.out.println("CONTACT NUMBER :           "
                        + current.accounts.getContactNumber());
                System.out.println("===================================================");
                pause();
                System.out.println("===================================================");
                break;
            }
        }
    }

    // ===============================================
    // File Handling Methods
    // ===============================================

    public void save() {
        try (BufferedWriter outFile = new BufferedWriter(
                new FileWriter(Variables.ACCOUNT_FILE));
                BufferedWriter outFile2 = new BufferedWriter(
                        new FileWriter(Variables.PATIENT_FILE));) {
            outFile.write("Username, Password\n");
            outFile2.write(
                    "Name,Sex,Birthday,Contact_Number,Appointment_Date,Code,Age\n");

            for (LIST current : L) {
                outFile.write(current.accounts.getUsername() + ","
                        + current.accounts.getPassword() + "\n");
                outFile2.write(current.accounts.getName() + ","
                        + current.accounts.getSex() + "," + current.accounts.getBday()
                        + "," + current.accounts.getContactNumber() + ","
                        + current.accounts.getAppointmentDate() + ","
                        + current.accounts.getAppointmentCode() + ","
                        + current.accounts.getAge() + "\n");
            }
        }
        catch (IOException e) {
            System.out.println("Error opening/writing to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void retrieve() {
        try (BufferedReader inFile = new BufferedReader(
                new FileReader(Variables.ACCOUNT_FILE));
                BufferedReader inFile2 = new BufferedReader(
                        new FileReader(Variables.PATIENT_FILE));) {
            // Skip First Line
            inFile.readLine();
            inFile2.readLine();

            String line1, line2;
            while ((line1 = inFile.readLine()) != null
                    && (line2 = inFile2.readLine()) != null) {
                // Read the data from the file and split it
                String[] accountList = line1.split(",");
                String[] patientList = line2.split(",");

                // Create an ACCOUNT Objects
                ACCOUNT account = new ACCOUNT();
                account.setUsername(accountList[0]);
                account.setPassword(accountList[1]);
                account.setName(patientList[0]);
                account.setSex(patientList[1]);
                account.setBday(patientList[2]);
                account.setContactNumber(patientList[3]);
                account.setAppointmentDate(patientList[4]);
                account.setAppointmentCode(patientList[5]);
                account.setAge(Integer.parseInt(patientList[6]));

                add(account);
            }
        }
        catch (IOException e) {
            System.out.println("Error opening/reading to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ===============================================
    // UI FUNCTIONS
    // ===============================================

    public void pause() {
        Scanner pause = new Scanner(System.in);
        System.out.println("\nPRESS ENTER KEY TO CONTINUE...");
        try {
            pause.nextLine();
        }
        catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
            pause.close();
        }
    }

    void clearScreen() {
        // Clear the console by printing multiple empty lines
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}