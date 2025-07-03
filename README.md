Employee Management System

This project is a Spring Boot-based RESTful web service that manages Employees and Departments. It supports basic CRUD operations, advanced querying, pagination, and reporting structures.

Features

- Create, update, delete, and retrieve Employees and Departments
- Expand departments to show employees (`expand=employee`)
- Employee lookup (`lookup=true`) to list Employee ID and Name
- Reporting Manager structure
- Department head linkage
- Paginated responses (20 items/page)

 Project Structure

employee-management-system/
├── src/
│ ├── main/java/... # Source code
│ └── main/resources/
│ └── application.properties 
├── database/
│ └── ems_employee.sql, ems_department.sql
├── json/
│ └── request-response-schema.json 
├── examples/
│ └── sample-api-responses.json # Sample outputs
├── README.md

End Points 

Employee : 

POST | /employee/create        | Create Employee
PUT  | /employee/update?id=1  | Update Employee Details
PUT  | /employee/updateDepartment?id=1&departmentId=1 | Update Employees Department
GET  | /employee/getAllEmployees   | Fetch All Employees
GET  | /employee/getAllEmployeeIds?lookup=true | Fetch All Employees And Ids 

Department :

POST   | /department/create | Create Department
DELETE | /department/delete?id=1 | Delete Department
PUT    | /department/update?id=1 | Update Department
GET    | /department/getAllDepartments | Fetch All Departments
GET    | /department/getDepartment?id=3&expand=true | Fetch Department And Their Employee



