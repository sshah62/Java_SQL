CREATE TABLE Employee
(
  emp_name VARCHAR2(55) PRIMARY KEY NOT NULL,
  emp_address VARCHAR2(150),
  emp_type VARCHAR2(1)
);



CREATE TABLE Employee_t
(
  empt_name VARCHAR2(55) PRIMARY KEY NOT NULL,
  education VARCHAR2(1),
  CONSTRAINT fk_empt_name
  FOREIGN KEY (empt_name)
  REFERENCES Employee(emp_name)
  ON DELETE CASCADE
);

CREATE TABLE Employee_q
(
  empq_name VARCHAR2(55) PRIMARY KEY NOT NULL,
  prod_type_empq INTEGER,
  CONSTRAINT fk_empq_name
  FOREIGN KEY (empq_name)
  REFERENCES Employee(emp_name)
  ON DELETE CASCADE
);
CREATE TABLE Employee_w
(
  empw_name VARCHAR2(55) PRIMARY KEY NOT NULL,
  num_products INTEGER,
  CONSTRAINT fk_empw_name
  FOREIGN KEY (empw_name)
  REFERENCES Employee(emp_name)
  ON DELETE CASCADE
);

CREATE TABLE Products
(
  prod_id INTEGER PRIMARY KEY NOT NULL,
  prod_type INTEGER,
  prod_date DATE,
  time_spent INTEGER
);

CREATE SEQUENCE prod_seq START WITH 101;

CREATE TABLE Product_1
(
  prod1_id INTEGER PRIMARY KEY,
  prod1_size VARCHAR(1),
  prod1_sw VARCHAR(55),
  CONSTRAINT fk_prod1
  FOREIGN KEY (prod1_id)
  REFERENCES Products(prod_id)
  ON DELETE CASCADE
);

CREATE TABLE Product_2
(
  prod2_id INTEGER PRIMARY KEY,
  prod2_size VARCHAR(1),
  prod2_clr VARCHAR(55),
  CONSTRAINT fk_prod2
  FOREIGN KEY (prod2_id)
  REFERENCES Products(prod_id)
  ON DELETE CASCADE
);

CREATE TABLE Product_3
(
  prod3_id INTEGER PRIMARY KEY,
  prod3_size VARCHAR2(1),
  prod3_wt VARCHAR2(55),
  CONSTRAINT fk_prod3
  FOREIGN KEY (prod3_id)
  REFERENCES Products(prod_id)
  ON DELETE CASCADE
);

CREATE TABLE Makes
(
  mk_emp_name VARCHAR2(55) NOT NULL,
  mk_prod_id INTEGER PRIMARY KEY,
  CONSTRAINT fk_mk_emp_name
  FOREIGN KEY (mk_emp_name)
  REFERENCES Employee_w (empw_name),
  CONSTRAINT fk_mk_prod_id
  FOREIGN KEY (mk_prod_id)
  REFERENCES Products(prod_id)
);

CREATE TABLE Chk_prod
(
  chk_emp_name VARCHAR2(55) NOT NULL,
  chk_prod_id INTEGER NOT NULL PRIMARY KEY,
  chk_result VARCHAR2(1) NOT NULL,
  CONSTRAINT fk_chk_emp_name
  FOREIGN KEY (chk_emp_name)
  REFERENCES Employee_q (empq_name),
  CONSTRAINT fk_chk_prod_id
  FOREIGN KEY (chk_prod_id)
  REFERENCES Products (prod_id)
);

CREATE TABLE Repairs
(
  rep_prod_id INTEGER PRIMARY KEY,
  rep_emp_name VARCHAR2(55),
  rep_comp_id INTEGER,
  rep_date DATE,
  CONSTRAINT fk_rep_emp_name
  FOREIGN KEY (rep_emp_name)
  REFERENCES Employee_t (empt_name),
  CONSTRAINT fk_rep_prod_id
  FOREIGN KEY (rep_prod_id)
  REFERENCES Products(prod_id),
  CONSTRAINT fk_rep_comp_id
  FOREIGN KEY (rep_comp_id)
  REFERENCES Complaint (comp_id)
);

CREATE TABLE Acct
(
  acct_id INTEGER,
  date_created DATE,
  acct_cost NUMBER(12,2),
  CONSTRAINT fk_acct
  FOREIGN KEY (acct_id)
  REFERENCES Products (prod_id)
);

