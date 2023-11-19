# Library API

A standalone java program to implement the [library_management](https://github.com/kirisaki-vk/library-management) API.

## Get Started
 You will need to initialize environment variables for the program to be able to connect to the database.
 
- `PG_USERNAME`: Defines the username to use for the connection.
- `PG_PASSWORD`: Defines the password to use
- `PG_DATABASE_URL`: Defines the url of the database

> NOTE: `PG_DATABASE_URL` is in the format `<host>/<database_name>`

## Database init scripts
Init SQL scripts for the database can be found in [this](dbinit/) directory