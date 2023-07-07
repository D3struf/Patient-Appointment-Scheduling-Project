import os
import random
import datetime

import Encryption


class Variables:
    DATABASE_FOLDER = "database"
    ACCOUNT_FILE = DATABASE_FOLDER + "/account.txt"
    PATIENT_FILE = DATABASE_FOLDER + "/patient.txt"
    DOCTOR_FILE = DATABASE_FOLDER + "/doctor.txt"
    KEY_FILE = DATABASE_FOLDER + "/key.txt"
    SCHEDULE_FOLDER = os.path.join(DATABASE_FOLDER, "Schedules")
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
loginAdmin = False
GREY = "\033[47m"
STOP = "\033[0m"
CYAN = "\033[48;5;44m"
CYAN2 = "\033[48;5;43m"
GREEN = "\033[48;5;46m"
RED = "\033[48;5;160m"


class Main:
    def __init__(self):
        self.L = LIST()
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


def takeInputPatientInformation():
    print("Please Fill up the Patient Information")
    username = input("Enter Username: ")
    password = input("Enter Password: ")
    name = input("Enter Name: ")
    age = int(input("Enter Age: "))
    sex = input("Enter Sex: ")
    bday = input("Enter Birthday: ")
    contactNumber = input("Enter Contact Number: ")

    if inputPatientInformation(username, password, name, age, sex, bday, contactNumber):
        print("\n")
        print_color(GREEN, " Account Created Successfully!! ", STOP)
        print("\n")
        return True
    else:
        print(RED, " Please Enter Different Username! ", STOP)
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


def takeLoginAccount():
    global globalUsername
    print("\n")
    print_color(CYAN2, "             E-SCHED MEDICAL             ", STOP)
    print()
    print_color(CYAN2, "           PATIENT APPOINTMENT           ", STOP)
    print("\n")
    user = input("Enter Username: ")
    password = input("Enter Password: ")
    valid = login_Account(user, password)
    if valid == 0:
        print_color(GREEN, " Log in Successful!! ", STOP)
        print("\n")
        return True
    elif valid == 1:
        print_color(RED, " Incorrect Password. ", STOP)
        print("\n")
        return False
    else:
        print_color(RED, " Create your Account First. ", STOP)
        print("\n")


def login_Account(username, password):
    # If exists, store in global variable
    global loginAdmin
    global globalUsername
    globalUsername = username

    if Variables.ADMIN_USERNAME == username:
        if Variables.ADMIN_PASSWORD == password:
            loginAdmin = True
            return 0

    # Validate Username
    for lists in L:
        if lists.accounts.username == username:
            if lists is not None and lists.accounts.password == password:
                return 0
            else:
                return 1

    return -1


# =================================================================
#                           MENU DRIVEN
# =================================================================
def pause():
    input("Please Enter to continue...")


