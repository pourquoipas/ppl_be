# Ppl Backend

Quarkus project to test backend.
(Excuse my poor english)

## Build

Run `mvn clean install` on interfaces project.

Start repository project with `./mvnw compile quarkus:dev:`

Start enterprise project with `./mvnw compile quarkus:dev: -Ddebug=[other than 5005 port, eg 5006]` 

## Project structure

Interface project is a library project where i'm triyng to put shared classes and entities between repository and enterprise.

The basic idea is to separate concerns from database logic (repository) and business logic (enterprise)

I'm thinking about create another level, called core.
Then put, all core business logic in core (i mean the business logic who don't change between different installation)
And leaving in enterprise the logic that can change form one setup to another.

I mean, take the "Persona" Table.
The fields codice, cognome, nome are required by database design. And the couple codice-societa must be unique.
I can put that check on 'core module'

Then on one installation i need to have also some other field required (eg, dataNascita, codiceFiscale)
The logic to check this is pertaining to enterprise module because it may vary on another installation.

For now, there's not core module done, i'm planning to add it in future.
 