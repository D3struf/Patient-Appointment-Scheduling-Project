#include "header.h"

int main(void)
{
    int choice1, choice2, login, create;
    char folder_path[101];
    char database_folder[101];

    system("cls");
    Box();

    // Create the folder paths
    snprintf(database_folder, sizeof(database_folder), "%s", DATABASE_FILE);
    mkdir(database_folder, 0777); // full permission to all
    snprintf(folder_path, sizeof(folder_path), "%s", FOLDER);
    mkdir(folder_path, 0777); // full permission to all

    init();
    retrieve();

    // Ask for user Account
    while (1)
    {
        switch(choice1 = menu(1))
        {

            case 1: system("cls");
                    Box();
                    login = login_Account();
                    break;
            case 2: system("cls");
                    Box();
                    create = patient_Information();
                    break;
            case 3:
                    save();
                    gotoxy(25,21);printf("Programmed By: Monter, John Paul | Garcia, Almira Jill | Carolino, Jeanne May\n\n\n\n");
                    exit(0);
                    break;
            default: gotoxy(51,17);printf("Invalid Choice, Try Again!!\n"); break;
        }
        if ((choice1 == 2 && create == 0) || (choice1 == 1 && login == 1))
            break;
    }

    // Main Menu
    while(1)
    {
        choice2 = menu(3);
        switch (choice2)
        {
            case 1: display_Patient_Information();
                    break;
            case 2: appointment_Schedule();
                    break;
            case 3: view_Schedule();
                    break;
            case 4: payment_Method();
                    break;
            case 5: save();
                    gotoxy(25,21);printf("Programmed By: Monter, John Paul | Garcia, Almira Jill | Carolino, Jeanne May\n\n\n\n");
                    exit(0);
                    break;
            default: gotoxy(46,21);printf("Invalid Choice, Try Again!!\n");
                    gotoxy(46,22);system("pause");
                    break;
        }
    }
    return 0;
}

// ===============================================
// Account Functions
// ===============================================

int login_Account()
{
    ACCOUNT y;
    LIST *p;
    p = L;
    int tries = 3;
    char *pass;

    system("cls");
    Box();
    system("COLOR 0E");
    gotoxy(35,5);printf("X|||||||||||||||||E-SCHED MEDICAL|||||||||||||||||X\n");
    gotoxy(35,6);printf("X|||||||||||||||PATIENT APPOINTMENT|||||||||||||||X\n");
    gotoxy(20,8);printf("==============================================================================\n");
    gotoxy(20,10);printf("Enter Username: ");
    gotoxy(37,10);scanf(" %[^\n]s", y.username);
    strcpy(global_Username, y.username);

    // Check if the username is in the database
    while (p != NULL)
    {
        // If the username is in the database
        if (strcmp(p->accounts.username, y.username) == 0)
        {
            // Prompt for password and check if it is correct 3 trials only
            while(tries != 0)
            {
                pass = get_Password("Enter Password: ", y.password);

                if (strcmp(pass, p->accounts.password) == 0)
                {
                    strcpy(y.password, pass);
                    gotoxy(20,14);printf("==============================================================================\n");
                    gotoxy(20,15);printf("                              Log in Successful!!\n");
                    gotoxy(20,16);printf("==============================================================================\n");
                    gotoxy(20,17);system("pause");
                    return 1;
                }
                else
                {
                    tries--;
                    gotoxy(37,13);printf("                         ");
                    gotoxy(20,14);printf("==============================================================================\n");
                    gotoxy(20,15);printf("Incorrect Password, you have %d trials left.\n", tries);
                    gotoxy(20,16);printf("==============================================================================\n");

                    if (tries == 0)
                    {
                        gotoxy(20,17);printf("==============================================================================\n");
                        gotoxy(20,18);printf("You have exceeded the number of tries\n");
                        gotoxy(20,19);printf("Please try again later\n");
                        gotoxy(20,20);printf("==============================================================================\n\n\n\n");
                        exit(0);
                    }
                }
            }
        }
        p = p->next;
    }
    if (p == NULL)
    {
        gotoxy(20,13);printf("==============================================================================\n");
        gotoxy(20,14);printf("Your account is not in the database\n");
        gotoxy(20,15);printf("Create account first.\n");
        gotoxy(20,16);printf("==============================================================================\n");
        gotoxy(20,17);system("pause");
    }
    return 0;
}

