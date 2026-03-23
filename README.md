Tow Truck Assistance API 🛠️🚗

A backend API for a Tow Truck Assistance App. Motorists can submit service requests, and the API manages request status. This project is designed as an API-first backend, ready for integration with a frontend or mobile app.

Table of Contents
Features
Tech Stack
Installation
API Endpoints
Testing with Postman
Contributing
License
Features
Create, read, update, and delete tow requests
Track request status: PENDING, IN_PROGRESS, COMPLETED
Simple, easy-to-integrate RESTful API
Tech Stack
Backend: Node.js & Express.js
Database: JSON file (can be replaced with MongoDB or Firebase)
Version Control: Git & GitHub
Installation
Clone the repository
git clone https://github.com/yourusername/towtruck.git
cd towtruck
Install dependencies
npm install
Start the server
npm start
The API will run at http://localhost:3000
API Endpoints
1. Create a Tow Request
POST /requests
Content-Type: application/json

{
  "customerName": "Alice ",
  "location": "Cape Town",
  "status": "PENDING"
}

Sample Response

{
  "id": "1",
  "customerName": "Alice ",
  "location": "Cape Town",
  "status": "PENDING"
}
2. Get All Requests
GET /requests

Sample Response

[
  {
    "id": "1",
    "customerName": "Alice ",
    "location": "Cape Town",
    "status": "PENDING"
  }
]
3. Update Request Status
PUT /requests/:id
Content-Type: application/json

{
  "status": "IN_PROGRESS"
}

Sample Response

{
  "id": "1",
  "customerName": "Alice ",
  "location": "Cape Town",
  "status": "IN_PROGRESS"
}
4. Delete a Request
DELETE /requests/:id

Sample Response

{
  "message": "Request deleted successfully"
}
Testing with Postman
Open Postman or any API client
Create a new request with http://localhost:3000/requests
Choose the appropriate method (GET, POST, PUT, DELETE)
For POST and PUT, use Body → raw → JSON to send data
Check the response to ensure your API is working

Tip: Save requests in a Postman collection for quick testing and future frontend integration

Contributing

Contributions are welcome!

Fork the repository
Create a new branch (git checkout -b feature/YourFeature)
Commit your changes (git commit -m 'Add feature')
Push to the branch (git push origin feature/YourFeature)
Open a Pull Request
License

This project is licensed under the MIT License.
