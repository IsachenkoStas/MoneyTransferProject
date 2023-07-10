# MoneyTransfer Project

**This is a program for making money transfers from one account to another.**

## Class diagram of the project MoneyTransfer

<img width="500" alt="Снимок экрана 2023-07-10 в 11 34 40" src="https://github.com/IsachenkoStas/MoneyTransferProject/assets/132468711/942a14da-7fdf-4876-b586-ba119388fa6d">


## Run

When starting, the program waits for input from the console.  
When you enter "1" - the program parses all files from the provided directory and selects the appropriate under the condition  
(i.e. .txt files).  
As a result of files parsing, the program forms a report file and updates the information in the file with account numbers, also transfers the parsed files to the archive folder.  
When you enter "2" - already generated file-report is displayed in the console, where date, time, file name and success of performed operations are indicated. 

### Additional Information

When adding your own files/directories for parsing, make sure that the files you need are **format.txt**, and also correspond to the regex prescribed in the program code.  

`line.matches("\\d{5}\\-\\d{5}\\|\\d{5}\\-\\d{5}\\: \\d+")`

Example text file:

<img width="300" alt="Снимок экрана 2023-07-09 в 15 46 44" src="https://github.com/IsachenkoStas/MoneyTransferProject/assets/132468711/a7b4643b-9732-40ff-976e-75dbffe3f674">

## Technoligies

Project is created with JAVA SE 17.
