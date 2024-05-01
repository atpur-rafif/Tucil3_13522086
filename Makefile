RECUR_WILDCARD=$(wildcard $1$2) $(foreach d,$(wildcard $1*),$(call RECUR_WILDCARD,$d/,$2))
SOURCE_CODE=$(call RECUR_WILDCARD,src,*.java)

# METHOD=cli
DICTIONARY=dictionary.txt
FROM=jail
TO=free

run:
	@javac -d bin $(SOURCE_CODE)
	@echo
	@echo
	@echo
	java -cp bin Main $(METHOD) $(DICTIONARY) ucs $(FROM) $(TO)
	@echo
	java -cp bin Main $(METHOD) $(DICTIONARY) greedy $(FROM) $(TO)
	@echo
	java -cp bin Main $(METHOD) $(DICTIONARY) astar $(FROM) $(TO)
	@echo
	@echo
	@echo

clean:
	rm -rf bin