char *get_Password(char *string, char *PASSWORD)
{
    char ch,
        *temp,
        pwd[101];
    int i = 0;

    // Prompt user for password
    gotoxy(20,13); printf("%s", string);
    gotoxy(37,13);printf("%s", PASSWORD);

    while (1)
    {
        ch = getch();

        if (ch == ENTER || ch == TAB)
        {
            pwd[i] = '\0';      // terminate string
            break;
        }
        else if (ch == BKSP)
        {
            if (i > 0)
            {
                i--;
                printf("\b \b");        // erase character for backspace
            }
        }
        else
        {
            pwd[i++] = ch;      // add character to string
            printf("* \b");    // print `*` instead of character
        }
    }
    temp = pwd;
    return temp;
}

int patient_Information()
{
    ACCOUNT x;
    char *temp;
    system("cls");
    Box();
    gotoxy(35,5);printf("X|||||||||||||||||E-SCHED MEDICAL|||||||||||||||||X\n");
    gotoxy(35,6);printf("X|||||||||||||||PATIENT APPOINTMENT|||||||||||||||X\n");
    gotoxy(20,8);printf("==============================================================================\n");
    gotoxy(38,10);printf("---PLEASE FILL UP THE FOLLOWING INFORMATION---");
    gotoxy(20,12);printf("Username: ");
    gotoxy(30,12);scanf(" %[^\n]s", x.username);
    strcpy(global_Username, x.username);

    //  Validate Username
    LIST *p;
    p = L;
    while (p != NULL)
    {
        if (strcmp(p->accounts.username, x.username) == 0)
        {
            gotoxy(20,13);printf("Username already exists!!\n");
            gotoxy(20,14);system("pause");
            return 1;
        }
        p = p->next;
    }
    temp = get_Password("Enter Password: ", x.password);
    strcpy(x.password, temp);
    gotoxy(20,14);printf("Enter Name (FIRST NAME MIDDLE INITIAL SURNAME): ");
    gotoxy(68,14);scanf(" %[^\n]s", x.name);
    gotoxy(20,15);printf("Enter Age: ");
    gotoxy(31,15);scanf("%d", &x.age);
    gotoxy(20,16);printf("Sex (M|F): ");
    gotoxy(32,16);scanf(" %[^\n]s", x.sex);
    gotoxy(20,17);printf("Enter Birthday (MM/DD/YY): ");
    gotoxy(47,17);scanf(" %[^\n]s", x.bday);
    gotoxy(20,18);printf("Enter Contact No (11 Digit Number): ");
    gotoxy(57,18);scanf(" %[^\n]s", x.contact_number);
    strcpy(x.appointment_date, "\0");
    strcpy(x.appointment_doctor, "\0");
    strcpy(x.appointment_doctor_contact_number, "\0");
    strcpy(x.appointment_code, "\0");
    strcpy(x.appointment_doctor_schedule, "\0");
    x.payment_status = 1;

    add_Account(x);
    gotoxy(20,19);printf("==============================================================================\n");
    gotoxy(20,20);printf("                          Account Created Successfully");
    gotoxy(20,21);printf("==============================================================================\n");
    gotoxy(20,22);system("pause");
    return 0;
}

int add_Account(ACCOUNT x)
{
    LIST *newNode;

    newNode = (LIST *)malloc(sizeof(LIST));
    newNode->accounts = x;

    newNode->next = L;
    L = newNode;
    return 0;
}

