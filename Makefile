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

run_front:
	echo "App started: http://localhost:9001/"
	cd front; rm -r node_modules; yarn; yarn start;
