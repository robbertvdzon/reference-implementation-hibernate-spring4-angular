#!/bin/bash

docker build -t robbertvdzon/mysql ./mysql
docker run -d -p 3080:80 -p 3306:3306 --name mysqldb robbertvdzon/mysql
