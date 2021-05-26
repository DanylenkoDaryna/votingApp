<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EA Sports 2.3</title>
</head>
<body>

Football  ${playersMap.get("Football").getCount()} | ${playersMap.get("Football").getPlayers().toString()}
<br>
<hr>
Biathlon  ${playersMap.get("Biathlon").getCount()} | ${playersMap.get("Biathlon").getPlayers()}
<br>
<hr>
Basketball ${playersMap.get("Basketball").getCount()} | ${playersMap.get("Basketball").getPlayers()}
<br>
<hr>
</body>
</html>