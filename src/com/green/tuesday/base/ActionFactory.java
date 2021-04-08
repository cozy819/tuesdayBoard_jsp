package com.green.tuesday.base;

import com.green.tuesday.impl.AccountCreate;
import com.green.tuesday.impl.AccountCreateForm;
import com.green.tuesday.impl.AccountDelete;
import com.green.tuesday.impl.AccountUpdate;
import com.green.tuesday.impl.AccountUpdateForm;
import com.green.tuesday.impl.AdminAccountList;
import com.green.tuesday.impl.AdminGenreList;
import com.green.tuesday.impl.AdminLogin;
import com.green.tuesday.impl.AdminMusicList;
import com.green.tuesday.impl.ClientLogin;
import com.green.tuesday.impl.ClientMusicList;
import com.green.tuesday.impl.ContentAdd;
import com.green.tuesday.impl.ContentAddForm;
import com.green.tuesday.impl.ContentDelete;
import com.green.tuesday.impl.ContentView;
import com.green.tuesday.impl.GenreCreate;
import com.green.tuesday.impl.GenreCreateForm;
import com.green.tuesday.impl.GenreDelete;
import com.green.tuesday.impl.GenreUpdate;
import com.green.tuesday.impl.GenreUpdateForm;
import com.green.tuesday.impl.Home;
import com.green.tuesday.impl.ReplAdd;
import com.green.tuesday.impl.ReplDelete;

public class ActionFactory {
	public Action getAction(String cmd) {

		Action  action  = null;

		System.out.println("cmd: " + cmd);

		switch(cmd) {
			case "Home" :
				action = new Home();
				break;
				
			//-- Account --------------------------------------------------
			case "AccountCreateForm":
				action = new AccountCreateForm();
				break;
				
			case "AccountCreate":
				action = new AccountCreate();
				break;				

			case "AdminAccountList":
				action = new AdminAccountList(); 
				break;

			case "AccountDelete":
				action = new AccountDelete();
				break;	

			case "AccountUpdateForm":
				action = new AccountUpdateForm();
				break;
				
			case "AccountUpdate":
				action = new AccountUpdate();
				break;

			//-- Genre --------------------------------------------------
			case "AdminGenreList":
				action = new AdminGenreList();
				break;
			
			case "GenreDelete":
				action = new GenreDelete();
				break;
			
			case "GenreUpdateForm":
				action = new GenreUpdateForm();
				break;
			
			case "GenreUpdate":
				action = new GenreUpdate();
				break;
			
			case "GenreCreateForm":
				action = new GenreCreateForm();
				break;
			
			case "GenreCreate":
				action = new GenreCreate();
				break;		
				
			//-- Content --------------------------------------------------	
			case "ContentAddForm":
				action = new ContentAddForm();
				break;
				
			case "ContentAdd":
				action = new ContentAdd();
				break;
			
			case "ContentView":
				action = new ContentView();
				break;
			
			case "ContentDelete":
				action = new ContentDelete();
				break;
				
			//-- Repl --------------------------------------------------
			case "ReplAdd":
				action = new ReplAdd();
				break;
				
			case "ReplDelete":
				action = new ReplDelete();
				break;
			
			//-- AdminMusic --------------------------------------------------
			case "AdminLogin":
				action = new AdminLogin();
				break;
				
			case "AdminMusicList":
				action = new AdminMusicList();
				break;
							
			//-- Client --------------------------------------------------	
			case "ClientLogin":
				action = new ClientLogin();
				break;
				
			case "ClientMusicList":
				action = new ClientMusicList();
				break;
		}		

		return  action;
	}
}
