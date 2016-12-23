Christopher Lu
# Estimation: before looking at the old code:
## How long do you think it will take you to complete this new feature?
1 hour.

## How many files will you need to add or update? Why?
Add: 
ImageGallery --> This will be the view that shows the images the user can choose from.
TurtImage or some other Image class that will be used in substitute for TerrainImage in ImageGallery.
Update: 
TurtleSprite --> Need to add a handler that calls ImageGallery when turtle is clicked.

# Review: after completing the feature:
## How long did it take you to complete this new feature?
40 minutes.

## How many files did you need to add or update? Why?
Same as estimate except that I forgot to update the resource file for the label of the confirm image button.

## Did you get it completely right on the first try?
No, my handler was not working and did not realize there was already a click handler in place, so I just put it in the existing click handler
and made a condition for SECONDARY Mouse button.

# Analysis: what do you feel this exercise reveals about your project's design and documentation?
## Was it as good (or bad) as you remembered?
I guess. I never really worked on the class that I modified, which kind of shows how easy and readable the class was.

## What could be improved?
As of right now, the front end turtle object is an ImageView. It could be improved by creating a custom TurtleFrontEnd object that contains many
of the properties in TurtleSprite, like ImageView, Image, etc.

## What would it have been like if you were not familiar with the code at all?
I wasn't, but because of its readability and my experience with handlers, it was quite an easy experience.