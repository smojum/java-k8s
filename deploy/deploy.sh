#!/usr/bin/env bash

function build_container() {
  #app name
  APP_NAME=java-k8s
  #repo location
  GCR_IMAGE_NAME=gcr.io/ultra-tube-309002/${APP_NAME}
  #remove docker images from local
  docker images -q $GCR_IMAGE_NAME | while read -r l; do docker rmi -f "$l"; done
  echo "Building $GCR_IMAGE_NAME"

  mvn -f pom.xml \
    -DskipTests=true \
    clean spring-boot:build-image -e \
    -Dspring.profiles.active=production,cloud \
    -Dspring-boot.build-image.imageName=$GCR_IMAGE_NAME \
    clean spring-boot:build-image -e
  IMAGE_ID="$(docker images -q $GCR_IMAGE_NAME)"
  docker tag "${IMAGE_ID}" ${GCR_IMAGE_NAME}:latest
  docker push ${GCR_IMAGE_NAME}:latest
}

echo "going to deploy the application"
NS=mynamespace
kubectl get ns/$NS || kubectl create namespace $NS
cd ..
build_container
cd deploy || exit
kubectl apply -f java-k8s.yaml -n $NS
