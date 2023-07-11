# MoneyTransfer Project

**This is a program for making money transfers from one account to another.**

## Class diagram of the project MoneyTransfer

<img width="711" alt="Снимок экрана 2023-07-11 в 13 41 55" src="https://github.com/IsachenkoStas/MoneyTransferProject/assets/132468711/08ed60e7-7393-412d-830f-fc4e22a465e8">



## Run

When starting, the program waits for input from the console.  
When you enter "1" - the program parses all files from the provided directory and selects the appropriate under the condition  
(i.e. .txt files).  
As a result of files parsing, the program forms a report file and updates the information in the file with account numbers, also transfers the parsed files to the archive folder.  
When you enter "2" - already generated file-report is displayed in the console, where date, time, file name and success of performed operations are indicated.  
You also have the option to call a method `readReportFile` that will display information from the report file exactly by the dates you enter. This method is overloaded.

### Additional Information

When adding your own files/directories for parsing, make sure that the files you need are **format.txt**, and also correspond to the regex prescribed in the program code.  

`line.matches("\\d{5}\\-\\d{5}\\|\\d{5}\\-\\d{5}\\: \\d+\\.?\\d*")`

Example text file:

<img width="300" alt="Снимок экрана 2023-07-09 в 15 46 44" src="https://github.com/IsachenkoStas/MoneyTransferProject/assets/132468711/a7b4643b-9732-40ff-976e-75dbffe3f674">

## Technoligies

Project is created with JAVA SE 17.
