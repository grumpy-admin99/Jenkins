def filename = "C:/admin/logs/instancelist.json"
def jsonFieldNameToFilter = "State" // Field to filter on
def jsonFieldValueToFilter = "stopped" // Value to filter on
def jsonFieldNameToOutput = "Name" // Return this field as a list
import java.io.File
import groovy.json.JsonSlurper
def jsonrawdata = new JsonSlurper().parse(new File(filename))
def jsonfiltereddata = jsonrawdata.findAll {map -> map."$jsonFieldNameToFilter" == jsonFieldValueToFilter }
return (jsonfiltereddata."$jsonFieldNameToOutput".sort())