import os
import random
import datetime

from linkedlist import linkedlist

import Encryption


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
        self.L = linkedlist()
        self.doctors = []
        listofDoctor()


def display():
    count = 0
    for current in L:
        print(str(count + 1) + ".) Username: " + current.accounts.username + " | Password: " + current.accounts.password + " | Name: " + current.accounts.name + " | Age: " + str(current.accounts.age) + " | Sex: " + current.accounts.sex + " | Birthday: " + current.accounts.bday + " | Contact Number: " + current.accounts.contact_number)
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
    def getUsername(self):
        return self.username

    def getPassword(self):
        return self.password

    def getName(self):
        return self.name

    def getAge(self):
        return self.age

    def getSex(self):
        return self.sex

    def getBday(self):
        return self.bday

    def getContactNumber(self):
        return self.contact_number

    def getAppointmentDate(self):
        return self.appointment_date

    def getAppointmentDoctor(self):
        return self.appointment_doctor

    def getAppointmentDoctorDepartment(self):
        return self.appointment_doctor_department

    def getAppointmentDoctorSchedule(self):
        return self.appointment_doctor_schedule

    def getAppointmentDoctorEmail(self):
        return self.appointment_doctor_email

    def getAppointmentDoctorContactNumber(self):
        return self.appointment_doctor_contact_number

    def getAppointmentCode(self):
        return self.appointment_code

    def getPaymentStatus(self):
        return self.payment_status

    # Setter methods
    def setUsername(self, username):
        self.username = username

    def setPassword(self, password):
        self.password = password

    def setName(self, name):
        self.name = name

    def setAge(self, age):
        self.age = age

    def setSex(self, sex):
        self.sex = sex

    def setBday(self, bday):
        self.bday = bday

    def setContactNumber(self, contact_number):
        self.contact_number = contact_number

    def setAppointmentDate(self, appointment_date):
        self.appointment_date = appointment_date

    def setAppointmentDoctor(self, appointment_doctor):
        self.appointment_doctor = appointment_doctor

    def setAppointmentDoctorDepartment(self, appointment_doctor_department):
        self.appointment_doctor_department = appointment_doctor_department

    def setAppointmentDoctorSchedule(self, appointment_doctor_schedule):
        self.appointment_doctor_schedule = appointment_doctor_schedule

    def setAppointmentDoctorEmail(self, appointment_doctor_email):
        self.appointment_doctor_email = appointment_doctor_email

    def setAppointmentDoctorContactNumber(self, appointment_doctor_contact_number):
        self.appointment_doctor_contact_number = appointment_doctor_contact_number

    def setAppointmentCode(self, appointment_code):
        self.appointment_code = appointment_code

    def setPaymentStatus(self, payment_status):
        self.payment_status = payment_status


class Appointment:
    def __init__(self, date, numPatients):
        self.date = date
        self.numPatients = numPatients

    # Getter methods
    def getDate(self):
        return self.date

    def getNumPatients(self):
        return self.numPatients

    # Setter methods
    def setDate(self, date):
        self.date = date

    def setNumPatients(self, numPatients):
        self.numPatients = numPatients


class Doctor:
    def __init__(self, name, department, schedule, email, contactNumber):
        self.name = name
        self.department = department
        self.schedule = schedule
        self.email = email
        self.contactNumber = contactNumber

    # Getter methods
    def getName(self):
        return self.name

    def getDepartment(self):
        return self.department

    def getSchedule(self):
        return self.schedule

    def getEmail(self):
        return self.email

    def getContactNumber(self):
        return self.contactNumber

    # Setter methods
    def setName(self, name):
        self.name = name

    def setDepartment(self, department):
        self.department = department

    def setSchedule(self, schedule):
        self.schedule = schedule

    def setEmail(self, email):
        self.email = email

    def setContactNumber(self, contactNumber):
        self.contactNumber = contactNumber


class LIST:
    def __init__(self):
        self.accounts = None
        self.next = None


def add(x):
    global L
    new_node = LIST()
    new_node.accounts = x

    new_node.next = None if L is not None else L.pop()
    L.append(new_node)


