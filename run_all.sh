#!/bin/sh
# önce bütün servisler için package ve container oluşturuyoruz

echo "Packaging jar for Academic service..."
cd ./academic-service
./mvnw clean package
cd ..

echo "Packaging jar for Student service..."
cd ./student-service
./mvnw clean package
cd ..

echo "Packaging jar for Human resources service..."
cd ./human-resources-service
./mvnw clean package
cd ..

echo "Packaging jar for authentication service..."
cd ./authentication-service
./mvnw clean package
cd ..



# sonra tüm servisleri docker-compose dosyası ile başlatıyoruz
echo "Starting all containers with docker compose..."
docker compose up

