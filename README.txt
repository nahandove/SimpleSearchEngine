Project assignment from JetBrains Academy (www.hyperskill.org), Java Developer track.

This program allows the user to search for specific people and their information (in
this particulat example, first name, last name, and email address) using 3 different
search strategies. The program can be easily adapted to other types of information,
e.g. books with title, author, ISBN number, with minimal changes of code.

The database is supplied via the command line as a file name with the argument "--data"
followed by the file name. Each line of the file represents one person with relevant
information: first name, last name, and email address, seperated by space. The program
parses the file and indexes the lines, and creates an inverted index database that 
references the indices of specific search terms.

The main menu allows the user to perform specific searches or look up all entries. The
user can perform the search and print all operations continuously until they enter 0 in
response to the main menu, where the program prints "Bye!" and ends.

Three search strategies are used: ANY, ALL, and NONE. These strategies are displayed 
after the user selects 1 (Find a person) from the main menu. ANY returns all entries
that contain any of the search terms the user entered (case insensitive and in any
order). ALL returns all entries that contain all search terms (case insensitive and
in any order). NONE is an exclusionary strategy: it returns all entries that do not
contain any of the search terms entered by the user. The main menu option 2 (Print 
all people) returns all entries in the database. 

If none of the entries match the search criteria, the program prints "no matching 
people found" and continues. Otherwise, the program tallies the number of entries
fitting the search criteria and display it as "% persons found:" prior to listing
entries.

2. September, 2023--description by E. Hsu (nahandove@gmail.com)