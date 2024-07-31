# TDD in Depth

## Module 1: The Basics

### 1.2 What is Testing?
- What is testing? [src](./module-1-content/src/main/java/com/codurance/module1/preRequisites/whatIsTesting) [test](./module-1-content/src/main/java/com/codurance/module1/preRequisites/whatIsTesting)
- What is automated testing? [src](./module-1-content/src/main/java/com/codurance/module1/preRequisites/whatIsAutomatedTesting) [test](./module-1-content/src/test/java/com/codurance/module1/preRequisites/whatIsAutomatedTesting)

### 1.4 Main Types of Tests
- Unit tests [src](./module-1-content/src/main/java/com/codurance/module1/preRequisites/mainTypesOfTests/unitTests) [test](./module-1-content/src/test/java/com/codurance/module1/preRequisites/mainTypesOfTests/unitTests)
- Test Doubles: Dummy [src](./module-1-content/src/main/java/com/codurance/module1/TestDoubles/Dummy) [test](./module-1-content/src/test/java/com/codurance/module1/TestDoubles/Dummy)
- Test Doubles: Fake [src](./module-1-content/src/main/java/com/codurance/module1/TestDoubles/Fake) [test](./module-1-content/src/test/java/com/codurance/module1/TestDoubles/Fake)
- Test Doubles: Stub [src](./module-1-content/src/main/java/com/codurance/module1/TestDoubles/Stub) [test](./module-1-content/src/test/java/com/codurance/module1/TestDoubles/Stub)
- Test Doubles: Spy [src](./module-1-content/src/main/java/com/codurance/module1/TestDoubles/Spy) [test](./module-1-content/src/test/java/com/codurance/module1/TestDoubles/Spy)
- Test Doubles: Mock [src](./module-1-content/src/main/java/com/codurance/module1/TestDoubles/Mock) [test](./module-1-content/src/test/java/com/codurance/module1/TestDoubles/Mock)
- Test Doubles: Mockito [test](./module-1-content/src/test/java/com/codurance/module1/TestDoublesMockito)
- Test Doubles: Vitest [test](./typescript-examples/src/module1/testDoubles)
- Integration Tests: Repository Example [src](./module-1-content/src/main/java/com/codurance/module1/preRequisites/mainTypesOfTests/integrationTests/repositoryExample) [test](./module-1-content/src/test/java/com/codurance/module1/preRequisites/mainTypesOfTests/integrationTests/repositoryExample)
- Integration Tests: Library Example [src](./module-1-content/src/main/java/com/codurance/module1/preRequisites/mainTypesOfTests/integrationTests/libraryExample) [test](./module-1-content/src/test/java/com/codurance/module1/preRequisites/mainTypesOfTests/integrationTests/libraryExample)
- Integration Tests: Test Doubles Example [src](./untested-bank/src/main/java/com/codurance/infrastructure/persistence) [test](./untested-bank/src/test/java/com/codurance/infrastructure/persistence)
- E2E tests [test](./typescript-examples/cypress/e2e/example.cy.ts)

### 1.5 Testing Plan

- Testing Plan [src](./untested-bank/src/main/java/com/codurance) [test](./untested-bank/src/main/java/com/codurance)


### 1.6 Introduction to Testing Best Practices

