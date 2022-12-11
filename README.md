# SPP-Pay-App-Java

![](https://img.shields.io/badge/Type-Desktop%20App%2FAplikasi%20Desktop-purple)

### Hello👋

The language in the application : Indonesia

---

### Description :
Contains a desktop application for paying tuition fees, CRUD implementation in Java Jframe Form. Also using Mysql as Database.

### Feature
- There are admins, officers and students as users
- Complete update to the Form's better performance mechanics
- Support Print Report Data

### Needs
Operating system I use: Windows 11\
Required Software:
- Netbeans IDE 8.2 
> __Warning__ (if you are using version above 8.2 , make sure your IDE has MySQL JDBC Driver. **Otherwise you should download it manually and add it to your library)**
- XAMPP php v8.1 or above

### Instructions:
- Clone this repo or download this repo.

- [IMPORT DATABASE]\
Run XAMPP and open `localhost/phpmyadmin`, create a new database then open the database, try pressing import on the navbar, choose the database file `stuff/aplikasipembayaranspp.sql`.

- [IMPORT THE PROJECT]\
Open Netbeans IDE, select `File -> Open Project -> Select The Project` **(Aplikasi Pembayaran SPP)**. 
> __Note__ \
If a pop up appears telling us to resolve the error, you can resolve it by entering the library that I have prepared in the `stuff` folder. And after that you don't need to add the library in the next instruction

- [ADD SOME LIBRARY]\
In **Netbeans IDE**, open the project that was created earlier, right click on `Libraries` and click `Add Library`, then put all the libraries that I have prepared in the `stuff` folder **(without the .sql file)**.

- Enjoy the app while running it

---


> __Note__ \
`Login Page as Administrator`\
ID       : 224\
Username : Aakhif\
Password : admin\
`Login Page as Petugas`\
ID       : 242\
Username : Aakhif\
Password : petugas\
`Login Page as Student`\
NISN     : 1234567890\
Name     : Aakhif\
ID SPP   : 13149633
