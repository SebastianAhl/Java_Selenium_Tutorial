## Disclaimer
This project was created for educational purposes. It is freely accessible to everyone. No liability is accepted for any damage resulting from its use.

## Description
This project is intended to provide an easy introduction to programming with [Selenium WebDriver](https://www.selenium.dev/documentation/webdriver/) using Java. The project demonstrates the use of Selenium for automated testing of websites.

To make it easier to get started, the use of build tools has been left out. At this point there won't be any test report created. You can use the integrated [Testing Explorer](https://code.visualstudio.com/docs/java/java-testing#_enable-testing-and-adding-test-framework-jars-to-your-project). I will demonstrate the use of the building tool Maven in a fork of this repository. (coming soon...)

I tried to use the [Test Practices of Selenium](https://www.selenium.dev/documentation/test_practices/) and the encouraged use of [Page object models](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/).

If you have any questions feel free to contact me directly.

# Further information:
[Visual Studio Code Java Testing](https://code.visualstudio.com/docs/java/java-testing)

## Software Used
Microsoft Windows 11 v22H2

Firefox Browser v123.0.1
Google Chrome v122.0.6261.95
Microsoft Edge v122.0.2365.66

Java JDK v21.0.2

Selenium for Java v4.18.1 (WebDriver)

Microsoft Visual Studio Code V1.87.0
Extensions:
- Debugger for Java v0.56.2 of Microsoft 
- Extension Pack for Java v0.25.15 of Microsoft 
- IntelliCode v1.2.30 of Microsoft 
- IntelliCode API Usage Examples v0.2.8 of Microsoft 
- Language Support for JAVA(TM) by Red Hat v1.28.1 of Red Hat
- Maven for Java v0.44.0 of Microsoft
- Project Manager for Java v0.23.5 of Microsoft 
- Test Runner for Java v0.40.1 of Microsoft

## Installation Instructions (Windows 11)
# Browsers
Download the browsers and install them with standard settings. Firefox you can install using the Microsoft store.

# Java
1. Download Java JDK
2. Install
3. Open Environment Variables
4. In System Variables:
- New... --> Variable name: JAVA_HOME --> Variable value: C:\Program Files\Java\jdk-21
- Path --> Edit... --> New --> C:\Program Files\Java\jdk-21\bin
5. Open Command Line --> java --version --> you should see the version installed

# Selenium
1. Download the Selenium WebDriver
2. I extracted them to C:\Selenium\selenium-java-4.18.1
3. If you use a different path you have to adjust adjust the Referenced Libraries to the path you extracted Selenium.

# Visual Studio Code
1. Open Microsoft Store in Windows
2. Search for "visual studio code" (not the insiders version)
3. Open it and install it
4. After the installation is completed, start it
5. On the left top side, press the button "Extensions"
6. Search for the extensions (listed in the "Software Used" section above) and install them.
7. After installation of all extensions, close visual studio and open it again.
8. With "File --> Open Folder" you can open the folder where you downloaded the repository from github.

## Hints
# Finding XPath easy
An easy way to find and copy XPATH of web elements with Edge browser
1. Open the website
2. Press F12 to open "Inspect"
3. Left-top-corner of "Inspect" press the button "Select ..."
4. Now you can select an element on the website by clicking on it.
5. The element will be highlighted in the "Inspect" as code
6. Right-click the highlighted code "Copy --> Copy full Xpath"
7. Enjoy your expath

## Folder Structure and File Description
Folder contained in the workspace:
- `src`: the folder to maintain sources
- `src\page_objects`: the folder to maintain page objects
- `src\testcases`: the folder to maintain testcases
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.