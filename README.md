# MyRetail


## How to start the MyRetail application

1. mvn package
1. java -jar target/my-retail-dropwizard-1.0-SNAPSHOT.jar server config.yml
1. Visit `http://localhost:8080/products/1` (see curl example below)



## Local DB setup

 - `create database my_retail_dropwizard;`
 - Create products table


```sql
CREATE TABLE products (
    id bigint NOT NULL,
    external_id integer NOT NULL,
    price_details jsonb
);


ALTER TABLE products OWNER TO andy;

CREATE SEQUENCE products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE products_id_seq OWNER TO andy;

ALTER SEQUENCE products_id_seq OWNED BY products.id;

ALTER TABLE ONLY products ALTER COLUMN id SET DEFAULT nextval('products_id_seq'::regclass);

ALTER TABLE ONLY products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);

CREATE INDEX index_products_on_external_id ON products USING btree (external_id);
```



 - Insert some product records
 
```sql
insert into products (id,external_id) VALUES (1, 15117729);
insert into products (id,external_id) VALUES (2, 16483589);
insert into products (id,external_id) VALUES (3, 16696652);
insert into products (id,external_id) VALUES (4, 16752456);
insert into products (id,external_id) VALUES (5, 15643793);
insert into products (id,external_id) VALUES (6, 13860428);
```


### Curl examples

```
curl -X GET \
  http://localhost:8080/products/1 \
  -H 'content-type: application/json'
```
