/**
 * Get project Name based on Project Id in Project Module
 */
function load(value){
	var projectName=document.getElementById('projectHandled');
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    console.log(this.response);
	    projectName.value=this.response;
	    }
	  };
	  xhttp.open("GET", "/HRMSProject/Admin/getProjectNameById/"+value, true);
	  xhttp.send();
}
// form submit for profile pic change for employee and admin

function changeProfilePic()
{
	document.getElementById("ProfilePicChangeForm").submit();
}
function loadLeavesById(formId)
{
	document.getElementById(formId).submit();

}
