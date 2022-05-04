cd ..
./mvnw -f pom.xml      -DskipTests=true -Dspring-boot.build-image.imageName=k8s-native clean spring-boot:build-image
./mvnw -f pom-basic.xml -DskipTests=true -Dspring-boot.build-image.imageName=k8s-basic clean spring-boot:build-image

