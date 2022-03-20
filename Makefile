docker_up d-up:
	docker-compose up -d --build

docker_stop:
	docker-compose stop

docker_down:
	docker-compose down

clean:
	./gradlew clean

build:
	./gradlew clean build

run_spring: clean
	./gradlew bootRun


