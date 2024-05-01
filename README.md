
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

For help running the program, run without argument  
```
java -cp bin Main
```