def isUsernameExists(username):
    if L is None:
        return False

    for node in L:
        if node.accounts.username == username:
            return True

    return False


def inputPatientInformation(username, password, name, age, sex, bday, contact_number):
    global globalUsername
    if isUsernameExists(username):
        return False

    # If it does not exist, store in global variable
    globalUsername = username

    acc = Account(username, password, name, age, sex, bday, contact_number)
    add(acc)
    return True


def login_Account(username, password):
    # If exists, store in global variable
    global globalUsername
    globalUsername = username

    # Validate Username
    for lists in L:
        if lists.accounts.username == username:
            if lists is not None and lists.accounts.password == password:
                return True
            else:
                return False

    return False


# =================================================================
#                   Patient Appointment Methods
# =================================================================
def generateAppointmentSchedules():
    slot = [] * Variables.DAYS
    tomorrow_date = datetime.datetime.now().date() + datetime.timedelta(days=1)

    for i in range(Variables.DAYS):
        patient_slot = Appointment(None, None)
        patient_slot.date = tomorrow_date.strftime("%b %d %Y")
        patient_slot.num_patients = checkPatientSlotFile(patient_slot.date)

        slot[i] = patient_slot
        tomorrow_date += datetime.timedelta(days=1)


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


def appointmentCode():
    randChar = chr(random.randint(65, 90))
    randNum = str(random.randint(100, 999))
    code = randChar
    code += randNum
    return code


def appointmentDoctor():
    global doctors
    random_doctor = random.choice(doctors)
    return random_doctor


def listofDoctor():
    global doctors
    doctors.append(Doctor("Dr. John Smith", "OPD", "Monday to Tuesday - 9:00am to 5:00pm", "john.smith@tupmc.com", "09123456789"))
    doctors.append(Doctor("Dr. Sarah Lee", "OPD", "Wednesday to Thursday - 10:00am to 6:00pm", "sarah.lee@hospital.com", "09987654321"))
    doctors.append(Doctor("Dr. Alex Murray", "OPD", "Friday to Saturday - 9:00am to 5:00pm", "alex.murray@tupmc.com", "09918273645"))


def updatePatientAppointment(current, sched, doc, code):
    current.accounts.setAppointmentCode(code)
    current.accounts.setAppointmentDate(sched.getDate())
    current.accounts.setAppointmentDoctor(doc.getName())
    current.accounts.setAppointmentDoctorContactNumber(doc.getContactNumber())
    current.accounts.setAppointmentDoctorDepartment(doc.getDepartment())
    current.accounts.setAppointmentDoctorEmail(doc.getEmail())
    current.accounts.setAppointmentDoctorSchedule(doc.getSchedule())


def updatePatientInformation(username, password, name, age, sex, bday, contactNumber):
    global L
    global globalUsername
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername().isEqual(globalUsername):
                current.accounts.setUsername(username)
                current.accounts.setPassword(password)
                current.accounts.setName(name)
                current.accounts.setAge(age)
                current.accounts.setBday(bday)
                current.accounts.setSex(sex)
                current.accounts.setContactNumber(contactNumber)


def appointmentSchedule(selectedSlot, selectedDoctor, code):
    currentAccount = getCurrentUserAccount()
    selectedSlot.numPatients += 1
    updatePatientAppointment(currentAccount, selectedSlot, selectedDoctor, code)
    savePatientSlotFile(currentAccount.accounts.getAppointmentDate(), selectedSlot.numPatients)


def confirmationCode():
    length = 5
    code = ""
    for i in range(length):
        if i % 2 == 0:
            randChar = chr(random.randint(65, 90))
            code += randChar
        else:
            randNum = str(random.randint(0, 10))
            code += randNum
    return code


def paymentMethod():
    currentAccount = getCurrentUserAccount()
    if currentAccount is not None and currentAccount.accounts is not None:
        currentAccount.accounts.setPaymentStatus(1)


# =============================================================================
#                       Getter Methods
# =============================================================================
def getCurrentUserAccount():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername().equals(globalUsername):
                return current


def getCurrentUserName():
    return globalUsername


def getCurrentPassword():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername().equals(globalUsername):
                return current.accounts.getPassword()


