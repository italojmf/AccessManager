# AccessManager
A simple "access manager" where it's possible to manage URL's on a black/white list using functions like: 
* verify [url]
* add-blacklist [url]
* add-whitelist [url]
* show-blacklist 
* show-whitelist
* remove-blacklsit [url]
* remove-whitelist [url]

# Running the Application
To run the application go to cmd/shell, then access: `AccessManager/src/dev/challenge/` and run:

`javac -cp ../../ AccessManager.java`

to compile, then run:

`java -cp ../../ dev/challenge/AccessManager [command] [args]`

to test the commands.
