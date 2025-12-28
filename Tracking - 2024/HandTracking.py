# pip install opencv-python
# pip install mediapipe
import cv2
import mediapipe as mp

vid = cv2.VideoCapture(0)
vid.set(3, 1280)
mphands = mp.solutions.hands
Hands = mphands.Hands(max_num_hands= 1, min_detection_confidence= 0.7, min_tracking_confidence= 0.6 )
mpdraw = mp.solutions.drawing_utils
while True :
    _, frame = vid.read()
    # convert from bgr to rgb
    RGBframe = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
    result = Hands.process(RGBframe)
    if result.multi_hand_landmarks:
        #print("hand found")
        for handLm in result.multi_hand_landmarks :
            #print(handLm)
            mpdraw.draw_landmarks(frame, handLm, mphands.HAND_CONNECTIONS,
                                  mpdraw.DrawingSpec(color=(0, 0, 255), circle_radius=7,
                                                     thickness=cv2.FILLED),
                                  mpdraw.DrawingSpec(color=(0, 255, 0), thickness=7)
                                  )
            for id, lm in enumerate(handLm.landmark):
                h, w, _ = frame.shape
                cx, cy = int(lm.x * w), int(lm.y * h)
                print(id, cx, cy)

               # cv2.circle(frame, (cx, cy), 5, (0, 255, 0), cv2.FILLED)
                if id == 4 :
                    pass
                    #Tx, Ty = cx, cy
                    #cv2.circle(frame, (Tx, Ty), 6, (255, 0, 0), cv2.FILLED)
                if id == 8 :
                    pass
                    #cv2.circle(frame, (cx, cy), 6, (255, 0, 0), cv2.FILLED)
                    #cv2.line(frame, (cx, cy), (Tx, Ty), (255, 0, 0), 5 )
    #cv2.imshow("rgbvideo", RGBframe)
    cv2.imshow("video", frame)
    cv2.waitKey(1)