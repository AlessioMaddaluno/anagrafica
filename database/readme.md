# Database Dump / Restore
Per effettuare un dump del database mysql:
```sh
 mysqldump -u root -p anagrafica > db_dump.sql
```
Sostituire il file *db_dump.sql* in questa directory.

## Esportare file da Docker

Identificare il container su cui è presente l'istanza mysql: 

```sh 
docker ps
```

Esportare il dump del database: 

```sh 
docker cp <containerId>:/dump/path/within/container /host/path/target
```