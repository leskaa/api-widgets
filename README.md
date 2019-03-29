# Api Widgets

An api that stores and retrieves widgets.

## Building/Running the Project

### Pre-Requisites

1. Java 8

### Running in intellij

Project must be imported into intellij as a gradle project.

#### Building the Project

1. Building can be accomplished by clicking the hammer icon in intellij.

#### Running Tests

1. Right click on test package and select the run test option from the context menu

#### Running the API

1. Click the debug or play button in intellij with the ApiWidgetApplication config selected.  You can also open the
    ApiWidgetApplication.java file and there should be a play button straight left of the class declaration in the gutter.


### Running via terminal

Commands below can be executed in linux and mac with a properly configured JVM.  Windows users will need to use
the gradlew.bat instead of gradlew.

#### Building and running tests

```
./gradlew clean build
```

#### Running the API

```
./gradlew clean bootRun
```

## Tasks

Here are the items we would like to implement in the API.  Feel free to tackle as many (or few) items as you have time for.
This is not an ordered list in any way and you should be able to complete most of these tasks independently of the others.

1. Implement a create gadget endpoint in the controller layer.
1. Implement a find all gadgets endpoint in the controller layer.
1. Return associated gadgets with widgets in the controller layer.
1. Rather than returning a list of widgets, we would like to return a paged response from the find all widgets endpoint.
1. Optionally write tests for the above tasks.

## General information

The api was created using spring boot and implementing the controller-service-repository pattern.  The DTOs (Data transfer objects)
and the entities have been setup to give all the information that is needed to complete the tasks above.  Comments are appreciated on
the code where appropriate.  Feedback on the difficulty of the tasks and possible next steps for the API is also welcome.