def getCurrentSchedule():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername().equals(globalUsername):
                return current.accounts.getAppointmentDate()


def getCurrentName():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername().equals(globalUsername):
                return current.accounts.getName()


def getCurrentAge():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername().equals(globalUsername):
                return current.accounts.getAge()


def getCurrentContactNumber():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername().equals(globalUsername):
                return current.accounts.getContactNumber()


def getCurrentSex():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername().equals(globalUsername):
                return current.accounts.getSex()


def getCurrentBirthday():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername().equals(globalUsername):
                return current.accounts.getBday()


def getCurrentPayment():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername().equals(globalUsername):
                return current.accounts.getPaymentStatus()


def getCurrentAppointmentCode():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername().equals(globalUsername):
                return current.accounts.getAppointmentCode()


def getCurrentAppointmentDate():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername().equals(globalUsername):
                return current.accounts.getAppointmentDate()


def getCurrentAppointmentDoctor():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername().equals(globalUsername):
                return current.accounts.getAppointmentDoctor()


def getCurrentAppointmentDoctorDepartment():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername().equals(globalUsername):
                return current.accounts.getAppointmentDoctorDepartment()


def getCurrentAppointmentDoctorSchedule():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername().equals(globalUsername):
                return current.accounts.getAppointmentDoctorSchedule()


def getCurrentAppointmentDoctorEmail():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername().equals(globalUsername):
                return current.accounts.getAppointmentDoctorEmail()


def getCurrentAppointmentDoctorContactNumber():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername().equals(globalUsername):
                return current.accounts.getAppointmentDoctorContactNumber()


def getAccountList():
    accountList = []
    for current in L:
        accountList.append(current.accounts)
    return accountList


def getDoctorList():
    doctorList = []
    for current in doctors:
        doctorList.append(current)
    return doctorList


# ================================================
#              File Handling Methods
# ================================================
def save():
    encryption = Encryption
    try:
        with open(Variables.ACCOUNT_FILE, 'w') as outFile, open(Variables.PATIENT_FILE, 'w') as outFile2, open(Variables.DOCTOR_FILE, 'w') as outFile3:
            outFile.write("Username, Password\n")
            outFile2.write("Name,Sex,Birthday,Contact_Number,Appointment_Date,Code,Age\n")
            outFile3.write("Name,Department,Schedule,Email,Contact_Number,Payment_Status\n")

            for current in L:
                # Encrypt all the data's
                encryptedUsername = encryption.encryptDecrypt(current.accounts.getUsername())
                encryptedPassword = encryption.encryptDecrypt(current.accounts.getPassword())
                encryptedName = encryption.encryptDecrypt(current.accounts.getName())
                encryptedSex = encryption.encryptDecrypt(current.accounts.getSex())
                encryptedBday = encryption.encryptDecrypt(current.accounts.getBday())
                encryptedContactNumber = encryption.encryptDecrypt(current.accounts.getContactNumber())
                encryptedAppointmentDate = encryption.encryptDecrypt(current.accounts.getAppointmentDate())
                encryptedAppointmentCode = encryption.encryptDecrypt(current.accounts.getAppointmentCode())
                encryptedAge = encryption.encryptDecrypt(str(current.accounts.getAge()))
                encryptedAppointmentDoctor = encryption.encryptDecrypt(current.accounts.getAppointmentDoctor())
                encryptedAppointmentDoctorDepartment = encryption.encryptDecrypt(current.accounts.getAppointmentDoctorDepartment())
                encryptedAppointmentDoctorSchedule = encryption.encryptDecrypt(current.accounts.getAppointmentDoctorSchedule())
                encryptedAppointmentDoctorEmail = encryption.encryptDecrypt(current.accounts.getAppointmentDoctorEmail())
                encryptedAppointmentDoctorContactNumber = encryption.encryptDecrypt(current.accounts.getAppointmentDoctorContactNumber())
                encryptedPaymentStatus = encryption.encryptDecrypt(str(current.accounts.getPaymentStatus()))

                # Encode the Encrypted Text with Base64
                encodedUsername = encryption.encodeToBase64(encryptedUsername)
                encodedPassword = encryption.encodeToBase64(encryptedPassword)
                encodedName = encryption.encodeToBase64(encryptedName)
                encodedSex = encryption.encodeToBase64(encryptedSex)
                encodedBday = encryption.encodeToBase64(encryptedBday)
                encodedContactNumber = encryption.encodeToBase64(encryptedContactNumber)
                encodedAppointmentDate = encryption.encodeToBase64(encryptedAppointmentDate)
                encodedAppointmentCode = encryption.encodeToBase64(encryptedAppointmentCode)
                encodedAge = encryption.encodeToBase64(encryptedAge)
                encodedAppointmentDoctor = encryption.encodeToBase64(encryptedAppointmentDoctor)
                encodedAppointmentDoctorDepartment = encryption.encodeToBase64(encryptedAppointmentDoctorDepartment)
                encodedAppointmentDoctorSchedule = encryption.encodeToBase64(encryptedAppointmentDoctorSchedule)
                encodedAppointmentDoctorEmail = encryption.encodeToBase64(encryptedAppointmentDoctorEmail)
                encodedAppointmentDoctorContactNumber = encryption.encodeToBase64(encryptedAppointmentDoctorContactNumber)
                encodedPaymentStatus = encryption.encodeToBase64(encryptedPaymentStatus)

                # Write to file
                outFile.write(f"{encodedUsername},{encodedPassword}\n")
                outFile2.write(f"{encodedName},{encodedSex},{encodedBday},{encodedContactNumber},{encodedAppointmentDate},{encodedAppointmentCode},{encodedAge}\n")
                outFile3.write(f"{encodedAppointmentDoctor},{encodedAppointmentDoctorDepartment},{encodedAppointmentDoctorSchedule},{encodedAppointmentDoctorEmail},{encodedAppointmentDoctorContactNumber},{encodedPaymentStatus}\n")
    except IOError as e:
        print("Error opening/writing to file: ", e)


