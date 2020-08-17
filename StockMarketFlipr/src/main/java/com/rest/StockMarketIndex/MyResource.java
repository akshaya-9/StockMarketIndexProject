package com.rest.StockMarketIndex;

import java.text.SimpleDateFormat;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.BSEDAO;
import com.dao.NSEDAO;
import com.dao.UserDAO;
import com.dto.BSE;
import com.dto.NSE;
import com.dto.User;
import com.google.protobuf.TextFormat.ParseException;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @Path("registerUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
     public String registerUser(User user){
    	/*User user =new User();
    	user.setUserId(1);
    	user.setUserName("akshaya");
    	user.setEmail("y.lalithaakshaya@gmail.com");
    	user.setPassword("abc123");*/
    	UserDAO  userdao =new UserDAO();
    	int num = userdao.register(user);
    	return "success";
    }
    
    @Path("loginUser/{email}/{password}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public User loginCust(@PathParam("email") String email , @PathParam("password") String password){
    	System.out.println(email);
        UserDAO custdao = new UserDAO();
    	User user = custdao.getUserByUserPass(email,password);
    	System.out.println(user.getUserName());
    	if(user != null) {
    		return user;
    	}
    	else {
    		return null;
    	}
    }
    @Path("nse")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public NSE nse(){
 
    	NSE nsee = new NSE();
		NSEDAO n = new NSEDAO();
		nsee = n.getNseByDate();
    	return nsee;}

    @Path("bse")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public BSE bse(){
 
    	BSE bsee = new BSE();
		BSEDAO b = new BSEDAO();
		bsee = b.getBseByDate();
    	return bsee;}
}
  

