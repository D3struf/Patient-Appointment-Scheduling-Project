import base64
from main import Variables

globalkey = 0
ByteFF = 0xFF


class Encryption:
    def __init__(self):
        self.globalkey = None

    def getKey(self):
        return self.globalkey

    def setKey(self, key):
        self.globalkey = key


def encryptDecrypt(input):
    inputBytes = list(input.encode())
    result = []
    for byte in inputBytes:
        result.append(byte ^ (globalkey & ByteFF))
    converted = ''.join(chr(byte) for byte in result)
    return converted


def convertToString(arrayofStrings):
    result = ''.join(arrayofStrings)
    return result


def encodeToBase64(encryptedStrings):
    return base64.b64encode(encryptedStrings.encode())


def decodeToBase64(decryptedStrings):
    return base64.b64decode(decryptedStrings)


def saveKey():
    try:
        with open(Variables.KEY_FILE, 'w') as outFile:
            outFile.write(str(globalkey))
    except IOError as e:
        print("Error opening/writing to file: ", e)


def retrieveKey():
    encryption = Encryption()
    try:
        with open(Variables.KEY_FILE, 'r') as inFile:
            key = int(inFile.readline())
            encryption.setKey(key)
    except IOError as e:
        print("Error opening/reading the file: ", e)