def retrieve():
    encryption = Encryption
    try:
        with open(Variables.ACCOUNT_FILE, 'r') as inFile, open(Variables.PATIENT_FILE, 'r') as inFile2, open(Variables.DOCTOR_FILE, 'r') as inFile3:
            inFile.readline()
            inFile2.readline()
            inFile3.readline()
            line1, line2, line3 = inFile.readline(), inFile2.readline(), inFile3.readline()
            while line1 and line2 and line3:
                # Read the data from the file and split it
                accountlist = line1.split(",")
                patientlist = line2.split(",")
                doctorlist = line3.split(",")

                # Decode the encrypted text using Base64
                decodeUsername = encryption.decodeToBase64(accountlist[0])
                decodePassword = encryption.decodeToBase64(accountlist[1])
                decodeName = encryption.decodeToBase64(patientlist[0])
                decodeSex = encryption.decodeToBase64(patientlist[1])
                decodeBday = encryption.decodeToBase64(patientlist[2])
                decodeContactNumber = encryption.decodeToBase64(patientlist[3])
                decodeAppointmentDate = encryption.decodeToBase64(patientlist[4])
                decodeAppointmentCode = encryption.decodeToBase64(patientlist[5])
                decodeAge = encryption.decodeToBase64(patientlist[6])
                decodeAppointmentDoctor = encryption.decodeToBase64(doctorlist[0])
                decodeAppointmentDoctorDepartment = encryption.decodeToBase64(doctorlist[1])
                decodeAppointmentDoctorSchedule = encryption.decodeToBase64(doctorlist[2])
                decodeAppointmentDoctorEmail = encryption.decodeToBase64(doctorlist[3])
                decodeAppointmentDoctorContactNumber = encryption.decodeToBase64(doctorlist[4])
                decodePaymentStatus = encryption.decodeToBase64(doctorlist[5])

                # Convert the decoded arrays to Strings
                convertToStringUsername = encryption.convertToString(decodeUsername)
                convertToStringPassword = encryption.convertToString(decodePassword)
                convertToStringName = encryption.convertToString(decodeName)
                convertToStringSex = encryption.convertToString(decodeSex)
                convertToStringBday = encryption.convertToString(decodeBday)
                convertToStringContactNumber = encryption.convertToString(decodeContactNumber)
                convertToStringAppointmentDate = encryption.convertToString(decodeAppointmentDate)
                convertToStringAppointmentCode = encryption.convertToString(decodeAppointmentCode)
                convertToStringAge = encryption.convertToString(decodeAge)
                convertToStringAppointmentDoctor = encryption.convertToString(decodeAppointmentDoctor)
                convertToStringAppointmentDoctorDepartment = encryption.convertToString(decodeAppointmentDoctorDepartment)
                convertToStringAppointmentDoctorSchedule = encryption.convertToString(decodeAppointmentDoctorSchedule)
                convertToStringAppointmentDoctorEmail = encryption.convertToString(decodeAppointmentDoctorEmail)
                convertToStringAppointmentDoctorContactNumber = encryption.convertToString(decodeAppointmentDoctorContactNumber)
                convertToStringPaymentStatus = encryption.convertToString(decodePaymentStatus)

                # Decrypt the Strings
                decryptedUsername = encryption.encryptDecrypt(convertToStringUsername)
                decryptedPassword = encryption.encryptDecrypt(convertToStringPassword)
                decryptedName = encryption.encryptDecrypt(convertToStringName)
                decryptedSex = encryption.encryptDecrypt(convertToStringSex)
                decryptedBday = encryption.encryptDecrypt(convertToStringBday)
                decryptedContactNumber = encryption.encryptDecrypt(convertToStringContactNumber)
                decryptedAppointmentDate = encryption.encryptDecrypt(convertToStringAppointmentDate)
                decryptedAppointmentCode = encryption.encryptDecrypt(convertToStringAppointmentCode)
                decryptedAge = encryption.encryptDecrypt(convertToStringAge)
                decryptedAppointmentDoctor = encryption.encryptDecrypt(convertToStringAppointmentDoctor)
                decryptedAppointmentDoctorDepartment = encryption.encryptDecrypt(convertToStringAppointmentDoctorDepartment)
                decryptedAppointmentDoctorSchedule = encryption.encryptDecrypt(convertToStringAppointmentDoctorSchedule)
                decryptedAppointmentDoctorEmail = encryption.encryptDecrypt(convertToStringAppointmentDoctorEmail)
                decryptedAppointmentDoctorContactNumber = encryption.encryptDecrypt(convertToStringAppointmentDoctorContactNumber)
                decryptedPaymentStatus = encryption.encryptDecrypt(convertToStringPaymentStatus)

                # Create the Account Objects
                account = Account(None, None, None, None, None, None, None)
                account.setUsername(decryptedUsername)
                account.setPassword(decryptedPassword)
                account.setName(decryptedName)
                account.setSex(decryptedSex)
                account.setBday(decryptedBday)
                account.setContactNumber(decryptedContactNumber)
                account.setAppointmentDate(decryptedAppointmentDate)
                account.setAppointmentCode(decryptedAppointmentCode)
                account.setAge(int(decryptedAge))
                account.setAppointmentDoctor(decryptedAppointmentDoctor)
                account.setAppointmentDoctorDepartment(decryptedAppointmentDoctorDepartment)
                account.setAppointmentDoctorSchedule(decryptedAppointmentDoctorSchedule)
                account.setAppointmentDoctorEmail(decryptedAppointmentDoctorEmail)
                account.setAppointmentDoctorContactNumber(decryptedAppointmentDoctorContactNumber)
                account.setPaymentStatus(int(decryptedPaymentStatus))
                add(account)

    except IOError as e:
        print("Error opening/reading the file: ", e)


# ================================================
#                     MAIN
# ================================================
if __name__ == "__main__":
    os.makedirs(Variables.SCHEDULE_FOLDER, exist_ok=True)
    inputPatientInformation("Johnpaul", "monter123", "John Paul", 19, "Male", "January 12, 2003", "09093698521")
    inputPatientInformation("jeanne", "carolino123", "Jeanne May", 19, "Female", "January 12, 2003", "09093698521")
    display()
    print("Running")
