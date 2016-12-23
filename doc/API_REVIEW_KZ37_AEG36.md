# Part 1
1. My API is the internal backend.  It should be flexible in the types of Strings it can take in; for example, it should be able to take in any length of string, or no string, and throw the appropriate errors.  In addition, it should be able to execute new commands fairly easily; therefore, if one were to add new commands to the external backend, the internal backend should be able to read in that String and recognize that those commands are valid.

2. We can make private methods which handle all the parsing through the string and creating the expression tree.  This way, nothing can be touched by the other API's.

3. Error cases that I primarily have to deal with is if I am given a string which does not exist as a command.  I would have to throw an error in this case.  Another error case would be if we were inputted an empty string; in this case, we would do nothing and not throw an error.

4. I think my API design is good because it is extensible and also it encapsulates the necessary information.

# Part 2
1.
a. A user enters "forward back 50"
b. A user enters a blank string
c. The turtle is facing an edge and the user enters "forward 50"
d. The user enters "forward" with no designated number of spaces
e. The user enters "towards x y" with x and y being off the screen.

2. I think reflection will definitely help us implement the design.  I'm not exactly sure how reflection works, but it would be helpful to access different classes without knowing exactly what those classes are from when you are making the command tree.

3. I am most excited to work on the reflection because I would love to learn something new about java.

4. I am most worried about error checking because there are a lot of possible errors, and it will be difficult to come up with a robust error checking method.