// ===============================================
// MENU FUNCTIONS
// ===============================================

int menu(int x)
{
    int choice;

    if (x == 1)
    {
        system("cls");
        Box();
        system("COLOR 0E");
        gotoxy(35,5);printf("X|||||||||||||||||E-SCHED MEDICAL|||||||||||||||||X\n");
        gotoxy(35,6);printf("X|||||||||||||||PATIENT APPOINTMENT|||||||||||||||X\n");
        gotoxy(41,8);printf("=======================================\n");
        gotoxy(51,9); printf("[1] LOG IN ACCOUNT\n");
        gotoxy(41,10);printf("=======================================\n");
        gotoxy(51,11);printf("[2] CREATE ACCOUNT\n");
        gotoxy(41,12);printf("=======================================\n");
        gotoxy(51,13);printf("[3] EXIT\n");
        gotoxy(41,14);printf("=======================================\n");
        gotoxy(51,15);printf("ENTER CHOICE: ");
        gotoxy(41,16);printf("=======================================\n");
        gotoxy(35,18);printf("X|||||||||||||||||||||||||||||||||||||||||||||||||X\n");
        gotoxy(35,19);printf("X|||||||||||||||||||||||||||||||||||||||||||||||||X\n");
        gotoxy(65,15);scanf("%d", &choice);
        return choice;
    }
    else if (x == 2)
    {
        gotoxy(41,13);printf("=======================================\n");
        gotoxy(51,14);printf("[1] Cash\n");
        gotoxy(41,15);printf("=======================================\n");
        gotoxy(51,16);printf("[2] Online Transaction\n");
        gotoxy(41,17);printf("=======================================\n");
        gotoxy(51,18);printf("[3] Back Menu\n");
        gotoxy(41,19);printf("=======================================\n");
        gotoxy(51,20);printf("Enter Choice: ");
        gotoxy(41,21);printf("=======================================\n");
        gotoxy(68,20);scanf("%d", &choice);
        return choice;
    }
    else
    {
        system("cls");
        Box();
        gotoxy(35,5);printf("X|||||||||||||||||E-SCHED MEDICAL|||||||||||||||||X\n");
        gotoxy(35,6);printf("X|||||||||||||||PATIENT APPOINTMENT|||||||||||||||X\n");
        gotoxy(41,8);printf("=======================================\n");
        gotoxy(46,9);printf("[1] View Patient Information\n");
        gotoxy(41,10);printf("=======================================\n");
        gotoxy(46,11);printf("[2] Schedule an Appointment\n");
        gotoxy(41,12);printf("=======================================\n");
        gotoxy(46,13);printf("[3] View Schedule\n");
        gotoxy(41,14);printf("=======================================\n");
        gotoxy(46,15);printf("[4] Payment for Appointment\n");
        gotoxy(41,16);printf("=======================================\n");
        gotoxy(46,17);printf("[5] Sign Out\n");
        gotoxy(41,18);printf("=======================================\n");
        gotoxy(46,19);printf("Enter Choice: ");
        gotoxy(41,20);printf("=======================================\n");
        gotoxy(65,19);scanf("%d", &choice);
        return choice;
    }

}

