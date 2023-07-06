import os


def checkPatientSlotFile(DTIME, scheduled):
    filePath = DTIME + ".txt"
    filePath2 = os.path.join(scheduled, filePath)
    try:
        # folderPath = os.path.dirname(Variables.SCHEDULE_FOLDER)
        # os.makedirs(filePath, exist_ok=True)
        with open(filePath2, "w") as file:
            print(filePath2)
            # if os.path.exists(filePath2):
            #     slotNum = file.readline()
            #     return int(slotNum)
            # else:
            #     return 0
    except IOError as e:
        print("Error opening/reading to file: ", e)
    return 0


schedule = "database\\Schedules"
DTIME = "July 12 2023"
checkPatientSlotFile(DTIME, schedule)
