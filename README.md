# slogo 

Group Members: Larissa Cox, Katrina Zhu, Alan Guo, Christopher Lu

Date started: October 11
Date finished: November 7
Hours spent: ~20 hours per person per week
			~160 hours total

Member roles:
Larissa: back end logic classes, worked primarily on slogo_logic and slogo_commands packages
Katrina: back end parsing and error checking, worked primarily on slogo_parsing package
Alan: front end display, worked primarily on slogo_turtle_ui package
Christopher: front end user input, worked primarily on slogo_general package

Resources: stackoverflow.com, java2s.com, docs/oracle.com

Files used to start project: Main.java

Files used to test the project: all files in data folder (can be fed into program using the Load File button

Resource files: all files in the resources and resoures.languages packages

Known bugs: a command cannot be defined twice because the second time, the parser will recognize it as an existing command. There are also no boundary checking conditions
for the turtle, so turtle can go out of the display. Open and save workspace button also do not work. Lastly, if the pen style is A, then selecting pen style A will cause the prrogram to crash. The user must select a style different from the current style to prevent crashing. One minor issue is that the HTL help page is incorrectly formatted.

Impressions: good project, great example of where reflection and interfaces can be used
Got more practice with using bindings, listeners and enumerations to provide functionality to front end features.


