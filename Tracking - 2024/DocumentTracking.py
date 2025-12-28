import cv2
import numpy as np
def drawRec(biggestNew, mainFrame):
        cv2.line(mainFrame, (biggestNew[0][0][0], biggestNew[0][0][1]), (biggestNew[1][0][0], biggestNew[1][0][1]), (0, 255, 0), 20)
        cv2.line(mainFrame, (biggestNew[0][0][0], biggestNew[0][0][1]), (biggestNew[2][0][0], biggestNew[2][0][1]), (0, 255, 0), 20)
        cv2.line(mainFrame, (biggestNew[3][0][0], biggestNew[3][0][1]), (biggestNew[2][0][0], biggestNew[2][0][1]), (0, 255, 0), 20)
        cv2.line(mainFrame, (biggestNew[3][0][0], biggestNew[3][0][1]), (biggestNew[1][0][0], biggestNew[1][0][1]), (0, 255, 0), 20)
#initializing
img = cv2.imread("/Users/ciqbian/Desktop/VS/Tracking - 2024/2.jpg")
img = cv2.resize(img, (int(480*2), int(640*2)))
w, h = 480, 640
imgWarp = img.copy()
# write code here
GrayImg = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
BlurredFrame = cv2.GaussianBlur(GrayImg, (5, 5), 1)
CannyFrame = cv2.Canny(BlurredFrame, 190, 190)
contours, _ = cv2.findContours(CannyFrame, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
ContourFrame = img.copy()
ContourFrame = cv2.drawContours(ContourFrame, contours, -1, (255, 0, 255), 4)
CornerFrame = img.copy()
maxArea = 0
biggest = []
for i in contours :
    area = cv2.contourArea(i)
    if area > 500 :
        peri = cv2.arcLength(i, True)
        edges = cv2.approxPolyDP(i, 0.02*peri, True)
        if area > maxArea and len(edges) == 4 :
            biggest = edges
            maxArea = area
if len(biggest) != 0 :
   # drawRec(biggest, CornerFrame)
    biggest = biggest.reshape((4, 2))
    biggestNew = np.zeros((4, 1, 2), dtype= np.int32)
    add = biggest.sum(1)
    biggestNew[0] = biggest[np.argmin(add)]
    biggestNew[3] = biggest[np.argmax(add)]
    dif = np.diff(biggest, axis = 1)
    biggestNew[1] = biggest[np.argmin(dif)]
    biggestNew[2] = biggest[np.argmax(dif)]
    drawRec(biggestNew, CornerFrame)
    CornerFrame = cv2.drawContours(CornerFrame, biggestNew, -1, (255, 0, 255), 25)
    pts1 = np.float32(biggestNew)
    pts2 = np.float32([[0, 0], [w, 0], [0, h], [w, h]])
    matrix = cv2.getPerspectiveTransform(pts1, pts2)
    imgWarp = cv2.warpPerspective(img, matrix, (w, h))


# resizing
img = cv2.resize(img, (480, 640))
GrayImg = cv2.resize(GrayImg, (480, 640))
BlurredFrame = cv2.resize(BlurredFrame, (480, 640))
CannyFrame = cv2.resize(CannyFrame, (480, 640))
ContourFrame = cv2.resize(ContourFrame, (480, 640))
CornerFrame = cv2.resize(CornerFrame, (480, 640))
#displaying
cv2.imshow("img", img)
cv2.imshow("GrayImg", GrayImg)
cv2.imshow("BlurredFrame", BlurredFrame)
cv2.imshow("CannyFrame", CannyFrame)
cv2.imshow("ContourFrame", ContourFrame)
cv2.imshow("CornerFrame", CornerFrame)
cv2.imshow("outputImage", imgWarp)
cv2.waitKey(0)