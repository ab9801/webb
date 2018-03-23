import MySQLdb
from flask import Flask
from flask_spyne import Spyne
from spyne.protocol.soap import Soap11
from spyne.model.primitive import Integer, String

app = Flask(__name__)
spyne = Spyne(app)

class soapDatabase(spyne.Service):
	__service_url_path__ = '/soap/database'
	__in_protocol__ = Soap11(validator='lxml')
	__out_protocol__ = Soap11()

	@spyne.srpc(String, _returns=String)
	def select(rollno):
		dbase = MySQLdb.connect('localhost','root','harshahj97','example')
		cur = dbase.cursor()
		query = "select * from student where rollno='"+rollno+"'"
		try:
			cur.execute(query)
			ans = cur.fetchall()
			for row in ans:
				return ' '.join(row[1:])
		except e:
			pass

if __name__ == '__main__':
	app.run(host='localhost', debug = True)
