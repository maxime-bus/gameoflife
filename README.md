# gameoflife

#Prerequisites

##Maven
The project is built with maven. You must have it installed on your machine.

#Build the app
After checking out the project sources, go to the root of the project then run :

`mvn compile assembly:single`

#Run the app
After the build, go to `target/` folder under the root project then run :

`java -Djava.library.path="natives/" -jar gameoflife.jar`

#How to use
The app starts with a 100x100 randomized board. You can reload the board with a new randomized state at any time, 
by hitting `r` key (reload).

#Improvments
The app is not finished yet. But these features may appear later :

- Edition of the board by clicking with the mouse on each cell to toggle their state.
- Load a board from a file.
- Possibility to change the rules by deciding when a cell dies, lives, remains in their state.
