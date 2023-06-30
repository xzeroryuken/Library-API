Book Management System
=====================

This repository contains a Book Management System that allows administrators to manage books and authors. The system provides the following functionalities:

-----------------
1. Create a Book
   
An administrator can create a book by sending a POST request to the server with the following parameters:
   - ISBN: The unique identifier of the book.
   - Name: The name of the book.
   - Description: A brief description of the book.
   - Price: The price of the book.
   - Author: The author of the book.
   - Genre: The genre/category of the book.
   - Publisher: The publisher of the book.
   - Year Published: The year in which the book was published.
   - Copies Sold: The number of copies sold.

The book information will be added to the system upon successful request.
---------------------------
2. Retrieve a Book's Details

An administrator can retrieve a book's details by sending a GET request to the server with the Book's ISBN as a parameter. The server will respond with the book's information in JSON format.
-------------------
3. Create an Author
   
An administrator can create an author by sending a POST request to the server with the following parameters:
   - First Name: The first name of the author.
   - Last Name: The last name of the author.
   - Biography: A short biography of the author.
   - Publisher: The publisher associated with the author.

The author's information will be added to the system upon successful request.
------------------------------------
4. Retrieve a List of Books by Author
   
An administrator can retrieve a list of books associated with a specific author by sending a GET request to the server with the Author's ID as a parameter. The server will respond with a JSON list of book objects that are associated with the author.
-----
Usage

To use this Book Management System, you can send HTTP requests to the appropriate endpoints as described above. Make sure to include the necessary parameters in the requests.
------------
Contributing

This project is open for contributions. If you find any issues or have suggestions for improvements, please feel free to open an issue or submit a pull request.
-------
License

This project is licensed under the MIT License. You can find more details in the [LICENSE](link-to-license-file) file.

