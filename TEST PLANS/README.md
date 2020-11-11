# TEST PLANS

|ID|Description|Expected output|Output|
|--|----|-----|----|
| TT_1_HH_01_LL_01 | Check for valid inputs | Proceed to admin/users’ welcome page | Passed |
| TT_2_HH_01_LL_02 | Check for invalid inputs | Display please try again. | Passed |
| TT_1_HH_02_LL_01 | Check for invalid admin password | Access denied, try again | Passed |
| TT_2_HH_03_LL_01 | Check with actual admin password | Admin privilege granted | Passed |
| TT_1_HH_04_LL_01 | Check for valid Registration input | Redirect to registration | Passed |
| TT_2_HH_04_LL_01 | Check for valid Login input | Redirect to Login | Passed |
| TT_3_HH_04_LL_01 | Check for invalid input | Invalid selection, please try again | Passed |
| TT_1_HH_05_LL_01 | Check for incorrect owner credential | Login successful | Passed |
| TT_2_HH_05_LL_01 | Check for incorrect owner credentials | Login failed, try again | Passed |
| TT_1_HH_06_LL_01 | Check for correct user credentials | Login successful | Passed |
| TT_2_HH_06_LL_01 | Check for incorrect user credentials | Login failed, try again | Passed |
| TT_1_HH_07_LL_01 | Check if search parameters work |Results matching search parameters  | Passed |
