import base64
from main import Variables

globalkey = None
ByteFF = 0xFF


class Encryption:
    def __init__(self):
        self.globalkey = None

    def getKey(self):
        return self.globalkey

    def setKey(self, key):
        self.globalkey = key


def convertToString(arrayofStrings):
    result = ''.join(arrayofStrings)
    return result


def encodeToBase64(encryptedStrings):
    return base64.b64encode(encryptedStrings.encode())


def decodeToBase64(decryptedStrings):
    return base64.b64decode(decryptedStrings)


def saveKey():
    try:
        with open(Variables.KEY_FILE, 'w'):
