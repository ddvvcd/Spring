<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
			<title>annotation::param</title>
	</head>
	<body>
		<h3>@RequestParam 어노테이션 실습</h3>
		
		<a href="/Ch04/annotation/param"></a>
		
		<h4>param1 결과</h4>
		<p>
			uid : ${uid} <!-- annotationController에서 참조한 key값 -->
		</p>
		
		<h4>parma2 결과</h4>
		<p>
			uid : ${uid} <!-- annotationController에서 참조한 key값 -->
			name : ${name} <!-- annotationController에서 참조한 key값 -->
		</p>
		
		<h4>param3 결과</h4>
		<p>
			uid : ${uid} <!-- annotationController에서 참조한 key값 -->
			name : ${name} <!-- annotationController에서 참조한 key값 -->
			hp : ${hp} <!-- annotationController에서 참조한 key값 -->
			age: ${age} <!-- annotationController에서 참조한 key값 -->
		</p>
	</body>
</html>