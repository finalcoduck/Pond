<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${!empty updateMsg }">
<script type="text/javascript">
swal({
	  type: 'success',
	  title: '수정 완료!',
	})
</script>
</c:if>
<section id="main">
	<div class="container">
		<div class="row justify-content-center vh80">
			<div class="col-12 col-md-8">
				<form class="form-horizontal">
				<fieldset>
				
				<!-- Form Name -->
				<legend>그룹 설정</legend>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class="control-label" for="textinput">학원 이름</label>  
				  <input id="groupName" name="textinput" type="text" placeholder="placeholder" class="form-control input-md" value='${groupVo.groupName }'>
				</div>
				
				<!-- Textarea -->
				<div class="form-group">
				  <label class="control-label" for="textarea">학원 소개</label>
				    <textarea class="form-control" id="groupDescription" name="textarea">${groupVo.groupDescription }</textarea>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class="control-label" for="textinput">학원 전화 번호</label>  
				  <input id="groupPhoneNum" name="textinput" type="text" placeholder="placeholder" class="form-control input-md" value='${groupVo.groupPhoneNum }'>
				</div>
				
				<div class="form-group">
				  <label class="control-label" for="textinput">학원 주소</label>  
				  	<input type="text" id="sample4_postcode" placeholder="우편번호" style="display: none">
					<input type="text" id="sample4_roadAddress" placeholder="도로명주소" value='${groupVo.groupAddr }'>
					<input type="text" id="sample4_jibunAddress" placeholder="지번주소" style="display: none">
					<span id="guide" style="color:#999"></span>

				</div>
				
				</fieldset>
				</form>
			</div>
		</div>
	</div>
</section>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>

    //주소 클릭
	$('#sample4_roadAddress').on('click', function(){
		swal({
			title: '주소를 수정하시겠습니까?',
			text: '(주소를 수정해야만 QR기능을 사용할 수 있습니다.)',
			type: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: '수정',
			cancelButtonText: '취소'
		}).then((result) => {
			if(result.value){
				sample4_execDaumPostcode();
			}
		})
	});
	
    //그룹이름 클릭
	$('#groupName').on('click', function(){
		swal({
			title: '그룹이름을 수정하시겠습니까?',
			type: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: '수정',
			cancelButtonText: '취소'
		}).then((result) => {
			if(result.value){
				swal({
					  title: '수정할 그룹이름을 입력해주세요',
					  input: 'text',
					  inputAttributes: {
					    autocapitalize: 'off'
					  },
					  showCancelButton: true,
					  confirmButtonText: '수정',
					  showLoaderOnConfirm: true,
					  preConfirm: (value) => {
					  location.href="${pageContext.request.contextPath}/group/update/group-info?groupNum=${groupVo.groupNum}&column=group_name&columnValue="+value;
				}});
			}
		})
	});	
    
    //그룹설명 클릭
	$('#groupDescription').on('click', function(){
		swal({
			title: '그룹소개를 수정하시겠습니까?',
			type: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: '수정',
			cancelButtonText: '취소'
		}).then((result) => {
			if(result.value){
				swal({
					  title: '그룹소개를 입력해주세요.',
					  input: 'textarea',
					  inputAttributes: {
					    autocapitalize: 'off'
					  },
					  showCancelButton: true,
					  confirmButtonText: '수정',
					  showLoaderOnConfirm: true,
					  preConfirm: (value) => {
					  location.href="${pageContext.request.contextPath}/group/update/group-info?groupNum=${groupVo.groupNum}&column=group_description&columnValue="+value;
				}});
			}
		})
	});	 
    
    //그룹이름 클릭
	$('#groupPhoneNum').on('click', function(){
		swal({
			title: '그룹전화번호를 수정하시겠습니까?',
			type: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: '수정',
			cancelButtonText: '취소'
		}).then((result) => {
			if(result.value){
				swal({
					  title: '수정할 그룹전화번호를 입력해주세요',
					  input: 'text',
					  inputAttributes: {
					    autocapitalize: 'off'
					  },
					  showCancelButton: true,
					  confirmButtonText: '수정',
					  showLoaderOnConfirm: true,
					  preConfirm: (value) => {
					  location.href="${pageContext.request.contextPath}/group/update/group-info?groupNum=${groupVo.groupNum}&column=group_phone_num&columnValue="+value;
				}});
			}
		})
	});	    

    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                location.href = "${pageContext.request.contextPath}/group/kakao/addr?address="+fullRoadAddr+"&groupNum="+${groupVo.groupNum}+"&updateOk=true";
                
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample4_roadAddress').value = fullRoadAddr;
                document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();
    }
</script>