from tkinter import *
from tkinter.ttk import Progressbar
from PIL import ImageTk, Image
from UILogin import UILogin


window = Tk()
welcomeFrame = Frame(window, bg="white")
progress_bar = Progressbar(welcomeFrame, orient=HORIZONTAL, length=1366, mode='determinate')


class UIWelcome:
    def __init__(self):
        # Load and resize images
        icon = ImageTk.PhotoImage(Image.open("images/logo.png").resize((200, 200)))
        bg_icon = ImageTk.PhotoImage(Image.open("images/bgicon.jpg").resize((683, 768)))
        java_icon = ImageTk.PhotoImage(Image.open("images/java.png").resize((65, 65)))
        tup_icon = ImageTk.PhotoImage(Image.open("images/tup.png").resize((55, 55)))

        # Create labels with images
        bg_image_label = Label(welcomeFrame, image=bg_icon, borderwidth=0)
        subject = Label(welcomeFrame, text=" Programming Language ", font=("Dialog", 18, "bold"), fg="white", bg="lightgray")
        title = Label(welcomeFrame, text="Patient Appointment", font=("Dialog", 55, "bold"), fg="#D62839", bg="white")
        title2 = Label(welcomeFrame, text="Scheduling System", font=("Dialog", 40, "bold"), fg="#D62839", bg="white")
        java_logo = Label(welcomeFrame, image=java_icon, bg="white")
        java_text = Label(welcomeFrame, text="Java 20", font=("Dialog", 24, "bold"), fg="gray", bg="white")
        tup_logo = Label(welcomeFrame, image=tup_icon, bg="white")
        tup_text = Label(welcomeFrame, text="TUP - Manila Students", font=("Dialog", 24, "bold"), fg="gray", bg="white")
        dev1 = Label(welcomeFrame, text="This program is created by the following Developers:", font=("Dialog", 18, "bold"), fg="lightgray", bg="white")
        dev2 = Label(welcomeFrame, text="Project Lead: John Paul Monter", font=("Dialog", 18, "bold"), fg="lightgray", bg="white")
        dev3 = Label(welcomeFrame, text="Jeanne May Carolino", font=("Dialog", 18, "bold"), fg="lightgray", bg="white")
        dev4 = Label(welcomeFrame, text="Almira Jill Garcia", font=("Dialog", 18, "bold"), fg="lightgray", bg="white")

        # Style the Frame
        window.iconphoto(False, icon)
        window.title("Patient Appointment Scheduling System")
        window.configure(bg="white")
        window.overrideredirect(True)
        center_frame_on_screen()
        window.geometry("1366x768")

        # Add objects
        welcomeFrame.place(x=0, y=0, width=1366, height=768)
        subject.place(x=40, y=140)
        title.place(x=40, y=185)
        title2.place(x=40, y=270)
        java_logo.place(x=40, y=660)
        java_text.place(x=115, y=680)
        tup_logo.place(x=250, y=670)
        tup_text.place(x=315, y=680)
        bg_image_label.place(x=690, y=-20)
        dev1.place(x=40, y=350)
        dev2.place(x=40, y=380)
        dev3.place(x=40, y=410)
        dev4.place(x=40, y=440)

        progress_bar.place(x=0, y=758)
        progress_fill()


def progress_fill():
    global progress_bar
    counter = 0
    while counter <= 100:
        progress_bar['value'] = counter
        welcomeFrame.update_idletasks()
        welcomeFrame.after(100)
        counter += 10


def center_frame_on_screen():
    screen_width = window.winfo_screenwidth()
    screen_height = window.winfo_screenheight()
    x = (screen_width - 1366) // 2
    y = (screen_height - 768) // 2
    window.geometry(f"1366x768+{x}+{y}")


if __name__ == '__main__':
    ui_welcome = UIWelcome()
    UILogin(window)
    window.mainloop()

