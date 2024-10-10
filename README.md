# Deca Compiler Project

## Project Overview

This project involves developing a compiler for a JAVA-like grammar using Java. The compiler is designed to parse source code, construct an Abstract Syntax Tree (AST), perform various checks for security warnings and errors, and finally translate the code into assembly language. The project is divided into three main steps, each focusing on a critical aspect of the compilation process.

## Key Steps and Implementation Details

### 1. Parsing and AST Construction

- **Parsing:**
  - Utilizes a lexer and parser to break down the source code into tokens and then parse these tokens according to the grammar rules.
  - Implemented using Java to tokenize and parse the source code.

- **AST Construction:**
  - Builds an AST that represents the hierarchical structure of the source code, which is essential for further compilation steps.
  - Defined various types of AST nodes to represent different constructs in the source code, such as expressions, statements, and declarations.

### 2. Compiler Checks

- **Security Warnings:**
  - The compiler checks for potential security issues in the code, such as unsafe operations or deprecated methods.
  - Implements checks for common security vulnerabilities and unsafe coding practices.

- **Pre-compiling Errors:**
  - Identifies errors that need to be addressed before the code can be compiled, such as syntax errors or type mismatches.
  - Utilizes a comprehensive set of rules to detect syntax and semantic errors before compilation.

- **Pre-flight Errors:**
  - Checks for errors that could cause the program to fail at runtime, ensuring that the code adheres to best practices and standards.
  - Ensures that the code is robust and adheres to best practices, reducing the likelihood of runtime errors.

### 3. Translation to Assembly Language

- **Code Generation:**
  - Converts the high-level constructs of the AST into low-level assembly instructions.
  - Translates the AST into assembly instructions, ensuring that the generated code is efficient and executable.

- **Optimization:**
  - Applies various optimization techniques to improve the efficiency of the generated assembly code.
  - Techniques include constant folding, dead code elimination, and loop unrolling to enhance the performance of the generated code.
