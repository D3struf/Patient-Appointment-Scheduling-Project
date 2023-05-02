#ifndef HEADER_H_INCLUDED
#define HEADER_H_INCLUDED

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>
#include <time.h>
#include <windows.h>

#define DATABASE_FILE "./database"
#define ACCOUNT_FILE "./database/account.txt"
#define PATIENT_FILE "./database/patient.txt"
#define DOCTOR_FILE "./database/doctor.txt"
#define FOLDER "./database/Schedules/"
#define HOSPITAL_NAME "TUP-Manila Medical Center"
#define RESERVATION_FEE 150
#define ENTER 13
#define TAB 9
#define BKSP 8
#define DAYS 3
#define MAX_PATIENTS 20
#define MAX_DOCTORS 2

// ===============================
// Array of Structure
// ===============================
typedef struct account {
    char username[51];
    char password[31];
    char name[81];
    char sex[51];
    char bday[9];
    char contact_number[12];
    char appointment_date[101];
    char appointment_doctor[101];
    char appointment_doctor_department[101];
    char appointment_doctor_schedule[101];
    char appointment_doctor_email[101];
    char appointment_doctor_contact_number[12];
    char appointment_code[5];
    int age;
    int payment_status;
}ACCOUNT;

typedef struct appointments {
    char date[31];
    int num_patients;
}SLOT;

typedef struct doctor {
    char name[81];
    char department[51];
    char schedule[101];
    char email[101];
    char contact_number[12];
}DOCTOR;

// ===============================
// Data Structure
// ===============================
typedef struct node {
    ACCOUNT accounts;
    SLOT slots;
    DOCTOR doctors;
    struct node *next;
}LIST;

// ===============================
// Global Variables
// ===============================
LIST *L;
char global_Username[81];

// ===============================
// Function Prototypes
// ===============================
void init();
int menu(int x);

// ===============================
// Account Related Functions
// ===============================
int login_Account();
int add_Account(ACCOUNT );
char *get_Password(char *, char *);
void display();
int search_Account();

// ===============================
// Patient Informations
// ===============================
void patient_Information();
void display_Patient_Information();
void appointment_Schedule();
void view_Schedule();
DOCTOR appoint_Doctor();
char *appointment_code();
void payment_Method();
char *confirmation_code();

// ===============================
// Database Functions
// ===============================
void save();
void retrieve();
int check_Patients_Slot_File(char *);
void save_Patients_Slot_File(char *, int );

#endif // HEADER_H_INCLUDED

//#include "header.h"
// #include "./functions/dbms.c"
// #include "./functions/accounts.c"
// #include "./functions/menu.c"

void Box()
{
    int a = 205; //Horizontal
    int b = 186; //Vertical
    int c = 187; //Corner Top Right
    int d = 201; // Corner Top Left
    int e = 188; //Corner Bottom Right
    int f = 200; //Corner Bottom Left
    //Starting Line < Alignment < End Line
    //W = 4 < x < 23
    // H = 11 < x < 110
    for (int i = 0; i < 100; i++) //Width
    {
        gotoxy(10+i,3);printf("%c", 205);// Top Width
        gotoxy(10+i,23);printf("%c", 205);// Bottom Width
    }
    for (int j = 0; j < 20; j++)
    {
        gotoxy(10,3+j);  printf("%c", 186); //Left Height Line
        gotoxy(110,3+j);printf("%c", 186); //Right Height Line
    }   gotoxy(110,3);  printf("%c", 187); //Corner Top Right
        gotoxy(10,3);    printf("%c", 201); //Corner Top Left
        gotoxy(110,23); printf("%c", 190);//188); //Corner Bottom Right
        gotoxy(10,23);   printf("%c", 200); //Corner Bottom Left
    //gotoxy(40,4);printf("x-x-x-x-x| OVERALL LEADERBOARD | x-x-x-x-x");


}

