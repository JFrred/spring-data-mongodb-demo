[![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/)
[![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)](https://mongodb.com/)
[![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)](https://maven.apache.org/)
[![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)

# Spring Data MongoDB demo
Simple Rest CRUD API with MongoDB running in a Docker container and Mongo Express gui 

### Useful links
* https://docs.mongodb.com/drivers/java/sync/current/quick-start/
* https://www.baeldung.com/spring-data-mongodb-tutorial
* https://www.youtube.com/watch?v=Www6cTUymCY&t=1471s

### Useful commands
to start the containers in the background and leave them running use:
```shell
    $ docker-compose up -d 
```

to run a command in a running container use: 
```shell
    $ docker exec -it <docker-container-id> bash
```

to open mongo shell in docker container use:
```shell
    root@<docker-container-id>:/# mongo mongodb://host:port -u <username> -p <password>
``` 
``    e.g.  root@abcdef123456:/# mongo mongodb://localhost:27017 -u rootuser -p rootpass
``

