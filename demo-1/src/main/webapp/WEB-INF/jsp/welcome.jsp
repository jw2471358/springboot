<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Welcome</title>
</head>
<body>
<script>
    var xhr = new XMLHttpRequest();
    /*
    xhr.onreadystatechange = function() {
        if (xhr.readyState === xhr.DONE) {
            if (xhr.status === 200 || xhr.status === 201) {
                console.log(xhr.responseText);
            } else {
                console.error(xhr.responseText);
            }
        }
    };
    xhr.open('GET', 'http://localhost:8080/json');
    xhr.send();
	*/

	/*
	//GET
    xhr.onload = function() {
   		if (xhr.status === 200 || xhr.status === 201) {
   	   		alert(11);
   	    	console.log("GET",xhr.responseText);
   		} else {
   	    	console.error(xhr.responseText);
   	  	}
   	};
   	xhr.open('GET', 'http://localhost:8080/json');
   	xhr.send();
   	*/
	
	//POST
   	var sendData = {
   		   	data : {
			  name: 'terry',
			  birth: 19941,
   		   	}
		};
	xhr.onload = function() {
		if (xhr.status === 200 || xhr.status === 201) {
		    console.log(xhr.responseText);
		} else {
		    console.error(xhr.responseText);
		}
	};
	xhr.open('POST', 'http://localhost:8080/json');
	xhr.setRequestHeader('Content-Type', 'application/json'); // 컨텐츠타입을 json으로
	xhr.send(JSON.stringify(sendData)); // 데이터를 stringify해서 보냄
	
</script>
Welcome~~
</body>
</html>