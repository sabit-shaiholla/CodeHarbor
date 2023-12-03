# Camera-tracked Virtual Keyboard
This is a virtual keyboard that is tracked by a camera. 
It is written in Python and uses OpenCV for image processing and Pygame for the GUI.

## Features
* Tracks the user's hand and displays it on the screen 
* Can write text in text editor based on your hand activity

## Dependencies
* Python 3.6
* OpenCV 3.4.2
* Pygame 1.9.4
* Numpy 1.15.4
* imutils 0.5.2
* pynput 1.4.2
* pyautogui 0.9.38

## How to install
1. Clone the repository
`https://github.com/sabit-shaiholla/31github/python-app/camera-keyboard.git`
2. Install the dependencies
`pip install -r requirements.txt`
3. Run the program
`python main.py`

## Help
You might face issue with webcam not showing and you get errors.
To solve it just change the value in this line (for example to `1`).
`cap = cv2.VideoCapture(0)`
Increment this number until you see your webcam.

## Click
In order to simulate a click, you need to connect the index and middle fingers on your hand.