  function login(showhide){
    if(showhide == "show"){
        document.getElementById('popupbox').style.visibility="visible";
    }else if(showhide == "hide"){
        document.getElementById('popupbox').style.visibility="hidden"; 
    }
  }
  
  
    function addbarang(showhide){
    if(showhide == "show"){
        document.getElementById('popupboxadd').style.visibility="visible";
    }else if(showhide == "hide"){
        document.getElementById('popupboxadd').style.visibility="hidden"; 
    }
  }
  
    
    function editbarang(showhide){
    if(showhide == "show"){
        document.getElementById('popupboxedit').style.visibility="visible";
    }else if(showhide == "hide"){
        document.getElementById('popupboxedit').style.visibility="hidden"; 
    }
  }