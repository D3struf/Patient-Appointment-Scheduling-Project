import os
import random
import datetime


class Variables:
    DATABASE_FOLDER = "database"
    ACCOUNT_FILE = DATABASE_FOLDER + "/account.txt"
    PATIENT_FILE = DATABASE_FOLDER + "/patient.txt"
    DOCTOR_FILE = DATABASE_FOLDER + "/doctor.txt"
    KEY_FILE = DATABASE_FOLDER + "/key.txt"
    SCHEDULE_FOLDER = DATABASE_FOLDER + "/Schedules"
    HOSPITAL_NAME = "TUP-Manila Medical Center"
    RESERVATION_FEE = 150
    ENTER = 13
    TAB = 9
    BKSP = 8
    DAYS = 3
    MAX_PATIENTS = 20
    MAX_DOCTORS = 3
    RAND_SEED = 3
    CHAR_NUM = 26
    NUM_NUM = 10
    ADMIN_USERNAME = "admin"
    ADMIN_PASSWORD = "admin123"

    # Determine the current working directory
    # currentDirectory = os.getcwd()

    # Construct the absolute paths using the current directory
    # databaseFolderPath = os.path.join(currentDirectory, DATABASE_FOLDER)
    # accountFilePath = os.path.join(currentDirectory, ACCOUNT_FILE)
    # patientFilePath = os.path.join(currentDirectory, PATIENT_FILE)
    # doctorFilePath = os.path.join(currentDirectory, DOCTOR_FILE)
    # keyFilePath = os.path.join(currentDirectory, KEY_FILE)
    # schedulesFolderPath = os.path.join(currentDirectory, FOLDER)


# =================================================================
#                           Global Variables
# =================================================================
L = []
doctors = []
globalUsername = ""


class Main:

    def __init__(self):
        self.L = LinkedList()
        self.doctors = []
        self.listofDoctors()

    L = []
    doctors = []
    globalUsername = ""

    def display(self):
        count = 0
        for current in self.L:
            print(str(count + 1) + ".) Username: " + current.accounts.username + " | Password: "
                  + current.accounts.password + " | Name: " + current.accounts.name + " | Age: "
                  + current.accounts.age + " | Sex: " + current.accounts.sex + " | Birthday: " + current.accounts.bday
                  + " | Contact Number: " + current.accounts.contact_number)
            current = current.next
            count += 1


class Account:
    def __init__(self, username, password, name, age, sex, bday, contact_number):
        self.username = username
        self.password = password
        self.name = name
        self.age = age
        self.sex = sex
        self.bday = bday
        self.contact_number = contact_number
        self.appointment_date = ""
        self.appointment_doctor = ""
        self.appointment_doctor_department = ""
        self.appointment_doctor_schedule = ""
        self.appointment_doctor_email = ""
        self.appointment_doctor_contact_number = ""
        self.appointment_code = ""
        self.payment_status = 0

    # Getter methods
    def get_username(self):
        return self.username

    def get_password(self):
        return self.password

    def get_name(self):
        return self.name

    def get_age(self):
        return self.age

    def get_sex(self):
        return self.sex

    def get_bday(self):
        return self.bday

    def get_contact_number(self):
        return self.contact_number

    def get_appointment_date(self):
        return self.appointment_date

    def get_appointment_doctor(self):
        return self.appointment_doctor

    def get_appointment_doctor_department(self):
        return self.appointment_doctor_department

    def get_appointment_doctor_schedule(self):
        return self.appointment_doctor_schedule

    def get_appointment_doctor_email(self):
        return self.appointment_doctor_email

    def get_appointment_doctor_contact_number(self):
        return self.appointment_doctor_contact_number

    def get_appointment_code(self):
        return self.appointment_code

    def get_payment_status(self):
        return self.payment_status

    # Setter methods
    def set_username(self, username):
        self.username = username

    def set_password(self, password):
        self.password = password

    def set_name(self, name):
        self.name = name

    def set_age(self, age):
        self.age = age

    def set_sex(self, sex):
        self.sex = sex

    def set_bday(self, bday):
        self.bday = bday

    def set_contact_number(self, contact_number):
        self.contact_number = contact_number

    def set_appointment_date(self, appointment_date):
        self.appointment_date = appointment_date

    def set_appointment_doctor(self, appointment_doctor):
        self.appointment_doctor = appointment_doctor

    def set_appointment_doctor_department(self, appointment_doctor_department):
        self.appointment_doctor_department = appointment_doctor_department

    def set_appointment_doctor_schedule(self, appointment_doctor_schedule):
        self.appointment_doctor_schedule = appointment_doctor_schedule

    def set_appointment_doctor_email(self, appointment_doctor_email):
        self.appointment_doctor_email = appointment_doctor_email

    def set_appointment_doctor_contact_number(self, appointment_doctor_contact_number):
        self.appointment_doctor_contact_number = appointment_doctor_contact_number

    def set_appointment_code(self, appointment_code):
        self.appointment_code = appointment_code

    def set_payment_status(self, payment_status):
        self.payment_status = payment_status


