function validate()
{
	var fName = document.myForm.firstname;
	var lName = document.myForm.lastname;
	var email = document.myForm.emailID;
	var pwd = document.myForm.pass;
	if(fName.value.length == 0)
	{
		alert("Name field cannot be empty")
		return false;
	}
	if(lName.value.length == 0)
	{
		alert("Name field cannot be empty")
		return false;
	}
	if(!email.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/))
	{
		alert("The Entered Email ID is invalid");
		return false;
	}
	if(pwd.value.length < 6)
	{
		alert("Password should contain atleast 6 characters");
		return false;
	}
	
		alert("Successfully Registered");
		msg="First Name:"+fName.value+"\nLast Name:"+lName.value+"\nEmail ID:"+email.value;
		document.getElementById("ref").innerHTML="<html><head><title> Form Details </title></head><body><pre id=\"out\"></pre></body></html>"
		document.getElementById("out").innerHTML=msg;
		document.body.style.background="orange";
		return true;
}
