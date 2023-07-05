from tkinter import *
from PIL import ImageTk, Image


def UILogin(window):
    bgColor = "#9AB9CA"
    labelColor = "#2E5774"
    loginFrame = Frame(window, bg=bgColor)
    loginFrame.place(x=0, y=0, width=1366, height=768)

    icon = ImageTk.PhotoImage(Image.open("images/logo.png").resize((100, 100)))
    bg_icon = ImageTk.PhotoImage(Image.open("images/bgImage.jpg").resize((1366, 768)))

    # bgImageLabel = Label(loginFrame, image=bg_icon)
    # bgImageLabel.place(x=0, y=-20)

    loginBox = Frame(loginFrame, bg=labelColor)
    loginBox.place(x=700, y=0, width=666, height=768)

    logo = Label(loginFrame, image=icon, bg="white")
    logo.place(x=180, y=300)

    title2 = Label(loginFrame, text="Scheduling System", font=("Ubuntu", 30, "bold"), fg="black", bg=bgColor)
    title2.place(x=250, y=345)

    title = Label(loginFrame, text="Patient Appointment", font=("Ubuntu", 30, "bold"), fg="black", bg=bgColor)
    title.place(x=250, y=300)

    logotext = Label(loginFrame, text="Sign in or create an account", font=("Ubuntu", 18), fg="black", bg=bgColor)
    logotext.place(x=250, y=395)

    signInText = Label(loginBox, text="Sign in", font=("Ubuntu", 30, "bold"), fg="black", bg=labelColor)
    signInText.place(x=50, y=50)

    username = Entry(loginBox, fg="black", bg="white", font=("Ubuntu", 18))
    username.place(x=80, y=150, width=500, height=40)

    usernametext = Label(loginBox, text="Username", fg="black", bg=labelColor, font=("Ubuntu", 16))
    usernametext.place(x=50, y=120)

    loginFrame.bg_icon = bg_icon
    loginFrame.icon = icon
