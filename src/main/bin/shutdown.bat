@echo off
set port=8088
for /f "tokens=1-5" %%i in ('netstat -ano^|findstr ":%port%"') do taskkill /F /pid %%m