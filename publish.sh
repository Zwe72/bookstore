cd target

./mvnw package -DskipTests

scp bookstore-0.0.1-SNAPSHOT.jar zwel@softala.haaga-helia.fi:

scp zwel@softala.haaga-helia.fi "java -jar bookstore-0.0.1.SNAPSHOT.jar"