void display_Patient_Information()
{
    LIST *p;
    p = L;

    // Look for the username
    while (p != NULL)
    {
        if (strcmp(p->accounts.username, global_Username) == 0)
        {
            system("cls");
            Box();
            gotoxy(35,5);printf("X|||||||||||||||||E-SCHED MEDICAL|||||||||||||||||X\n");
            gotoxy(35,6);printf("X|||||||||||||||PATIENT APPOINTMENT|||||||||||||||X\n");
            gotoxy(30,8);printf("================================================================\n");
            gotoxy(30,9);printf("                     Patient Information                        \n");
            gotoxy(30,10);printf("================================================================\n");
            gotoxy(30,11);;printf("USERNAME:           %s\n", p->accounts.username);
            gotoxy(30,12);printf("PASSWORD:           %s\n", p->accounts.password);
            gotoxy(30,13);printf("NAME:               %s\n", p->accounts.name);
            gotoxy(30,14);printf("AGE:                %d\n", p->accounts.age);
            gotoxy(30,15);printf("SEX:                %s\n", p->accounts.sex);
            gotoxy(30,16);printf("BIRTHDAY:           %s\n", p->accounts.bday);
            gotoxy(30,17);printf("CONTACT NUMBER:     %s\n", p->accounts.contact_number);
            gotoxy(30,18);printf("================================================================\n\t");
            gotoxy(30,19);system("pause");
            gotoxy(30,20);printf("================================================================\n");
            break;
        }
        p = p->next;
    }
}

void appointment_Schedule()
{
    SLOT x[3];
    DOCTOR y;

    system("cls");
    Box();
    gotoxy(35,5);printf("X|||||||||||||||||E-SCHED MEDICAL|||||||||||||||||X\n");
    gotoxy(35,6);printf("X|||||||||||||||PATIENT APPOINTMENT|||||||||||||||X\n");
    gotoxy(30,8);printf("================================================================\n");
    gotoxy(30,9);printf("                     Appointment Schedule                       \n");
    gotoxy(30,10);printf("================================================================\n");

    // Check if the user has already scheduled an appointment
    LIST *q;
    q = L;
    while (q != NULL)
    {
        if (strcmp(q->accounts.username, global_Username) == 0)
        {
            if (strcmp(q->accounts.appointment_date, "\0") != 0)
            {
                gotoxy(30,12);printf("You have already scheduled an appointment");
                gotoxy(30,13);printf("Check your appointment schedule in the View Schedule Menu");
                gotoxy(30,14);printf("================================================================");
                gotoxy(30,15);system("pause");
                return;
            }
            else
            {
                break;
            }
        }
        q = q->next;
    }

    // get the current date and time
    time_t ttime = time(NULL);

    // Set the date to the start of the next day
    struct tm *set_time = localtime(&ttime);
    set_time->tm_hour = 0;
    set_time->tm_min = 0;
    set_time->tm_sec = 0;

    // Iterate to generate the Appointment Schedules
    for (int i = 0; i < DAYS; i++)
    {
        // Add 1 day to each iteration
        set_time->tm_mday++;

        //Convert the set_time to ttime
        ttime = mktime(set_time);
        set_time = localtime(&ttime);
        // Format the date string
        strftime(x[i].date, sizeof(x[i].date), "%b %d %Y", set_time);

        // Check the file
        x[i].num_patients = check_Patients_Slot_File(x[i].date);
    }

    gotoxy(30,12);printf("       DATE         NUMBER OF PATIENTS          SLOTS AVAILABLE \n\n");

    // MENU for Appointment Dates
    for (int i = 0, n = 1; i < DAYS; i++)
    {
        gotoxy(30,13+i);printf("[%i]    %s         %d                       (%d/%d)\n", n++, x[i].date, x[i].num_patients, x[i].num_patients, MAX_PATIENTS);
    }

    // Get the user input
    int choice;
    char *code;
    while (1)
    {
        int full = 0;
        gotoxy(30,17);printf("Enter Choice: ");
        gotoxy(45,17);scanf("%d", &choice);
        gotoxy(30,18);printf("================================================================");
        switch (choice)
        {
            case 1:
            case 2:
            case 3:
                    if (x[choice-1].num_patients >= MAX_PATIENTS)
                    {
                        gotoxy(30,19);printf("Sorry, the slots are already full");
                        gotoxy(30,20);printf("Please choose another date");
                        full = 1;
                        break;
                    }
                    else
                    {
                        y = appoint_Doctor();
                        code = appointment_code();
                        system("cls");
                        Box();
                        gotoxy(35,5);printf("X|||||||||||||||||E-SCHED MEDICAL|||||||||||||||||X\n");
                        gotoxy(35,6);printf("X|||||||||||||||PATIENT APPOINTMENT|||||||||||||||X\n");
                        gotoxy(30,8);printf("================================================================\n");
                        gotoxy(30,9);printf("                     Appointment Schedule                       \n");
                        gotoxy(30,10);printf("================================================================\n");
                        gotoxy(30,12);printf("You have Successfully created an Appointment Schedule\n");
                        gotoxy(30,13);printf("Your Appointment Schedule is on %s\n", x[choice-1].date);
                        gotoxy(30,14); printf("Your Doctor is %s\n", y.name);
                        gotoxy(30,15);printf("Your Appointment Code is %s\n", code);
                        x[choice-1].num_patients++;
                        break;
                    }

            default:gotoxy(30,19);printf("Invalid Choice\n");
                    break;
        }
        gotoxy(30,20);printf("================================================================\n");
        gotoxy(30,21);system("pause");
        if ((choice > 0 && choice <= 3) || full == 0)
            break;
    }

    // Copy the date to the users data
    LIST *p;
    p = L;
    while (p != NULL)
    {
        if (strcmp(p->accounts.username, global_Username) == 0)
        {
            strcpy(p->accounts.appointment_date, x[choice-1].date);
            strcpy(p->accounts.appointment_doctor, y.name);
            strcpy(p->accounts.appointment_doctor_department, y.department);
            strcpy(p->accounts.appointment_doctor_schedule, y.schedule);
            strcpy(p->accounts.appointment_doctor_email, y.email);
            strcpy(p->accounts.appointment_doctor_contact_number, y.contact_number);
            strcpy(p->accounts.appointment_code, code);
            break;
        }
    }

    save_Patients_Slot_File(x[choice-1].date, x[choice-1].num_patients);
}

