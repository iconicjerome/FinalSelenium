@echo off
set projectLocation="C:\Users\USER\IdeaProjects\FinalSelenium"
cd %projectLocation%
set classpath=%projectLocation%\target\classes;%projectLocation%\target\test-classes;%projectLocation%\lib\*
java -cp %classpath% org.testng.TestNG testng.xml
pause

