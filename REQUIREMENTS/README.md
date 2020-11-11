# REQUIREMENTS

## HIGH LEVEL REQUIREMENTS

|ID|Requirement|
|--|-----------|
| HH_01 | The portal should serve both admin and users |
| HH_02 | Admin should have access to entire database but priviledge should be restricted |
| HH_03 | User Portal should offer both owners and tenants to use the facility |
| HH_04 | Owners should be able to register and list their properties |
| HH_05 | OWners should be able to login to review their entered details |
| HH_06 | Tenants should be able to register and subsequently login |
| HH_07 | Tenants should be able to search for available properties based on rent and city |

## LOW LEVEL REQUIREMENTS

|ID|Requirement|
|--|-----------|
| HH_01_LL_01 | Have a common class to choose between user and admin entry. |
| HH_01_LL_02 | Call the adminObject or userObject as user the user input choice. |
| HH_02_LL_01 | Admin privileges are password protected. Private class takes password as input from admin and return Boolean. |
| HH_03_LL_01 | Common interface for both owners and tenants to register or login |
| HH_04_LL_01 | File Writer class used to save owner registration and property listed data. |
| HH_05_LL_01 | File Reader class used to read owner data in case of successful login. |
| HH_06_LL_01 | File Writer class used to save tenant details into file. |
| HH_07_LL_01 | Recursively search after fetching data from file using Buffered Reader. |

