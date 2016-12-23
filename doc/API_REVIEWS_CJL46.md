Christopher Lu
Austin
Katrina Zhu
My API is the user input API.

# Part I

**What about your API/design is intended to be flexible?**
My API is designed so that any form of user input, whether it is text box, expression button clicking, or variable button clicking, can be converted and passed into the controller in string format. The new values for the variable can also be fed into the backend in string form.

**How is your API/design encapsulating your implementation decisions?**
These getters are available for other users:
	String getText();
	String getLanguage(text);
	String convertExpression(button);
	String convertVar(button);
The API allows outside users to only access the string value of the user input, which is what we want. We don't want them to be able to change or break how convertExpression(button); or getLanguage(); work.

**What exceptions (error cases) might occur in your part and how will you handle them (or not, by throwing)?**

Error cases related to user input will not be caught/handled in the external frontend. They will be handled in the internal backend. 

**Why do you think your API/design is good (also define what your measure of good is)?**

Our API design is good because it fulfills its purpose of passing user input to the internal backend in a very flexible manner. Any form of user input, be it text box, expression button, or variable button, can have its string value accessed via getters and setters in the API.

# Part II
**Come up with at least five use cases for your part (it is absolutely fine if they are useful for both teams).**
*FORWARD pixels, user clicks enter.*
Call getText(); that returns string text that has the text value of user input into the text box.
Call getLanguage(text); that returns string indicating what language it is. Feeds information into the internal backend.

*User clicks on previous expression.*
Call convertExpression(button); that returns string text that has the text value of the expression button.
Call getLanguage(text); that returns string indicating what language it is. Feeds both strings into the internal backend.

*User does not enter any command into the text box, clicks enter.*
Call getText(); and getLanguage(text); which will feed in null values of text and language to internal backend. Null handling will happen in the internal backend (most likely the parser).

*User clicks on variable, types new variable value into text box, clicks enter.*
Call convertVar(button); and getLanguage(text); which will feed in strings of text name of the variable as well as the language to the internal backend. The user then types in new value of the variable in the user input text box, call getText(); to pass in new variable value to internal backend.

*This is a mistake.*
Call getText(); and getLanguage(text); which will feed in string values of text and language to internal backend. Error handling will happen in the internal backend (most likely the parser).

**How do you think at least one of the "advanced" Java features will help you implement your design?**
I think binding may help with implementing my design (actually, I'm not sure if the following is really part of external front end). Here is an example of where binding can be used. Let's say the user creates a predefined function called moveInCircle(some parameters); By binding the parameters together, such as radius, speed, and direction, by changing one or more of the bound values, the new circular movement of the turtle will be calculated automatically when moveInCircle(some parameters).

**What feature/design problem are you most excited to work on?**
Changing the variable value or executing past expressions upon the user clicking on the variable or expression.

**What feature/design problem are you most worried about working on?**
Changing the variable value or executing past expressions upon the user clicking on the variable or expression.

Internal Backend: Parse the information passed in from the front end. Calculation of turtle's next state.
External Backend: The next state of the turtle.
Internal Frontend: Turtle Display.
External Frontend: Pass user input into the backend (e.g. textboxes, clickable expressions, clickable variables.)

Advanced Java Topics:
Reflection, binding, enumerated types, generics.