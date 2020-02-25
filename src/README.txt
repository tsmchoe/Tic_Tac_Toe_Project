Timothy Choe
U67371475
2/23/2020

Compile:
In order to run the program, simply run the Play_Game.java file. However to do so, please javac all the java files in the tic_tac_class folder before. Then make sure to get out of the folder (one step out) and call tic_tac_class.Play_Game in order to run the program.

Class Descriptions:
Board_Cell - a class representing a physical cell of the board

Token - a class that gives the visual representation of the token players use in game and keeps track of who uses which token.

Player - a class that keeps the players information - it will be useful as it also allows players to keep track of which team they are on

Board - a class used to change the scale of the playing field - uses board cell to display what is inside the board and uses token to access where the token is placed on the board

Tic_Tac_Toe_Rules - a class that contains the TTT winning conditions - useful as it makes it more readable and easier to change who wins the game

Tic_Tac_Toe - the actual TTT game logic played out - Uses Tic_Tac_Toe rules to check to see who has won, uses player to switch between users and stores information, uses Token and board to display the physical representation of the game.

Order_and_Chaos - the Order and Chaos game logic played out. Pretty much the same as tic_tac_toe, excetp it allows the user to put in either token instead of being fixed to one. Also board is fixed to 6x6 as that is the strict ruling for it.

Play_Game - main file where everything is run - this is useful as mulitiple games could be run on this class and could potentially lead to a platform where players can access which games they want to play.


How To Play:
The file Play_Game is used to run either TTT or OC. To choose, simply run Play_game and follow the instructions - it will take you to the correct game. 

Please do not use commas!!! Only put spaces between where the console asks for several conditions! (ex. enter(name, team, power) -> Jason 4 Lighting)

For TTT, Users will be prompted to enter their names and what team they belong on (arbitrary for now, but will be useful when playing a team game). Then they can choose which token they would like to play with (only characters are allowed as anything not a character will cause an error).They can then choose whatever scale they want to put their board as. It can be as big as nxn or even nxm and mxn depending on the mood of the player, but there should only be a space and no comma between the dimensions (ex. 4 5 = 4x5 board size). They can then give the win condition as to how many consecutive tokens they need to win the game (a single integer).

In order to play TTT, one simply has to type the coordinates from x(0-(n-1)) y(0-(n-1)) as to where they want to place their piece on the board. There should only be a space and no comma between the coordinates (Ex. 1 2)


For OC - the rules follow the same as TTT, except please when entering your token follow the format (X ,Y, token) all with space in between all three parts!!!
