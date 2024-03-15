# Catch'em all

1. Handle a call to a risky method in the main method in [CatchEmAll](src/main/java/com/rpam/rd/autotasks/CatchEmAll.java) that can throw different types of exceptions.

2. Please note that some types of exceptions should be handled, while other - wrapped and rethrown, while others - shouldn't.

Details:

| What is thrown | How to handle |
| --- | --- |
| IOException | Wrap in an IllegalArgumentException with a message "Resource error" and throw it |
| FileNotFoundException | Wrap in an IllegalArgumentException with a message "Resource is missing" and throw it | 
| ArithmeticException or NumberFormatException | Print a message of the thrown exception to System.err and do not throw anything |
| Any other Exceptions | Should not be caught |
