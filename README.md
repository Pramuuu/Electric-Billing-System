# ⚡ Electricity Billing System

A **desktop-based Electricity Billing System** built with **Java (Swing)**, **JDBC**, and **MySQL**.  
It allows admins and customers to manage electricity accounts, generate bills, update details, and simulate payments.

---

## 📌 Technologies Used
- **Front End**: Java Core, Swing (GUI)
- **Back End**: MySQL Database
- **Database Connectivity**: JDBC (Java Database Connectivity)
- **IDE Used**: NetBeans (recommended)

---

## 📂 Project Structure

- `Conn.java` → Database connection helper (JDBC).
- `Splash.java` → Splash screen (startup animation).
- `Login.java` → Login window (Admin/Customer).
- `Signup.java` → Create new account (Admin/Customer).
- `Project.java` → Main dashboard with menu options.
- `NewCustomer.java` → Add a new customer with meter number.
- `MeterInfo.java` → Add meter details.
- `CalculateBill.java` → Calculate monthly bill.
- `GenerateBill.java` → Generate printable bill for a customer.
- `PayBill.java` → Pay electricity bills.
- `Paytm.java` → Simulated Paytm payment integration.
- `ViewInformation.java` → View customer details.
- `UpdateInformation.java` → Update customer details.
- `CustomerDetails.java` → Table view of all customers.
- `DepositDetails.java` → View/search bills by meter & month.
- `BillDetails.java` → Show bills for a particular meter.

---

## 🗄 Database Schema

**Database name**: `ebs`

```sql
CREATE TABLE login (
  meter_no VARCHAR(20) PRIMARY KEY,
  username VARCHAR(50),
  name VARCHAR(100),
  password VARCHAR(255),
  user VARCHAR(20)
);

CREATE TABLE customer (
  name VARCHAR(100),
  meter_no VARCHAR(20) PRIMARY KEY,
  address VARCHAR(255),
  city VARCHAR(100),
  state VARCHAR(100),
  email VARCHAR(100),
  phone VARCHAR(20)
);

CREATE TABLE meter_info (
  meter_no VARCHAR(20) PRIMARY KEY,
  meter_location VARCHAR(50),
  meter_type VARCHAR(50),
  phase_code VARCHAR(20),
  bill_type VARCHAR(50),
  days INT
);

CREATE TABLE tax (
  id INT AUTO_INCREMENT PRIMARY KEY,
  cost_per_unit INT,
  meter_rent INT,
  service_charge INT,
  service_tax INT,
  swach_bharat_cess INT,
  fixed_tax INT
);

CREATE TABLE bill (
  meter_no VARCHAR(20),
  month VARCHAR(20),
  units VARCHAR(20),
  totalbill VARCHAR(50),
  status VARCHAR(20),
  PRIMARY KEY (meter_no, month)
);
Sample Data
sql
Copy code
INSERT INTO tax (cost_per_unit, meter_rent, service_charge, service_tax, swach_bharat_cess, fixed_tax)
VALUES (10, 50, 25, 5, 2, 10);

INSERT INTO login (meter_no, username, name, password, user) VALUES
('admin1', 'admin', 'Administrator', 'adminpassword', 'Admin');
⚙️ Configuration
Update Conn.java with your DB credentials:

java
Copy code
c = DriverManager.getConnection(
  "jdbc:mysql://localhost:3306/ebs",
  "root",
  "your_db_password"
);
Add MySQL Connector/J JAR to your project libraries.

▶️ How to Run
Start MySQL server and create the database ebs.

Run the above SQL schema to create tables.

Open the project in NetBeans (or any Java IDE).

Add MySQL JDBC Driver to the project libraries.

Run Splash.java (or directly Login.java for quick start).

Command-line (alternative)
bash
Copy code
javac -cp ".;mysql-connector-java-<version>.jar" src/electricity/billing/system/*.java
java -cp ".;mysql-connector-java-<version>.jar" electricity.billing.system.Splash
🔑 Key Links Between Classes
meter_no is the primary key linking all tables (customer, meter_info, bill, login).

Conn.java provides a shared DB connection for all modules.

Login.java → opens Project.java (dashboard).

From Project.java, menus launch respective modules:

Customer management → NewCustomer, UpdateInformation, ViewInformation

Billing → CalculateBill, GenerateBill, PayBill

Reports → CustomerDetails, DepositDetails, BillDetails

📌 Notes
Security: Current SQL uses string concatenation → should be changed to PreparedStatement.

Passwords: Stored in plain text → recommend hashing (e.g., BCrypt).

Database credentials: Should be moved to a config file instead of hardcoding.

📑 .gitignore (suggested)
gitignore
Copy code
nbproject/private/
dist/
build/
*.class
*.log
.DS_Store
mysql-connector-java-*.jar
db.properties
📜 License
Add your license here (e.g., MIT, Apache 2.0).

pgsql
Copy code

✅ This file is fully GitHub-ready.  
Do you also want me to include a **project architecture diagram (in Markdown with ASCII / image li
