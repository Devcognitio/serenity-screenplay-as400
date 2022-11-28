[![Java CI with Gradle](https://github.com/Devcognitio/serenity-screenplay-as400/actions/workflows/pipeline.yml/badge.svg?branch=main)](https://github.com/Devcognitio/serenity-screenplay-as400/actions/workflows/pipeline.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=serenity-screenplay-as400&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=serenity-screenplay-as400)

<p align='center'>
    <img src='https://user-images.githubusercontent.com/77740619/131050720-d5d4dcce-5f45-4616-812f-63b24bc02bfe.png'>
    <h3 align='center'>Devco</h3>
    <h3 align='center'>Screenplay AS400 Library</h3>
  <p>

  ___

  > This library will allow you to interact with AS400 systems using Serenity BDD with Java.

  It provides a set of interactions which will allow the generation of automatic test artifacts in a simple way with an AS400 system. Also, it will eliminate the dependency on an AS400 session emulation system since it will carry out the connection and interaction through telnet.
  
  ### Developed with 🔨

  * SerenityBDD + Screenplay library with Java
  * xtn5250 Library Version: 2.2
  * dm3270-lib Library Version: 0.9.1

  ## Start up 🚀

  Follow the steps below to start using the library in your automation process.

  ### Prerequisites 📋

   * Java JDK 11

  ### Instalation 🔧

  * Serenity properties

  When using the library you will be provided with some properties that will allow you to to have control over the maximum timeout on the connection, as well as the moment and format of capturing evidence during execution time.
  
  1. Maximum timeout

  ```
  connection.timeut = 5000
  ```
>  Note: By default, 10 Sec (10000 millis)

>  :warning: Express time in milliseconds.

2. Screenshot time

 ```
  serenity.take.screenshots =   --> FOR_EACH_ACTION
                                '--> FOR_EACH_VALIDATION
```

>  Note: By default, evidences will not be taken.

3. Screenshot format

 ```
 serenity.format.screenshots =  --> TEXT
                               '--> IMAGE
 ```

>  Note: By default, the format will be IMAGE                     


  ## How to use ⚙️

  Considering that AS400 systems expose two different terminals (3270 and 5250). You will find functionalities for each of them, just make sure you use the right ones.

 ```
  Terminal 5250 > co.com.devco.automation.screenplay.as400.screen5250

  Terminal 3270 > co.com.devco.automation.screenplay.as400.screen3270
 ```

 ### Interactions

  <br>
  
  1. Open a new session with a terminal
  
  * OpenScreen5250
  ```
  Open5250.session(Session)
  ```
  
  * OpenScreen3270
  ```
  Open3270.session(Session)
  ```
  
  > Note: For both terminals. This method needs an object of type Session which can be created as follows:
  
  ```
  Session.withHost(String).andPort(Integer).conectingToSSL(boolean)
  ```
  
  <br>

  2. Enter text into editable field
  
  Same invocation for both terminals. Just invoke the correct one inside the correct package.
  
 ```
  Enter.theValue(String).into(Target)
 ```
  
  > Note: If you have questions about how to create the target, go to the corresponding section.
  
  <br>
  
  3. Hit a key or send a character
  
  Same invocation for both terminals. Just invoke the correct one inside the correct package.
  
  * Terminal 5250
  
  ```
  Hit.the(KeysScreen5250)
  ```
  
  * Terminal 3270
  
  ```
  Hit.the(KeysScreen3270)
  ```
  
  > Note: See existing keys for the 5250 or 3270 terminal.
  
  <br>
  
  ### Questions
    
  ```
   Text.of(Target)
  ```

  > :warning: The target must be created by coordinates, not by label.
  
  <br>
  
  ### Target
  
  The target of this library can be created by coordinates or tag.
  
> Warning: Make sure you are using the target object from this library and not the one from Serenity BDD.
 
  * Creation by tag
  
  ```
    Target element = Target.the(String).locatedByTag(String)
  ```
  
  * Creation by coordinates
  
  ```
    Target element = Target.the(String).locatedByCoordinate(Coordinate)
  ```
    
> Note: It is recommended to use the following method when you have to extract a text from the terminal because you will be able to locate it by start and end position, as well as the length of the text.
  
  ```
    Coordinate.withRow(Integer).withInitialColumn(Integer).andLenght(Integer)
  ```

  ### Waits
  
  * System wait
  
  ```
    Wait.system() -> Wait until the system is ready to interact.
  ```
  
  * Wait for text 
  
  ```
    Wait.string(String) -> Wait until string is observable on the screen.
  ```
  
  * Wait a while
  
  ```
    Wait.time(Long) -> Wait a time expressed in milliseconds.
  ```
  
  > Note: The hit action uses the Wait.system() action by default with a timeout of 10 seconds.
  
  
 ### Contributions
  
If you want to contribute you can send your pull request and it will be reviewed by the administrators.
  
  ## Authors ✒️

* **Gabriel Jaime Useche Ossa** -(https://github.com/gusecheo)
* **Devco** -(https://github.com/Devcognitio)
