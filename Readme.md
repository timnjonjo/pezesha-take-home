# Pezesha Payment
## Producer
* Written in Spring-boot
* Runs on port 8090
* To Build
```bash
    cd /sample-producer
    mvn clean package
    docker build -t pezesha-producer:1.0.0 .
    docker push pezesha-producer:1.0.0
```

## Consumer
* Written in Spring-boot
* Runs on port 8090
* To Build
```bash
    cd /sample-consumer
    mvn clean package
    docker build -t pezesha-consumer:1.0.0 .
    docker push pezesha-consumer:1.0.0
```
