<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html><html lang='ko' class=''>
<head><script src='//static.codepen.io/assets/editor/live/console_runner-ce3034e6bde3912cc25f83cccb7caa2b0f976196f2f2d52303a462c826d54a73.js'></script><script src='//static.codepen.io/assets/editor/live/css_reload-2a5c7ad0fe826f66e054c6020c99c1e1c63210256b6ba07eb41d7a4cb0d0adab.js'></script><meta charset='UTF-8'><meta name="robots" content="noindex"><link rel="shortcut icon" type="image/x-icon" href="//static.codepen.io/assets/favicon/favicon-8ea04875e70c4b0bb41da869e81236e54394d63638a1ef12fa558a4a835f1164.ico" /><link rel="mask-icon" type="" href="//static.codepen.io/assets/favicon/logo-pin-f2d2b6d2c61838f7e76325261b7195c27224080bc099486ddd6dccb469b8e8e6.svg" color="#111" /><link rel="canonical" href="https://codepen.io/iheartkode/pen/yJBBZZ" />
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css'><link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.css'>
<style class="cp-pen-styles">@import url(https://fonts.googleapis.com/css?family=Oswald|Roboto);
body {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  font-family: 'Roboto', sans-serif;
}

.container {
  width: 500px;
  height: 500px;
  box-shadow: 5px 5px 10px 2px #888;
}

.top-bar {
  text-align: center;
  background: #29CDB5;
  width: 500px;
  height: 300px;
}
.top-bar .fa-check-circle-o {
  color: white;
  margin-top: 5px;
  font-size: 18em;
}

.bottom-bar {
  text-align: center;
}
.bottom-bar h1 {
  color: #444;
  font-family: 'Oswald', sans-serif;
  font-weight: bold;
  margin-bottom: -10px;
}
.bottom-bar p {
  color: #555;
  font-weight: bold;
  margin-bottom: 20px;
  font-size: 1.2em;
}
.bottom-bar button {
  background: white;
  border: 3px solid #29CDB5;
  color: #444;
  border-radius: 10px;
  padding: 10px 20px 10px 20px;
  outline: none;
  transition: all 0.3s ease-in;
}
.bottom-bar button:hover {
  background: #29CDB5;
  color: white;
}
</style></head><body>
<div class="container">
  <div class="top-bar">
    <i class="fa fa-check-circle-o" aria-hidden="true"></i>
  </div>
  <div class="bottom-bar">
    <h1>You Did It!</h1>
    <p>인증을 완료 하셨습니다.</p>
  </div>
</div>

</body>
<script type="text/javascript">
$('#dismiss-btn').on('click',function(){
	var win = window.open("about:blank", "_self");
	win.close();
});
</script>
</html>