def menu(x):
    if x == 1:
        print("\n")
        print_color(CYAN2, "        E-SCHED MEDICAL         ", STOP)
        print()
        print_color(CYAN2, "      PATIENT APPOINTMENT       ", STOP)
        print("\n")
        print_color(GREY, "   1   ", STOP)
        print_color(CYAN, "     LOG IN ACCOUNT      ", STOP)
        print()
        print_color(GREY, "   2   ", STOP)
        print_color(CYAN, "     CREATE ACCOUNT      ", STOP)
        print()
        print_color(GREY, "   3   ", STOP)
        print_color(CYAN, "     EXIT PROGRAM        ", STOP)
        print("\n")
        print_color(CYAN, " Enter Choice: ", STOP)
        select = int(input(" "))
        print("\n")
        return select

    elif x == 2:
        print("\n")
        print_color(CYAN2, "     PAYMENT METHOD      ", STOP)
        print()
        print_color(CYAN2, "   MODE OF TRANSACTION   ", STOP)
        print("\n")
        print_color(GREY, "   1   ", STOP)
        print_color(CYAN, "       CASH       ", STOP)
        print()
        print_color(GREY, "   2   ", STOP)
        print_color(CYAN, "       ONLINE     ", STOP)
        print()
        print_color(GREY, "   3   ", STOP)
        print_color(CYAN, "       BACK       ", STOP)
        print("\n")
        print_color(CYAN, " Enter Choice: ", STOP)
        select = int(input(" "))
        print("\n")
        return select

    elif x == 3:
        print("\n")
        print_color(CYAN2, "             E-SCHED MEDICAL             ", STOP)
        print()
        print_color(CYAN2, "           PATIENT APPOINTMENT           ", STOP)
        print("\n")
        print_color(GREY, "   1   ", STOP)
        print_color(CYAN, "     VIEW PATIENT INFORMATION     ", STOP)
        print()
        print_color(GREY, "   2   ", STOP)
        print_color(CYAN, "     SCHEDULE AN APPOINTMENT      ", STOP)
        print()
        print_color(GREY, "   3   ", STOP)
        print_color(CYAN, "     VIEW SCHEDULED APPOINTMENT   ", STOP)
        print()
        print_color(GREY, "   4   ", STOP)
        print_color(CYAN, "     PAYMENT FOR APPOINTMENT      ", STOP)
        print()
        print_color(GREY, "   5   ", STOP)
        print_color(CYAN, "     LOG OUT ACCOUNT              ", STOP)
        print("\n")
        print_color(CYAN, " Enter Choice: ", STOP)
        select = int(input(" "))
        print("\n")
        return select

    elif x == 4:
        print("\n")
        print_color(CYAN2, "             E-SCHED MEDICAL             ", STOP)
        print()
        print_color(CYAN2, "           PATIENT APPOINTMENT           ", STOP)
        print("\n")
        print_color(GREY, "   1   ", STOP)
        print_color(CYAN, "       DISPLAY PATIENT LIST       ", STOP)
        print()
        print_color(GREY, "   2   ", STOP)
        print_color(CYAN, "       DISPLAY DOCTOR LIST        ", STOP)
        print()
        print_color(GREY, "   3   ", STOP)
        print_color(CYAN, "       SECURITY KEY               ", STOP)
        print()
        print_color(GREY, "   4   ", STOP)
        print_color(CYAN, "       LOG OUT ACCOUNT            ", STOP)
        print("\n")
        print_color(CYAN, " Enter Choice: ", STOP)
        select = int(input(" "))
        print("\n")
        return select


def display_patient_information():
    # Look for the username
    for current in L:
        if current.accounts.username == globalUsername:
            print("\n")
            print_color(CYAN2, "                      E-SCHED MEDICAL                      ", STOP)
            print()
            print_color(CYAN2, "                    PATIENT APPOINTMENT                    ", STOP)
            print()
            print_color(CYAN, "                    Patient Information                    ", STOP)
            print("\n")
            print(f"USERNAME:           {current.accounts.getUsername()}")
            print(f"PASSWORD:           {current.accounts.getPassword()}")
            print(f"NAME:               {current.accounts.getName()}")
            print(f"AGE:                {current.accounts.getAge()}")
            print(f"SEX:                {current.accounts.getSex()}")
            print(f"BIRTHDAY:           {current.accounts.getBday()}")
            print(f"CONTACT NUMBER:     {current.accounts.getContactNumber()}")
            print("\n")
            input("Press Enter to continue...")
            print("\n")
            break


