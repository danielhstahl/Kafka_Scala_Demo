Run `docker-compose up` to start the producer and broker.  In a second terminal, run `sbt run` to start the scala consumer.  Once everything is ready, run `docker ps` in a third terminal and find the docker image with name "kafka".  Create bash terminal via `docker exec -ti <containerId> bash`.  You should see output produced by the scala consumer. 