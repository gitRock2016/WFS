
// alert("外部ファイルのJSの呼び出し");

function ohayou() {
	  window.alert("Hello!");
	}

function sample(){
	
	// 対象
	// <input type="submit" value="削除ボタン" name="del" onclick="mysubmit(this)" id="delBtn">
	/**
	 * 1-1
	 * name="del"のオブジェクトを取得する
	 * Listでとれるので[0]で指定する
	 */
	//document.getElementsByName("del")[0]

	/**
	 * 1-2
	 * id="delBtnl"のオブジェクトを取得する
	 * 1-1と等価
	 */
	// document.getElementById("delBtn")
	
	/*<form name="editform">*/
	/**
	 * document.[formの名前].action
	 * formの属性actionの値を変更
	 */
	 // document.editform.action=url;
	/**
	 * editformのformをサブミットする
	 */
	// document.editform.submit();
	
}

$(function(){
	$("#ajax1").click(function(){
//		const ajaxUrl="ajax/show";
//		const ajaxUrl="ajax/show2";
		const ajaxUrl="ajax/get_usr/hinatsuru";
			
		
		$("#outputdata").text("ajax1 inital data");
		
		$.ajax({
			type : "GET",
			url : ajaxUrl,
			dataType : "json",
			success : function(data){
						success(data);
				
			},
			error: function(XMLHttpRequest,textStatus, errorTrown){
						error(XMLHttpRequest,textStatus, errorTrown);
			}
		});
		
	});
	
	function success(data){
		alert("success:"+data);
		
		$("#outputdata").empty();
//		for(let cnt=0 ; cnt < data.length ; cnt++){
////			alert("success:"+data[cnt]);
////			$("#outputdata").append("data["+cnt+"]:"+data[cnt]+";");
//			
//		}
		
		// SampleBean1.java
//		console.log(data.dealerId);
//		console.log(data.name);
//		console.log(data.takuban);

		// Usr
		console.log(data.uid);
		console.log(data.passwd);
		console.log(data.unam);
		
	}
	
	function error(XMLHttpRequest,textStatus, errorTrown){
		alert("error:" + XMLHttpRequest);
		alert("status:" + textStatus);
		alert("errorThrown:" + errorTrown);
	}
})