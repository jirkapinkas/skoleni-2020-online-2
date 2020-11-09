1. Spustit (databaze & pgadmin):

    docker-compose up
    
    
POZNAMKA: "docker-compose up" se zavola v adresari, ve kterem je docker-compose.yml

2. Spustit tridu DemoDockerApplication (timto se vytvori databaze a spusti aplikace):

3A. Funguje: http://localhost:8080/stuffs (funguje GET, POST, PUT, DELETE ... diky Spring Data REST)

3B. Funguje: http://localhost:5050 (username: admin@admin.cz, password: admin)
Tady je mozne se podivat do databaze:

    hostname: mypostgres (to je nazev servicy v docker-compose.yml)
    port: 5432 (port na kterem bezi databaze, nikoli port 5555, ktery pouziva aplikace - ta se pripojuje pres localhost)
    username: postgres
    password: password
    

4. Odstraneni databaze & pgadmin:

    docker-compose down