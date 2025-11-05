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
find pa2 -name "*.class" -delete
rm -f pa2/Coordinator.java pa2/Coordinator\$State.java
javac pa2/Flight.java pa2/Geo.java pa2/Kinematics.java

java -cp pa2/lib/salsa1.1.6.jar:. salsac.SalsaCompiler \
  pa2/Main.salsa \
  pa2/ReaderActor.salsa \
  pa2/Coordinator.salsa \
  pa2/PairWorker.salsa \
  pa2/DcpaWorker.salsa \
  pa2/TcpaWorker.salsa

javac -cp pa2/lib/salsa1.1.6.jar:. $(find pa2 -name "*.java")


RUN IT:
export WORKER_THEATERS="rmsp://127.0.0.1:51001/UAL/,rmsp://127.0.0.1:51002/UAL/"
java -cp pa2/lib/salsa1.1.6.jar:. pa2.Main ./pa2/data/2nmi.txt

cd /mnt/c/Users/jimiw/OneDrive/Documents/Distributed/pa2

# recompile SALSA
java -cp pa2/lib/salsa1.1.6.jar:. salsac.SalsaCompiler pa2/*.salsa

# compile Java helpers first
javac -cp pa2/lib/salsa1.1.6.jar:. pa2/Flight.java pa2/Geo.java pa2/Kinematics.java

# compile all generated Java
javac -cp pa2/lib/salsa1.1.6.jar:. pa2/*.java

# run
java -DWORKER_THEATERS="rmsp://127.0.0.1:51001/UAL/,rmsp://127.0.0.1:51002/UAL/" \
     -cp pa2/lib/salsa1.1.6.jar:. pa2.Main ./pa2/data/2nmi.txt
