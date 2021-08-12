# JackFruit Assignment

The application is based on concept of online food delivery system. The application contains both front end and back end. The front end is made on react and
the server side of the application is build using java on Spring boot. .
- vedio link of assignment-  https://www.loom.com/share/3dc6ecd69c194df39ad75332a5fba2a4
             
- frontend code  github link - https://github.com/Shivam4819/JackFruitFrontEnd

## Architecture of Backend

The project architecture has three layers,that are controller, service and dao layer

- Controller- Controller basically act as gateway , it accept request from frontend and send that request to specific service on Service layer.

- Service- Service layer has all the bussiness logic and if there is any work associated with database it pass the data to Dao layer.

- Dao- This layer perform all the operations that are associated with database.

## API

- This application has 7 api

- restaurantlist- This api fetches the details of restaurant from the database and display that data on front end

- fetchMenu- This api return the menu list of particular restaurant. 

- addMenu- This api adds the specific item in cart. 

- cartItem- Ths api return all the data stored in cart table. 

- deletItem- This api deletes the specific item from cart. 

- placeOrder- This api stores all the data when order is finally placed.

- finalOrder- This api return the final order from order tabel.
