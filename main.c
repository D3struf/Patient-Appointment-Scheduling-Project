#include "header.h"
// #include "./functions/dbms.c"
// #include "./functions/accounts.c"
// #include "./functions/menu.c"

int main(void)
{
    int choice1, choice2, login;
    char folder_path[101];

    // Create the folder path
    snprintf(folder_path, sizeof(folder_path), "%s", FOLDER);
    mkdir(folder_path, 0777); // full permission to all

    init();
    retrieve();
    display();

    // Ask for user Account
    while (1)
    {
        switch(choice1 = menu(1))
        {
            case 1: login = login_Account();
                    break;
            case 2: patient_Information();
                    break; 
            case 3: save();
                    exit(0);
                    break;
            default: printf("Invalid Choice, Try Again!!\n"); break;
        }
        if (choice1 == 2 || (choice1 == 1 && login == 1))
            break;
    }

    // Main Menu
    while(1)
    {
        choice2 = menu(2);
        switch (choice2)
        {
            case 1: display_Patient_Information(); 
                    break;
            case 2: appointment_Schedule();
                    break;
            case 3: view_Schedule();
                    break;
            case 4: 
                    break;
            case 5: save(); 
                    exit(0); 
                    break;
            default: printf("Invalid Choice, Try Again!!\n"); 
                    system("pause");
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
    printf("Enter Username: ");
    scanf(" %[^\n]s", y.username);
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
                    printf("\nLog in Successful!!\n");
                    system("pause");
                    return 1;
                }
                else
                {
                    tries--;
                    printf("\nIncorrect Password, you have %d trials left.\n", tries);

                    if (tries == 0)
                    {
                        printf("\nYou have exceeded the number of tries\n");
                        printf("Please try again later\n");
                        exit(0);
                    }
                }
            }
        }
        p = p->next;
    }
    if (p == NULL)
    {
        printf("Your account is not in the database\n");
        printf("Create account first.\n");
        system("pause");
        return 0;
    }
}

char *get_Password(char *string, char *PASSWORD)
{
    char ch,
        *temp,
        pwd[101];
    int i = 0;

    printf("%s", string);
    printf("%s", PASSWORD);

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
    printf("\n\n\tPLEASE FILL UP THE FOLLOWING INFORMATION\n");
    
    printf("Username: ");
    scanf(" %[^\n]s", x.username);
    strcpy(global_Username, x.username);
    printf("Enter Name (FIRST NAME MIDDLE INITIAL SURNAME): ");
    scanf(" %[^\n]s", x.name);
    printf("Enter Age: ");
    scanf("%d", &x.age);
    printf("Sex: ");
    scanf(" %[^\n]s", x.sex);
    printf("Enter Birthday (MM/DD/YY): ");
    scanf(" %[^\n]s", x.bday);
    printf("Enter Contact No: ");
    scanf(" %[^\n]s", x.contact_number);
    temp = get_Password("Enter Password: ", x.password);
    strcpy(x.password, temp);
    strcpy(x.appointment_date, "\0");
    strcpy(x.appointment_doctor, "\0");
    strcpy(x.appointment_doctor_contact_number, "\0");

    add_Account(x);
    printf("\nAccount Created Successfully!!\n");
    system("pause");
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
        printf("%s %s\n", p->accounts.username, p->accounts.password);
        p = p->next;
    }
    system("pause");
}

// ===============================================
// MENU FUNCTIONS
// ===============================================

