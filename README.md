# assignment
Project Title:Game
Project Desc: This project aims to establish theory presented by Monty Hall.
As per which the chances of wining are higher if user changes the selection.

Tech/Framework: Java, Spring boot, Maven.

Installation: Build it using Maven.
Execution: User can execute this project via below 2 ways
1. Simply run Spring Application class - GameApplication
2. Run test class/ test methods in Test class - GameApplicationTests

Code Flow via Scheduler:
GameScheduler starts automatically on application start.
GameScheduler class will ask to play the game on console, invokes GameService.
Input Param:GameInput need not be set in this case.
GameService executes the game and invokes GameUtil.
GameUtil class contains the game logic.
Statistics pojo will show the totalWins, winPercentage, etc.

CodeFlow via Test Class:
There are two methods that will execute game for 100 runs.
testGameChangeBox will always change the user selection.
testGameKeepBox will always go with initial selection.

Results Observed:
Win percentage is higher if the user changes the box.
Sample output:
Statistics{switchedBoxes=100, totalRun=100, wins=76, winPercentage=76.0}
Statistics{switchedBoxes=100, totalRun=100, wins=67, winPercentage=67.0}
Win percentage is lower if the user changes the box.
Sample output:
Statistics{switchedBoxes=0, totalRun=100, wins=31, winPercentage=31.0}
Statistics{switchedBoxes=0, totalRun=100, wins=33, winPercentage=33.0}
