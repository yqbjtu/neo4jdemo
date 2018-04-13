# neo4jdemo

MATCH (n:Person {id:62})<-[:TEAMMATE]-(person) RETURN person.name
MATCH (n:Person {})<-[:TEAMMATE]-(person) RETURN person.name

http://127.0.0.1:8080/device/init
http://127.0.0.1:8080/category/init

Match (m:CategoryModel{name:'波音737'})-[r]-(d:Device) return count(*)
Match (m:CategoryModel{name:'波音737'})-[r]-(c:Category) return c
Match (c:Category{name:'Plane'})-[r]-(m:CategoryModel) return m
Match (c:Category{name:'Plane'})-[r]-(m:CategoryModel) return m.name