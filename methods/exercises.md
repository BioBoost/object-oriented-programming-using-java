# Exercises

## Hello and Welcome

Create a method that outputs a hello and welcome message to the user. Call the method from your main method.

## Your full name

Create a method that takes 2 arguments:
* `String firstname`
* `String lastname`

Make it return your full name by concatenating both arguments into a single string.

## Prime Numbers

Create an application that prints all the prime numbers ([https://en.wikipedia.org/wiki/Prime_number](https://en.wikipedia.org/wiki/Prime_number)) between 2 and 100 (inclusive). 1 is not a prime number. Make use of a method that you create yourself that checks if a number is a prime number and returns a `boolean`.

There are several ways to check if a number is a prime number. Take a look at the wiki page and choose the simplest method, namely "Trial division".

Once tested and finished allow the user the input the maximum range to be tested. In the example above it is fixed to 100. Allow the user to for example input 1000 to get all the primes between 2 and 1000.

Also print how many prime numbers you found at the end.

Example output:
```text
This application will determine primes for you.
What is the upper bound you wish to test (inclusive)? 1000

Found these primes between 2 and 1000:
2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997

There are 168 primes in this range.
```
