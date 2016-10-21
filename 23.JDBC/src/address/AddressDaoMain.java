package address;

import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class AddressDaoMain {

	public static void main(String[] args) throws Exception {
		AddressDao addrDao = new AddressDao();
		
		/*
		이름      널        유형           
		------- -------- ------------ 
		NO      NOT NULL NUMBER(4)    
		ID               VARCHAR2(6)  
		NAME             VARCHAR2(20) 
		PHONE            VARCHAR2(15) 
		ADDRESS          VARCHAR2(60)
		 */
		
		int no = 0;
	
	
		AddressDTO addrDTO = new AddressDTO(99, "동해", "물과", "백두", "산이");
	
		
		//addrDao.insert(no, id,name,phone,address);
		//addrDao.insert(addrDTO);
		
		//addrDao.delete(1123);
		
		
		addrDao.update(99, "뉴 주소");
		
		AddressDTO findAddr = addrDao.selectOne(6);
		System.out.println(findAddr.toString());
		System.out.println(">> 찾은 값 : "+findAddr.getNo()+"\t"+findAddr.getId()+"\t"+findAddr.getName()+"\t"+findAddr.getPhone()+"\t"+findAddr.getAddress());
		
		
		System.out.println("\n >>> Select All");
		ArrayList<AddressDTO> addrList = addrDao.selectAll();
		for (AddressDTO addressDTO : addrList) {
			System.out.println(addressDTO.getNo()+"\t"+addressDTO.getId()+"\t"+addressDTO.getNo()+"\t"+addressDTO.getName()+"\t"+addressDTO.getPhone()+"\t"+addressDTO.getAddress());
		}
		
		
		//addrDao.selectAll();
	}

}