int main(void)
{
    int choice1, choice2, login;
    char folder_path[101];
    char database_folder[101];
    system("cls");
    Box();
    // Create the folder path
    snprintf(database_folder, sizeof(database_folder), "%s", DATABASE_FILE);
    mkdir(database_folder, 0777); // full permission to all

    snprintf(folder_path, sizeof(folder_path), "%s", FOLDER);
    mkdir(folder_path, 0777); // full permission to all

    init();
    retrieve();
    //display();
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
                    patient_Information();
                    break;
            case 3:
                    save();
                    gotoxy(25,21);printf("Programmed By: Monter, John Paul | Garcia, Almira Jill | Carolino, Jeanne May\n\n\n\n");
                    exit(0);
                    break;
            default: gotoxy(51,17);printf("Invalid Choice, Try Again!!\n"); break;
        }
        if (choice1 == 2 || (choice1 == 1 && login == 1))
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

    while (p != NULL)
    {
        if (strcmp(p->accounts.username, y.username) == 0)
        {
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
                    gotoxy(20,14);printf("==============================================================================\n");
                    gotoxy(20,15);printf("\nIncorrect Password, you have %d trials left.\n", tries);
                    gotoxy(20,16);printf("==============================================================================\n");

                    if (tries == 0)
                    {
                        gotoxy(20,17);printf("==============================================================================\n");
                        gotoxy(20,18);printf("\nYou have exceeded the number of tries\n");
                        gotoxy(20,19);printf("Please try again later\n");
                        gotoxy(20,20);printf("==============================================================================\n");
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
        return 0;
    }
}

char *get_Password(char *string, char *PASSWORD)
{
    char ch,
        *temp,
        pwd[101];
    int i = 0;

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

void patient_Information()
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
            return;
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
    gotoxy(20,18);printf("Enter Contact No: ");
    gotoxy(38,18);scanf(" %[^\n]s", x.contact_number);
    strcpy(x.appointment_date, "\0");
    strcpy(x.appointment_doctor, "\0");
    strcpy(x.appointment_doctor_contact_number, "\0");
    strcpy(x.appointment_code, "\0");
    x.payment_status = 1;

    add_Account(x);
    gotoxy(20,19);printf("==============================================================================\n");
    gotoxy(20,20);printf("                          Account Created Successfully");
    gotoxy(20,21);printf("==============================================================================\n");
    gotoxy(20,22);system("pause");
}

int search_Account()
{
    LIST *p;
    p = L;
    int marker = 1;

    while (p != NULL)
    {
        if (strcmp(p->accounts.username, global_Username) == 0)
        {
            return marker;
        }
        p = p->next;
        marker++;
    }
    return -1;
}

int add_Account(ACCOUNT x)
{
    LIST *p, *q, *newNode;
    p = q = L;

    newNode = (LIST *)malloc(sizeof(LIST));
    newNode->accounts = x;

    newNode->next = L;
    L = newNode;
    return 0;
}

void display()
{
    LIST *p;
    p = L;

    while (p != NULL)
    {
        gotoxy(20,14);printf("USERNAME:           %s\n", p->accounts.username);
        gotoxy(20,15);printf("PASSWORD:           %s\n", p->accounts.password);
        gotoxy(20,16);printf("NAME:               %s\n", p->accounts.name);
        gotoxy(20,17);printf("AGE:                %d\n", p->accounts.age);
        gotoxy(20,18);printf("SEX:                %s\n", p->accounts.sex);
        gotoxy(20,19);printf("BIRTHDAY:           %s\n", p->accounts.bday);
        gotoxy(20,20);printf("CONTACT NUMBER:     %s\n", p->accounts.contact_number);
        gotoxy(20,21);printf("%s\n", p->accounts.appointment_date);
        p = p->next;
    }
    gotoxy(20,22);system("pause");
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
            gotoxy(30,21);system("pause");
            gotoxy(30,22);printf("================================================================\n");
            break;
        }
        p = p->next;
    }
}

