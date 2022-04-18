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

rebuild_front:
	echo "App started: \n"
	cd front; rm -r node_modules; yarn; yarn start;

run_front:
	cd front; yarn start;