CREATE TABLE Acct_1
(
  acct1_id INTEGER PRIMARY KEY,
  cost_1 NUMBER(12,2),
  CONSTRAINT fk_acct1_id
  FOREIGN KEY (acct1_id)
  REFERENCES Product_1 (prod1_id)
);


CREATE TABLE Acct_2
(
  acct2_id INTEGER PRIMARY KEY,
  cost_2 NUMBER(12,2),
  CONSTRAINT fk_acct2_id
  FOREIGN KEY (acct2_id)
  REFERENCES Product_2 (prod2_id)
);

CREATE TABLE Acct_3
(
  acct3_id INTEGER Primary KEY,
  cost_3 NUMBER(12,2),
  CONSTRAINT fk_acct3_id
  FOREIGN KEY (acct3_id)
  REFERENCES Product_3 (prod3_id)
);


CREATE TABLE Customer
(
  cust_name VARCHAR(55) NOT NULL PRIMARY KEY,
  cust_address VARCHAR(150)
);

CREATE TABLE Purchase
(
  purchase_id INTEGER NOT NULL PRIMARY KEY,
  purchase_cust_name VARCHAR(55) NOT NULL,
  CONSTRAINT fk_pur_prod
  FOREIGN KEY (purchase_id)
  REFERENCES Products(prod_id),
  CONSTRAINT fk_cust_name
  FOREIGN KEY (purchase_cust_name)
  REFERENCES Customer (cust_name)
);

CREATE TABLE Complaint
(
  comp_id INTEGER PRIMARY KEY,
  comp_cust_name VARCHAR(55) NOT NULL,
  comp_prod_id INTEGER NOT NULL,
  comp_date DATE,
  comp_description VARCHAR(500),
  comp_resolution VARCHAR(1),
  CONSTRAINT fk_comp_prod_id
  FOREIGN KEY (comp_prod_id)
  REFERENCES Purchase(purchase_id),
  CONSTRAINT fk_comp_cust_name
  FOREIGN KEY (comp_cust_name)
  REFERENCES Customer (cust_name)
);

CREATE SEQUENCE comp_id_seq START WITH 1001;

CREATE TABLE Accidents
(
  acc_id INTEGER NOT NULL PRIMARY KEY,
  acc_prod_id INTEGER NOT NULL,
  acc_date DATE,
  days_lost INTEGER,
  CONSTRAINT fk_acc_prod_id
  FOREIGN KEY (acc_prod_id)
  REFERENCES Products (prod_id)
);
CREATE SEQUENCE acci_seq START WITH 5001;


select * from Purchase 
Where EXISTS
(
select * from Makes
WHERE PURCHASE.purchase_id = Makes.mk_prod_id
AND PURCHASE.purchase_cust_name = MAKES.mk_emp_name
)
UNION ALL
select * from Purchase 
Where EXISTS
(
select * from REPAIRS
WHERE PURCHASE.purchase_id = REPAIRS.rep_prod_id
AND PURCHASE.purchase_cust_name = REPAIRS.rep_emp_name
)
UNION ALL
select * from Purchase 
Where EXISTS
(
select * from CHK_PROD
WHERE PURCHASE.purchase_id = CHK_PROD.chk_prod_id
AND PURCHASE.purchase_cust_name = CHK_PROD.chk_emp_name
);


/*SELECT sum(days_lost) FROM ACCIDENTS WHERE EXISTS (SELECT comp_prod_id FROM COMPLAINT);


SELECT AVG(acct_cost) FROM ACCT WHERE '01-JAN-16' <= ACCT.date_created AND ACCT.date_created <= '31-DEC-16';

SELECT * FROM CUSTOMER ORDER BY cust_name;

SELECT mk_prod_id FROM MAKES WHERE mk_emp_name = 'bill clinton';*/

--INDEXES
--ACCIDENTS
CREATE INDEX idx_acc_prod_id ON ACCIDENTS(acc_prod_id);

--ACCT
CREATE INDEX idx_acc_date_created ON ACCT(date_created);

--CHK_PROD
CREATE INDEX idx_chk_emp_name ON CHK_PROD(chk_emp_name);
CREATE INDEX idx_chk_result ON CHK_PROD(chk_result);

--COMPLAINT
CREATE INDEX idx_comp_prod_id ON COMPLAINT(comp_prod_id);

-- MAKES
CREATE INDEX idx_mk_emp_name ON MAKES(mk_emp_name);

-- PRODUCTS
CREATE INDEX idx_prod_date ON PRODUCTS(prod_date);

-- REPAIRS
CREATE INDEX idx_rep_emp_name ON REPAIRS(rep_emp_name);
CREATE INDEX idx_rep_date ON REPAIRS(rep_date);

