// Modifiable parameters for the script
def psScriptToRun = "C:/admin/scripts/List-Ec2Instances.ps1" // This powershell script should emit the results in json
def jsonFieldNameToFilter = "State" // Field to filter on
def jsonFieldValueToFilter = "stopped" // Value to filter on
def jsonFieldNameToOutput = "Name" // Return this field as a list
import java.io.File
import groovy.json.JsonSlurper
def PowershellScript = {
command, args ->
def powerShellCommand = ". ${command} ${args}"
def shellCommand = "powershell.exe -ExecutionPolicy Bypass -NoLogo -NonInteractive -NoProfile -Command \"${powerShellCommand}\""
def process = shellCommand.execute()
def out = new StringBuffer()
def err = new StringBuffer()
process.consumeProcessOutput(out, err)
process.waitFor()
if (err.size() > 0) println "Received Error: $err"
return (out)
}
// this runs the powershell script and expects the output in json
def jsonrawdata = new JsonSlurper().parseText( PowershellScript(psScriptToRun,'').toString() )
def jsonfiltereddata = jsonrawdata.findAll {map -> map."$jsonFieldNameToFilter" == jsonFieldValueToFilter }
//println (jsonfiltereddata."$jsonFieldNameToOutput")
return (jsonfiltereddata."$jsonFieldNameToOutput".sort())