# =================================================================
#                   Patient Appointment Methods
# =================================================================
def takeAppointmentSchedule():
    print("\n")
    print_color(CYAN2, "                      E-SCHED MEDICAL                      ", STOP)
    print()
    print_color(CYAN2, "                    PATIENT APPOINTMENT                    ", STOP)
    print()
    print_color(CYAN, "                    Appointment Schedule                   ", STOP)
    print("\n")

    # Check if the user has already scheduled an appointment
    for current in L:
        if current.accounts.username == globalUsername:
            if current.accounts.getAppointmentDate() != "":
                print_color(GREEN, " You have already scheduled an appointment ", STOP)
                print("\n")
                print("Check your appointment schedule in the View Schedule Menu")
                print("\n")
                input("Press Enter to continue...")
                return

            print("       DATE         NUMBER OF PATIENTS          SLOTS AVAILABLE")
            chosenSlot = generateAppointmentSchedules()

            full = 0
            selects = int(input("Enter Choice: "))
            print("================================================================")
            if 1 <= selects <= 3:
                if chosenSlot[selects - 1].numPatients >= Variables.MAX_PATIENTS:
                    print("Sorry, the slots are already full")
                    print("Please choose another date")
                    full = 1
                else:
                    y = appointmentDoctor()
                    code = appointmentCode()
                    print_color(CYAN2, "                      E-SCHED MEDICAL                      ", STOP)
                    print()
                    print_color(CYAN2, "                    PATIENT APPOINTMENT                    ", STOP)
                    print()
                    print_color(CYAN, "                    Appointment Schedule                   ", STOP)
                    print("\n")
                    print_color(GREEN, " You have Successfully created an Appointment Schedule ", STOP)
                    print("\n")
                    print("Your Appointment Schedule is on ", chosenSlot[selects - 1].date)
                    print("Your Doctor is ", y.name)
                    print("Your Appointment Code is ", code)
                    chosenSlot[selects - 1].numPatients += 1
                    updatePatientAppointment(chosenSlot[selects - 1], y, code)
                    savePatientSlotFile(chosenSlot[selects - 1].date, chosenSlot[selects - 1].numPatients)
                    break
            else:
                print_color(RED, "Invalid Choice", STOP)
            print("\n")
            input("Press Enter to continue...")
            if 1 <= selects <= 3 or full == 0:
                break


def view_schedule():
    for current in L:
        if current.accounts.getUsername() == globalUsername:
            if current.accounts.getAppointmentDate() == "":
                print("\n")
                print(RED, " You do not have an Appointment Yet, Create First! ")
                print("\n")
                pause()
                return

            print("\n")
            print_color(CYAN, "                    Appointment Schedule                   ", STOP)
            print("\n")
            print(f"USERNAME:           {current.accounts.getUsername()}")
            print(f"NAME:               {current.accounts.getName()}")
            print(f"APPOINTMENT DATE:   {current.accounts.getAppointmentDate()}")
            print(f"===========================CODE: {current.accounts.getAppointmentCode()}===========================")
            print("DOCTOR DETAILS")
            print(f"APPOINTMENT DOCTOR: {current.accounts.getAppointmentDoctor()}")
            print(f"DEPARTMENT:         {current.accounts.getAppointmentDoctorDepartment()}")
            print(f"SCHEDULE:           {current.accounts.getAppointmentDoctorSchedule()}")
            print(f"EMAIL:              {current.accounts.getAppointmentDoctorEmail()}")
            print(f"CONTACT NUMBER:     {current.accounts.getAppointmentDoctorContactNumber()}")
            print("\n")
            input("Press Enter to continue...")
            print("\n")
            break


def generateAppointmentSchedules():
    slot = [Appointment(None, None) for _ in range(Variables.DAYS)]
    tomorrow_date = datetime.datetime.now().date() + datetime.timedelta(days=1)

    for i in range(Variables.DAYS):
        patient_slot = Appointment(None, None)
        patient_slot.date = tomorrow_date.strftime("%b-%d-%Y")
        patient_slot.numPatients = checkPatientSlotFile(patient_slot.date)

        slot[i] = patient_slot
        tomorrow_date += datetime.timedelta(days=1)

    index = 1
    for i in range(Variables.DAYS):
        print(f"{index}     {slot[i].date}     {slot[i].numPatients}     {slot[i].numPatients}/{Variables.MAX_PATIENTS}")
        index += 1
    return slot


def checkPatientSlotFile(DTIME):
    FilePath = os.path.join(os.getcwd(), Variables.SCHEDULE_FOLDER, (DTIME + ".txt"))
    if not os.path.exists(FilePath):
        open(FilePath, "w").close()

    with open(FilePath, "r") as file:
        if os.path.exists(FilePath):
            slotNum = file.readline()
            if slotNum == "":
                return 0
            else:
                return int(slotNum)
    return 0


