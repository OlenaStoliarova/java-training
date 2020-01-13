####To get jar:

mvn clean install -DskipTests=true

####To run jar:
java -Dfile.encoding=UTF-8 -jar CruiseCompanyOnSpring-0.0.1-SNAPSHOT.jar

####Example of killing process
C:\>jps

    6464 jar
    1412
    9716 RemoteMavenServer36
    3292 Jps
    5132 Launcher

C:\>taskkill -f /PID 6464

    SUCCESS: The process with PID 6464 has been terminated.