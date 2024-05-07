# Natural Language Generator
A model that analyzes a given body of text and produces unique phrases and sentences based off of statistical word-arrangement.

## Table of Contents
* [General Info](#general-information)
* [Setup](#setup)
* [Project Status](#project-status)
* [Acknowledgements](#acknowledgements)
* [Contact](#contact)


## General Information
This project was developed by Elijah Potter and William Ngo in order to produce a simple model that attempts to replicate natural language.
Advanced AI like that of ChatGPT uses massive amounts of data, processing, and complexity to generate its own text, and our model replicates
that funcitonality at a much smaller scale. Though most of the phrases our model generates is complete gibberish, its still an interesting
demonstration.


## Setup
To setup the project, one needs only to provide a couple of arguments to the TextGenerator class. The first argument
is the filepath to the text file that will be processed, the second argument is the "seed" or starting word of the
phrase, the third argument is the number of words to be returned, and the final argument is either "all", "one", or
is left empty.

If "all" is passed as a fourth argument then the resultant phrase will be based on randomness and probability. If 
"one" is passed then only the most probable words will be printed in the phrase. If it's empty, then a list of all
possible words following the "seed" will be returned.


## Project Status
Project is: _complete_


## Acknowledgements
- Many thanks to Professor Heisler at the University of Utah for instructing us for this project.


## Contact
Created by [Elijah Potter](https://www.linkedin.com/in/elijah-a-potter/) and William Ngo