def savePatientSlotFile(DTIME, numPatient):
    FilePath = os.path.join(os.getcwd(), Variables.SCHEDULE_FOLDER, (DTIME + ".txt"))
    if not os.path.exists(FilePath):
        open(FilePath, "w").close()

    with open(FilePath, "w") as file:
        print(FilePath)
        file.write(str(numPatient))


def appointmentCode():
    randChar = chr(random.randint(65, 90))
    randNum = str(random.randint(100, 999))
    code = randChar
    code += randNum
    return code


def appointmentDoctor():
    global doctors
    listofDoctor()
    random_doctor = random.choice(doctors)
    return random_doctor


def listofDoctor():
    global doctors
    doctors.append(Doctor("Dr. John Smith", "OPD", "Monday to Tuesday - 9:00am to 5:00pm", "john.smith@tupmc.com", "09123456789"))
    doctors.append(Doctor("Dr. Sarah Lee", "OPD", "Wednesday to Thursday - 10:00am to 6:00pm", "sarah.lee@hospital.com", "09987654321"))
    doctors.append(Doctor("Dr. Alex Murray", "OPD", "Friday to Saturday - 9:00am to 5:00pm", "alex.murray@tupmc.com", "09918273645"))


def updatePatientAppointment(sched, doc, code):
    current = getCurrentUserAccount()
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


def takePaymentMethod():
    currentAccount = getCurrentUserAccount()
    if currentAccount is not None and currentAccount.accounts is not None:
        if currentAccount.accounts.getPaymentStatus() == 2:
            print_color(GREEN, " You have already paid your Appointment ", STOP)
            pause()
            return
        elif currentAccount.accounts.getAppointmentDate() == "":
            print_color(RED, " You Do Not have an Appointment Yet, Create First!! ", STOP)
            pause()
            return

    while True:
        selected = menu(2)
        if 1 > selected > 3:
            print("Invalid Input!, Try Again!!!")
            pause()

        if selected == 1:
            print_color(GREY, " Mode of Transaction:", STOP)
            print_color(GREEN, " Cash ", STOP)
            print("\n")
            print(f"Go to the nearest {Variables.HOSPITAL_NAME} for your Payment!")
            pause()
            break
        elif selected == 2:
            print("\n")
            print_color(GREY, " Mode of Transaction:", STOP)
            print_color(GREEN, " Online ", STOP)
            print("\n")
            break
        elif selected == 3:
            return

    status = 1
    if selected == 2:
        print(f"Reservation Fee: {Variables.RESERVATION_FEE}.00")
        input("Enter your Bank Name: ")
        input("Enter your Account Number: ")
        amount = int(input("Enter Amount: "))
        if amount == Variables.RESERVATION_FEE:
            temp = confirmationCode()
            print(f"Your Confirmation Code is: {temp}")
            print_color(GREEN, "Payment Successful", STOP)
            print("Thank You for Using our Program!!")
            pause()
            status = 2
        elif amount > Variables.RESERVATION_FEE:
            temp = confirmationCode()
            print(f"Your Confirmation Code is: {temp}")
            print_color(GREEN, "Payment Successful", STOP)
            print("Thank You for Using our Program!!")
            pause()
            status = 2
        else:
            print(RED, "Payment Failed", STOP)
            pause()
            return

    updatePaymentMethod(status)


def updatePaymentMethod(status):
    currentAccount = getCurrentUserAccount()
    if currentAccount is not None and currentAccount.accounts is not None:
        currentAccount.accounts.setPaymentStatus(status)
        print(currentAccount.accounts.getPaymentStatus())


# =============================================================================
#                       Getter Methods
# =============================================================================
def getCurrentUserAccount():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername() == globalUsername:
                return current


def getCurrentUserName():
    return globalUsername


def getCurrentPassword():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername() == globalUsername:
                return current.accounts.getPassword()


