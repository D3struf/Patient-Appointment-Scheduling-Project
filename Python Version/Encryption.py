import base64
from main import Variables, LIST

globalkey = 0
ByteFF = 0xFF
RAND_SEED = 42
CHAR_NUM = 26
NUM_NUM = 10


class Encryption:
    def __init__(self):
        self.globalkey = None


def getKey(self):
    return self.globalkey


def setKey(key):
    global globalkey
    globalkey = key


# def encryptDecrypt(text):
#     inputBytes = []
#     for b in text:
#         inputBytes.append(ord(b))
#
#     result = [] * len(inputBytes)
#     for bb in inputBytes:
#         result.append(bb ^ globalkey)
#
#     converted = ""
#     for bbb in result:
#         converted += chr(bbb)
#
#     return converted


def encrypt(plain_text):
    plain_text_bytes = plain_text.encode()
    encrypted = bytearray()
    for i in range(len(plain_text_bytes)):
        encrypted.append(plain_text_bytes[i] ^ (globalkey % 256))
    return encrypted.hex()


def decrypt(encrypted_text):
    decrypted = bytearray.fromhex(encrypted_text)
    plain_text_bytes = bytearray()
    for i in range(len(decrypted)):
        plain_text_bytes.append(decrypted[i] ^ (globalkey % 256))
    return plain_text_bytes.decode()


# def encrypt(plain_text):
#     encrypted = []
#     for char in plain_text:
#         if char.isalpha():
#             if char.islower():
#                 encrypted_char = chr((ord(char) - ord('a') + RAND_SEED) % CHAR_NUM + ord('a'))
#             else:
#                 encrypted_char = chr((ord(char) - ord('A') + RAND_SEED) % CHAR_NUM + ord('A'))
#         elif char.isdigit():
#             encrypted_char = chr((ord(char) - ord('0') + RAND_SEED) % NUM_NUM + ord('0'))
#         else:
#             encrypted_char = char
#         encrypted.append(encrypted_char)
#     return ','.join(encrypted)
#
#
# def decrypt(encrypted_text):
#     decrypted = []
#     encrypted_chars = encrypted_text.split(',')
#     for char in encrypted_chars:
#         if char.isalpha():
#             if char.islower():
#                 decrypted_char = chr((ord(char) - ord('a') - RAND_SEED + CHAR_NUM) % CHAR_NUM + ord('a'))
#             else:
#                 decrypted_char = chr((ord(char) - ord('A') - RAND_SEED + CHAR_NUM) % CHAR_NUM + ord('A'))
#         elif char.isdigit():
#             decrypted_char = chr((ord(char) - ord('0') - RAND_SEED + NUM_NUM) % NUM_NUM + ord('0'))
#         else:
#             decrypted_char = char
#         decrypted.append(decrypted_char)
#     return ''.join(decrypted)


# def convertToString(arrayofStrings):
#     result = ''.join(arrayofStrings)
#     return result
#
#
# def encodeToBase64(encryptedStrings):
#     return base64.b64encode(encryptedStrings.encode())
#
#
# def decodeToBase64(decryptedStrings):
#     return base64.b64decode(decryptedStrings)


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
            setKey(key)
    except IOError as e:
        print("Error opening/reading the file: ", e)
