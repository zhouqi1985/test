package test5.test5;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class logonBaiduFieldSetMapper implements FieldSetMapper<plogonBaidu>{
    
	//@Override
	public plogonBaidu mapFieldSet(FieldSet fieldset) throws BindException {
		plogonBaidu plogonBaidu = new plogonBaidu();
		plogonBaidu.setLogonid(fieldset.readString("loginid"));
		plogonBaidu.setLogonpassword(fieldset.readString("logonpassword"));
		plogonBaidu.setVerifycode(fieldset.readString("verifycode"));
		plogonBaidu.setProtocal(fieldset.readString("protocal"));
		plogonBaidu.setSearchtext(fieldset.readString("searchtext"));
		return plogonBaidu;
	}

}
