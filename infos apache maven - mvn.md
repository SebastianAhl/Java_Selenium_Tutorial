# General information
"Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information." source [Homepage Apache Maven](https://maven.apache.org/)

Maven can be started in Windows via the command line.

# pom.xml
"Maven builds a project using its project object model (POM) and a set of plugins." source [What is Maven](https://maven.apache.org/what-is-maven.html)
[POM Reference](https://maven.apache.org/pom.html)

## Dependencies section

A list of availabe dependencies one can find on [MVN Repository](https://mvnrepository.com).
I highly recommend to navigate to this website and search for the dependency you want to add to your project.

### Adding dependencies with Visual Studio Code (VS Code)
1. Open the VS Code explorer on the left
2. Open the section "MAVEN"
3. Navigate to "Dependencies"
4. Press the "+" next to the "Dependencies"
5. Search for the dependency you want to add --> now it VS Code searches online
6. After the results are displayed you can either add the dependency by clicking on it or add more search terms for a detailed search.

### Adding dependencies manually
1. Navigate to [MVN Repository](https://mvnrepository.com)
2. Search for a dependency (e.g. "junit")
3. Open the one that you want to use
4. Choose the version you want to use (clicking on version)
5. Copy and paste the dependency from the website to your pom.xml

## Properties section
More or less the section for variables:
"Properties are the last required piece to understand POM basics. Maven properties are value placeholders, like properties in Ant. Their values are accessible anywhere within a POM by using the notation ${X}, where X is the property." Source [POM Properties](https://maven.apache.org/pom.html)

## Build section
You can find the available version [Maven Plugins](https://maven.apache.org/plugins/index.html).

"Beyond the basics of the POM given above, there are two more elements that must be understood before claiming basic competency of the POM. They are the build element, that handles things like declaring your project's directory structure and managing plugins; and the reporting element, that largely mirrors the build element for reporting purposes." source [Build Information](https://maven.apache.org/pom.html#build)

# Syntax
## Maven
`mvn --version`
- `mvn`: Maven
- `--version`: Returns the used maven version

`mvn surefire-report:report -f "pom.xml" -Dgroups=Test`
- `surefire-report:report`: runs tests, creates a report in html format
- `-f`: Parameter for path option to the pom.xml file
- `pom.xml`: Path to the pom.xml file
- (optional)`-Dgroups=Test`: only runs tests with the @Tag="Test"; Carfull, case sensitive

## Helpfiles
`mvn PLUGIN:help -Ddetail=true`
Help for the surefire plugin.
- (optional) `-Ddetail=true`: prints more details of the help file

`mvn surefire:help -Ddetail=true`
Help for the surefire plugin.
- (optional) `-Ddetail=true`: prints more details of the help file

`mvn surefire-report:help`
Help for the surefire report plugin.
From the help file:
`surefire-report:failsafe-report-only`
  `Creates a nicely formatted Failsafe Test Report in html format. This goal does`
  `not run the tests, it only builds the reports.`

`surefire-report:help`
  `Display help information on maven-surefire-report-plugin.`
  `Call mvn surefire-report:help -Ddetail=true -Dgoal=<goal-name> to display`
  `parameter details.`

`surefire-report:report`
  `Creates a nicely formatted Surefire Test Report in html format.`

`surefire-report:report-only`
  `Creates a nicely formatted Surefire Test Report in html format. This goal does`
  `not run the tests, it only builds the reports.`