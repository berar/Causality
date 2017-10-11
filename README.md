# Abstract
Java programming language is used fairly often nowadays. However, due to the fact that it is a compiled programming language, Java carries certain problems. The main one is the fact that if the code needs to be changed, the whole project has be re-compiled in the majority of cases, with artifacts being reinstalled. The problem as described, is solved by introducing a library named Causality, which makes it possible to isolate parts of the system to be redefined. This paper will present the library, its setting, features, classes, and finally give a simple example of the implementation of Causality library in practice.

# Introduction
In this paper a java library called Causality will be presented. This name is chosen because the effect of the library resembles that term; the predetermined predicate chooses a subclass of a superclass which corresponds to the effect or consequence. For example, if there is a superclass called Shape, it is split into classes like Triangle, Square, etc. then predicates can be defined from which it would follow the appropriate class selection.

Java programming language is a compiled programming language [1]. So if there is a need to make a change to the code, often the whole project must be re-compiled and artifacts must be installed again. Because of this case and problem, this library was created. In this way, it is possible to isolate parts of the system that can be redefined by altering the textual information consisting of JSON textuality [2] and defining predicates and selecting class implementations in a different way [3], thereby avoiding re-compiling the entire project.

# Classes of Causality system
In further subchapters of this chapter, classes of Causality system will be presented. Classes of this system are split into three modules: Predicate package, Matcher package and Causality package. All of these three submodules are part of the higher order module which represents entirety of Causality library which is packed as a Java archive file [5][6].

## Predicate classes
The basis of the predicate class packet is the Predicate interface, which consists of two methods: test and flattened. The test method is an important method that returns a Boolean value for a predicate. Flattened method is a method that returns the stream of predicates since some predicate implementations contain multiple predicates.

Condition is a typed class that implements the Predicate interface. It is slightly more complicated than other classes that implement this interface. One field of this class is Matcher - a matching class that will be explained in the next chapter. It is important to note that the Matcher type corresponds to a type that defines a typed object of the Condition class. The objects of this class are practically used to compare the values of the key variables with a parameter over the matching Matcher class.

## Matcher classes
Basically, the Matcher interface is a typed interface and the idea is that based on two input values that are of this type, it returns a Boolean type as the output value.

Matcher interface implementation is an abstract typed AbstractMatcher class that contains a private field from an associative array matchers whose key is a String object that points to a Matcher of type T. This associative array will be filled by classes that inherit the AbstractMatcher class. These are the NumericalMatcher classes and StringMatcher.

## Causality classes
Causation is a typified class that is the most important class in this library. Each Causation object consists of a superCause field that is of the Predicate type and this predicate corresponds to an over-condition that must always be fulfilled for the given problem. The next field is the causalities that is a list of Causality objects of type of T. The field otherwise is a field of type T and corresponds to the result or effect when no predicate from the predicate part within the causalities list is met.

It is important to note the valueMap field that is of type of associative array with the keys that are String objects and values that are Object objects themselves. Within this field, the values of the variables will be found. For instance, we can have a variable "a". It is the key within this associative array, and the value for that variable or that key will be in the value for that key in an associative set, depending on the current state of the program.

# Conclusion
Predicate classes are class implementations of Predicate interfaces and they represent the predicate abstraction. Matching classes are so-called "matcher" classes of a type T and they compare two values of type T in a way. The classes of causality are higher-class classes in the library that deal with the already mentioned classes and interfaces and serve for JSON parsing and selecting the right effects across predicates that compare arbitrary variables.

Further improvements to the Causality library could relate to branching support with a single causality class, so that the Causation object could actually consist of several Causation objects and thus divide the effects within a single Causation object meaning that no more Causation objects should be used as shown in the example from the previous chapter.

It is also important to note that this library is dependent on another open-source library, fasterxml-jackson version 2.7.0, which is used to parse JSON text formats. The reason is that this library comes with its JSON parser that is used to determine the Causation object in a text format. Further improvement would be the writing of custom AST parser for a plain formal-predicate mathematical inscription that would contribute to greater readability.

# References
1.	Gosling, J.; Joy, B.; Steele, G.; Bracha, G.. "The Java Language Specification, 2nd Edition", http://docs.oracle.com/javase/specs/#237601
2.	Introducing JSON, http://www.json.org/)
3.	https://github.com/FasterXML/jackson-docs
4.	Encyclopædia Britannica, Formal system definition, (2007).
5.	Sybase, PowerDesigner 16.1 Documentation, (2011).
5.	Grady Booch, Object-Oriented Analysis and Design with Applications, (2007)., Addison Wesley Longman Publishing Co., Inc. Redwood City, CA, USA, ISBN:020189551X