--------------------------------------------------------
--  File created - Sunday-November-20-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure ENTER_NEW_ACCIDENT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SHAH0542"."ENTER_NEW_ACCIDENT" (acc_prod_id INTEGER, acc_date1 VARCHAR2, days_lost NUMBER) AS 
acc_date DATE;
BEGIN
  acc_date := to_date(acc_date1);
  INSERT INTO ACCIDENTS VALUES(acci_seq.NEXTVAL, acc_prod_id, acc_date, days_lost);
END ENTER_NEW_ACCIDENT;

/
--------------------------------------------------------
--  DDL for Procedure ENTER_NEW_COMPLAINT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SHAH0542"."ENTER_NEW_COMPLAINT" (comp_cust_name VARCHAR2, comp_prod_id INTEGER, comp_date1 VARCHAR2, comp_description VARCHAR2, comp_resolution VARCHAR2, rep_emp_name VARCHAR2)AS 
comp_date DATE;
BEGIN
  comp_date := to_date(comp_date1);
  INSERT INTO COMPLAINT VALUES(comp_id_seq.NEXTVAL, comp_cust_name, comp_prod_id, comp_date, comp_description, comp_resolution);
  INSERT INTO REPAIRS(rep_prod_id, rep_emp_name, rep_comp_id) VALUES(comp_prod_id, rep_emp_name, comp_id_seq.CURRVAL);
END ENTER_NEW_COMPLAINT;

/
--------------------------------------------------------
--  DDL for Procedure ENTER_NEW_CUSTOMER
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SHAH0542"."ENTER_NEW_CUSTOMER" (cust_name VARCHAR2, cust_address VARCHAR2) AS 
BEGIN
  INSERT INTO CUSTOMER VALUES(cust_name, cust_address);
END ENTER_NEW_CUSTOMER;

/
--------------------------------------------------------
--  DDL for Procedure ENTER_NEW_PROD
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SHAH0542"."ENTER_NEW_PROD" (prod_type INTEGER, prod_date1 VARCHAR2, time_spent NUMBER, prod_size VARCHAR2, mk_emp_name VARCHAR2, chk_emp_name VARCHAR2, chk_result VARCHAR2, rep_emp_name VARCHAR2, prod_cost NUMBER, prod_type_data VARCHAR2) AS 
 prod_date DATE;
BEGIN
   prod_date := to_date(prod_date1, 'DD-MON-YY');
   INSERT INTO PRODUCTS VALUES(prod_seq.NEXTVAL, prod_type, prod_date, time_spent);
   INSERT INTO ACCT VALUES (prod_seq.CURRVAL, prod_date, prod_cost);
   INSERT INTO MAKES VALUES(mk_emp_name, prod_seq.CURRVAL);
   INSERT INTO CHK_PROD VALUES(chk_emp_name, prod_seq.CURRVAL, chk_result);
   IF (rep_emp_name != 'NONE')
   THEN INSERT INTO REPAIRS(REP_PROD_ID, REP_EMP_NAME, REP_DATE) VALUES(prod_seq.CURRVAL, rep_emp_name, prod_date);
   END IF;
   IF (prod_type = 1)
   THEN INSERT INTO PRODUCT_1 VALUES(prod_seq.CURRVAL, prod_size, prod_type_data);
   INSERT INTO ACCT_1 VALUES(prod_seq.CURRVAL, prod_cost);
   ELSIF (prod_type = 2)
   THEN INSERT INTO PRODUCT_2 VALUES(prod_seq.CURRVAL, prod_size, prod_type_data);
   INSERT INTO ACCT_2 VALUES(prod_seq.CURRVAL, prod_cost);
   ELSIF (prod_type = 3)
   THEN INSERT INTO PRODUCT_3 VALUES(prod_seq.CURRVAL, prod_size, prod_type_data);
   INSERT INTO ACCT_3 VALUES(prod_seq.CURRVAL, prod_cost);
   END IF;
END ENTER_NEW_PROD;

/
--------------------------------------------------------
--  DDL for Procedure ENTER_NEW_PURCHASE
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SHAH0542"."ENTER_NEW_PURCHASE" (purchase_id INTEGER, purchase_cust_name VARCHAR2)AS 
BEGIN
  INSERT INTO PURCHASE VALUES(purchase_id, purchase_cust_name);
END ENTER_NEW_PURCHASE;