int menu(int x)
{
    int choice;
    system("cls");
    if (x == 1)
    {
        printf("[1] Log in Account\n");
        printf("[2] Create Account\n");
        printf("[3] Exit\n");
        printf("Enter Choice: ");
        scanf("%d", &choice);
        return choice;
    }
    else 
    {
        printf("[1] View Patient Information\n");
        printf("[2] Schedule an Appointment\n");
        printf("[3] View Schedule\n");
        printf("[4] Payment for Appointment\n");
        printf("[5] Sign Out\n");
        printf("Enter Choice: ");
        scanf("%d", &choice);
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
            printf("================================================================\n");
            printf("                     Patient Information                        \n");
            printf("================================================================\n");
            printf("USERNAME:           %s\n", p->accounts.username);
            printf("PASSWORD:           %s\n", p->accounts.password);
            printf("NAME:               %s\n", p->accounts.name);
            printf("AGE:                %d\n", p->accounts.age);
            printf("SEX:                %s\n", p->accounts.sex);
            printf("BIRTHDAY:           %s\n", p->accounts.bday);
            printf("CONTACT NUMBER:     %s\n", p->accounts.contact_number);
            printf("================================================================\n\t");
            system("pause");
            printf("================================================================\n");
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
    printf("================================================================\n");
    printf("                     Appointment Schedule                       \n");
    printf("================================================================\n");

    // Check if the user has already scheduled an appointment
    LIST *q;
    q = L;
    while (q != NULL)
    {
        if (strcmp(q->accounts.username, global_Username) == 0)
        {
            if (strcmp(q->accounts.appointment_date, "\0") != 0)
            {
                printf("\nYou have already scheduled an appointment\n");
                printf("Check your appointment schedule in the View Schedule Menu\n");
                printf("================================================================\n");
                system("pause");
                return;
            }
            else
            {
                break;
            }
                
        }
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

    printf("       DATE         NUMBER OF PATIENTS          SLOTS AVAILABLE \n\n");

    // MENU for Appointment Dates
    for (int i = 0, n = 1; i < DAYS; i++)
    {
        printf("[%i]    %s         %d                       (%d/%d)\n", n++, x[i].date, x[i].num_patients, x[i].num_patients, MAX_PATIENTS);
    }

    // Get the user input
    int choice;
    //char *code;
    while (1)
    {
        int full = 0;
        printf("\nEnter Choice: ");
        scanf("%d", &choice);
        printf("================================================================\n");
        switch (choice)
        {
            case 1: 
            case 2:
            case 3: 
                    if (x[choice-1].num_patients >= MAX_PATIENTS)
                    {
                        printf("Sorry, the slots are already full\n");
                        printf("Please choose another date\n");
                        full = 1;
                        break;
                    }
                    else
                    {
                        y = appoint_Doctor();
                        //code = appointment_code();
                        //printf("Your Appointment Code is %s\n", code);
                        printf("You have Successfully created an Appointment Schedule\n");
                        printf("Your Appointment Schedule is on %s\n", x[choice-1].date);
                        printf("Your Doctor is %s\n", y.name);
                        
                        x[choice-1].num_patients++;
                        break;
                    }
                    
            default: printf("Invalid Choice\n");
                    break;
        }
        printf("================================================================\n");
        system("pause");
        if ((choice > 0 && choice <= 3) && full == 0)
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
            //strcpy(p->accounts.appointment_code, code);
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
            printf("================================================================\n");
            printf("                     Appointment Schedule                       \n");
            printf("================================================================\n");
            printf("USERNAME:           %s\n", p->accounts.username);
            printf("NAME:               %s\n", p->accounts.name);
            printf("APPOINTMENT DATE:   %s\n", p->accounts.appointment_date);
            printf("===========================CODE: %s============================\n", p->accounts.appointment_code);
            printf("\nDOCTOR DETAILS\n");
            printf("APPOINTMENT DOCTOR: %s\n", p->accounts.appointment_doctor);
            printf("DEPARTMENT:         %s\n", p->accounts.appointment_doctor_department);
            printf("SCHEDULE:           %s\n", p->accounts.appointment_doctor_schedule);
            printf("EMAIL:              %s\n", p->accounts.appointment_doctor_email);
            printf("CONTACT NUMBER:     %s\n", p->accounts.appointment_doctor_contact_number);
            printf("================================================================\n\t");
            system("pause");
            printf("================================================================\n");
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

char *appointment_code()
{
    // FORMAT CODE: CDDD 
    char code[5], 
        *temp;
    int num, num2 = 0;
    
    // generate a random number
    srand(time(NULL));
    num = rand() % 999 + 100;
    while(num2 > 90 || num2 < 65)
    {
        num2 = rand() % 90;
    }

    // convert the number to character
    sprintf(code, "%c%d", num2, num);
    strcpy(temp, code);
    printf("%s\n", temp);
    system("pause");
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
        fprintf(outFile2, "Name,Sex,Birthday,Contact_Number,Appointment_Date,Age\n");
        fprintf(outFile3, "Name,Department,Schedule,Email,Contact_Number\n");
        while (L != NULL)
        {
            fprintf(outFile, "%s,%s\n", L->accounts.username, L->accounts.password);
            fprintf(outFile2, "%s,%s,%s,%s,%s,%d\n", L->accounts.name, L->accounts.sex, L->accounts.bday, L->accounts.contact_number, L->accounts.appointment_date, L->accounts.age);
            fprintf(outFile3, "%s,%s,%s,%s,%s\n", L->accounts.appointment_doctor, L->accounts.appointment_doctor_department, L->accounts.appointment_doctor_schedule, L->accounts.appointment_doctor_email, L->accounts.appointment_doctor_contact_number);
            L = L->next;
        }
    }
    fclose(outFile);
    fclose(outFile2);
}

void retrieve()
{
    FILE *inFile, *inFile2, *inFile3;
    ACCOUNT z;
    int i = 0;
    char line[41], line2[81], line3[101];

    inFile = fopen(ACCOUNT_FILE, "r+");
    inFile2 = fopen(PATIENT_FILE, "r+");
    inFile3 = fopen(DOCTOR_FILE, "r+");

    if (inFile == NULL || inFile2 == NULL || inFile3 == NULL)
    {
        printf("Error opening file\n");
        system("pause");
    }
    else
    {
        while (!feof(inFile))
        {
            if (i == 0)
            {
                fscanf(inFile, "%s\n", line);
                fscanf(inFile2, "%s\n", line2);
                fscanf(inFile3, "%s\n", line3);
                i = 1;
            }
            else
            {
                fscanf(inFile, " %[^,],%s\n", z.username, z.password);
                fscanf(inFile2, " %[^,],%[^,],%[^,],%[^,],%[^,],%d\n", z.name, z.sex, z.bday, z.contact_number, z.appointment_date, &z.age);
                fscanf(inFile3, " %[^,],%[^,],%[^,],%[^,],%[^,]\n", z.appointment_doctor, z.appointment_doctor_department, z.appointment_doctor_schedule, z.appointment_doctor_email, z.appointment_doctor_contact_number);
                add_Account(z);
            }
        }
    }
    fclose(inFile);
    fclose(inFile2);
}
