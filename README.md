# Food Delivery System

The application is based on concept of online food delivery system. The application contains both front end and back end. The front end is made on react and
the server side of the application is build using Spring boot. Mysql is used as the Database

- frontend code  github link - https://github.com/Shivam4819/FoodDeliveryFrontEnd
## Architecture of Backend

The project architecture has three layers,that are controller, service and dao layer

- Controller- Controller basically act as gateway , it accept request from frontend and send that request to specific service on Service layer.

- Service- Service layer has all the bussiness logic and if there is any work associated with database it pass the data to Dao layer.

- DAO- This layer perform all the operations that are associated with database.

## API

- This application has 4 api

- restaurantlist- This api fetches the details of restaurant from the database and display that data on front end

- fetchMenu- This api return the menu list of particular restaurant. 

- placeOrder- This api stores all the data when order is finally placed.

- finalOrder- This api return the final order from order tabel.

## Database
 - MySql database is used to store the data.
 
 - Restaurant table- used to store list of restaurant. Columns- [id, name, address, contact]
 
 - Menu table- used to store the menu item of each restaurant. Columns-[id,restaurant_id, item_name, price]
 
 - Order table- used to store the final order. Columns- [id,item_name, price]
