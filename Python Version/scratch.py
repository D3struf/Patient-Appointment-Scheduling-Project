
def print_color(fcolor, text, last):
    print(f"{fcolor}{text}{last}", end='')

GREY = "\033[47m"
STOP = "\033[0m"
CYAN = "\033[48;5;44m"
CYAN2 = "\033[48;5;43m"
GREEN = "\033[48;5;46m"
RED = "\033[48;5;160m"


def takeLoginAccount():
    global globalUsername
    print("\n")
    print_color(CYAN2, "                      ADMIN PAGE                      ", STOP)
    print()
    print_color(CYAN, "                       SECURITY                       ", STOP)
    print("\n")
    print_color(GREY, " Mode of Transaction:", STOP)
    print_color(GREEN, " Cash ", STOP)
    user = input("Enter Username: ")
    password = input("Enter Password: ")
    valid = 9
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

if __name__ == "__main__":
    takeLoginAccount()  # Example usage of the takeLoginAccount function
