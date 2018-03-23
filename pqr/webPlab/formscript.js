function validate()
{
	var fName = document.myForm.firstname;
	var lName = document.myForm.lastname;
	var email = document.myForm.emailID;
	var mob = document.myForm.mobile;
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
		document.body.innerHTML = "<html><head><title>Details Displayed.</title></head><body><pre id=\"out\" > </pre></body></html>"
		msg = "First Name : "+fName.value+"\nLast Name : "+lName.value+"\nEmail Id : "+email.value+"\nMobile : "+mob.value+"\n";
		document.body.style.background="blue";
		document.getElementById("out").innerHTML = msg;
		return true;
}

