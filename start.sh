eval "$(docker-machine env dev)"
docker run -d -p $1:9999 dbnode