/
--------------------------------------------------------
--  DDL for Procedure ENTER_NEW_QC
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SHAH0542"."ENTER_NEW_QC" (emp_name VARCHAR2, emp_address VARCHAR2, emp_type VARCHAR2, prod_type INTEGER)   AS 
BEGIN
  INSERT INTO EMPLOYEE VALUES(emp_name, emp_address, emp_type);
  INSERT INTO Employee_q VALUES(emp_name,prod_type);
  COMMIT;
END ENTER_NEW_QC;

/
--------------------------------------------------------
--  DDL for Procedure ENTER_NEW_TECH
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SHAH0542"."ENTER_NEW_TECH" (emp_name VARCHAR2, emp_address VARCHAR2, emp_type INTEGER, education VARCHAR2)   AS 
BEGIN
  INSERT INTO EMPLOYEE VALUES(emp_name, emp_address, emp_type);
  INSERT INTO Employee_t VALUES(emp_name, education);
  COMMIT;
END ENTER_NEW_TECH;

/
--------------------------------------------------------
--  DDL for Procedure ENTER_NEW_WORKER
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SHAH0542"."ENTER_NEW_WORKER" (emp_name VARCHAR2, emp_address VARCHAR2, emp_type INTEGER, num_products INTEGER)   AS 
BEGIN
  INSERT INTO Employee VALUES(emp_name, emp_address, emp_type);
  INSERT INTO Employee_w VALUES(emp_name, num_products);
  COMMIT;
END ENTER_NEW_WORKER;

/
--------------------------------------------------------
--  DDL for Procedure SWITCH_EMPLOYEES
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SHAH0542"."SWITCH_EMPLOYEES" (empq_name_q16 VARCHAR2, empt_name_q16 VARCHAR2)AS 
BEGIN
  INSERT INTO EMPLOYEE_T VALUES((SELECT emp_name FROM EMPLOYEE WHERE emp_name = empq_name_q16),
  (SELECT education FROM EMPLOYEE_T WHERE empt_name = empt_name_q16));
  INSERT INTO EMPLOYEE_Q VALUES((SELECT emp_name FROM EMPLOYEE WHERE emp_name = empt_name_q16),
  (SELECT prod_type_empq FROM EMPLOYEE_Q WHERE empq_name = empq_name_q16));
  UPDATE REPAIRS
    SET rep_emp_name = (SELECT emp_name FROM EMPLOYEE WHERE emp_name = empq_name_q16)
    WHERE rep_emp_name = empt_name_q16;
  UPDATE CHK_PROD
    SET chk_emp_name = (SELECT emp_name FROM EMPLOYEE WHERE emp_name = empt_name_q16)
    WHERE chk_emp_name = empq_name_q16;
  DELETE FROM EMPLOYEE_Q WHERE empq_name = empq_name_q16;
  DELETE FROM EMPLOYEE_T WHERE empt_name = empt_name_q16;
END SWITCH_EMPLOYEES;

/
--------------------------------------------------------
--  DDL for Procedure SWITCH_POSITIONS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "SHAH0542"."SWITCH_POSITIONS" (empq_name_q16 VARCHAR2, empt_name_q16 VARCHAR2)AS 
BEGIN
  INSERT INTO EMPLOYEE_T VALUES((SELECT emp_name FROM EMPLOYEE WHERE emp_name = empq_name_q16),
  (SELECT education FROM EMPLOYEE_T WHERE empt_name = empt_name_q16));
  INSERT INTO EMPLOYEE_Q VALUES((SELECT emp_name FROM EMPLOYEE WHERE emp_name = empt_name_q16),
  (SELECT prod_type_empq FROM EMPLOYEE_Q WHERE empq_name = empq_name_q16));
  UPDATE REPAIRS
    SET rep_emp_name = (SELECT emp_name FROM EMPLOYEE WHERE emp_name = empq_name_q16)
    WHERE rep_emp_name = empt_name_q16;
  UPDATE CHK_PROD
    SET chk_emp_name = (SELECT emp_name FROM EMPLOYEE WHERE emp_name = empt_name_q16)
    WHERE chk_emp_name = empq_name_q16;
  UPDATE EMPLOYEE
    SET emp_type = 2 WHERE emp_name = empt_name_q16;
  UPDATE EMPLOYEE
    SET emp_type = 3 WHERE emp_name = empq_name_q16;
  DELETE FROM EMPLOYEE_Q WHERE empq_name = empq_name_q16;
  DELETE FROM EMPLOYEE_T WHERE empt_name = empt_name_q16;
END SWITCH_POSITIONS;

/

