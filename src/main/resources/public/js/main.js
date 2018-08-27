//NomineeDetails

//AccountDetails
function displayNominee() {
   var x = document.getElementById("nominee-checkbox");
   if(x.checked) {
         document.getElementById("continue").setAttribute("value","Add Nominee");
         document.getElementById("hasNominee").setAttribute("value", "true");
   } else {
         document.getElementById("continue").setAttribute("value","Submit");
         document.getElementById("hasNominee").setAttribute("value", "false");
   }      
}

function accountSelect(select) {
	if(select == "Online Transfer") {
		document.getElementById("bank").style.display = "block";
		document.getElementById("check").style.display = "none";
	} else {
		document.getElementById("check").style.display = "block";
		document.getElementById("bank").style.display = "none";
	}
}

function minBalSelect(select) {
	if(select == "Checking Account") {
		document.getElementById("amtWarning").style.display = "block";
	} else {
		document.getElementById("amtWarning").style.display = "none";
	}
}

function saveAccountDetails() {
	sessionStorage.setItem("accType", document.getElementById("account").value);
}

//PersonalDetails & NomineeDetails
function autotab(current,to) {
	if(current.getAttribute && current.value.length==current.getAttribute("maxlength")) {
		to.focus()
	}
}

function isNumberKey(evt) {
    var charCode = (evt.which) ? evt.which : event.keyCode;
    if ((charCode < 48 || charCode > 57))
        return false;
    return true;
}

function isAlphaKey(evt) {
    var charCode = (evt.which) ? evt.which : event.keyCode;
    if (!((charCode >= 97 && charCode <= 122) || (charCode >= 65 && charCode <= 90) ||charCode == 08))
        return false;
    
    return true;
}

function generateSSN()
{
    document.getElementById('ssn').value = 
        document.getElementById('ssn1').value + 
        document.getElementById('ssn2').value +
        document.getElementById('ssn3').value;
}

//ContactDetails

//index page
function openCity(evt, cityName) {
    // Declare all variables
    var i, tabcontent, tablinks;

    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    // Show the current tab, and add an "active" class to the button that opened the tab
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
} 

function accountNum() {
	var accNum = '${accNum}';
	document.getElementById("accountNum").setAttribute("value", accNum.value);
}