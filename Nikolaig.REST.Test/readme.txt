
Project done in Spring Tool Suite 4

Primary idea of this webservice is to have possiblity:
1. to create new tasks with request POST

2. get all tasks by request GET
3. modify existing task with request PUT by received id

4. create new user with request POST, choosing existing tasks received by GET
5. modify existing user by request PUT and adding or removing tasks by ID from task list received by GET

6. delete user by request DELETE

7. delete task by request DELETE, 
Here we have problem with foreign key in user collection:

It is not implemented in this project, because it can be done in different ways.
One possible solution could be like that: when we want to delete task, we mark it obsolete and disable for choosing in front end.
This is to avoid visual conflict at the moment when user choose deleted task, submit POST request, but after looking at the list of choose tasks he don't see it.

And at the end of the day we can run job on database and assert users and task valid keys.

---------------------------------------------------------
Conclusion: for this kind of web service we don't need find by name or find by criteria REST api


Project installation steps:

==============================================================
==============================================================
==============================================================

1. MongoDB:

a. Create database nikolaig_test
b. Create collections user and task

c. Fill collection task with data:

{"name": "Check casting website"}
{"name": "Go to gym"}
{"name": "Learn new scene"}
{"name": "Check show business"}
{"name": "Watch TV shows"}
{"name": "Study old movies"}
{"name": "Get acting class"}

d. Fill collection user with data, REMEMBER to change $id to valid task id:

db.user.insertOne(
{
    "tasks": [{
       "$ref": "task",
       "$id": ObjectId("5c3235cc05cf3d1158d87428"),
       "$db": "nikolaig_test"
    },{
       "$ref": "task",
       "$id": ObjectId("5c3235cc05cf3d1158d87429"),
       "$db": "nikolaig_test"
    }],
    "name": "Tom",
    "lastName": "Hanks",
}
)

db.user.insertOne(
{
    "tasks": [{
       "$ref": "task",
       "$id": ObjectId("5c3235cc05cf3d1158d8742a"),
       "$db": "nikolaig_test"
    },{
       "$ref": "task",
       "$id": ObjectId("5c3235cc05cf3d1158d8742b"),
       "$db": "nikolaig_test"
    }],
    "name": "Brad",
    "lastName": "Pitt",
}
)


==============================================================
==============================================================
==============================================================



2. Open web application project in Spring Tool Suite 4 and run

==============================================================


Test cases for REST api:

**************************************************************
GET all from user:
http://localhost:8080/user/


**************************************************************
GET user by ID:
http://localhost:8080/user/5c326f7cbd1e3026ccceebd1 <-- set valid ID


**************************************************************
GET all from task: (no need GET task by ID)
http://localhost:8080/user/task/


**************************************************************
add new user
POST http://localhost:8080/user/

request json BODY:
    {
        "name": "Tom",
        "lastName": "Hanks",
        "tasks": [
            {
                "_id": "5c3235cc05cf3d1158d87428" <-- set valid ID
            },
            {
                "_id": "5c3235cc05cf3d1158d87429" <-- set valid ID
            }
        ]
    }


**************************************************************
modify existing user
PUT http://localhost:8080/user/5c326f7cbd1e3026ccceebd1 <-- set valid ID

request json BODY:
    {
        "name": "Tom",
        "lastName": "Hanks 111", <-- EXAMPLE: modify surname
        "tasks": [
            {
                "_id": "5c3235cc05cf3d1158d87428"
            },
            {
                "_id": "5c3235cc05cf3d1158d87429"
            }
        ]
    }
    
    
**************************************************************    
add new task
POST http://localhost:8080/user/task/

request json BODY:    
    {"name": "Get NEW TASK 11"}
    
    
**************************************************************
modify task
PUT http://localhost:8080/user/task/5c326d21bd1e300ab4bd5f3e <-- set valid ID

request json BODY: 
	{"name": "Get NEW TASK 11 00"} <-- EXAMPLE: add 00


**************************************************************
delete user
DELETE http://localhost:8080/user/5c326f7cbd1e3026ccceebd1 <-- set valid ID
	
	
**************************************************************
delete task
DELETE http://localhost:8080/user/task/5c326d21bd1e300ab4bd5f3e <-- set valid ID