void save_Patients_Slot_File(char *DTIME, int x)
{
    FILE *outFile;
    char file_path[101];

    // Format the file path
    snprintf(file_path, sizeof(file_path), "%s%s", FOLDER, DTIME);

    outFile = fopen(file_path, "w+");
    if (outFile != NULL)
    {
        fprintf(outFile, "%d", x);
        fclose(outFile);
    }
}

int check_Patients_Slot_File(char *DTIME)
{
    FILE *inFile;
    int num;
    char file_path[101];

    // Format the file path
    snprintf(file_path, sizeof(file_path), "%s%s", FOLDER, DTIME);

    inFile = fopen(file_path, "r");
    if (inFile != NULL)
    {
        fscanf(inFile, "%d", &num);
        return num;
        fclose(inFile);
    }
    else
    {
        return 0;
    }
}

void view_Schedule()
{
    LIST *p;
    p = L;

    while (p != NULL)
    {
        if (strcmp(p->accounts.username, global_Username) == 0)
        {
            system("cls");
            Box();
            gotoxy(30,4);printf("================================================================\n");
            gotoxy(30,5);printf("                     Appointment Schedule                       \n");
            gotoxy(30,6);printf("================================================================\n");
            gotoxy(30,8);printf("USERNAME:           %s\n", p->accounts.username);
            gotoxy(30,9);printf("NAME:               %s\n", p->accounts.name);
            gotoxy(30,10);printf("APPOINTMENT DATE:   %s\n", p->accounts.appointment_date);
            gotoxy(30,12);printf("===========================CODE: %s===========================\n", p->accounts.appointment_code);
            gotoxy(30,14);;printf("DOCTOR DETAILS");
            gotoxy(30,15);printf("APPOINTMENT DOCTOR: %s\n", p->accounts.appointment_doctor);
            gotoxy(30,16);printf("DEPARTMENT:         %s\n", p->accounts.appointment_doctor_department);
            gotoxy(30,17);printf("SCHEDULE:           %s\n", p->accounts.appointment_doctor_schedule);
            gotoxy(30,18);printf("EMAIL:              %s\n", p->accounts.appointment_doctor_email);
            gotoxy(30,19);printf("CONTACT NUMBER:     %s\n", p->accounts.appointment_doctor_contact_number);
            gotoxy(30,20);printf("================================================================\n\t");
            gotoxy(30,22);printf("================================================================\n");
            gotoxy(30,21);system("pause");
            break;
        }
        p = p->next;
    }
}

