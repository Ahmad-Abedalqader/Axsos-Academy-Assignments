const express = require("express");
const app = express();

// This will fire our mongoose.connect statement to initialize our database connection
require("./server/config/mongoose.config");

app.use(express.json(), express.urlencoded({ extended: true }));

// This is where we import the users routes function from our user.routes.js file
const AllJokesRoutes = require("./server/routes/jokes.routes");
AllJokesRoutes(app);

app.listen(8000, () => console.log("The server is all fired up on port 8000"));