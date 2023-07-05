import tkinter as tk
from tkinter import *
import another

window = tk.Tk()

page1 = Frame(window)
page1.place(x=10, y=10)

label1 = Label(text="Page 1")
label1.place(x=100, y=10)

btn1 = Button(page1, text="next", command=lambda: another.secondpage(window).page2.tkraise())
btn1.pack()

window.geometry("600x600")
window.mainloop()
