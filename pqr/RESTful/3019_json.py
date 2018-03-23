from flask import Flask,request
app=Flask(__name__,static_url_path="")

@app.route('/dispDetails', methods=['POST'])
def display():
	print(request.is_json)
	dictionary = request.get_json()
	msg ="RollNo: "+dictionary["rollno"]+"<br>"+"Name: "+dictionary["name"]+"<br>"+"Email: "+dictionary["email"]+"<br>"+"Department: "+dictionary["dept"]
	return msg

if __name__=="__main__":
	app.run(host='localhost',debug=True)