DOCTOR appoint_Doctor()
{
    DOCTOR doctors[MAX_DOCTORS] = {
        {"Dr. John Smith", "OPD", "Monday to Friday - 9:00am to 5:00pm", "john.smith@tupmc.com", "09123456789"},
        {"Dr. Sarah Lee", "OPD", "Tuesday to Saturday - 10:00am to 6:00pm", "sarah.lee@hospital.com", "09987654321"}
        };

    // generate a number
    srand(time(NULL));
    int num = rand() % MAX_DOCTORS ;

    // return the selected doctor
    return doctors[num];
}

void payment_Method()
{
    // Check if the user has already paid the appointment
    LIST *q;
    q = L;
    while (q != NULL)
    {
        if (strcmp(q->accounts.username, global_Username) == 0)
        {
            if (q->accounts.payment_status == 2)
            {
                printf("You have already paid your appointment\n");
                system("pause");
                return;
            }
            else
            {
                break;
            }
        }
        q = q->next;
    }

    int choice;
    while(1)
    {
        system("cls");
        printf("================================================================\n");
        printf("                     Payment Method                             \n");
        printf("================================================================\n");
        printf("                   Mode of Transaction                          \n");

        switch(choice = menu(2))
        {
            case 1: printf("Mode of Transaction is Cash\n");
                    printf("Go to the nearest %s for your payment\n", HOSPITAL_NAME);
                    system("pause");
                    break;
            case 2: printf("================================================================\n");
                    printf("                 Mode of Transaction: Online                    \n");
                    printf("================================================================\n");
                    break;
            case 3: return;
            default: printf("Invalid Input\n");
                    system("pause");
        }
        if (choice > 0 && choice <= 3)
            break;
    }

    // Prompt for payment details
    int amount, status = 1;
    char bank_name[101], account_number[101];
    char *temp = malloc(sizeof(char) * 5);
    if (choice == 2)
    {
        printf("Reservation Fee: %d.00\n", RESERVATION_FEE);
        printf("Enter your Bank Name: ");
        scanf("%s", bank_name);
        printf("Enter your Account Number: ");
        scanf("%s", account_number);
        printf("Enter Amount: ");
        scanf("%d", &amount);
        if (amount == RESERVATION_FEE)
        {
            temp = confirmation_code();
            printf("Your Confirmation Code is: %s\n", temp);
            printf("Payment Successful\n");
            printf("Thank You For Using our Program!!\n");
            system("pause");
            status = 2;
        }
        else if (amount > RESERVATION_FEE)
        {
            temp = confirmation_code();
            printf("Your Confirmation Code is: %s\n", temp);
            printf("Payment Successful\n");
            printf("Change: %d.00\n", amount - RESERVATION_FEE);
            printf("Thank You For Using our Program!!\n");
            system("pause");
            status = 2;
        }
        else
        {
            printf("Payment Failed\n");
            system("pause");
            return;
        }
    }
    // Update the payment status
    LIST *p;
    p = L;

    while (p != NULL)
    {
        if (strcmp(p->accounts.username, global_Username) == 0)
        {
            p->accounts.payment_status = status;
            break;
        }
    }
    return;
}

char *appointment_code()
{
    // FORMAT CODE: CDDD
    char code[5],
        *temp;
    int num, num2 = 0;

    temp = malloc(sizeof(char) * 5);

    // generate a random number
    srand(time(NULL));
    num = rand() % 899 + 100;
    num2 = rand() % 26 + 65;

    // convert the number to character
    sprintf(code, "%c%d", num2, num);
    strcpy(temp, code);
    return temp;
}

