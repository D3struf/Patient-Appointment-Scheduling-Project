#ifndef HEADER_H_INCLUDED
#define HEADER_H_INCLUDED

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>
#include <time.h>

#define ACCOUNT_FILE "./database/account.txt"
#define PATIENT_FILE "./database/patient.txt"
#define DOCTOR_FILE "./database/doctor.txt"
#define FOLDER "./database/Schedules/"
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

// ===============================
// Database Functions
// ===============================
void save();
void retrieve();
int check_Patients_Slot_File(char *);
void save_Patients_Slot_File(char *, int );

#endif // HEADER_H_INCLUDED