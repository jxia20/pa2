PA2 SALSA Actors d1,d2,t2 with distribution:

Build (single machine):

find pa2 -name "*.class" -delete
javac pa2/Flight.java pa2/Geo.java pa2/Kinematics.java
java -cp pa2/lib/salsa1.1.6.jar:. salsac.SalsaCompiler \
  pa2/Main.salsa pa2/ReaderActor.salsa pa2/Coordinator.salsa \
  pa2/PairWorker.salsa pa2/DcpaWorker.salsa pa2/TcpaWorker.salsa
javac -cp pa2/lib/salsa1.1.6.jar:. $(find pa2 -name "*.java")

Run (local/no distribution):

java -cp pa2/lib/salsa1.1.6.jar:. pa2.Main ./pa2/data/2nmi.txt

Distributed run (2 theaters + naming server):

Terminal 1 As Naming Server:

java -cp pa2/lib/salsa1.1.6.jar:. wwc.naming.WWCNamingServer -p 5050

Terminal 2 as Theater 51001:

java -cp pa2/lib/salsa1.1.6.jar:. wwc.messaging.Theater 51001

Terminal 3 as Theater 52002:

java -cp pa2/lib/salsa1.1.6.jar:. wwc.messaging.Theater 51002

Terminal 4 as terminal to run:

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
