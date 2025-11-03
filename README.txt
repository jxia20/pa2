Run it with:

find pa2 -name "*.class" -delete
javac pa2/Flight.java pa2/Geo.java
java -cp pa2/lib/salsa1.1.6.jar:. salsac.SalsaCompiler pa2/Main.salsa pa2/ReaderActor.salsa pa2/Coordinator.salsa pa2/PairWorker.salsa
javac -cp pa2/lib/salsa1.1.6.jar:. $(find pa2 -name "*.java")
java -cp pa2/lib/salsa1.1.6.jar:. pa2.Main ./pa2/data/2nmi.txt