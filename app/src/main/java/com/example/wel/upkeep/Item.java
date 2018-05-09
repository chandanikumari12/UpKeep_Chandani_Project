package com.example.wel.upkeep;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by 103 on 11/21/2017.
 */

public class Item {

    private String name;
    private String surname;
    private String image;
    private String id,type;
    private String check_teammember,repair_type;

    private JSONArray jsonarray;
    private JSONObject jsonObject;
    private String createdon,isread,video;
    public Item(String name, String surname, String image)
    {
        this.name = name;
        this.surname = surname;
        this.image = image;
    }

    public Item(String name, String surname)
    {
        this.name = name;
        this.surname = surname;
    }

    public Item(String name, String surname, String createdon, String isread, String video, String type, String repair_type)
    {
        this.name = name;
        this.surname = surname;
        this.createdon = createdon;
        this.isread = isread;
        this.video = video;
        this.type = type;
        this.repair_type = repair_type;
    }

    public Item(String rank, String team_name, String team_points, String tid, String video, JSONObject jsonObject2)
    {
        this.name = rank;
        this.surname = team_name;
        this.createdon = team_points;
        this.isread = tid;
        this.video = video;
        this.jsonObject = jsonObject2;
    }

      public Item(String name, String surname, String image, String isread)
        {
            this.name = name;
            this.surname = surname;
            this.image = image;
            this.isread = isread;
        }

        public Item(String name, String surname, String image, String isread, String check_teammember)
        {
            this.name = name;
            this.surname = surname;
            this.image = image;
            this.isread = isread;
            this.check_teammember = check_teammember;
        }


        public Item(String name, String surname, JSONArray jsonarray)
        {
            this.name = name;
            this.surname = surname;
            this.jsonarray = jsonarray;
        }



    public String getName() {
        return name;
    }
    public String getcheck_teammember() {
        return check_teammember;
    }

   /* public void setName(String name) {
        this.name = name;
    }*/

    public String getSurname()
    {
        return surname;
    }
    public JSONArray getjsonarray()
    {
        return jsonarray;
    }

    public JSONObject getJsonObject()
    {
        return jsonObject;
    }

    public String getImage()
    {
        return image;
    }
    public String getType()
    {
        return type;
    }
    public String getrepair_type()
    {
        return repair_type;
    }

    public String getId(){return id;}
    public String getCreatedon()
    {
        return createdon;
    }
    public String getIsread()
    {
        return isread;
    }
    public String getVideo()
    {
        return video;
    }

    public void setId(String id){this.id = id;}

    public void setCheck_teammember(String check_teammember){this.check_teammember = check_teammember;}


    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;

        Item itemCompare = (Item) obj;
        if(itemCompare.getName().equals(this.getName()))
            return true;
        return false;
    }
}