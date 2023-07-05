from tkinter import *
from tkinter.ttk import Progressbar
from PIL import ImageTk, Image


class UIWelcome:
    def __init__(self):
        self.welcome_frame = Tk()

        # Load and resize images
        icon = ImageTk.PhotoImage(Image.open("images/logo.png").resize((200, 200)))
        bg_icon = ImageTk.PhotoImage(Image.open("images/bgicon.jpg").resize((683, 768)))
        java_icon = ImageTk.PhotoImage(Image.open("images/java.png").resize((65, 65)))
        tup_icon = ImageTk.PhotoImage(Image.open("images/tup.png").resize((55, 55)))

        # Create labels with images
        bg_image_label = Label(self.welcome_frame, image=bg_icon)
        self.progress_bar = Progressbar(self.welcome_frame, orient=HORIZONTAL, length=1366, mode='determinate')
        subject = Label(self.welcome_frame, text="  Programming Language", font=("Dialog", 18, "bold"), fg="white", bg="lightgray")
        title = Label(self.welcome_frame, text="Patient Appointment", font=("Dialog", 55, "bold"), fg="#D62839", bg="white")
        title2 = Label(self.welcome_frame, text="Scheduling System", font=("Dialog", 40, "bold"), fg="#D62839",bg="white")
        java_logo = Label(self.welcome_frame, image=java_icon, bg="white")
        java_text = Label(self.welcome_frame, text="Java 20", font=("Dialog", 24, "bold"), fg="gray", bg="white")
        tup_logo = Label(self.welcome_frame, image=tup_icon, bg="white")
        tup_text = Label(self.welcome_frame, text="TUP - Manila Students", font=("Dialog", 24, "bold"), fg="gray", bg="white")
        dev1 = Label(self.welcome_frame, text="This program is created by the following Developers:", font=("Dialog", 18, "bold"), fg="lightgray", bg="white")
        dev2 = Label(self.welcome_frame, text="Project Lead: John Paul Monter", font=("Dialog", 18, "bold"), fg="lightgray", bg="white")
        dev3 = Label(self.welcome_frame, text="Jeanne May Carolino", font=("Dialog", 18, "bold"), fg="lightgray", bg="white")
        dev4 = Label(self.welcome_frame, text="Almira Jill Garcia", font=("Dialog", 18, "bold"), fg="lightgray", bg="white")

        # Style the Framegit brach
        self.welcome_frame.iconphoto(False, icon)
        self.welcome_frame.title("Patient Appointment Scheduling System")
        self.welcome_frame.configure(bg="white")
        self.welcome_frame.overrideredirect(True)
        self.center_frame_on_screen()
        self.welcome_frame.geometry("1366x768")

        # Add objects
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

        self.progress_bar.place(x=0, y=758)
        self.progress_fill()

    def progress_fill(self):
        counter = 0
        while counter <= 100:
            self.progress_bar['value'] = counter
            self.welcome_frame.update_idletasks()
            self.welcome_frame.after(100)
            counter += 1
        self.welcome_frame.destroy()

    def center_frame_on_screen(self):
        screen_width = self.welcome_frame.winfo_screenwidth()
        screen_height = self.welcome_frame.winfo_screenheight()
        x = (screen_width - 1366) // 2
        y = (screen_height - 768) // 2
        self.welcome_frame.geometry(f"1366x768+{x}+{y}")


if __name__ == '__main__':
    ui_welcome = UIWelcome()
    ui_welcome.welcome_frame.mainloop()

