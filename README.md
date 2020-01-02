# Jenkins
Useful code snippets for using Jenkins as an Ops tool

Groovy snippets are useful for Active Choices plugin - this is used because active choices cannot run Powershell directly and requires a shim to work.
* GetListFromTextFile - This retrieves a simple list from a textfile.
* SelectFilteredJsonListFromFile - retrives a file containing a json array and then filters based on a key-field value. Finally diplays the value of another field
* SelectFilteredJsonListFromPowershell - calls a powershell script (and retrieves the json results output. Then filters based on a key-field value. Finally diplays the value of another field

