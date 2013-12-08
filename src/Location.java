/**
 * Created by IntelliJ IDEA.
 * User: Toggi
 * Date: 7.12.2013
 * Time: 18:05
 * To change this template use File | Settings | File Templates.
 */
public class Location {
    private String _type;
    private int _id;
    private String name;
    private String type;
    private Coordinates geo_position;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public Coordinates getGeo_position() {
        return geo_position;
    }

    public void setGeo_position(Coordinates geo_position) {
        this.geo_position = geo_position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
