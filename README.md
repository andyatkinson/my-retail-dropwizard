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



 - Insert some product records, with price details
 
```sql
insert into products (id,external_id,price_details) VALUES (1, 15117729, '{"value": 13.49, "currency_code": "USD"}');
insert into products (id,external_id) VALUES (2, 16483589);
insert into products (id,external_id) VALUES (3, 16696652);
insert into products (id,external_id) VALUES (4, 16752456);
insert into products (id,external_id) VALUES (5, 15643793);
insert into products (id,external_id) VALUES (6, 13860428);
```


### Curl examples

```
curl -X GET \
  http://localhost:8080/products/15117729 \
  -H 'content-type: application/json'
```

### JSON HTTP requests and JSON parsing 

Added dependencies Unirest and JsonPath to make it easier to load and parse JSON, and drill into deeply nested structures.

### Benchmarking

Benchmarking with wrk

```
$ wrk -t1 -c10 -d10s http://127.0.0.1:8080/products/15117729
Running 10s test @ http://127.0.0.1:8080/products/15117729
  1 threads and 10 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency   273.07ms  368.96ms   1.97s    85.54%
    Req/Sec    73.00     52.65   191.00     56.10%
  621 requests in 10.06s, 143.73KB read
  Socket errors: connect 0, read 0, write 0, timeout 1
Requests/sec:     61.73
Transfer/sec:     14.29KB
```
