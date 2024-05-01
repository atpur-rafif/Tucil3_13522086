RECUR_WILDCARD=$(wildcard $1$2) $(foreach d,$(wildcard $1*),$(call RECUR_WILDCARD,$d/,$2))
SOURCE_CODE=$(call RECUR_WILDCARD,src,*.java)

run:
	@javac -d bin $(SOURCE_CODE)
	@echo
	@echo
	@echo
	java -cp bin Main cli dictionary.txt ucs myth lore
	@echo
	java -cp bin Main cli dictionary.txt greedy myth lore
	@echo
	java -cp bin Main cli dictionary.txt astar myth lore
	@echo
	@echo
	@echo

clean:
	rm -rf bin
