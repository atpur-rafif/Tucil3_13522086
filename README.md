# Description

This program is a solver for game named "Word Ladder", where the player need to change only one character (and make sure the new word exist in dictionary) to get from start word to the end word on each step. Algorithm used in this program is UCS, Greedy Best First Search, and A*. UCS algoritm always use the lowest weight node to expand, while greedy can't backtrack the search. A* exist as combination from this two algorithm to be more efficient and optimal.

# Requirement
Tested on openjdk 22

# How to Compile

Windows User (Really?):  
```
javac -d bin  src/Main.java src/Algorithm/Algorithm.java src/Algorithm/Astar.java src/Algorithm/Greedy.java src/Algorithm/Heuristic.java src/Algorithm/UCS.java src/CLI/CLI.java   src/Construct/CostSearcher.java src/Construct/CostSearch.java src/Construct/Dictionary.java src/Construct/Finder.java src/Construct/Node.java src/Construct/Visitor.java
```

Linux with Make:  
```
make compile
```

# How to Run

Windows & Linux :  
Program already compiled, running from base directory and dictionary.txt exist as line separated word in the same directory  
```
java -cp bin Main dictionary.txt astar jail free
```
Argument: `<executable name> <dictionary path> <algorithm (ucs/greedy/astar)> <start> <end>`

For help running the program, run without argument  
```
java -cp bin Main
```

Note: File named "dictionary.txt" in this repository extracted from [this website](https://wordwormdormdork.com/)

# Contributor
Muhammad Atpur Rafif (13522086)