def getCurrentSchedule():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername() == globalUsername:
                return current.accounts.getAppointmentDate()


def getCurrentName():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername() == globalUsername:
                return current.accounts.getName()


def getCurrentAge():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername() == globalUsername:
                return current.accounts.getAge()


def getCurrentContactNumber():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername() == globalUsername:
                return current.accounts.getContactNumber()


def getCurrentSex():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername() == globalUsername:
                return current.accounts.getSex()


def getCurrentBirthday():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername() == globalUsername:
                return current.accounts.getBday()


def getCurrentPayment():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername() == globalUsername:
                return current.accounts.getPaymentStatus()


def getCurrentAppointmentCode():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername() == globalUsername:
                return current.accounts.getAppointmentCode()


def getCurrentAppointmentDate():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername() == globalUsername:
                return current.accounts.getAppointmentDate()


def getCurrentAppointmentDoctor():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername() == globalUsername:
                return current.accounts.getAppointmentDoctor()


def getCurrentAppointmentDoctorDepartment():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername() == globalUsername:
                return current.accounts.getAppointmentDoctorDepartment()


def getCurrentAppointmentDoctorSchedule():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername() == globalUsername:
                return current.accounts.getAppointmentDoctorSchedule()


def getCurrentAppointmentDoctorEmail():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername() == globalUsername:
                return current.accounts.getAppointmentDoctorEmail()


def getCurrentAppointmentDoctorContactNumber():
    for current in L:
        if current is not None and current.accounts is not None and current.accounts.getUsername() is not None:
            if current.accounts.getUsername() == globalUsername:
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
#                   Admin Methods
# ================================================
def display_patient_list():
    sorted_list = sorted(L, key=lambda x: x.accounts.name)
    count = 0
    print("\n")
    print_color(CYAN2, "                      ADMIN PAGE                      ", STOP)
    print()
    print_color(CYAN, "                    PATIENT'S LIST                    ", STOP)
    print("\n")
    for current in sorted_list:
        print(str(count + 1) + ".) Name: " + current.accounts.name + " | Age: " + str(current.accounts.age) + " | Sex: " + current.accounts.sex + " | Birthday: " + current.accounts.bday + " | Contact Number: " + current.accounts.contact_number + "| Doctor: " + current.accounts.getAppointmentDoctor() + "| Payment Status: " + (
              "Paid" if current.accounts.getPaymentStatus() == 2 else "Unpaid"))
        count += 1


def display_doctor_list():
    print("\n")
    print_color(CYAN2, "                      ADMIN PAGE                      ", STOP)
    print()
    print_color(CYAN, "                     DOCTOR'S LIST                    ", STOP)
    print("\n")
    print("DOCTOR", f"\t\t\t\t\t""DEPARTMENT"f"\t\t\t""SCHEDULE"f"\t\t\t\t\t\t\t\t\t\t\t""EMAIL", f"\t\t\t\t\t\t\t""CONTACT NO.")
    print("Dr. Alex Murray", f"\t\t""OPD", f"\t\t\t\t""Friday to Saturday - 9:00am to 5:00pm", f"\t\t\t\t""alex.murray@tupmc.com", f"\t\t\t""09918273645")
    print("Dr. John Smith", f"\t\t\t""OPD", f"\t\t\t\t""Monday to Tuesday - 9:00am to 5:00pm", f"\t\t\t\t""john.smith@tupmc.com", f"\t\t\t""09123456789")
    print("Dr. Sarah Lee", f"\t\t\t""OPD", f"\t\t\t\t""Wednesday to Thursday - 10:00am to 6:00pm", f"\t\t\t""sarah.lee@hospital.com", f"\t\t\t""09987654321")


def security():
    print("\n")
    print_color(CYAN2, "                      ADMIN PAGE                      ", STOP)
    print()
    print_color(CYAN, "                       SECURITY                       ", STOP)
    print("\n")
    encryption = Encryption
    print("Current Key: ", encryption.globalkey)
    newKey = int(input("Enter a new key: "))
    encryption.setKey(newKey)
    encryption.saveKey()


