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
	  xhttp.open("GET", "/BhaluSRO/Admin/getProjectNameById/"+value, true);
	  xhttp.send();
}
  