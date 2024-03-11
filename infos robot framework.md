# General Information
(Robot Framework)[https://robotframework.org/] is generic framework for test automation and robotic process automation.
It offers an easy syntax with human-readable keywords.

In my opinion, the Robot framework is mostly used together with Python. Even though Java is supported, most tutorials are for Python.
I wanted to learn how to use it with Java. Therefore I created this little tutorial to find out how it works. Feel free to use it for your own purposes.

I have planned to rewrite some of my tests in Robot Framework. This will make it easy to point out the differences.

--> I gave up to use robot framework with Java. Its main support is for Python and it lacks of information about how to use it with Java.

# Installation
## In Maven
!!!Unfortunately, the version for Maven is quite old. Version v4.1.2 is of 20th Oct 2021.!!!

1. Open the link (Robot Framework in Maven Repository)[https://mvnrepository.com/artifact/org.robotframework/robotframework] and choose the latest version
2. Copy the dependency of the website
3. Open the "pom.xml" file
4. Add the dependency of robot framework to the dependencies section
5. You can run all the tests with surefire command (`mvn surefire-report:report -f "pom.xml" -Dgroups=Test`)
6. If all tests succeed you are already done :-)

You can see the result in my "pom.xml" from line 22 to line 27.

# Examples
## First Example: Rewrite LoginLogoutTests.java
I think these testcases are the easiest ones to start with.

## Links
(Robot Framework in Maven Repository)[https://mvnrepository.com/artifact/org.robotframework/robotframework]
(GitHub Robot Framework for Maven)[https://github.com/robotframework/MavenPlugin]