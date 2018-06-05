
@echo off


SET CURRENT_DIR=%cd%
SET PROJECT_DIR=%CURRENT_DIR%/..

 


set CP=%CLASS_PATH%;%PROJECT_DIR%

SET CP=%CP%;%CURRENT_DIR%/../lib/*

echo %CP%

SET APPNAME=com.tooklili.tookitem.TookItemApplication

java -Xms256m -Xmx256m -classpath "%CP%" %APPNAME% %1



echo "started"
pause