# ================================================
#              File Handling Methods
# ================================================
def save():
    encryption = Encryption
    try:
        with open(Variables.ACCOUNT_FILE, 'w') as outFile, open(Variables.PATIENT_FILE, 'w') as outFile2, open(Variables.DOCTOR_FILE, 'w') as outFile3:
            outFile.write("Username,Password\n")
            outFile2.write("Name,Sex,Birthday,Contact_Number,Appointment_Date,Code,Age\n")
            outFile3.write("Name,Department,Schedule,Email,Contact_Number,Payment_Status\n")

            for current in L:
                # Encrypt all the data's
                encryptedUsername = encryption.encrypt(current.accounts.getUsername())
                encryptedPassword = encryption.encrypt(current.accounts.getPassword())
                encryptedName = encryption.encrypt(current.accounts.getName())
                encryptedSex = encryption.encrypt(current.accounts.getSex())
                encryptedBday = encryption.encrypt(current.accounts.getBday())
                encryptedContactNumber = encryption.encrypt(current.accounts.getContactNumber())
                encryptedAppointmentDate = encryption.encrypt(current.accounts.getAppointmentDate())
                encryptedAppointmentCode = encryption.encrypt(current.accounts.getAppointmentCode())
                encryptedAge = encryption.encrypt(str(current.accounts.getAge()))
                encryptedAppointmentDoctor = encryption.encrypt(current.accounts.getAppointmentDoctor())
                encryptedAppointmentDoctorDepartment = encryption.encrypt(current.accounts.getAppointmentDoctorDepartment())
                encryptedAppointmentDoctorSchedule = encryption.encrypt(current.accounts.getAppointmentDoctorSchedule())
                encryptedAppointmentDoctorEmail = encryption.encrypt(current.accounts.getAppointmentDoctorEmail())
                encryptedAppointmentDoctorContactNumber = encryption.encrypt(current.accounts.getAppointmentDoctorContactNumber())
                encryptedPaymentStatus = encryption.encrypt(str(current.accounts.getPaymentStatus()))

                # Write to file
                outFile.write(f"{encryptedUsername},{encryptedPassword}\n")
                outFile2.write(f"{encryptedName},{encryptedSex},{encryptedBday},{encryptedContactNumber},{encryptedAppointmentDate},{encryptedAppointmentCode},{encryptedAge}\n")
                outFile3.write(f"{encryptedAppointmentDoctor},{encryptedAppointmentDoctorDepartment},{encryptedAppointmentDoctorSchedule},{encryptedAppointmentDoctorEmail},{encryptedAppointmentDoctorContactNumber},{encryptedPaymentStatus}\n")
    except IOError as e:
        print("Error opening/writing to file: ", e)


