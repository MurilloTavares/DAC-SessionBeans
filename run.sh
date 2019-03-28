docker build -t dacsession/banco ./banco
docker run -p 5433:5432 --name banco -d dacsession/banco

mvn clean package

docker build -t dacsession/app .
docker run -p 8082:8080 --name app --link banco:hostbanco -d dacsession/app