DOCTOR appoint_Doctor()
{
    char *temp;
    DOCTOR doctors[MAX_DOCTORS] = {
        {"Dr. John Smith", "OPD", "Monday to Friday - 9:00am to 5:00pm", "john.smith@tupmc.com", "09123456789"},
        {"Dr. Sarah Lee", "OPD", "Tuesday to Saturday - 10:00am to 6:00pm", "sarah.lee@hospital.com", "09987654321"}
        };

    // generate a number
    srand(time(NULL));
    int num = rand() % MAX_DOCTORS ;

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
                system ("cls");
                Box();
                gotoxy(35,5);printf("X|||||||||||||||||E-SCHED MEDICAL|||||||||||||||||X\n");
                gotoxy(35,6);printf("X|||||||||||||||PATIENT APPOINTMENT|||||||||||||||X\n");
                gotoxy(30,8);printf("================================================================\n");
                gotoxy(30,9);printf("                     Payment for Appointment                       \n");
                gotoxy(30,10);printf("================================================================\n");
                gotoxy(30,12);printf("You have already paid your appointment\n");
                gotoxy(30,14);printf("================================================================\n");
                gotoxy(30,13);system("pause");


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
        Box();
        gotoxy(35,5);printf("X|||||||||||||||||E-SCHED MEDICAL|||||||||||||||||X\n");
        gotoxy(35,6);printf("X|||||||||||||||PATIENT APPOINTMENT|||||||||||||||X\n");
        gotoxy(30,8);printf("================================================================\n");
        gotoxy(30,9);printf("                        Payment Method                             \n");
        gotoxy(30,10);printf("================================================================\n");
        gotoxy(30,11);printf("                     Mode of Transaction                          \n");

        switch(choice = menu(2))
        {
            case 1: system("cls");
                    Box();
                    gotoxy(35,5);printf("X|||||||||||||||||E-SCHED MEDICAL|||||||||||||||||X\n");
                    gotoxy(35,6);printf("X|||||||||||||||PATIENT APPOINTMENT|||||||||||||||X\n");
                    gotoxy(30,8);printf("================================================================\n");
                    gotoxy(30,9);printf("                        Payment Method                             \n");
                    gotoxy(30,10);printf("================================================================\n");
                    gotoxy(30,13);printf("Mode of Transaction is Cash\n");
                    gotoxy(30,14);printf("Go to the nearest %s for your payment\n", HOSPITAL_NAME);
                    gotoxy(30,15);printf("================================================================\n");
                    gotoxy(30,16);system("pause");
                    break;
            case 2:
                    gotoxy(35,5);printf("X|||||||||||||||||E-SCHED MEDICAL|||||||||||||||||X\n");
                    gotoxy(35,6);printf("X|||||||||||||||PATIENT APPOINTMENT|||||||||||||||X\n");
                    gotoxy(30,8);printf("================================================================\n");
                    gotoxy(30,9);printf("                 Mode of Transaction: Online                              \n");
                    gotoxy(30,10);printf("================================================================\n");
                    break;
            case 3: return;
            default: gotoxy(30,21);printf("Invalid Input\n");
                    gotoxy(30,22);system("pause");
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
        system("cls");
        Box();
        gotoxy(35,5);printf("X|||||||||||||||||E-SCHED MEDICAL|||||||||||||||||X\n");
        gotoxy(35,6);printf("X|||||||||||||||PATIENT APPOINTMENT|||||||||||||||X\n");
        gotoxy(30,8);printf("================================================================\n");
        gotoxy(30,9);printf("                 Mode of Transaction: Online                              \n");
        gotoxy(30,10);printf("================================================================\n");
        gotoxy(30,12);printf("Reservation Fee: %d.00\n", RESERVATION_FEE);
        gotoxy(30,13);printf("Enter your Bank Name: ");
        gotoxy(52,13);scanf("%s", bank_name);
        gotoxy(30,14);printf("Enter your Account Number: ");
        gotoxy(58,14);scanf("%s", account_number);
        gotoxy(30,15);printf("Enter Amount: ");
        gotoxy(45,15);scanf("%d", &amount);
        if (amount == RESERVATION_FEE)
        {
            system("cls");
            Box();
            gotoxy(35,5);printf("X|||||||||||||||||E-SCHED MEDICAL|||||||||||||||||X\n");
            gotoxy(35,6);printf("X|||||||||||||||PATIENT APPOINTMENT|||||||||||||||X\n");
            gotoxy(30,8);printf("================================================================\n");
            gotoxy(30,9);printf("                 Mode of Transaction: Online                              \n");
            gotoxy(30,10);printf("================================================================\n");
            temp = confirmation_code();
             gotoxy(30,13);printf("Your Confirmation Code is: %s\n", temp);
             gotoxy(30,14);printf("Payment Successful\n");
             gotoxy(30,15);printf("Thank You For Using our Program!!\n");
             gotoxy(30,16);system("pause");
            status = 2;
        }
        else if (amount > RESERVATION_FEE)
        {
            system("cls");
            Box();
            gotoxy(35,5);printf("X|||||||||||||||||E-SCHED MEDICAL|||||||||||||||||X\n");
            gotoxy(35,6);printf("X|||||||||||||||PATIENT APPOINTMENT|||||||||||||||X\n");
            gotoxy(30,8);printf("================================================================\n");
            gotoxy(30,9);printf("                 Mode of Transaction: Online                              \n");
            gotoxy(30,10);printf("================================================================\n");
            temp = confirmation_code();
            gotoxy(30,13);printf("Your Confirmation Code is: %s\n", temp);
            gotoxy(30,14);printf("Payment Successful\n");
            gotoxy(30,15);printf("Change: %d.00\n", amount - RESERVATION_FEE);
            gotoxy(30,16);printf("Thank You For Using our Program!!\n");
            gotoxy(30,17);system("pause");
            status = 2;
        }
        else
        {
            system("cls");
            Box();
            gotoxy(35,5);printf("X|||||||||||||||||E-SCHED MEDICAL|||||||||||||||||X\n");
            gotoxy(35,6);printf("X|||||||||||||||PATIENT APPOINTMENT|||||||||||||||X\n");
            gotoxy(30,8);printf("================================================================\n");
            gotoxy(30,9);printf("                 Mode of Transaction: Online                              \n");
            gotoxy(30,10);printf("================================================================\n");
            gotoxy(30,13);printf("Payment Failed\n");
            gotoxy(30,14);system("pause");
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
    sprintf(code, "%c%d%c%d%c", num[0], num[1], num[2], num[3], num[4]);
    strcpy(temp, code);
    return temp;
}

// ===============================================
// DATABASE FUNCTIONS
// ===============================================

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
                add_Account(z);
            }
        }
    }
    fclose(inFile);
    fclose(inFile2);
    fclose(inFile3);
}

void gotoxy(int x, int y)
{
    COORD coord = {0,0};
    coord.X=x;
    coord.Y=y;
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE),coord);
}