def retrieve():
    encryption = Encryption
    try:
        with open(Variables.ACCOUNT_FILE, 'r') as inFile, open(Variables.PATIENT_FILE, 'r') as inFile2, open(Variables.DOCTOR_FILE, 'r') as inFile3:
            inFile.readline()
            inFile2.readline()
            inFile3.readline()

            for line1, line2, line3 in zip(inFile, inFile2, inFile3):
                retrieveTextAccount = line1.strip()
                account_values = retrieveTextAccount.split(',')
                decryptedUsername = encryption.decrypt(account_values[0])
                decryptedPassword = encryption.decrypt(account_values[1])

                retrieveTextPatient = line2.strip()
                patient_values = retrieveTextPatient.split(',')
                decryptedName = encryption.decrypt(patient_values[0])
                decryptedSex = encryption.decrypt(patient_values[1])
                decryptedBday = encryption.decrypt(patient_values[2])
                decryptedContactNumber = encryption.decrypt(patient_values[3])
                decryptedAppointmentDate = encryption.decrypt(patient_values[4])
                decryptedAppointmentCode = encryption.decrypt(patient_values[5])
                decryptedAge = encryption.decrypt(patient_values[6])

                retrieveTextDoctor = line3.strip()
                doctor_values = retrieveTextDoctor.split(',')
                decryptedAppointmentDoctor = encryption.decrypt(doctor_values[0])
                decryptedAppointmentDoctorDepartment = encryption.decrypt(doctor_values[1])
                decryptedAppointmentDoctorSchedule = encryption.decrypt(doctor_values[2])
                decryptedAppointmentDoctorEmail = encryption.decrypt(doctor_values[3])
                decryptedAppointmentDoctorContactNumber = encryption.decrypt(doctor_values[4])
                decryptedPaymentStatus = encryption.decrypt(doctor_values[5])

                account = Account(None, None, None, None, None, None, None)
                account.setUsername(decryptedUsername)
                account.setPassword(decryptedPassword)
                account.setName(decryptedName)
                account.setSex(decryptedSex)
                account.setBday(decryptedBday)
                account.setContactNumber(decryptedContactNumber)
                account.setAppointmentDate(decryptedAppointmentDate)
                account.setAppointmentCode(decryptedAppointmentCode)
                account.setAge(decryptedAge)
                account.setAppointmentDoctor(decryptedAppointmentDoctor)
                account.setAppointmentDoctorDepartment(decryptedAppointmentDoctorDepartment)
                account.setAppointmentDoctorSchedule(decryptedAppointmentDoctorSchedule)
                account.setAppointmentDoctorEmail(decryptedAppointmentDoctorEmail)
                account.setAppointmentDoctorContactNumber(decryptedAppointmentDoctorContactNumber)
                account.setPaymentStatus(int(decryptedPaymentStatus))
                add(account)

    except IOError as e:
        print("Error opening/reading the file: ", e)


# =================================================================
#                           PROGRAM DESIGN
# =================================================================
def print_welcome_message():
    print("\033[1;36m")  # Set text color to cyan
    print("\n░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░")
    print("░░██░░░░░░░░██░███████░██░░░░░░░██████░░░███████░░████░░░░████░███████░░")
    print("░░██░░░░░░░░██░██░░░░░░██░░░░░░██░░░░██░██░░░░░██░██░██░░██░██░██░░░░░░░")
    print("░░██░░░██░░░██░██████░░██░░░░░░██░░░░░░░██░░░░░██░██░░░██░░░██░██████░░░")
    print("░░██░██░░██░██░██░░░░░░██░░░░░░██░░░░██░██░░░░░██░██░░░░░░░░██░██░░░░░░░")
    print("░░████░░░░████░███████░███████░░██████░░░███████░░██░░░░░░░░██░███████░░")
    print("░░░░░░░░░░░░░░░░░░░░░░ Patient Scheduling System ░░░░░░░░░░░░░░░░░░░░░░░")

    print("\n\t\t  Manage and Schedule Patient Appointments with ease.\n")
    print("\t\t\t              Let's get started!\n")

    print("\033[0m")  # Reset text color to default


def print_bye_message():
    print("\033[1;36m")  # Set text color to cyan
    print("\n░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░")
    print("░░░░█████████░░░░███░░░░ ███░░█████████░░███░░")
    print("░░░░███░░░░███░░░░███░░ ███░░░███░░░░░░░░███░░")
    print("░░░░█████████░░░░░░░░███░░░░░░████████░░░███░░")
    print("░░░░███░░░░███░░░░░░░███░░░░░░███░░░░░░░░░░░░░")
    print("░░░░█████████░░░░░░░░███░░░░░░█████████░░███░░")
    print("░░░░░░ Thank You for using our Program! ░░░░░░")
    print("\n       Programmed By:       ")
    print("         John Paul Monter           ")
    print("         Jeanne May Carolino           ")
    print("         Almira Jill Garcia              ")
    print("\033[0m")  # Reset text color to default


