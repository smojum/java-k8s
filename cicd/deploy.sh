#!/usr/bin/env bash

#function build_container() {
#  #remove docker images from local
#  #docker images -q $DOCKER_IMAGE_NAME | while read -r l; do docker rmi -f "$l"; done
#  echo "Building $DOCKER_IMAGE_NAME"
#  ./mvnw -f pom.xml -DskipTests=true clean spring-boot:build-image clean spring-boot:build-image
#  docker tag java-k8s:1.0.0-SNAPSHOT gcr.io/tribal-union-94611/java-k8s:latest
#  docker push gcr.io/tribal-union-94611/java-k8s:latest
#}
#
#echo "going to deploy the application"
#NS=mynamespace
#kubectl get ns/$NS || kubectl create namespace $NS
#cd ..
#build_container
#cd deploy || exit
#kubectl apply -f java-k8s.yaml -n $NS || exit

docker run -d -p 8000:8090 k8s-basic
docker run -d -p 9000:8090 k8s-native
#sleep 10
#docker container ls -s
#docker stats
