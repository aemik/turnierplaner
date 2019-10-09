REM set current path
SET mypath=%~dp0
cd %mypath:~0,-1%

mvn clean compile quarkus:dev

pause