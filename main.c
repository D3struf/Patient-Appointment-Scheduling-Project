#include "header.h"
// #include "./functions/dbms.c"
// #include "./functions/accounts.c"
// #include "./functions/menu.c"

int main(void)
{
    int choice1, choice2, login;

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
            case 2: break;
            case 3: break;
            case 4: save(); 
                    exit(0); 
                    break;
            case 5: save(); 
                    exit(0); 
                    break;
            default: printf("Invalid Choice, Try Again!!\n"); 
                    system("pause");
                    break;
        }
    }
    //display all account pa lang to
    display();
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
    printf("Enter Password: ");
    scanf(" %[^\n]s", x.password);

    add_Account(x);
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

// ===============================================
// DATABASE FUNCTIONS
// ===============================================

void init()
{
    L = NULL;
}

void save()
{
    FILE *outFile, *outFile2;

    outFile = fopen(ACCOUNT_FILE, "w+");
    outFile2 = fopen(PATIENT_FILE, "w+");

    if (outFile == NULL || outFile2 == NULL)
    {
        printf("Error opening file\n");
        system("pause");
    }
    else
    {
        fprintf(outFile, "Username,Password\n");
        fprintf(outFile2, "Name,Age,Sex,Birthday,ContactNumber\n");
        while (L != NULL)
        {
            fprintf(outFile, "%s,%s\n", L->accounts.username, L->accounts.password);
            fprintf(outFile2, "%s,%s,%s,%s,%d\n", L->accounts.name, L->accounts.sex, L->accounts.bday, L->accounts.contact_number, L->accounts.age);
            L = L->next;
        }
    }
    fclose(outFile);
    fclose(outFile2);
}

void retrieve()
{
    FILE *inFile, *inFile2;
    ACCOUNT z;
    int i = 0;
    char line[41], line2[81];

    inFile = fopen(ACCOUNT_FILE, "r+");
    inFile2 = fopen(PATIENT_FILE, "r+");

    if (inFile == NULL || inFile2 == NULL)
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
                i = 1;
            }
            else
            {
                fscanf(inFile, " %[^,],%s\n", z.username, z.password);
                fscanf(inFile2, " %[^,],%[^,],%[^,],%[^,],%d\n", z.name, z.sex, z.bday, z.contact_number, &z.age);
                add_Account(z);
            }
        }
    }
    fclose(inFile);
    fclose(inFile2);
}
