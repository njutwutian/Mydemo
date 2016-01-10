package com.easygo.bll;
import com.easygo.dao.LoginDAO;
import com.easygo.model.UserModel;
public class LoginBll {
     public boolean checkLoginBll(UserModel userModel)
     {
    	 return new LoginDAO().checkLogin(userModel);
     }
     public UserModel getIdByUserModelBll(UserModel userModel)
     {
         return new LoginDAO().getIdByUserModel(userModel);    	 
     }
}
