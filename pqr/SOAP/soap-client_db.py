from suds.client import Client as SudsClient

url = 'http://localhost:5000/soap/database?wsdl'
client = SudsClient(url=url, cache=None)
rollno = input("Enter Student RollNo: ")
r = client.service.select(rollno)
print r
