# Assigment

## Introduction

Welcome to the unique *Fox bookstore*, where you can **buy** and **borrow** books. They are looking for an engineer (you)
to fix and add new features that are critical for their business while improving overall the software.

## Instructions - Getting started
Currently, the application contains 3 endpoints:
- `GET /hi` - where you get a plain text response welcoming you.
- `GET /users` - where you get a list of users of the bookstore with their permissions.
- `POST /users` - where admin users can create new users

###### Using online IDE - Che Openshift
In order to validate that current `bookstore` version of the project is working in your environment, try the following steps:
1. Open a terminal within Che IDE: in the top menu -> "Terminal" -> "Open Terminal in specific container" -> select `maven`
1. Clean, compile, and verify `bookstore` maven project with: `mvn clean verify`
1. If everything is fine, you are set to start working in the assignment!
   Otherwise, try first to solve any configuration issue. If you get stuck, request help to the interviewer

## Backlog of tasks to complete:
In this assignment you will need to complete the following tasks:
1. Create a new Search books endpoint that accepts an **optional** query param to filter (search) among all books.
   You are in charge of the design and implementation.
   Make use and extend as required the BookService and BookRepository. 
   
    1.1 (Optional) As part of the response, hide the user_id and convert it into a new boolean attribute that represents
        if a book is available or not (when no user_id, the book is available).

1. Fix a bug that was reported by a user:
   ```
   User: Dennis
   When I try to add a new user "Darió", I am getting back a success but the user is never created. 
   Darió is a new intern in Fox bookstore and he will need be added with the read and write permissions. 
   Dennis is Admin
   ```
   A user in the bookstore can have the permissions read, write, and admin. In the test db, Dennis is already admin.
   
1. Optional: Improve quality of the project overall

There are few restrictions that you have to take into account while building these features (see section **Constrains**).

### Constrains
To scope this assignment and make it more fun, there are few general restrictions to follow:
1. You should reuse as much as possible (code, dependencies, ...) - Don't completely change the stack
1. You should refactor/improve/add any code when it helps you out - You want to leave things better than how you inherit them 
1. Do think about security, maintainability, performance among other topics - Better safe than sorry!

### Important!
Few things to have in mind while doing the exercise:
- Please abstain yourself of sharing or publishing this assignment. 
- You need to do this assignment with integrity (alone and without plagiarism), otherwise you will be immediately disqualified.
- We will review your solution as if it is a real project. Make sure to write clean code, add good testing, 
  don't use old-fashioned methods (i.e. using java 7 instead of 8+), etc. when extending/improving the application.
  - In case you are using the online IDE - Che, we will also review the use of git (e.g. your branching strategy).
- The assignment gives you quite some freedom to do things as you want, however it should take you around **4h**. If you want to invest **2h** extra, it is your choice. 
  Make sure to keep track of the things that you left out of your solution, as well as important design choices taken (we may ask about them in the interview). 
  Based on experience, two important tips while doing the assignment:
  - It is better to have *less* functionality **well-polished** than *all* the functionality **half-baked**. We care about details that show your style and experience.
  - There may be one or two bugs in this code left unintentionally by previous developers, feel free to fix them ;)

Good Luck!
 