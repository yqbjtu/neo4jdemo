# neo4jdemo

MATCH (n:Person {id:62})<-[:TEAMMATE]-(person) RETURN person.name
MATCH (n:Person {})<-[:TEAMMATE]-(person) RETURN person.name