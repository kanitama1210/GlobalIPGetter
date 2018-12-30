SRC_PATH=./src/jp
CLASSPATH=./bin

build: $(SRC_PATH)/GlobalIPGetter.java $(SRC_PATH)/DialogGenerator.java
	javac -d $(CLASSPATH) $(SRC_PATH)/*.java

run:
	java -cp $(CLASSPATH) jp/GlobalIPGetter

all:
	make build
	make run