def print_admin_message():
    print("\033[1;36m")  # Set text color to cyan
    print("\n░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░")
    print("░░░░░░░░██░░░░██████░░░████░░████░████████░████░░░░██░░░░")
    print("░░░░░░██░░██░░██░░░██░░██░████░██░░░░██░░░░██░██░░░██░░░░")
    print("░░░░░██░░░░██░██░░░░██░██░░██░░██░░░░██░░░░██░░██░░██░░░░")
    print("░░░░░████████░██░░░██░░██░░░░░░██░░░░██░░░░██░░░██░██░░░░")
    print("░░░░░██░░░░██░██████░░░██░░░░░░██ ████████░██░░░░████░░░░")
    print("░░░░░░░░░░░░░ Appointment Scheduling System ░░░░░░░░░░░░░")
    print("\033[0m")  # Reset text color to default


def print_patient_message():
    print("\033[1;36m")  # Set text color to cyan
    print("\n░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░")
    print("░░░░░██████░░░░░██░░░░████████░████████░░███████░████░░░░██░████████░░░░")
    print("░░░░██░░░░██░░██░░██░░░░░██░░░░░░░██░░░░██░░░░░░░██░██░░░██░░░░██░░░░░░░")
    print("░░░░███████░░██░░░░██░░░░██░░░░░░░██░░░░███████░░██░░██░░██░░░░██░░░░░░░")
    print("░░░░██░░░░░░░████████░░░░██░░░░░░░██░░░░██░░░░░░░██░░░██░██░░░░██░░░░░░░")
    print("░░░░██░░░░░░░██░░░░██░░░░██░░░░████████░░███████░██░░░░████░░░░██░░░░░░░")
    print("░░░░░░░░░░░░░░░░░░░░░ Appointment Scheduling System ░░░░░░░░░░░░░░░░░░░░")
    print("\033[0m")  # Reset text color to default


def print_color(fcolor, text, last):
    print(f"{fcolor}{text}{last}", end='')


# ================================================
#                     MAIN
# ================================================
if __name__ == "__main__":
    os.makedirs(Variables.DATABASE_FOLDER, exist_ok=True)
    os.makedirs(Variables.SCHEDULE_FOLDER, exist_ok=True)
    encrypt = Encryption
    if os.path.exists(Variables.KEY_FILE):
        encrypt.retrieveKey()
    else:
        encrypt.setKey(70)
        encrypt.saveKey()
    retrieve()
    print_welcome_message()

    inputPatientInformation("Johnpaul", "monter123", "John Paul", 19, "Male", "January 12, 2003", "09093698521")
    inputPatientInformation("jeanne", "carolino123", "Jeanne May", 19, "Female", "January 12, 2003", "09093698521")
    inputPatientInformation("miraii", "garcia123", "Almira Jill", 19, "Female", "January 12, 2003", "09093698521")

    #display()

    # ASK FOR USER
    isValid = True
    Valid = True
    while isValid:
        choice = menu(1)
        if 1 > choice > 3:
            input("Wrong Input Try Again!!! Press Enter")
        if choice == 1:
            Valid = takeLoginAccount()
        elif choice == 2:
            Valid = takeInputPatientInformation()
        elif choice == 3:
            save()
            print_bye_message()
            exit(0)
        if Valid:
            break

    # Menu Driven for Admin Side
    if loginAdmin:
        isValid = True
        Valid = True
        while isValid:
            print_admin_message()
            choice1 = menu(4)
            if 1 > choice1 > 4:
                input("Wrong Input Try Again!!! Press Enter")
            if choice1 == 1:
                display_patient_list()
            elif choice1 == 2:
                display_doctor_list()
            elif choice1 == 3:
                security()
            elif choice1 == 4:
                save()
                print_bye_message()
                exit(0)
    else:
        # Menu Driven for Patient Side
        isValid = True
        Valid = True
        while isValid:
            print_patient_message()
            choice1 = menu(3)
            if 1 > choice1 > 5:
                input("Wrong Input Try Again!!! Press Enter")
            if choice1 == 1:
                display_patient_information()
            elif choice1 == 2:
                takeAppointmentSchedule()
            elif choice1 == 3:
                view_schedule()
            elif choice1 == 4:
                takePaymentMethod()
            elif choice1 == 5:
                save()
                print_bye_message()
                exit(0)
