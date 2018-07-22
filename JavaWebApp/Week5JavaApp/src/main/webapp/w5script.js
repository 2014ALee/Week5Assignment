document.getElementById('countIncrement').addEventListener('click', increment);

function increment(){
	let num = document.getElementById('counter').value;
	let json = JSON.stringify(num);
	let xhr = new XMLHttpRequest;
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			let newVal = JSON.parse(xhr.responseText);
			document.getElementById('counter').value = newVal;
		}
	}
	xhr.open('POST','count',true);
	xhr.send(json);
}