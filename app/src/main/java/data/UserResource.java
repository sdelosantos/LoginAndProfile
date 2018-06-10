package data;

import java.util.ArrayList;
import java.util.List;

public  class UserResource {
    private static ArrayList<User> resource = (new dataResource()).resource;

    //LOGIN USER
    public static int Login(String email, String password){
        int userId = 0;
        if(email==null || email=="" || password=="" || password==null)
            return 0;
        for(User u : resource)
            if(u.email.toLowerCase().equals(email.toLowerCase()) && u.password.toLowerCase().equals(password.toLowerCase())) {
                userId = u.id;
                break;
            }

        return  userId;
    }

    // GET USER BY ID
    public static User getUserById(int id){
        User result = new User();
        for(User u : resource)
            if(u.id==id) {
                result = u;
                break;
            }
        return  result;
    }

    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////  DATA  ////////////////////////////////////
   ////////////////////////////////////////////////////////////////////////////////
    static class dataResource{
        private ArrayList<User> resource;
        public  dataResource(){
            resource = new ArrayList<>();
            User u = new User();
            u.id= 1;
            u.name = "Saddan De los santos Marte";
            u.email = "saddam@test.com";
            u.password = "123456";
            u.cantFollower = 1000;
            u.cantFollowing = 500;
            u.cantPhotos = 200;

            User u2 = new User();
            u2.id= 2;
            u2.name = "DeadPool";
            u2.email = "deadPool@test.com";
            u2.password = "123456";
            u2.cantFollower = 150;
            u2.cantFollowing = 250;
            u2.cantPhotos = 2500;

            resource.add(u);
            resource.add(u2);
        }
    }
}

