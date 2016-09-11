package com.ek.test.framework.model.apiCategories;

/**
 * Created by Administrator on 9/11/2016.
 */
public class Children_data {
    private String position;

    private String id;

    private String level;

    private String product_count;

    private String is_active;

    private String url_path;

    private String name;

    private String[] children_data;

    private String url_key;

    private String parent_id;

    public String getPosition ()
    {
        return position;
    }

    public void setPosition (String position)
    {
        this.position = position;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getLevel ()
    {
        return level;
    }

    public void setLevel (String level)
    {
        this.level = level;
    }

    public String getProduct_count ()
    {
        return product_count;
    }

    public void setProduct_count (String product_count)
    {
        this.product_count = product_count;
    }

    public String getIs_active ()
    {
        return is_active;
    }

    public void setIs_active (String is_active)
    {
        this.is_active = is_active;
    }

    public String getUrl_path ()
    {
        return url_path;
    }

    public void setUrl_path (String url_path)
    {
        this.url_path = url_path;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String[] getChildren_data ()
    {
        return children_data;
    }

    public void setChildren_data (String[] children_data)
    {
        this.children_data = children_data;
    }

    public String getUrl_key ()
    {
        return url_key;
    }

    public void setUrl_key (String url_key)
    {
        this.url_key = url_key;
    }

    public String getParent_id ()
    {
        return parent_id;
    }

    public void setParent_id (String parent_id)
    {
        this.parent_id = parent_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [position = "+position+", id = "+id+", level = "+level+", product_count = "+product_count+", is_active = "+is_active+", url_path = "+url_path+", name = "+name+", children_data = "+children_data+", url_key = "+url_key+", parent_id = "+parent_id+"]";
    }
}
