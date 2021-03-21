
-------xDesign Munro Project ---------------------------
This project is about accessing Munro's data from CSV file. There are some additional search and filter 
criteria that can be aplied to the returned data from CSV file.

Also, just to add some a few points:

- the project is written in Java language, ver. 1.8.
- I've not done any optimization in terms of cache or performance though in real 
prod-like system it would be just mandatory
- Also, I included the controllerAdvice which could be potentially used for some exceptional cases where we need to 
handle any sort of exceptions. I've not spotted such in my project as it would require a longer analysis etc
- I've added some tests, of course for a real project these tests should include the coverage of many more scenarios.
- I've not included any logs as it is just a small project


