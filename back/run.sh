docker run -p 8080:8080 -e POSTGRES_URL=jdbc:postgresql://db:5432/dummy -e POSTGRES_USER=dummy -e POSTGRES_PASSWORD=dummy container
docker run -p 5432:5432 -e POSTGRES_PASSWORD=dummy \
      -e POSTGRES_DB=dummy \
      -e POSTGRES_USER=dummy \
      postgres:13