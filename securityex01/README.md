# MySQL DB 및 사용자 생성

``` 
create user 'cos'@'%' identified by 'bitc5600';
GRANT ALL PRIVILEGES ON *.* TO 'cos'@'%';
create database security;
use security;
```