- What To Test/What Not To Test [src](./module-1-content/src/main/java/com/codurance/module1/preRequisites/WhatToTest)
- Proper Test Naming/Structure [src](./module-1-content/src/main/java/com/codurance/module1/preRequisites/bestPractices/properNamingAndStructure) [test](./module-1-content/src/test/java/com/codurance/module1/preRequisites/bestPractices/properNamingAndStructure)
- Parameterized Tests [src](./module-1-content/src/main/java/com/codurance/module1/preRequisites/bestPractices/parameterizedTests) [test](./module-1-content/src/test/java/com/codurance/module1/preRequisites/bestPractices/parameterizedTests)
- Test Set Up and Tear Down [src](./module-1-content/src/main/java/com/codurance/module1/preRequisites/bestPractices/lifeCycle) [test](./module-1-content/src/test/java/com/codurance/module1/preRequisites/bestPractices/lifeCycle)
- Choosing the Right Matcher [src](./module-1-content/src/main/java/com/codurance/module1/preRequisites/bestPractices/improvingOurTestSuite) [test](./module-1-content/src/test/java/com/codurance/module1/preRequisites/bestPractices/improvingOurTestSuite/example)
- Introduction to AssertJ [src](./module-1-content/src/main/java/com/codurance/module1/preRequisites/bestPractices/improvingOurTestSuite) [test](./module-1-content/src/test/java/com/codurance/module1/preRequisites/bestPractices/improvingOurTestSuite/exercise/part2)
- Custom Matchers [src](./module-1-content/src/main/java/com/codurance/module1/preRequisites/bestPractices/improvingOurTestSuite/customMatchers) [test](./module-1-content/src/test/java/com/codurance/module1/preRequisites/bestPractices/improvingOurTestSuite/exercise/part3)

### 1.7 Other Concepts Related to Testing

- What is a Flaky Test? [src](./module-1-content/src/main/java/com/codurance/module1/preRequisites/flakyTest/example/flaky) [test](./module-1-content/src/test/java/com/codurance/module1/preRequisites/flakyTest/example/flaky)
- How to Prevent Flaky Tests [src](./module-1-content/src/main/java/com/codurance/module1/preRequisites/flakyTest/example/robust) [test](./module-1-content/src/test/java/com/codurance/module1/preRequisites/flakyTest/example/robust)
- Mutation Testing [src](./module-1-content/src/main/java/com/codurance/module1/preRequisites/otherTypesOfTest/mutation) [test](./module-1-content/src/test/java/com/codurance/module1/preRequisites/otherTypesOfTest/mutation)
- Property Based Testing [src](./module-1-content/src/main/java/com/codurance/module1/preRequisites/otherTypesOfTest/propertyBased) [test](./module-1-content/src/test/java/com/codurance/module1/preRequisites/otherTypesOfTest/propertyBased)

### 1.9 How To Do TDD

- Rule 1 [src](./module-1-content/src/main/java/com/codurance/module1/howWeDoTDD/threeRulesOfTDD/FizzBuzz.java) [test](./module-1-content/src/test/java/com/codurance/module1/howWeDoTDD/threeRulesOfTDD/FizzBuzzShould.java)
- Rule 2 [src](./module-1-content/src/main/java/com/codurance/module1/howWeDoTDD/threeRulesOfTDD/FizzBuzz.java) [test](./module-1-content/src/test/java/com/codurance/module1/howWeDoTDD/threeRulesOfTDD/FizzBuzzShould.java)
- Rule 3 [src](./module-1-content/src/main/java/com/codurance/module1/howWeDoTDD/threeRulesOfTDD/FizzBuzz.java) [test](./module-1-content/src/test/java/com/codurance/module1/howWeDoTDD/threeRulesOfTDD/FizzBuzzShould.java)
- The TDD Cycle [src](./module-1-content/src/main/java/com/codurance/module1/howWeDoTDD/threeRulesOfTDD/FizzBuzz.java) [test](./module-1-content/src/test/java/com/codurance/module1/howWeDoTDD/threeRulesOfTDD/FizzBuzzShould.java)
- Refactoring [src](./module-1-content/src/main/java/com/codurance/module1/howWeDoTDD/threeRulesOfTDD/FizzBuzz.java) [test](./module-1-content/src/test/java/com/codurance/module1/howWeDoTDD/threeRulesOfTDD/FizzBuzzShould.java)
- Our Solution: Leap Year [src](./leap-year-our-solution/src/main) [test](./leap-year-our-solution/src/test)
