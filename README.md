An anagram is a type of word play where the result of rearranging the letters of a word produces a new word.  This new word uses all the letters of the original word exactly once.

For instance, the word "read" is an anagram of "dear". Write a function that takes a string as input, seperates the string by the ";" character, and then treat those as two separate strings s1 and s2. The function should then return the list of indices which represent the start of an anagram of s1 in s2.

 

Example:

Sample Input: "read;Dear Mr Interviewer, I dreaded the coding test"
Sample Output = 0 23 24

The code should return the list containing indices 0 (start of “dear” in s2), 23 ( start of “drea” in s2), and 24 (start of “read” in s2).

 

Note:

The strings will not contain the character ";" as we are using as a delimiter.
