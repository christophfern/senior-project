This project was a side by side with my college senior thesis. My thesis was all about possible designs for a genetic algorithm 
in order to optimize different problems in order to come up with a satifcatory solution. Upon hearing this I was 
approached by a professor who thought my research could be applied to problem at the college. So I accepted and created this project.

I couldn't bare to put this project on GitHub in the original condition. I have done some organization of files and added a few comments but no actual code changes from the original so that I can look back and remember how badly written this bad boy was

Issues looking back on the project. I'm writing this 4 years later
* It was written in Java
  * Java 1.8 when Java 16 was out (I think specifically because I used javafx.util.Pair then didn't know how to upgrade)
  * Even though I believe Java is the superior language. Python or javascript would have been a much better tool. 
  I even wrote it with so many static functions/classes that it clearly didn't need classes to encapsulate everything
* There are absolutely no tests. None. Zero.
* There is absolutely no documentation. None. Zero
* The objects are so tightly coupled to the parsing of the excel file that when I considered moving to a web app for fun. 
I gave up immediately
* There's no any retry/failure protections. You better have an excel formatted in the exact structure that that one 
professor was using, for that one specific job or all hell will break loose and the app will cry in bad JModals
*  I'm proud of the Algorithm Design inside the GeneticAlgorithm class, but I'm not proud of how ugly it's implemented and
how tightly coupled it is to my horrible objects
* This could've easily been a web app
* I'm sure there are more issues but almost all of them stem from, I never wrote java code before this project

All in all there's so many things wrong with this project, but it did what I needed it to do and just like in real business the user never read the code, so they were happy. 
They just reaped the benefits. I'm proud of the Algorithm Design, and I'm proud of my thesis, and I'm happy this whole thing worked through the spaghetti and to my knowledge the professor is still using the silly little desktop app

