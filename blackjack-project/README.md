# Camel based implementation of the _RedHatBlackJack_ API

## API Description ##


### Building

    mvn clean package

### Running Locally

    mvn spring-boot:run
	
	i.e mvn spring-boot:run -DskipTests -Dspring.profiles.active=dev

Getting the API docs:

    curl http://localhost:8080/openapi.json

## Running on OpenShift

    mvn fabric8:deploy

You can expose the service externally using the following command:

    oc expose svc redhatblackjack

And then you can access it's OpenAPI docs hosted by the service at:

    curl -s http://$(oc get route redhatblackjack --template={{.spec.host}})/openapi.json