char *confirmation_code()
{
    char code[5];
    char *temp;
    temp = malloc(sizeof(char) * 5);
    int num[5];

    // generate a random code
    srand(time(NULL));
    for (int i = 0; i < 5; i++)
    {
        if (i % 2 == 0)
        {
            num[i] = rand() % 26 + 65;
        }
        else
        {
            num[i] = rand() % 10;
        }
    }
    // format the code and return
    sprintf(code, "%c%d%c%d%c", num[0], num[1], num[2], num[3], num[4]);
    strcpy(temp, code);
    return temp;
}

// ===============================================
// DATABASE FUNCTIONS
// ===============================================

void encrypt(char *str) {
    // encryption algorithm
    int i = 0;
    while (str[i]) {
        if (str[i] >= 'a' && str[i] <= 'z') {
            str[i] = 'a' + ((str[i] - 'a' + RAND_SEED) % CHAR_NUM);
        } else if (str[i] >= '0' && str[i] <= '9') {
            str[i] = '0' + ((str[i] - '0' + RAND_SEED) % NUM_NUM);
        } else if (str[i] >= 'A' && str[i] <= 'Z') {
            str[i] = 'A' + ((str[i] - 'A' + RAND_SEED) % CHAR_NUM);
        }
        i++;
    }
}

void decrypt(char *str) {
    // decryption algorithm
    int i = 0;
    while (str[i]) {
        if (str[i] >= 'a' && str[i] <= 'z') {
            str[i] = 'a' + ((str[i] - 'a' - RAND_SEED + CHAR_NUM) % CHAR_NUM);
        } else if (str[i] >= '0' && str[i] <= '9') {
            str[i] = '0' + ((str[i] - '0' - RAND_SEED + NUM_NUM) % NUM_NUM);
        } else if (str[i] >= 'A' && str[i] <= 'Z') {
            str[i] = 'A' + ((str[i] - 'A' - RAND_SEED + CHAR_NUM) % CHAR_NUM);
        }
        i++;
    }
}

void init()
{
    L = NULL;
}

void save()
{
    LIST *p;
    p = L;
    FILE *outFile, *outFile2, *outFile3;

    outFile = fopen(ACCOUNT_FILE, "w+");
    outFile2 = fopen(PATIENT_FILE, "w+");
    outFile3 = fopen(DOCTOR_FILE, "w+");

    if (outFile == NULL || outFile2 == NULL || outFile3 == NULL)
    {
        printf("Error opening file\n");
        system("pause");
    }
    else
    {
        fprintf(outFile, "Username,Password\n");
        fprintf(outFile2, "Name,Sex,Birthday,Contact_Number,Appointment_Date,Code,Age\n");
        fprintf(outFile3, "Name,Department,Schedule,Email,Contact_Number,Payment_Status\n");
        while (p != NULL)
        {
            // Encrypt all the data before saving
            encrypt(p->accounts.username); encrypt(p->accounts.password); encrypt(p->accounts.name); encrypt(p->accounts.sex); encrypt(p->accounts.bday); encrypt(p->accounts.contact_number);
            encrypt(p->accounts.appointment_date); encrypt(p->accounts.appointment_code); encrypt(p->accounts.appointment_doctor); encrypt(p->accounts.appointment_doctor_department); 
            encrypt(p->accounts.appointment_doctor_schedule); encrypt(p->accounts.appointment_doctor_email); encrypt(p->accounts.appointment_doctor_contact_number);

            fprintf(outFile, "%s,%s\n", p->accounts.username, p->accounts.password);
            fprintf(outFile2, "%s,%s,%s,%s,%s,%s,%d\n", p->accounts.name, p->accounts.sex, p->accounts.bday, p->accounts.contact_number, p->accounts.appointment_date, p->accounts.appointment_code, p->accounts.age);
            fprintf(outFile3, "%s,%s,%s,%s,%s,%d\n", p->accounts.appointment_doctor, p->accounts.appointment_doctor_department, p->accounts.appointment_doctor_schedule, p->accounts.appointment_doctor_email, p->accounts.appointment_doctor_contact_number, p->accounts.payment_status);
            p = p->next;
        }
    }
    fclose(outFile);
    fclose(outFile2);
    fclose(outFile3);
}

