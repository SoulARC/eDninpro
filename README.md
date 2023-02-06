## Abstract

This is a simple REST API for working with Excel files. The program reads data from the attached
file and places it in the database. Two types of files with the extensions .xlsx and .xls are
available for processing. If the user downloads the same file with changed content, the database
will only store the changed data and access the previous version of the file. If a user wants to
retrieve data from the server, they can do so by creating a .pdf file and uploading it.

## Function

| Endpoints        | Description                                                                                                                                                                                                        |
|:-----------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| POST:`/register` | Register user                                                                                                                                                                                                      |
| POST:`/login`    | Allows the user to login with jwt token                                                                                                                                                                            |
| POST:`/upload`   | Through this endpoint the data of which will be stored in the database                                                                                                                                             |
| GET:`/history`   | Get list of history books by name: `/history?name=fileName`                                                                                                                                                        |
| GET:`/search`    | Searches all data by value and displays the detailed placement of each record: `/search?text=something`                                                                                                            |
| GET:`/pdf`       | Creates a pdf file with the latest relevant data taken from the database of a specific file: `/pdf?name=fileName`                                                                                                  |
| GET:`/pdf/{id}`  | Allows you to get the same pdf file with the data of a specific file version in a table by its `id`. To get the id of the file in the table before executing this command, it is recommended to execute `/history` |
