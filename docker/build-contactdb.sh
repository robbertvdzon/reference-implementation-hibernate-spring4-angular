#!/bin/bash


docker build -t robbertvdzon/contactdb ./contactdb
docker run -d -p 8080:8080 --name contactdb robbertvdzon/contactdb