void retrieve()
{
    FILE *inFile, *inFile2, *inFile3;
    ACCOUNT z;
    int i = 0;
    char line[1001], line2[1001], line3[1001];

    inFile = fopen(ACCOUNT_FILE, "r+");
    inFile2 = fopen(PATIENT_FILE, "r+");
    inFile3 = fopen(DOCTOR_FILE, "r+");

    if (inFile == NULL || inFile2 == NULL || inFile3 == NULL)
    {
        gotoxy(30,19);printf("Error opening file\n");
    }
    else
    {
        fscanf(inFile, "%s\n", line);
        fscanf(inFile2, "%s\n", line2);
        fscanf(inFile3, "%s\n", line3);

        while (!feof(inFile))
        {
            if (i == 0)
            {
                i = 1;
            }
            else
            {
                                fscanf(inFile, " %[^,],%s\n", z.username, z.password);
                fscanf(inFile2, " %[^,],%[^,],%[^,],%[^,],%[^,],%[^,],%d\n", z.name, z.sex, z.bday, z.contact_number, z.appointment_date, z.appointment_code, &z.age);
                fscanf(inFile3, " %[^,],%[^,],%[^,],%[^,],%[^,],%d\n", z.appointment_doctor, z.appointment_doctor_department, z.appointment_doctor_schedule, z.appointment_doctor_email, z.appointment_doctor_contact_number, &z.payment_status);

                // Decrypt all the data before saving in the program
                decrypt(z.username); decrypt(z.password); decrypt(z.name); decrypt(z.sex); decrypt(z.bday); decrypt(z.contact_number); decrypt(z.appointment_date); decrypt(z.appointment_code); decrypt(z.appointment_doctor); decrypt(z.appointment_doctor_department); decrypt(z.appointment_doctor_schedule); decrypt(z.appointment_doctor_email); decrypt(z.appointment_doctor_contact_number);

                add_Account(z);
            }
        }
    }
    fclose(inFile);
    fclose(inFile2);
    fclose(inFile3);
}

// ===============================================
// UI FUNCTIONS
// ===============================================

void Box()
{
    int a = 205; //Horizontal
    int b = 186; //Vertical
    int c = 187; //Corner Top Right
    int d = 201; // Corner Top Left
    int e = 190; //Corner Bottom Right
    int f = 200; //Corner Bottom Left
    //Starting Line < Alignment < End Line
    //W = 4 < x < 23
    // H = 11 < x < 110
    for (int i = 0; i < 100; i++) //Width
    {
        gotoxy(10+i,3);printf("%c", a);// Top Width
        gotoxy(10+i,23);printf("%c", a);// Bottom Width
    }
    for (int j = 0; j < 20; j++)
    {
        gotoxy(10,3+j);  printf("%c", b); //Left Height Line
        gotoxy(110,3+j);printf("%c", b); //Right Height Line
    }   gotoxy(110,3);  printf("%c", c); //Corner Top Right
        gotoxy(10,3);    printf("%c", d); //Corner Top Left
        gotoxy(110,23); printf("%c", e);//188); //Corner Bottom Right
        gotoxy(10,23);   printf("%c", f); //Corner Bottom Left
}

void gotoxy(int x, int y)
{
    COORD coord = {0,0};
    coord.X=x;
    coord.Y=y;
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE),coord);
}