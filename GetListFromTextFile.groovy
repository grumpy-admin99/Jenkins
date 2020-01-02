def filename = "C:/admin/logs/instancelist_names.txt"
import java.io.File
def dataList = new File(filename) as String[]
return (dataList.sort())
