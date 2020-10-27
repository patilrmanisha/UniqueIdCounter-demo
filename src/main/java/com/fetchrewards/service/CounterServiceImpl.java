package com.fetchrewards.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CounterServiceImpl implements CounterService{
	
	@Override
	public int getUniqueIdCount(List<String> emails) {
		
		if(emails == null || emails.size() == 0) return 0;
		
		HashSet<String> uniqueIds = new HashSet<>();
		
		for(String e : emails) { 
			
			//some validity checks to avoid index out of bound exception with split function.
			if(e.contains("@") && ! e.startsWith("+") && ! e.endsWith("@") ) {
			
				String[] splitE = e.split("@");
				String userName = splitE[0];
				String domain = splitE[1]; //Assuming id has valid domain (name and extension)
				
				if(userName.contains("+")) 
					userName = userName.substring(0, userName.indexOf("+"));
					
				if(userName.contains("."))
					userName = userName.replace(".", "");
				
				String emailId = userName +"@"+ domain;
				uniqueIds.add(emailId);
				
			}	
		}
		
		//System.out.println(uniqueIds);
		return uniqueIds.size();
	}

}
