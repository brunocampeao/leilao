@echo off
setlocal enabledelayedexpansion

set JAVA_CMD=E:\ECLIPSE\VMS\jdk1.8.0_144-DCEVM\bin\java.exe
set JAVA_CMD_PARAMS=-agentlib:jdwp=transport=dt_socket,server=n,suspend=y,address=localhost:5555 -jar .\target\br.projeto.leilao.app-0.0.1-SNAPSHOT-exec.jar
set JAVA_APP_PARAMS=

%JAVA_CMD% %JAVA_CMD_PARAMS% %JAVA_APP_PARAMS%

