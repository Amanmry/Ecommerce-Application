# Useful Queries

**`Problem Faced :`** While developing the Springboot Application I was using primary key generator in the entity class `@GeneratedValue(strategy = GenerationType.IDENTITY)` which internally in database creates a sequence and stores in metadata for table, but the problem was eventhough I was deleting all the records from the DB still the sequence was not reseting to default, so to reset it we need to :

1. Identify the Sequence Name using Query or Manually from pgAdmin Console, Inside Sequence Dropdown

2. Alter that sequence to Restart from 1 using SQL Query.

## To Identify the Sequence for a Table in Postgres SQL

```sql
SELECT
    tns.nspname AS table_schema,
    t.relname AS table_name,
    a.attname AS column_name,
    sns.nspname AS sequence_schema,
    s.relname AS sequence_name
FROM
    pg_namespace tns
JOIN pg_class t ON tns.oid = t.relnamespace AND t.relkind IN ('p', 'r') 
JOIN pg_attribute a ON t.oid = a.attrelid AND NOT a.attisdropped
JOIN pg_depend d ON t.oid = d.refobjid AND a.attnum = d.refobjsubid
JOIN pg_class s ON d.objid = s.oid AND s.relkind = 'S' 
JOIN pg_namespace sns ON s.relnamespace = sns.oid
WHERE
    t.relname = 'cart_item'  -- Table Name
    AND tns.nspname = 'public'; -- Schema Name
```

## To Reset the Sequence Generator for the Specific Table

```sql
ALTER SEQUENCE cart_item_id_seq RESTART WITH 1;
```

---