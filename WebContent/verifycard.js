function checkCard(fld){
			var button = document.getElementById("regcard");
			var cardNum = fld.value;
			var isValid = false;
			var luhnArr = [0,2,4,6,8,1,3,5,7,9];
			var counter = 0;
			var incNum;
			var odd = false;
			var temp = String(cardNum).replace(/[^\d]/g, "");
			var credit_error = document.getElementById('credit_error');
			if( temp.length == 0){
				isValid = false;
			}
			else{
				for(var i = temp.length-1;i>=0; --i){
				incNum = parseInt(temp.charAt(i),10);
				counter += (odd = !odd)? incNum : luhnArr[incNum];
				}
				isValid = (counter%10==0);
			}
			if(!isValid){
				credit_error.innerHTML = 'The Credit Card Number is not valid';
				button.disabled = true;
			}
			else{
				credit_error.innerHTML = '';
				button.disabled = false;
			}
		}