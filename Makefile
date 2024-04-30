RECUR_WILDCARD=$(wildcard $1$2) $(foreach d,$(wildcard $1*),$(call RECUR_WILDCARD,$d/,$2))
SOURCE_CODE=$(call RECUR_WILDCARD,src,*.java)

run:
	javac -d bin $(SOURCE_CODE)
	java -cp bin Main

clean:
	rm -rf bin
