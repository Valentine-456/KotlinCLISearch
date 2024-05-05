# Kotlin Text Search CLI Tool

## Test task
Implement a simple CLI tool in Kotlin that indexes a folder containing text files and then responds to user queries for string occurrences within the files. Focus on implementing basic functionality, ensuring correctness, and handling user errors gracefully. You are allowed to use any libraries.

-----------------

## Features
- **Indexing**: Recursively indexes all text files in the specified directory, skipping non-text files and directories named ".KotlinCLISearch" (where indexes are stored).
- **Search**: Allows users to query the indexed data for specific string occurrences, returning the relevant file paths and contexts where the strings appear (Phrase search - I chose this type of search, because it best suits the search in project files as it is in IDEs).
- **Error Handling**: Implements graceful error management to guide users through common input mistakes.

## Used Libraries
- **Kotlin Standard Library**: For core language functionality.
- **[Apache Lucene](https://github.com/apache/lucene)**: For indexing and searching text data.
- **[Kotlinx-cli](https://github.com/Kotlin/kotlinx-cli)**: To handle command-line argument parsing.

## Inspiration
When implementing this CLI tool, I thought a lot how similar things are implemented in git cli tool:
- where to store inverted index (similar to .git folder), 
- how to handle inconsistencies between index and actual folder, 
- how to handle deletion/updates of a  file inside the indexed folder, 
- etc...

-----------------

## Usage
To use CLI tool download .JAR file from here.
```bash
git clone https://github.com/Valentine-456/KotlinCLISearch
cd KotlinTextSearchCLI
./gradlew build
./gradlew assemble

# later usage:
java -jar build/libs/KotlinCLISearch-1.0-SNAPSHOT.jar index 
java -jar build/libs/KotlinCLISearch-1.0-SNAPSHOT.jar search -q "your query here"
```



To index a folder run:
```bash
java -jar path/to/KotlinCLISearch-1.0-SNAPSHOT.jar index -p relativePath/to/your/folder
```

To search a query in a folder run:
```bash
java -jar path/to/KotlinCLISearch-1.0-SNAPSHOT.jar search -q "your query here" -p relativePath/to/your/folder
```

In both cases the --path or -p parameter is optional and by default is current working directory.

### Notice
If you run index a folder and then change its contents (add, delete or update some file), you may get wrong results of a search.
You will need to reindex the folder by using index subcommand again.
```bash
java -jar build/libs/KotlinCLISearch-1.0-SNAPSHOT.jar index -p relativePath/to/your/folder
```

### Further improvement ideas:

- add more types of search (wildcard, prefix, boolean, etc)
- packaging into an executable and distribution
- create .KotlinCLISearchIgnore (similar to .gitignore) to choose what files to exclude form indexing
- logging and debugging
- interactive search Mode
- add tests
- etc...

-------------------