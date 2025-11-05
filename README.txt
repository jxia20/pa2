Run it with:

find pa2 -name "*.class" -delete
javac pa2/Flight.java pa2/Geo.java
java -cp pa2/lib/salsa1.1.6.jar:. salsac.SalsaCompiler pa2/Main.salsa pa2/ReaderActor.salsa pa2/Coordinator.salsa pa2/PairWorker.salsa
javac -cp pa2/lib/salsa1.1.6.jar:. $(find pa2 -name "*.java")
java -cp pa2/lib/salsa1.1.6.jar:. pa2.Main ./pa2/data/2nmi.txt

Run these 3 in separate terminals:
Open Naming Server:
java -cp pa2/lib/salsa1.1.6.jar:. wwc.naming.WWCNamingServer -p 5050

Open Theater 1:
java -cp pa2/lib/salsa1.1.6.jar:. wwc.messaging.Theater 51001

Open Theater 2:
java -cp pa2/lib/salsa1.1.6.jar:. wwc.messaging.Theater 51002

Then run this in 4th terminal:

BUILD IT, NEEDS TO BE DONE AFTER EVERY CHANGE:
find pa2 -name "*.class" -deleterm -f pa2/Coordinator.java pa2/Coordinator\$State.java
javac pa2/Flight.java pa2/Geo.java pa2/Kinematics.java

java -cp pa2/lib/salsa1.1.6.jar:. salsac.SalsaCompiler \ 
  pa2/Main.salsa pa2/ReaderActor.salsa pa2/Coordinator.salsa \
  pa2/PairWorker.salsa pa2/DcpaWorker.salsa pa2/TcpaWorker.salsa

javac -cp pa2/lib/salsa1.1.6.jar:. 

RUN IT:
export WORKER_THEATERS="rmsp://127.0.0.1:51001/UAL/,rmsp://127.0.0.1:51002/UAL/"
java -cp pa2/lib/salsa1.1.6.jar:. pa2.Main ./pa2/data/2nmi.txt