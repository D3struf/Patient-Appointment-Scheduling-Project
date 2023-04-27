#ifndef HEADER_H_INCLUDED
#define HEADER_H_INCLUDED

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>

#define ACCOUNT_FILE "./database/account.txt"
#define PATIENT_FILE "./database/patient.txt"
// #define DEPARTMENTS ""
#define ENTER 13
#define TAB 9
#define BKSP 8

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
    int age;
}ACCOUNT;

// ===============================
// Data Structure
// ===============================
typedef struct node {
    ACCOUNT accounts;
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
int add_Account(ACCOUNT x);
char *get_Password(char *, char *);
void display();
int search_Account();

// ===============================
// Patient Informations
// ===============================
void patient_Information();
void display_Patient_Information();

// ===============================
// Database Functions
// ===============================
void save();
void retrieve();

#endif // HEADER_H_INCLUDED