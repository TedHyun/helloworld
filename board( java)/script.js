function writeSave(){
	
	if(document.writeform.writer.value==""){
	  alert("�ۼ��ڸ� �Է��Ͻʽÿ�.");
	  document.writeform.writer.focus();
	  return false;
	}
	if(document.writeform.subject.value==""){
	  alert("������ �Է��Ͻʽÿ�.");
	  document.writeform.subject.focus();
	  return false;
	}
	
	if(document.writeform.content.value==""){
	  alert("������ �Է��Ͻʽÿ�.");
	  document.writeform.content.focus();
	  return false;
	}
        
	//if(document.writeform.passwd.value==""){
	//  alert(" ��й�ȣ�� �Է��Ͻʽÿ�.");
	 // document.writeform.passwd.focus();
	//  return false;
	//}
 }    

