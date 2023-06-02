import java.util.LinkedList;

public class AppointmentSystem {
    private LinkedList<Account> accounts; // LinkedList for login system
    private LinkedList<Patient> patients; // LinkedList for patient information
    private LinkedList<LinkedList<Appointment>> appointmentSchedules; // LinkedList
                                                                      // of
                                                                      // LinkedLists
                                                                      // for
                                                                      // appointment
                                                                      // schedules

    public AppointmentSystem() {
        accounts = new LinkedList<>();
        patients = new LinkedList<>();
        appointmentSchedules = new LinkedList<>();
    }

    public void createAccount(String username, String password) {
        Account account = new Account(username, password);
        accounts.add(account);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void scheduleAppointment(String username, Appointment appointment) {
        int patientIndex = findPatientByUsername(username);
        if (patientIndex != -1) {
            if (appointmentSchedules.size() > patientIndex) {
                LinkedList<Appointment> patientSchedule = appointmentSchedules
                        .get(patientIndex);
                patientSchedule.add(appointment);
            }
            else {
                LinkedList<Appointment> patientSchedule = new LinkedList<>();
                patientSchedule.add(appointment);
                appointmentSchedules.add(patientSchedule);
            }
        }
    }

    public void viewPatientInformation(String username) {
        int patientIndex = findPatientByUsername(username);
        if (patientIndex != -1) {
            Patient patient = patients.get(patientIndex);
            System.out.println(patient.toString());
        }
    }

    public void viewAppointmentSchedule(String username) {
        int patientIndex = findPatientByUsername(username);
        if (patientIndex != -1) {
            if (appointmentSchedules.size() > patientIndex) {
                LinkedList<Appointment> patientSchedule = appointmentSchedules
                        .get(patientIndex);
                for (Appointment appointment : patientSchedule) {
                    System.out.println(appointment.toString());
                }
            }
            else {
                System.out.println("No appointments found for " + username);
            }
        }
    }

    // Helper method to find patient index by username
    private int findPatientByUsername(String username) {
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            if (patient.getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }

    // Other methods and classes

    private class Account {
        private String username;
        private String password;

        public Account(String username, String password) {
            this.setUsername(username);
            this.setPassword(password);
        }

        // Getters
        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        // Setters
        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    private class Patient {
        private String username;
        private String name;
        // Other patient information

        public Patient(String username, String name) {
            this.username = username;
            this.name = name;
        }

        // Getters
        public String getUsername() {
            return username;
        }

        public String getName() {
            return name;
        }

        // Setters
        public void setUsername(String username) {
            this.username = username;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private class Appointment {
        // Appointment details
        // ...
    }
}
