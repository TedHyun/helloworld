CREATE TABLE product(
	p_id VARCHAR2(100) PRIMARY KEY ,
	p_name VARCHAR2(200),
	p_unitPrice  NUMBER,
	p_description  VARCHAR2(200),
   	p_category VARCHAR2(200),
	p_manufacturer VARCHAR2(200),
	p_unitsInStock NUMBER,
	p_condition VARCHAR2(200),
	p_fileName  VARCHAR2(200)
);

desc product;