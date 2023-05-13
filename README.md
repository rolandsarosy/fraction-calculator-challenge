
# Fraction Calculator Challenge
This repository contains my solution to a programming challenge requested during an application process to a specific company.

## Challenge Description
The goal was to create a calculator which does operations on proper and improper fractions and whole numbers. It was crucial to write code that handles everything that can be thrown at it, gracefully.
(Details of the specification will not be mentioned to preserve the authenticity of the challenge.)

## Solution
The solution adheres to all specification points. I don't have much exprience with console programs, but I did my best to make the package, file and method structrues readable.
The code adheres to the Kotlin functional programming guidelines. The solution also has 80+ tests in it, ranging from arithmetic operations, through validity checks to raw input tests.

## Getting started
This code is built upon the JVM using Kotlin, built by the Gradle build system, with Kotlin DSL. It's recommended to use IntelliJ IDEA 2023 to index and build the project.
Most JDK version above 11 should work, but this code was specificatlly tested with OpenJDK 20.0.1 and Amazon Coretto 15.

How to run the program:
- Download IntelliJ IDEA 2023.1.1 Ultimate
- Open the project with IntelliJ IDEA. 
- Let the project index and build for the first time.
- Select a compatible JDK. 
- Launch the `main()` function found in `root\src\main\kotlin\app`. 

How to run the tests (Using IntelliJ IDEA 2023):
- After successfully building the project, select `Project` in the top of the hierarchy window.
- Under `src`, find the `test` folder. 
- To launch any single test, or launch all tests in a folder, simply right click the test or the folder and select "Run test(s)..."

## Dependencies
**Language**: Kotlin

**Language version**: 1.8.20

**Format**: Console program

**Build scripts**: Kotlin DSL

Dependencies are as follows: 
|Name            |Usage													|Mandatory?											|
|----------------|-------------------------------|-----------------------------|
|`Kotlin 1.8.20`|Language and its base libraries|Yes|
|`Junit5`|Unit testing utility.|Yes|

## Credits
This work is my of my own creation. Some of the tools used were: IntelliJ IDEA Ultimate 2023, Hackmath.net fraction calculator, regex101.com, ChatGPT.