class Appointment:
    def __init__(self, date, num_patients):
        self.date = date
        self.num_patients = num_patients

    # Getter methods
    def get_date(self):
        return self.date

    def get_num_patients(self):
        return self.num_patients

    # Setter methods
    def set_date(self, date):
        self.date = date

    def set_num_patients(self, num_patients):
        self.num_patients = num_patients


class Doctor:
    def __init__(self, name, department, schedule, email, contact_number):
        self.name = name
        self.department = department
        self.schedule = schedule
        self.email = email
        self.contact_number = contact_number

    # Getter methods
    def get_name(self):
        return self.name

    def get_department(self):
        return self.department

    def get_schedule(self):
        return self.schedule

    def get_email(self):
        return self.email

    def get_contact_number(self):
        return self.contact_number

    # Setter methods
    def set_name(self, name):
        self.name = name

    def set_department(self, department):
        self.department = department

    def set_schedule(self, schedule):
        self.schedule = schedule

    def set_email(self, email):
        self.email = email

    def set_contact_number(self, contact_number):
        self.contact_number = contact_number


class LIST:
    def __init__(self):
        self.accounts = None
        self.next = None


def add(self, x):
    new_node = LIST()
    new_node.accounts = x

    new_node.next = None if L.isEmpty() else L.getFirst()
    L.addFirst(new_node)


def isUsernameExists(self, username):
    if self.L is None:
        return False

    for node in self.L:
        if node.accounts.username == username:
            return True

    return False


def inputPatientInformation(self, username, password, name, age, sex, bday, contact_number):
    if self.isUsernameExists(username):
        return False

    # If does not exist, store in global variable
    globalUsername = username

    acc = Account(username, password, name, age, sex, bday, contact_number)
    self.add(acc)
    return True


def login_Account(self, username, password):
    # If exists, store in global variable
    self.globalUsername = username

    # Validate Username
    for lists in self.L:
        if lists.accounts.username == username:
            if lists is not None and lists.accounts.password == password:
                return True
            else:
                return False

    return False


def checkPatientSlotFile(DTIME):
    filePath = Variables.SCHEDULE_FOLDER + DTIME
    try:
        with open(filePath, "r") as file:
            slotNum = file.readline()
            return int(slotNum)
    except IOError as e:
        print("Error opening/reading to file: ", e)
    return 0


def savePatientSlotFile(DTIME, numPatient):
    filePath = Variables.SCHEDULE_FOLDER + DTIME
    try:
        with open(filePath, "w") as file:
            file.write(str(numPatient))
    except IOError as e:
        print("Error opening/writing to file:", e)


# ================================================
#                     MAIN
# ================================================
if __name__ == "__main__":
    os.makedirs(Variables.SCHEDULE_FOLDER, exist_ok=True)

    print("Running")
