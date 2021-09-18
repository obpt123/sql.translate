# Sql.Translate

```sql.translate``` is a docker tools for translate sql from one to another, is a docker wrapper for the ```org.jooq```.


You can see more details usage in [Jooq](https://www.jooq.org/doc/3.1/manual/sql-building/sql-parser/sql-parser-cli/).



### How to use


* Convert To mysql

```
    docker run obpt123/sql-translate -T mysql -s "select top 1 name, newid() as randomId from [dbo].[table1]"
```

the result for the mysql will be:

```sql
select name, uuid() as randomid from `dbo`.`table1` limit 1;
```


* Convert to postgres
```
    docker run obpt123/sql-translate:0.0.1 -T postgres -s "select top 1 name, newid() as randomId from [dbo].[table1]"
```
the result for the postgres will be:

```sql
select name, gen_random_uuid() as randomid from "dbo"."table1" fetch next 1 rows only;
```

