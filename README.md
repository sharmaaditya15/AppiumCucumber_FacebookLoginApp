# Login to Facebook in mobile device/Emulator and like a page - Cucumber Framework 

This project contains the BDD framework code to login to Facebook in a mobile device using chrome browser and native Facebook app , search for a particular page and hit like button 

# Prerequisites

- An Emulator should be up and running with Android 11 
- or a real mobile device should be connected
- Appium should be installed
- Appium server should be up and running 

# How to Run 
- Import the project in eclipse
- Run the Appium server by command line or by Appium desktop application
- commands to run appium server 

```
appium
```
or in case of compatible chromedriver version 

```
appium --allow-insecure chromedriver_autodownload
```

- Start the emulator via Eclipse / Android studio 
- Right click on the feature file (LoginAndLikeFetchRewards.feature) and run as Cucumber Feature