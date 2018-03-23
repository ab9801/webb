import MySQLdb
from flask import Flask,request

app=Flask(__name__,static_url_path="")

@app.route('/create',methods=["GET","POST"])
def createStud():
	print("INSERTION...")
	try:
		hv = request.get_json()
		rollno = hv['rollno']
		name = hv['name']
		dept = hv['dept']
		email = hv['email']
		dbase = MySQLdb.connect("localhost","root","harshahj97","example")
		cur = dbase.cursor()
		try:
			cur.execute("insert into student values('"+rollno+"','"+name+"','"+dept+"','"+email+"')")
			dbase.commit()
		except:
			dbase.rollback()
		return "Insertion Successful"
	except:
		return "Error"
	finally:
		dbase.close()

@app.route('/retrieve',methods=["GET","POST"])
def retrieveStud():
	print("SELECTION...")
	try:
		hv = request.get_json()
		dbase = MySQLdb.connect("localhost","root","harshahj97","example")
		cur = dbase.cursor()
		cur.execute("select * from student where dept='"+hv['dept']+"'")
		result = cur.fetchall()
		ans = []
		for row in result:
			_1 = row[0]
			_2 = row[1]
			_3 = row[2]
			_4 = row[3]
			sub = "ROLLNO: "+_1+"<br/>NAME: "+_2+"<br/>DEPT: "+_3+"<br/>EMAIL: "+_4
			ans.append(sub)
		return "".join(ans)
	except:
		return "Error"
	finally:
		dbase.close()

@app.route('/update',methods=["GET","POST"])
def updateStud():
	print("UPDATION...")
	try:
		hv = request.get_json()
		dbase = MySQLdb.connect("localhost","root","harshahj97","example")
		cur = dbase.cursor()
		try:
			cur.execute("update student set email='"+hv['email']+"' where rollno='"+hv['rollno']+"'")
			dbase.commit()
			return "Updation Successful"
		except:
			dbase.rollback()
	except:
		return "Error"
	finally:
		dbase.close()

@app.route('/remove',methods=["GET","POST"])
def removeStud():
	print("DELETION...")
	try:
		hv = request.get_json()
		dbase = MySQLdb.connect("localhost","root","harshahj97","example")
		cur = dbase.cursor()
		try:
			cur.execute("delete from student where rollno='"+hv['rollno']+"'")
			dbase.commit()
			return "Deletion Successful"
		except:
			dbase.rollback()
	except:
		return "Error"
	finally:
		dbase.close()

if __name__=="__main__":
	app.run(host="localhost",debug=True)
