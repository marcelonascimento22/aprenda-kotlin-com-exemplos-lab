@echo off
echo Compilando...
kotlinc desafio.kt -cp "C:\Program Files\kotlin\kotlinc\lib\kotlin-stdlib.jar" -include-runtime -d app.jar
echo Executando aplicativo...
java -jar app.jar

pause