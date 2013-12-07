/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function delete_item(id) {
    
    /*var popup = document.getElementById("popup");
    popup.style.visibility = 'visible';*/
    
    var id_popup = document.getElementById("id_popup");
    id_popup.value = id;
    
    var form = document.getElementById("formdelete");
    var r=confirm("Are you sure ?");
    if (r==true)
      {
      form.submit();
      }
    else
      {
          
      } 
}

function closePopup() {
    var popup = document.getElementById("popup");
    popup.style.visibility='hidden';
}
