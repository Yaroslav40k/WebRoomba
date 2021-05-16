
# WebRoomba

![alt text](https://spectrum.ieee.org/image/Mjk4NjEyNg.jpeg)
This application  is a quite simple test task implementation.
It navigates an imaginary robotic hoover (much like a Roomba) through an equally imaginary room based on:

- room dimensions as X and Y coordinates, identifying the top right corner of the room rectangle. 
    This room is divided up in a grid based on these dimensions; a room that has dimensions X: 5 and Y: 5 has 5 columns and 5 rows,
    so 25 possible hoover positions. The bottom left corner is the point of origin for our coordinate system, 
    so as the room contains all coordinates its bottom left corner is defined by X: 0 and Y: 0.
- locations of patches of dirt, also defined by X and Y coordinates identifying the bottom left corner of those grid positions.
- an initial hoover position (X and Y coordinates like patches of dirt)
- driving instructions (as cardinal directions where e.g. N and E mean "go north" and "go east" respectively)

The room is a rectangular, has no obstacles (except the room walls), no doors and all locations in the room are clean (hoovering has no effect),
except for the locations of the patches of dirt presented in the program input.
Placing the hoover on a patch of dirt ("hoovering") removes the patch of dirt so that patch is then clean for the remainder of the program run. 
The hoover is always on - there is no need to enable it.

Driving into a wall has no effect (the robot skids in place).

## Getting Started


### Prerequisites

- Java (JDK 11+)
- Apache Maven 3.6.1+ 

### Installing

1. In order to run the code from  this repository, you will need to either download it or clone it to your machine. 
    Click the green "clone or download repository" button on the top right of the repository.
    In order to clone, you will need to have git installed on your computer.
    
2. You need to download and install Maven : https://maven.apache.org/.    
    
3. Use Maven 'mvn package' command to  build a JAR file, don`t forget to run 'mvn clean' before the build.
    By default, 'webroomba-1.0.jar' will be located in 'target' folder inside the project directory.
    
4. Alternatively, an author can provide you already compiled and built code in a precious little JAR file.    
    
    
## Deployment

By default,  if you have used Maven to build a jar, 'webroomba-1.0.jar' will be located in 'target' folder inside the project directory.
Application can be deployed on any suitable machine, since it is based on Spring Boot 2 and has Tomcat inside.

## Running the application
1. Run jar file using a Java VM via simple command console:  'java -jar webroomba-{jar_version}.jar'
    Latest version by now is 1.0. Don`t forget!
  *   On Windows - Open Windows command prompt. Go to your ".jar" file directory.
                 So if jar file is located in C:\somefolder, 
                 Type the following command: java -jar webroomba-1.0.jar.
    
  *   On Linux - Open a command prompt with CTRL + ALT + T.
               Go to your ".jar" file directory. If your Ubuntu version / flavour supports it, 
               you should be able to right click on your ".jar" file's directory and click "Open in Terminal"
               Type the following command: java -jar webroomba-1.0.jar.
               
  *   On Mac -   Open Terminal.
               Go to your ".jar" file directory. 
               Type the following command: java -jar webroomba-1.0.jar.
               
  *  By default, WebRoomba service picks port 8080 and fails if it is already in use.

  *  On http://localhost:8080/h2-console will be in-memory H2 data base console. Since in the task requirements, 
     it was clearly stated, that we need to persist  each input and output to a DB.
     You can check it every time after an application has started.
   
## Sending commands

A. An application provides 3 different endpoints:              

* POST http://localhost:8080/api/action/run - runs application main logic

B. Response statuses:
* 200: The instruction processed successfully
* 400: Bad request - you have made a mistake in input JSON
* 500: There was an unknown problem  in WebRoomba application.

C. Headers:
* Accept: application/json
* Content-type: application/json;charset=UTF-8

D. Input example:
{"roomSize": [5,5],"coords": [0,0],"patches": [[0,2],[0,3],[0,4]],"instructions": "WNNES"}

* roomSize - size of a grid (X and Y length)
* coords - hoover start position (X and Y coordinates)
* patches - dirt patches position (X and Y coordinates)
* instructions - chars, dedicated to show direction for hoover movements

E. Output example:
{"coords": [1,1],"patches": 1}
* coords - hoover final position
* patches - collected dirt patches

F. Optional endpoints to check persistance layer work:
* GET http://localhost:8080/api/statistic/inputs - returns all inputs from current session
* GET http://localhost:8080/api/statistic/outputs - returns all outputs from current session

All endpoints can be called via Postman or similar program.
If you need Postman endpoints collection - contact me.

## Validators

* Grid size: existence, both coordinates presented, extra coordinates
* Hoover start position: existence, both coordinates presented, extra coordinates, out of grid coordinates
* Dirt patches position: both coordinates presented, extra coordinates, 
* Instructions: existence, lower case chars, letters

For more information check 'com.andersen.webroomba.validator' package.

## Running the tests

Junit5 Jupiter based tests should be pushed during each 'build' operation, right after Maven compile stage.
Currently, there are 37 different unit test in the project, covering 123 cases.

### Break down into 'end to end' tests

All tests should run automatically during Maven build.


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## Versioning

* [GitHub](https://https://github.com/) 


## Authors

* **Yaroslav Dmitriev** -  *Initial work* - [Git](https://github.com/Yaroslav40k)


## License

TBD

## Acknowledgments

* 

